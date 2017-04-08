package sample.kot.rest.com;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressLint({"WorldReadableFiles"})
public class KotRestActivity extends Activity implements OnClickListener {
    private Button btnOutlet;
    private Button btnTable;
    private String outletId;
    private String outletName;
    private TextView windowTitleView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.home);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar);
        this.btnTable = (Button) findViewById(R.id.btnTable);
        this.btnOutlet = (Button) findViewById(R.id.btnOutlet);
        this.windowTitleView = (TextView) findViewById(R.id.window_title);
        this.btnTable.setOnClickListener(this);
        this.btnOutlet.setOnClickListener(this);
        this.windowTitleView.setText(getText(R.string.app_name));
        this.outletId = getSharedPreferences("myPrefs", Context.MODE_PRIVATE).getString("outletId", "nothing");
        this.outletName = getSharedPreferences("myPrefs", Context.MODE_PRIVATE).getString("outletName", "nothing");
        if (this.outletId.equalsIgnoreCase("nothing")) {
            ((RelativeLayout) findViewById(R.id.outletInfo)).setVisibility(View.GONE);
            return;
        }
        ((RelativeLayout) findViewById(R.id.outletInfo)).setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.outletInfoText)).setText(this.outletName);
        ((TextView) findViewById(R.id.kotIpText)).setText(Utils.getKotIpAddress(this));
        ((TextView) findViewById(R.id.tabletIpText)).setText(getSharedPreferences("myPrefs", Context.MODE_PRIVATE).getString("tabletId", "nothing"));
    }

    public void onClick(View view) {
        if (view == this.btnTable) {
            if (getSharedPreferences("myPrefs", Context.MODE_PRIVATE).getString("outletId", "nothing").equals("nothing")) {
                showAlert("Please select an Outlet");
            } else {
                startActivity(new Intent(this, KOTTableActivity.class));
            }
        } else if (view == this.btnOutlet) {
            startActivity(new Intent(this, KOTOutletActivity.class));
        }
    }

    protected void showAlert(String message) {
        Builder alert = new Builder(this);
        alert.setTitle("Alert Message");
        alert.setMessage(message);
        alert.setNegativeButton("OK", null);
        alert.show();
    }

    public void onBackPressed() {
        Utils.logout(this);
    }

    public void logout(View view) {
        Utils.logout(this);
    }
}
