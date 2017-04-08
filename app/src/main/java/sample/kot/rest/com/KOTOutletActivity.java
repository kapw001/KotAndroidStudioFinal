package sample.kot.rest.com;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
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
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParser;

@SuppressLint({"WorldReadableFiles"})
public class KOTOutletActivity extends Activity implements OnClickListener, OnItemClickListener {
    private static final String URL = "KOTService/services/OutletAction?wsdl";
    private static Handler handleAlerts;
    private static String isServiceAvailable;
    private static Handler serviceMessage;
    private String METHOD_NAME;
    private String SOAP_ACTION;
    Button btnOutExit;
    Button btnOutok;
    String[] outletIds;
    String[] outletNames;
    ListView outletsList;
    Map<String, String> outletsMap;
    private ProgressDialog progressDialog;
    String selectedOutletId;
    String selectedOutletName;
    private boolean soapResult;
    private Thread t1;
    private Thread t2;
    TextView windowTitleView;

    /* renamed from: sample.kot.rest.com.KOTOutletActivity.1 */
    class C00151 extends Handler {
        C00151() {
        }

        public void handleMessage(Message msg) {
            KOTOutletActivity.isServiceAvailable = (String) msg.obj;
        }
    }

    /* renamed from: sample.kot.rest.com.KOTOutletActivity.2 */
    class C00162 implements Runnable {
        C00162() {
        }

        public void run() {
            while (!KOTOutletActivity.this.soapResult) {
                try {
                    System.out.println("Sleeping");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    KOTOutletActivity.this.progressDialog.dismiss();
                    System.out.println("Thread Exception : " + e.getMessage());
                    return;
                }
            }
            KOTOutletActivity.this.progressDialog.dismiss();
        }
    }

    /* renamed from: sample.kot.rest.com.KOTOutletActivity.3 */
    class C00193 implements Runnable {

        /* renamed from: sample.kot.rest.com.KOTOutletActivity.3.1 */
        class C00171 implements Runnable {
            C00171() {
            }

            public void run() {
                KOTOutletActivity.this.populateOutlets();
            }
        }

        /* renamed from: sample.kot.rest.com.KOTOutletActivity.3.2 */
        class C00182 implements Runnable {
            C00182() {
            }

            public void run() {
                Utils.showAlert(KOTOutletActivity.this, Constants.SERVICE_UNAVAILABLE, Constants.TRY_AGAIN);
            }
        }

        C00193() {
        }

        public void run() {
            Utils.checkServiceAvailability(KOTOutletActivity.this, KOTOutletActivity.serviceMessage, Constants.REQUEST_TIME_OUT.intValue());
            while (XmlPullParser.NO_NAMESPACE.equals(KOTOutletActivity.isServiceAvailable)) {
                try {
                    Thread.sleep((long) Constants.SLEEP_TIME_1000.intValue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (Constants.TRUE.equalsIgnoreCase(KOTOutletActivity.isServiceAvailable) && KOTOutletActivity.this.loadOutlets()) {
                KOTOutletActivity.handleAlerts.post(new C00171());
                return;
            }
            KOTOutletActivity.this.soapResult = true;
            KOTOutletActivity.handleAlerts.post(new C00182());
        }
    }

    public KOTOutletActivity() {
        this.selectedOutletId = null;
        this.selectedOutletName = null;
        this.outletIds = new String[]{"RS"};
        this.outletNames = new String[]{"Roof Top Restaurant"};
        this.outletsMap = null;
        this.METHOD_NAME = "getOutlets";
        this.SOAP_ACTION = new StringBuilder(Constants.NAMESPACE).append(this.METHOD_NAME).toString();
        this.soapResult = false;
    }

    static {
        isServiceAvailable = XmlPullParser.NO_NAMESPACE;
    }

    public void onCreate(Bundle saved) {
        super.onCreate(saved);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.kot_outlet);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar);
        this.outletsList = (ListView) findViewById(R.id.listOut);
        this.btnOutok = (Button) findViewById(R.id.btnOutletOk);
        this.btnOutExit = (Button) findViewById(R.id.btnOutletExit);
        this.windowTitleView = (TextView) findViewById(R.id.window_title);
        this.outletsList.setOnItemClickListener(this);
        this.btnOutok.setOnClickListener(this);
        this.btnOutExit.setOnClickListener(this);
        this.windowTitleView.setText(getText(R.string.app_name) + " - Outlets");
        getOutlets(this);
    }

    public void onClick(View clickedView) {
        if (clickedView == this.btnOutok) {
            Editor prefsEditor = getSharedPreferences("myPrefs", Context.MODE_PRIVATE).edit();
            prefsEditor.putString("outletId", this.selectedOutletId);
            prefsEditor.putString("outletName", this.selectedOutletName);
            prefsEditor.putInt("position", 0);
            prefsEditor.putBoolean("firsttime", true);
            prefsEditor.commit();

            if (getSharedPreferences("myPrefs", Context.MODE_PRIVATE).getString("outletId", "nothing").equals("nothing")) {
                showAlert("Please select an Outlet");
            } else {
                Intent intents = getIntent();
                intents.setClass(this, KOTTableActivity.class);

                startActivity(intents);
            }


        } else if (clickedView == this.btnOutExit) {
            finish();
        }
    }

    protected void showAlert(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Alert Message");
        alert.setMessage(message);
        alert.setNegativeButton("OK", null);
        alert.show();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        view.getFocusables(position);
        view.setSelected(true);
        this.selectedOutletId = this.outletIds[position];
        this.selectedOutletName = this.outletNames[position];
    }

    private boolean loadOutlets() {
        this.soapResult = false;
        try {
            SoapObject request = new SoapObject(Constants.NAMESPACE, this.METHOD_NAME);
            request.addProperty("userId", Utils.getUserId(this));
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(request);
            new HttpTransportSE("http://" + Utils.getKotIpAddress(this) + "/" + URL).call(this.SOAP_ACTION, envelope);
            Vector soapResponse = (Vector) envelope.getResponse();
            System.out.println("Outlet Response : " + soapResponse);
            if (soapResponse != null && soapResponse.size() > 0) {
                System.out.println("Response List Size : " + soapResponse.size());
                int numberOfOutlets = soapResponse.size();
                this.outletIds = new String[numberOfOutlets];
                this.outletNames = new String[numberOfOutlets];
                String responseOutlet = XmlPullParser.NO_NAMESPACE;
                for (int loopIterator = 0; loopIterator < numberOfOutlets; loopIterator++) {
                    responseOutlet = soapResponse.get(loopIterator).toString();
                    this.outletIds[loopIterator] = responseOutlet.substring(responseOutlet.indexOf("outletId=") + 9, responseOutlet.indexOf(";", responseOutlet.indexOf("outletId=")));
                    this.outletNames[loopIterator] = responseOutlet.substring(responseOutlet.indexOf("outletDesc=") + 11, responseOutlet.indexOf(";", responseOutlet.indexOf("outletDesc=")));
                }
            }
            this.soapResult = true;
        } catch (Exception e) {
            Log.e(e.getLocalizedMessage(), e.getMessage());
        }
        return this.soapResult;
    }

    private void populateOutlets() {
        List<Map<String, String>> data = new ArrayList();
        if (this.outletIds == null || this.outletIds.length <= 0) {
            this.outletsMap = new HashMap(2);
            this.outletsMap.put("outletId", "RS");
            this.outletsMap.put("outletDesc", "Roof Top Restaurant");
            data.add(this.outletsMap);
            this.outletsMap = new HashMap(2);
            this.outletsMap.put("outletId", "BR");
            this.outletsMap.put("outletDesc", "Bar");
            data.add(this.outletsMap);
            this.outletsList.setAdapter(new SimpleAdapter(this, data, R.layout.outlet_list_item, new String[]{"outletId", "outletDesc"}, new int[]{R.id.outletId, R.id.outletName}));
            return;
        }
        int outletSize = this.outletIds.length;
        for (int i = 0; i < outletSize; i++) {
            this.outletsMap = new HashMap(2);
            this.outletsMap.put("outletId", this.outletIds[i]);
            this.outletsMap.put("outletDesc", this.outletNames[i]);
            data.add(this.outletsMap);
        }
        this.outletsList.setAdapter(new SimpleAdapter(this, data, R.layout.outlet_list_item, new String[]{"outletId", "outletDesc"}, new int[]{R.id.outletId, R.id.outletName}));
    }

    @SuppressLint({"HandlerLeak"})
    private void getOutlets(Activity activity) {
        serviceMessage = new C00151();
        handleAlerts = new Handler();
        this.t1 = new Thread(new C00162());
        this.t2 = new Thread(new C00193());
        if (isInternetConnectionOn()) {
            this.progressDialog = new ProgressDialog(this);
            this.progressDialog.setCancelable(true);
            this.progressDialog.setMessage("Loading Outlets...");
            this.progressDialog.setProgressStyle(0);
            this.progressDialog.setCancelable(false);
            this.progressDialog.show();
            this.t1.start();
            this.t2.start();
            return;
        }
        Utils.showAlert(this, Constants.INTERNET_UNAVAILABLE, Constants.CHECK_INTERNET_CONNECTION);
    }

    public void logout(View view) {
        Utils.logout(this);
    }

    public boolean isInternetConnectionOn() {
        return Utils.isInternetConnectionOn(this);
    }

    public void onBackPressed() {
    }
}
