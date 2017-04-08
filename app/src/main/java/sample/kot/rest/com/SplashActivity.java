package sample.kot.rest.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(getApplicationContext(), KotLoginActivity.class);
                startActivity(intent);

            }
        }, 2000);
    }
}
