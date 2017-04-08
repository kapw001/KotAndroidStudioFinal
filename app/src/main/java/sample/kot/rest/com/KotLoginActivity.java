package sample.kot.rest.com;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParser;

import static android.content.ContentValues.TAG;

@SuppressLint({"WorldReadableFiles"})
public class KotLoginActivity extends Activity implements OnClickListener {
    static String KOT_IP_ADDRESS = null;
    private static final String URL = "KOTService/services/LoginActionService?wsdl";
    private static Handler errorMessage;
    private static Handler handleAlerts;
    private static String isServiceAvailable;
    private static Handler serviceMessage;
    private String METHOD_NAME;
    private String SOAP_ACTION;
    EditText edtPass;
    EditText edtUserName;
    TextView errorText;
    Button exitButton;
    Button loginButton;
    private ProgressDialog progressDialog;
    Button settingsButton;
    private boolean soapResult;
    private Thread t1;
    private Thread t2;
    private String userId;

    /* renamed from: sample.kot.rest.com.KotLoginActivity.1 */
    class C00291 extends Handler {
        C00291() {
        }

        public void handleMessage(Message msg) {
            KotLoginActivity.this.errorText.setText((String) msg.obj);
            KotLoginActivity.this.edtPass.setText(XmlPullParser.NO_NAMESPACE);
        }
    }

    /* renamed from: sample.kot.rest.com.KotLoginActivity.2 */
    class C00302 extends Handler {
        C00302() {
        }

        public void handleMessage(Message msg) {
            KotLoginActivity.isServiceAvailable = (String) msg.obj;
        }
    }

    /* renamed from: sample.kot.rest.com.KotLoginActivity.3 */
    class C00313 implements Runnable {
        C00313() {
        }

        public void run() {
            while (!KotLoginActivity.this.soapResult) {
                try {
                    System.out.println("Sleeping");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    KotLoginActivity.this.progressDialog.dismiss();
                    System.out.println("Thread Exception : " + e.getMessage());
                    return;
                }
            }
            KotLoginActivity.this.progressDialog.dismiss();
        }
    }

    /* renamed from: sample.kot.rest.com.KotLoginActivity.4 */
    class C00334 implements Runnable {

        /* renamed from: sample.kot.rest.com.KotLoginActivity.4.1 */
        class C00321 implements Runnable {
            C00321() {
            }

            public void run() {
                Utils.showAlert(KotLoginActivity.this, Constants.SERVICE_UNAVAILABLE, Constants.TRY_AGAIN);
                KotLoginActivity.this.edtPass.setText(XmlPullParser.NO_NAMESPACE);
            }
        }

        C00334() {
        }

        public void run() {
            Message messsage;
            Utils.checkServiceAvailability(KotLoginActivity.this, KotLoginActivity.serviceMessage, Constants.REQUEST_TIME_OUT.intValue());
            System.out.println("isServiceAvailable : " + KotLoginActivity.isServiceAvailable);
            while (XmlPullParser.NO_NAMESPACE.equals(KotLoginActivity.isServiceAvailable)) {
                try {
                    Thread.sleep((long) Constants.SLEEP_TIME_1000.intValue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("isServiceAvailable : " + KotLoginActivity.isServiceAvailable);
            if (!KotLoginActivity.isServiceAvailable.equalsIgnoreCase(Constants.TRUE) || !KotLoginActivity.this.getSoapResponse()) {
                KotLoginActivity.this.soapResult = true;
                KotLoginActivity.handleAlerts.post(new C00321());
            } else if (KotLoginActivity.this.userId == null || XmlPullParser.NO_NAMESPACE.equals(KotLoginActivity.this.userId)) {
                messsage = new Message();
                messsage.obj = KotLoginActivity.this.getText(R.string.invalidLogin).toString();
                KotLoginActivity.errorMessage.sendMessage(messsage);
            } else {
                System.out.println("Inside IF");
                messsage = new Message();
                messsage.obj = XmlPullParser.NO_NAMESPACE;
                KotLoginActivity.errorMessage.sendMessage(messsage);
                KotLoginActivity.this.nextPage();
            }
        }
    }

    public KotLoginActivity() {
        this.METHOD_NAME = "validateUserLogin";
        this.SOAP_ACTION = new StringBuilder(Constants.NAMESPACE).append(this.METHOD_NAME).toString();
        this.userId = null;
        this.soapResult = false;
    }

    static {
        KOT_IP_ADDRESS = XmlPullParser.NO_NAMESPACE;
        isServiceAvailable = XmlPullParser.NO_NAMESPACE;
    }

    public void onCreate(Bundle saved) {
        super.onCreate(saved);
        setContentView(R.layout.login_kot);
        this.edtUserName = (EditText) findViewById(R.id.edtUserName);
        this.edtPass = (EditText) findViewById(R.id.edtPass);
        this.errorText = (TextView) findViewById(R.id.errorText);
        this.loginButton = (Button) findViewById(R.id.btnLogin);
        this.exitButton = (Button) findViewById(R.id.btnLoginCancel);
        this.settingsButton = (Button) findViewById(R.id.btnSettings);
        this.loginButton.setOnClickListener(this);
        this.exitButton.setOnClickListener(this);
        this.settingsButton.setOnClickListener(this);
        KOT_IP_ADDRESS = getSharedPreferences("myPrefs", Context.MODE_PRIVATE).getString("kotIp", "nothing");
        ((RelativeLayout) findViewById(R.id.appVersion)).setVisibility(View.VISIBLE);
    }

    public void onClick(View clickedButton) {
        if (clickedButton == this.loginButton) {
            login(clickedButton);
        } else if (clickedButton == this.settingsButton) {
            startActivity(new Intent(this, KOTSettingActivity.class));
        } else if (clickedButton == this.exitButton) {
            System.out.println("Exit Button Pressed - Login");
            System.exit(0);
        }
    }

    public void nextPage() {
        Editor prefsEditor = getSharedPreferences("myPrefs", Context.MODE_PRIVATE).edit();
        prefsEditor.putString("userId", this.userId);
        prefsEditor.commit();
        startActivity(new Intent(this, KOTOutletActivity.class));
    }

    public void onBackPressed() {
        System.exit(0);
    }

    public boolean isInternetConnectionOn() {
        return Utils.isInternetConnectionOn(this);
    }

    @SuppressLint({"HandlerLeak"})
    private void login(View view) {
//        Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();
        errorMessage = new C00291();
        serviceMessage = new C00302();
        handleAlerts = new Handler();
        this.t1 = new Thread(new C00313());
        this.t2 = new Thread(new C00334());
        if (isInternetConnectionOn()) {
            this.soapResult = false;
            this.errorText.setText(XmlPullParser.NO_NAMESPACE);
            if (KOT_IP_ADDRESS.equalsIgnoreCase("nothing")) {
                System.out.println("No IP address provided");
                this.edtUserName.setText(XmlPullParser.NO_NAMESPACE);
                this.edtPass.setText(XmlPullParser.NO_NAMESPACE);
                this.errorText.setText("Please provide server IP");
                return;
            } else if (XmlPullParser.NO_NAMESPACE.equals(this.edtUserName.getText().toString().trim()) || XmlPullParser.NO_NAMESPACE.equals(this.edtPass.getText().toString().trim())) {
                if (XmlPullParser.NO_NAMESPACE.equals(this.edtUserName.getText().toString().trim())) {
                    this.edtUserName.setError("Username is Required");
                }
                if (XmlPullParser.NO_NAMESPACE.equals(this.edtPass.getText().toString().trim())) {
                    this.edtPass.setError("Password is Required");
//                    return;
                }
                return;
            } else {
                this.progressDialog = new ProgressDialog(view.getContext());
                this.progressDialog.setCancelable(true);
                this.progressDialog.setMessage("Logging in ...");
//                this.progressDialog.setProgressStyle(0);
                this.progressDialog.setCancelable(false);
                this.progressDialog.show();
                this.t1.start();
                this.t2.start();
                return;
            }
        }
        Utils.showAlert(this, Constants.INTERNET_UNAVAILABLE, Constants.CHECK_INTERNET_CONNECTION);
    }

//    192.168.1.43:8080

    private boolean getSoapResponse() {
        this.soapResult = false;
        try {
            SoapObject request = new SoapObject(Constants.NAMESPACE, this.METHOD_NAME);
            request.addProperty("username", this.edtUserName.getText().toString());
            request.addProperty("password", this.edtPass.getText().toString());
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(request);
            HttpTransportSE httpTransportSE = new HttpTransportSE("http://" + KOT_IP_ADDRESS + "/" + URL);
            httpTransportSE.debug = true;
            httpTransportSE.call(this.SOAP_ACTION, envelope);
            Log.e(TAG, "doInBackground: request " + httpTransportSE.requestDump);
            Log.e(TAG, "doInBackground: response " + httpTransportSE.responseDump);
            Object responseObject = envelope.getResponse();

            System.out.println("Result 1 : " + responseObject);
            if (responseObject != null) {
                this.userId = responseObject.toString();
            }
            System.out.println("User ID : " + this.userId);
            this.soapResult = true;
        } catch (Exception e) {
            System.out.println("Exception Occured while login : " + e.getMessage());
        }
        return this.soapResult;
    }
}
