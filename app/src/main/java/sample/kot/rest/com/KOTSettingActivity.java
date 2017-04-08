package sample.kot.rest.com;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

@SuppressLint({"WorldReadableFiles"})
public class KOTSettingActivity extends Activity implements OnClickListener {
    Button exit;
    EditText kotIpAddressView;
    Button save;
    EditText tabletIdText;
    TextView txtIp;

    public void onCreate(Bundle saved) {
        super.onCreate(saved);
        setContentView(R.layout.kot_settings);
        this.kotIpAddressView = (EditText) findViewById(R.id.edtIpAddress);
        this.tabletIdText = (EditText) findViewById(R.id.editTabletId);
        this.txtIp = (TextView) findViewById(R.id.txtIP);
        this.save = (Button) findViewById(R.id.btnSettingSave);
        this.exit = (Button) findViewById(R.id.btnSettingExit);
        this.save.setOnClickListener(this);
        this.exit.setOnClickListener(this);
        this.txtIp.setText("IP Address of KOT Server");
        SharedPreferences myPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        if (!myPref.getString("kotIp", "nothing").equalsIgnoreCase("nothing")) {
            this.kotIpAddressView.setText(myPref.getString("kotIp", XmlPullParser.NO_NAMESPACE));
        }
        if (!myPref.getString("tabletId", "nothing").equalsIgnoreCase("nothing")) {
            this.tabletIdText.setText(myPref.getString("tabletId", XmlPullParser.NO_NAMESPACE));
        }
    }

    public void onClick(View v) {
        Intent intent;
        if (v == this.save) {
            if (XmlPullParser.NO_NAMESPACE.equals(this.kotIpAddressView.getText().toString().trim()) || XmlPullParser.NO_NAMESPACE.equals(this.tabletIdText.getText().toString().trim())) {
                if (XmlPullParser.NO_NAMESPACE.equals(this.kotIpAddressView.getText().toString().trim())) {
                    this.kotIpAddressView.setError("IP Address is Required");
                }
                if (XmlPullParser.NO_NAMESPACE.equals(this.tabletIdText.getText().toString().trim())) {
                    this.tabletIdText.setError("Tablet ID is Required");
                    return;
                }
                return;
            }
            Editor prefsEditor = getSharedPreferences("myPrefs", Context.MODE_PRIVATE).edit();
            prefsEditor.putString("kotIp", XmlPullParser.NO_NAMESPACE.equals(this.kotIpAddressView.getText().toString().trim()) ? "nothing" : this.kotIpAddressView.getText().toString().trim());
            prefsEditor.putString("tabletId", XmlPullParser.NO_NAMESPACE.equals(this.tabletIdText.getText().toString().trim()) ? "nothing" : this.tabletIdText.getText().toString().trim());
            prefsEditor.commit();
            Toast.makeText(getApplicationContext(), "IP Address & Tablet ID saved successfully", Toast.LENGTH_SHORT).show();
            intent = new Intent(this, KotLoginActivity.class);
            intent.addFlags(67108864);
            startActivity(intent);
        } else if (v == this.exit) {
            intent = new Intent(this, KotLoginActivity.class);
            intent.addFlags(67108864);
            startActivity(intent);
        }
    }
}
