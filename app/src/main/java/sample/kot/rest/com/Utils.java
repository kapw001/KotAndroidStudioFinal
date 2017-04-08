/**
 *
 */
package sample.kot.rest.com;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * @author jaiganeshk
 */
@SuppressLint("WorldReadableFiles")
public class Utils {

    /**
     * @return true if Internet Connection is available
     */
    public static boolean isInternetConnectionOn(Context context) {
        System.out.println("Connection method inside Utils class");
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) { // connected to the internet
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                return true;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                return true;
            }
        } else {
            return false;
            // not connected to the internet
        }
//        if (connectivityManager.getNetworkInfo(0).getState() == State.CONNECTED || connectivityManager.getNetworkInfo(1).getState() == State.CONNECTED) {
//            return true;
//        }
        return false;
    }

	/*public boolean checkServiceAvailability(Context context, final int timeout){
        boolean responded = false;
		HttpURLConnection serviceTest;
		try{
			URL url = new URL("http://"+getKotIpAddress(context)+"/KOTService");
			serviceTest = (HttpURLConnection) url.openConnection();
			HttpURLConnection.setFollowRedirects(false);
			serviceTest.setConnectTimeout(timeout);
			serviceTest.setRequestMethod("GET");
			serviceTest.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)");
			serviceTest.connect();
			responded = true;
			Message messsage = new Message();
			messsage.obj = Constants.TRUE;
			handler.sendMessage(messsage);
			System.out.println("Connected");
		}
		catch(Exception e){
			responded = false;
			System.out.println("Timeout");
		}
		return responded;
	}*/

    /**
     * @param handler
     * @param timeout
     */
    public static void checkServiceAvailability(final Context context, final Handler handler, final int timeout) {
        System.out.println("Inside checkServiceAvailability ");
        new Thread() {
            private boolean responded = false;
            HttpURLConnection serviceTest;

            @Override
            public void run() {

                new Thread() {
                    @Override
                    public void run() {
                        try {
                            URL url = new URL("http://" + getKotIpAddress(context) + "/KOTService");
                            serviceTest = (HttpURLConnection) url.openConnection();
                            HttpURLConnection.setFollowRedirects(false);
                            serviceTest.setConnectTimeout(timeout);
                            serviceTest.setRequestMethod("GET");
                            serviceTest.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)");
                            serviceTest.connect();
                            responded = true;
                            System.out.println("Connected");
                            Log.e(TAG, "run: Connected " + responded);
                        } catch (Exception e) {
                            responded = false;
                            System.out.println("Timeout");
                            Log.e(TAG, "run: Timeout " + responded);
                        }
                    }

                }.start();

                try {
                    int waited = 0;
                    while (!responded && (waited <= timeout)) {
                        sleep(Constants.SLEEP_TIME_100);
                        if (!responded) {
                            waited += Constants.SLEEP_TIME_100;
                        }
                    }
                } catch (InterruptedException e) {
                } // do nothing
                finally {
                    if (!responded) {
                        Message messsage = new Message();
                        messsage.obj = Constants.FALSE;
                        handler.sendMessage(messsage);
                    } else {
                        Message messsage = new Message();
                        messsage.obj = Constants.TRUE;
                        handler.sendMessage(messsage);
                    }
                }
            }
        }.start();

    }

    /**
     * @param context
     */
    public static void logout(final Context context) {
        System.out.println("Logout method inside Utils class");

        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setCancelable(false);
        alert.setTitle("Logout");
        alert.setMessage("Are you sure want to logout?");

        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                @SuppressWarnings("static-access")
                SharedPreferences myPrefs = context.getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor prefsEditor = myPrefs.edit();
                prefsEditor.putString("tableId", "nothing");
                prefsEditor.putString("outletId", "nothing");
                prefsEditor.putString("userId", "nothing");
                prefsEditor.commit();
                Intent intent = new Intent(context, KotLoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        alert.setNegativeButton("No", null);
        alert.show();
    }

    /**
     * @param context
     * @param title
     * @param message
     */
    public static void showAlert(Context context, final String title, final String message) {
        // TODO Auto-generated method stub
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle(title);
        alert.setMessage(message);
        alert.setCancelable(false);
        alert.setNegativeButton("OK", null);
        alert.show();
    }

    /**
     * @param context
     * @return userId
     */
    public static String getUserId(Context context) {
        return (context.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)).getString("userId", "nothing");
    }

    /**
     * @param context
     * @return kotIpAddress
     */
    public static String getKotIpAddress(Context context) {
        return (context.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)).getString("kotIp", "nothing");
    }

    public static String formatDate(String currentDateTime) {
        String formattedDate = "00-00-00 00:00:00";
        SimpleDateFormat dateFormatFrom = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormatTo = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
        try {
            Date convertedDate = dateFormatFrom.parse(currentDateTime);
            formattedDate = dateFormatTo.format(convertedDate);
            System.out.println(dateFormatTo.format(convertedDate));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            Log.e("ER001", e.getMessage());
        }

        return formattedDate;
    }
}
