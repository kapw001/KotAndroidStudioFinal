package sample.kot.rest.com;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.hm.kot.model.Item;
import com.hm.kot.model.KOT;
import com.hm.kot.model.Table;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParser;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import static android.content.ContentValues.TAG;

@SuppressLint({"WorldReadableFiles"})
public class KOTEntryActivity extends Activity implements OnClickListener, TextWatcher {
    private static final int FAV = 2;
    private static final int GROUP = 1;
    private static final int ITEMS = 3;
    private static final int SAVE_KOT = 4;
    private static final String URL = "KOTService/services/";
    private static String clickedButton;
    private static Handler handleAlerts;
    private static String indicatorMessage;
    private static String isServiceAvailable;
    private static Handler serviceMessage;
    private String METHOD_NAME;
    private String SOAP_ACTION;
    private String WSDL;
    private Button btnBill;
    private Button btnDel;
    private Button btnExit;
    private Button btnFav;
    private Button btnMinus;
    private Button btnPlus;
    private Button btnPrint;
    private Button btnQty;
    private Button btnSave;
    private float curX;
    private float curY;
    private String groupId;
    String[] groupIds;
    String[] groupNames;
    List<String> itemIdList;
    List<String> itemIdList_original;
    String[] itemIds;
    private List<Item> itemList;
    private List<Item> itemList_Orignal;
    String[] itemNames;
    private Map<String, KOT> kotMap;
    private LinearLayout l2;
    private TableLayout linearEntry;
    private ListView listFoodGroups;
    private float mx;
    private float my;
    private NumberFormat numberFormat;
    private String outletId;
    private String outletName;
    private ProgressDialog progressDialog;
    private int quantity;
    private String selectedItem;
    private Table selectedTable;
    private boolean soapResult;
    private Thread t1;
    private Thread t2;
    private TableLayout tableGroup;
    private String tableId;
    private String tableName;
    private String tabletId;
    private TableLayout tl;
    private ScrollView vScroll;
    private TextView windowTitleView;
    private EditText search;

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        if (s.length() > 0) {
            List<Item> fill = filter(itemList_Orignal, s.toString());
            this.itemList.clear();
            this.itemList.addAll(fill);
        } else {
            if (this.itemList != null) {
                this.itemList.clear();
                this.itemIdList.clear();
                this.itemIdList.addAll(itemIdList_original);
                this.itemList.addAll(itemList_Orignal);
            }
        }
        fillItemsLayout();

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    private List<Item> filter(List<Item> models, String query) {
        this.itemIdList.clear();
        query = query.toLowerCase();
        final List<Item> filteredModelList = new ArrayList<>();
        for (Item model : models) {

            final String text = model.getRsiDesc().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
                this.itemIdList.add(model.getRsiId());
            }

        }


        return filteredModelList;
    }


    /* renamed from: sample.kot.rest.com.KOTEntryActivity.1 */
    class C00011 implements OnItemClickListener {
        C00011() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            String s = KOTEntryActivity.this.listFoodGroups.getItemAtPosition(position).toString();
            KOTEntryActivity.this.groupId = s.substring(s.indexOf("groupId=") + 8, s.indexOf(",", s.indexOf("groupId=")));
            KOTEntryActivity.indicatorMessage = "Updating Items...";
            new ItemsAsyncTask().execute();
//            Toast.makeText(KOTEntryActivity.this, "Make request", Toast.LENGTH_SHORT).show();
        }
    }

    /* renamed from: sample.kot.rest.com.KOTEntryActivity.2 */
    class C00022 implements OnClickListener {
        C00022() {
        }

        public void onClick(View v) {
            KOTEntryActivity.this.refillKOTEntry(v.getContentDescription().toString());
        }
    }

    /* renamed from: sample.kot.rest.com.KOTEntryActivity.3 */
    class C00033 implements DialogInterface.OnClickListener {
        private final /* synthetic */ EditText val$inputQuantity;
        private final /* synthetic */ String val$selectedItemId;

        C00033(String str, EditText editText) {
            this.val$selectedItemId = str;
            this.val$inputQuantity = editText;
        }

        public void onClick(DialogInterface dialog, int whichButton) {
            if (KOTEntryActivity.this.kotMap.containsKey(this.val$selectedItemId)) {
                KOT kot = (KOT) KOTEntryActivity.this.kotMap.get(this.val$selectedItemId);
                float itemPrice = Float.parseFloat(kot.getKotPrice());
                if (!kot.getKotQty().equals("1")) {
                    itemPrice = Float.parseFloat(kot.getKotPrice()) / Float.parseFloat(kot.getKotQty());
                }
                kot.setKotQty(this.val$inputQuantity.getText().toString());
                if (Integer.parseInt(this.val$inputQuantity.getText().toString()) < KOTEntryActivity.GROUP) {
                    KOTEntryActivity.this.kotMap.remove(this.val$selectedItemId);
                }
            }
            KOTEntryActivity.this.addKOTEntry();
        }
    }

    /* renamed from: sample.kot.rest.com.KOTEntryActivity.4 */
    class C00044 extends Handler {
        C00044() {
        }

        public void handleMessage(Message msg) {
            KOTEntryActivity.isServiceAvailable = (String) msg.obj;
        }
    }

    /* renamed from: sample.kot.rest.com.KOTEntryActivity.5 */
    class C00055 implements Runnable {
        C00055() {
        }

        public void run() {
            while (!KOTEntryActivity.this.soapResult) {
                try {
                    System.out.println("Sleeping");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    if (KOTEntryActivity.this.progressDialog != null) {
                        KOTEntryActivity.this.progressDialog.dismiss();
                    }
                    System.out.println("Thread Exception : " + e.getMessage());
                    return;
                }
            }
            if (KOTEntryActivity.this.progressDialog != null) {
                KOTEntryActivity.this.progressDialog.dismiss();
            }
//            KOTEntryActivity.this.progressDialog.dismiss();
        }
    }

    /* renamed from: sample.kot.rest.com.KOTEntryActivity.6 */
    class C00146 implements Runnable {
        private final /* synthetic */ int val$methodSelector;

        /* renamed from: sample.kot.rest.com.KOTEntryActivity.6.1 */
        class C00061 implements Runnable {
            C00061() {
            }

            public void run() {
                KOTEntryActivity.this.populateGroups();
                KOTEntryActivity.this.getItemsByGroup("fav");
                KOTEntryActivity.this.fillItemsLayout();
            }
        }

        /* renamed from: sample.kot.rest.com.KOTEntryActivity.6.2 */
        class C00072 implements Runnable {
            C00072() {
            }

            public void run() {
                Utils.showAlert(KOTEntryActivity.this, Constants.SERVICE_UNAVAILABLE, Constants.TRY_AGAIN);
            }
        }

        /* renamed from: sample.kot.rest.com.KOTEntryActivity.6.3 */
        class C00083 implements Runnable {
            C00083() {
            }

            public void run() {
                KOTEntryActivity.this.fillItemsLayout();
            }
        }

        /* renamed from: sample.kot.rest.com.KOTEntryActivity.6.4 */
        class C00094 implements Runnable {
            C00094() {
            }

            public void run() {
                Utils.showAlert(KOTEntryActivity.this, Constants.SERVICE_UNAVAILABLE, Constants.TRY_AGAIN);
            }
        }

        /* renamed from: sample.kot.rest.com.KOTEntryActivity.6.5 */
        class C00105 implements Runnable {
            C00105() {
            }

            public void run() {
                KOTEntryActivity.this.fillItemsLayout();
            }
        }

        /* renamed from: sample.kot.rest.com.KOTEntryActivity.6.6 */
        class C00116 implements Runnable {
            C00116() {
            }

            public void run() {
                Utils.showAlert(KOTEntryActivity.this, Constants.SERVICE_UNAVAILABLE, Constants.TRY_AGAIN);
            }
        }

        /* renamed from: sample.kot.rest.com.KOTEntryActivity.6.7 */
        class C00127 implements Runnable {
            C00127() {
            }

            public void run() {
//                Intent intent = new Intent();
//                setResult(0, intent);
//                finish();
                Intent intent = new Intent(KOTEntryActivity.this, KOTTableActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                KOTEntryActivity.this.startActivity(intent);
            }
        }

        /* renamed from: sample.kot.rest.com.KOTEntryActivity.6.8 */
        class C00138 implements Runnable {
            C00138() {
            }

            public void run() {
                if (Constants.TRUE.equalsIgnoreCase(KOTEntryActivity.isServiceAvailable)) {
                    Utils.showAlert(KOTEntryActivity.this, Constants.SERVICE_UNAVAILABLE, Constants.TRY_AGAIN);
                } else {
                    Utils.showAlert(KOTEntryActivity.this, Constants.SAVE_FAILURE_TITLE, Constants.SAVE_FAILURE_MESSAGE);
                }
            }
        }

        C00146(int i) {
            this.val$methodSelector = i;
        }

        public void run() {
            Utils.checkServiceAvailability(KOTEntryActivity.this, KOTEntryActivity.serviceMessage, Constants.REQUEST_TIME_OUT.intValue());
            while (XmlPullParser.NO_NAMESPACE.equals(KOTEntryActivity.isServiceAvailable)) {
                try {
                    Thread.sleep((long) Constants.SLEEP_TIME_1000.intValue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            switch (this.val$methodSelector) {
                case KOTEntryActivity.GROUP /*1*/:
                    if (Constants.TRUE.equalsIgnoreCase(KOTEntryActivity.isServiceAvailable) && KOTEntryActivity.this.getGroups()) {
                        KOTEntryActivity.handleAlerts.post(new C00061());
                        KOTEntryActivity.this.soapResult = true;
                        return;
                    }
                    KOTEntryActivity.handleAlerts.post(new C00072());
                    KOTEntryActivity.this.soapResult = true;
                case KOTEntryActivity.FAV /*2*/:
                    if (Constants.TRUE.equalsIgnoreCase(KOTEntryActivity.isServiceAvailable) && KOTEntryActivity.this.getItemsByGroup("fav")) {
                        System.out.println("Inside ");
                        KOTEntryActivity.handleAlerts.post(new C00083());
                        KOTEntryActivity.this.soapResult = true;
                        return;
                    }
                    KOTEntryActivity.handleAlerts.post(new C00094());
                    KOTEntryActivity.this.soapResult = true;
                case KOTEntryActivity.ITEMS /*3*/:
                    if (Constants.TRUE.equalsIgnoreCase(KOTEntryActivity.isServiceAvailable) && KOTEntryActivity.this.getItemsByGroup(KOTEntryActivity.this.groupId)) {
                        System.out.println("Inside ");
                        KOTEntryActivity.handleAlerts.post(new C00105());
                        KOTEntryActivity.this.soapResult = true;
                        return;
                    }
                    KOTEntryActivity.handleAlerts.post(new C00116());
                    KOTEntryActivity.this.soapResult = true;
                case KOTEntryActivity.SAVE_KOT /*4*/:
                    if (Constants.TRUE.equalsIgnoreCase(KOTEntryActivity.isServiceAvailable) && KOTEntryActivity.this.saveOrUpdateKOTEntry()) {
                        System.out.println("Inside ");
                        KOTEntryActivity.handleAlerts.post(new C00127());
                        KOTEntryActivity.this.soapResult = true;
                        return;
                    }
                    KOTEntryActivity.handleAlerts.post(new C00138());
                    KOTEntryActivity.this.soapResult = true;
                default:
            }
        }
    }

    private class ItemsAsyncTask extends AsyncTask<String, Void, String> {
        private ProgressDialog Dialog;
        String response;

        private ItemsAsyncTask() {
            this.response = XmlPullParser.NO_NAMESPACE;
        }

        protected void onPreExecute() {
            this.Dialog = new ProgressDialog(KOTEntryActivity.this);
            this.Dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            this.Dialog.setMessage("Loading Items...");
            this.Dialog.setCancelable(false);
            this.Dialog.show();
        }

        protected String doInBackground(String... urls) {
            try {
                KOTEntryActivity.this.getItemsByGroup(KOTEntryActivity.this.groupId);
                this.response = "Success";
            } catch (Exception e) {
                this.response = "Failed";
            }
            return this.response;
        }

        protected void onPostExecute(String result) {
            if (this.response.equalsIgnoreCase("Success")) {
                KOTEntryActivity.this.fillItemsLayout();
                KOTEntryActivity.this.soapResult = true;
            } else {
                Toast.makeText(KOTEntryActivity.this, "Sorry Unable to retrive data. Please try again later", Toast.LENGTH_SHORT).show();
                KOTEntryActivity.this.soapResult = false;
            }
            this.Dialog.dismiss();
            this.Dialog = null;
        }
    }

    public KOTEntryActivity() {
        this.kotMap = new LinkedHashMap();
        this.METHOD_NAME = "getGroups";
        this.SOAP_ACTION = new StringBuilder(Constants.NAMESPACE).append(this.METHOD_NAME).toString();
        this.WSDL = "GroupAction?wsdl";
        this.selectedTable = null;
        this.outletId = XmlPullParser.NO_NAMESPACE;
        this.outletName = XmlPullParser.NO_NAMESPACE;
        this.tableId = XmlPullParser.NO_NAMESPACE;
        this.tableName = XmlPullParser.NO_NAMESPACE;
        this.tabletId = XmlPullParser.NO_NAMESPACE;
        this.groupId = XmlPullParser.NO_NAMESPACE;
        this.quantity = 0;
        this.itemIdList = null;
        this.itemIdList_original = null;
        this.selectedItem = XmlPullParser.NO_NAMESPACE;
        String[] strArr = new String[FAV];
        strArr[0] = "B";
        strArr[GROUP] = "C";
        this.groupIds = strArr;
        strArr = new String[FAV];
        strArr[0] = "Breakfast";
        strArr[GROUP] = "Chinese";
        this.groupNames = strArr;
        strArr = new String[ITEMS];
        strArr[0] = "MD";
        strArr[GROUP] = "AC1";
        strArr[FAV] = "AC2";
        this.itemIds = strArr;
        strArr = new String[ITEMS];
        strArr[0] = "Masala Dosa";
        strArr[GROUP] = "American Chopsey (Veg)";
        strArr[FAV] = "American Chopsey (Non-Veg)";
        this.itemNames = strArr;
        this.soapResult = false;
        this.numberFormat = null;
    }

    static {
        isServiceAvailable = XmlPullParser.NO_NAMESPACE;
        clickedButton = XmlPullParser.NO_NAMESPACE;
        indicatorMessage = "Preparing KOT...";
    }

    public void onCreate(Bundle saved) {
        super.onCreate(saved);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.entry_kot);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build();
        StrictMode.setThreadPolicy(policy);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar);

        this.l2 = (LinearLayout) findViewById(R.id.linearEntry2);
        this.listFoodGroups = (ListView) findViewById(R.id.listFoodGroups);
        this.windowTitleView = (TextView) findViewById(R.id.window_title);
        this.linearEntry = (TableLayout) findViewById(R.id.linearEntry2);
        this.tl = (TableLayout) findViewById(R.id.kotEntryTable);
        this.btnPlus = (Button) findViewById(R.id.btnPlus);
        this.btnMinus = (Button) findViewById(R.id.btnminus);
        this.btnQty = (Button) findViewById(R.id.btnQty);
        this.btnDel = (Button) findViewById(R.id.btnDel);
        this.btnSave = (Button) findViewById(R.id.btnSave);
        this.btnPrint = (Button) findViewById(R.id.btnPrint);
        this.btnBill = (Button) findViewById(R.id.btnBill);
        this.btnExit = (Button) findViewById(R.id.btnClose);
        this.btnFav = (Button) findViewById(R.id.btnFav);
        this.search = (EditText) findViewById(R.id.inputSearch);
        this.search.addTextChangedListener(this);
        this.btnPlus.setOnClickListener(this);
        this.btnMinus.setOnClickListener(this);
        this.btnQty.setOnClickListener(this);
        this.btnDel.setOnClickListener(this);
        this.btnSave.setOnClickListener(this);
        this.btnPrint.setOnClickListener(this);
        this.btnBill.setOnClickListener(this);
        this.btnExit.setOnClickListener(this);
        this.btnFav.setOnClickListener(this);
        this.outletId = getSharedPreferences("myPrefs", Context.MODE_PRIVATE).getString("outletId", "nothing");
        this.outletName = getSharedPreferences("myPrefs", Context.MODE_PRIVATE).getString("outletName", "nothing");
        this.tableId = getSharedPreferences("myPrefs", Context.MODE_PRIVATE).getString("tableId", "nothing");
        this.tableName = getSharedPreferences("myPrefs", Context.MODE_PRIVATE).getString("tableName", "nothing");
        this.tabletId = getSharedPreferences("myPrefs", Context.MODE_PRIVATE).getString("tabletId", "nothing");
        this.windowTitleView.setText(getText(R.string.app_name) + " - " + this.outletName + " - " + "Table ID : " + this.tableId);
        this.selectedTable = (Table) getIntent().getExtras().getParcelable("tableInfo");
        getSoapResponse(this, GROUP);
        this.listFoodGroups.setOnItemClickListener(new C00011());
    }

    public void onClick(View clickedView) {
        if (clickedView == this.btnPlus) {
            if (this.selectedItem.equalsIgnoreCase(XmlPullParser.NO_NAMESPACE)) {
                showAlert("Please select an Item");
            } else {
                increaseQuantity(this.selectedItem);
            }
        } else if (clickedView == this.btnMinus) {
            if (this.selectedItem.equalsIgnoreCase(XmlPullParser.NO_NAMESPACE)) {
                showAlert("Please select an Item");
            } else {
                decreaseQuantity(this.selectedItem);
            }
        } else if (clickedView == this.btnQty) {
            if (this.selectedItem.equalsIgnoreCase(XmlPullParser.NO_NAMESPACE)) {
                showAlert("Please select an Item");
            } else {
                modifyQuantity(this.selectedItem);
            }
        } else if (clickedView == this.btnDel) {
            if (this.selectedItem.equalsIgnoreCase(XmlPullParser.NO_NAMESPACE)) {
                showAlert("Please select an Item");
            } else {
                deleteSelectedItem(this.selectedItem);
            }
        } else if (clickedView == this.btnSave) {
            clickedButton = Constants.COMMAND_SAVE;
            if (this.kotMap == null || this.kotMap.size() <= 0) {
                showAlert("No items are selected");
                return;
            }
            indicatorMessage = "Updating KOT...";
            getSoapResponse(this, SAVE_KOT);
        } else if (clickedView == this.btnPrint) {
            clickedButton = Constants.COMMAND_PRINT;
            if (this.kotMap == null || this.kotMap.size() <= 0) {
                showAlert("No items are selected");
                return;
            }
            indicatorMessage = "Printing KOT...";
            getSoapResponse(this, SAVE_KOT);
        } else if (clickedView == this.btnBill) {
            clickedButton = Constants.COMMAND_BILL;
            if (this.kotMap == null || this.kotMap.size() <= 0) {
                showAlert("No items are selected");
                return;
            }
            indicatorMessage = "Printing Bill...";
            getSoapResponse(this, SAVE_KOT);
        } else if (clickedView == this.btnExit) {
            Intent intent = new Intent();
            setResult(0, intent);
            finish();
        } else if (clickedView == this.btnFav) {
            indicatorMessage = "Updating Items...";
            getSoapResponse(this, FAV);
        } else if (clickedView.getContentDescription() != null && !XmlPullParser.NO_NAMESPACE.equalsIgnoreCase(clickedView.getContentDescription().toString().trim())) {
            addKOTEntryFromItem(clickedView.getContentDescription().toString().trim());
        }
    }

    private boolean getGroups() {
        this.soapResult = false;
        this.METHOD_NAME = "getGroups";
        this.WSDL = "GroupAction?wsdl";
        try {
            SoapObject request = new SoapObject(Constants.NAMESPACE, this.METHOD_NAME);
            request.addProperty("outletId", this.outletId);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE("http://" + Utils.getKotIpAddress(this) + "/" + URL + this.WSDL);
            System.out.println("Web Service : http://" + Utils.getKotIpAddress(this) + "/" + URL + this.WSDL);
            androidHttpTransport.call(this.SOAP_ACTION, envelope);
            Vector soapResponse = (Vector) envelope.getResponse();
            if (soapResponse != null && soapResponse.size() > 0) {
                int numberOfGroups = soapResponse.size();
                this.groupIds = new String[numberOfGroups];
                this.groupNames = new String[numberOfGroups];
                String response = XmlPullParser.NO_NAMESPACE;
                for (int loopIterator = 0; loopIterator < numberOfGroups; loopIterator++) {
                    response = soapResponse.get(loopIterator).toString();
                    this.groupIds[loopIterator] = response.substring(response.indexOf("groupId=") + 8, response.indexOf(";", response.indexOf("groupId=")));
                    this.groupNames[loopIterator] = response.substring(response.indexOf("groupDesc=") + 10, response.indexOf(";", response.indexOf("groupDesc=")));
                }
            }
            this.soapResult = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception Occurs : " + e.getMessage());
        }
        return this.soapResult;
    }

    private void populateGroups() {
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        if (null != groupNames) {
            int groupSize = groupNames.length;
            for (int i = 0; i < groupSize; i++) {
                Map<String, String> groupsMap = new HashMap<String, String>(2);
                groupsMap.put("groupId", groupIds[i]);
                groupsMap.put("groupName", groupNames[i].toUpperCase());
                data.add(groupsMap);
            }

            CustomListAdapter adapter = new CustomListAdapter(this, data,
                    R.layout.group_list_item,
                    new String[]{"groupId", "groupName"},
                    new int[]{R.id.groupId, R.id.groupDescription});
            listFoodGroups.setAdapter(adapter);
        } else {
            Map<String, String> groupsMap = new HashMap<String, String>(2);
            groupsMap.put("groupId", "0");
            groupsMap.put("groupName", "No Groups found");
            data.add(groupsMap);

            CustomListAdapter adapter = new CustomListAdapter(this, data,
                    R.layout.group_list_item,
                    new String[]{"groupId", "groupName"},
                    new int[]{R.id.groupId, R.id.groupDescription});
            listFoodGroups.setAdapter(adapter);
        }
//        List<Map<String, String>> data = new ArrayList();
//        if (this.groupNames != null) {
//            int groupSize = this.groupNames.length;
//            for (int i = 0; i < groupSize; i += GROUP) {
//                Map<String, String> groupsMap = new HashMap(FAV);
//                groupsMap.put("groupId", this.groupIds[i]);
//                groupsMap.put("groupName", this.groupNames[i].toUpperCase());
//                data.add(groupsMap);
//            }
//            String[] strArr = new String[FAV];
//            strArr[0] = "groupId";
//            strArr[GROUP] = "groupName";
//            this.listFoodGroups.setAdapter(new CustomListAdapter(this, data, R.layout.group_list_item, strArr, new int[]{R.id.groupId, R.id.groupDescription}));
//            return;
//        }
//        groupsMap = new HashMap(FAV);
//        groupsMap.put("groupId", "0");
//        groupsMap.put("groupName", "No Groups found");
//        data.add(groupsMap);
//        strArr = new String[FAV];
//        strArr[0] = "groupId";
//        strArr[GROUP] = "groupName";
//        this.listFoodGroups.setAdapter(new CustomListAdapter(this, data, R.layout.group_list_item, strArr, new int[]{R.id.groupId, R.id.groupDescription}));
    }

    private boolean getItemsByGroup(String groupId) {
        this.soapResult = false;
        this.METHOD_NAME = "getItemsByGroup";
        this.WSDL = "KOTAction?wsdl";
        System.out.println("Inside getItemsByGroup");
        try {
            SoapObject request = new SoapObject(Constants.NAMESPACE, this.METHOD_NAME);
            request.addProperty("groupId", (Object) groupId);
            request.addProperty("outletId", this.outletId);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(request);
            new HttpTransportSE("http://" + Utils.getKotIpAddress(this) + "/" + URL + this.WSDL).call(this.SOAP_ACTION, envelope);
            Vector soapResponse = (Vector) envelope.getResponse();
            this.itemList = null;
            this.itemList_Orignal = null;
            this.itemIdList = null;
            this.itemIdList_original = null;
            this.itemIdList = new ArrayList();
            this.itemIdList_original = new ArrayList();
            this.itemList = new ArrayList();
            this.itemList_Orignal = new ArrayList<>();
            if (soapResponse != null && soapResponse.size() > 0) {
                int numberOfKOTEntries = soapResponse.size();
                for (int loopIterator = 0; loopIterator < numberOfKOTEntries; loopIterator++) {
                    String kotInfo = soapResponse.get(loopIterator).toString();
                    Item item = new Item();
                    item.setRsiId(kotInfo.substring(kotInfo.indexOf("rsiId=") + 6, kotInfo.indexOf(";", kotInfo.indexOf("rsiId="))));
                    item.setRsiDesc(kotInfo.substring(kotInfo.indexOf("rsiDesc=") + 8, kotInfo.indexOf(";", kotInfo.indexOf("rsiDesc="))));
                    item.setRsiUnit(kotInfo.substring(kotInfo.indexOf("rsiUnit=") + 8, kotInfo.indexOf(";", kotInfo.indexOf("rsiUnit="))));
                    item.setRsiType(kotInfo.substring(kotInfo.indexOf("rsiType=") + 8, kotInfo.indexOf(";", kotInfo.indexOf("rsiType="))));
                    item.setRsiGroup(kotInfo.substring(kotInfo.indexOf("rsiGroup=") + 9, kotInfo.indexOf(";", kotInfo.indexOf("rsiGroup="))));
                    item.setRsiCatId(kotInfo.substring(kotInfo.indexOf("rsiCatId=") + 9, kotInfo.indexOf(";", kotInfo.indexOf("rsiCatId="))));
                    item.setRsiIsStock(kotInfo.substring(kotInfo.indexOf("rsiIsStock=") + 11, kotInfo.indexOf(";", kotInfo.indexOf("rsiIsStock="))));
                    item.setRsiCost(kotInfo.substring(kotInfo.indexOf("rsiCost=") + 8, kotInfo.indexOf(";", kotInfo.indexOf("rsiCost="))));
                    this.itemIdList.add(item.getRsiId());
                    this.itemIdList_original.add(item.getRsiId());
                    this.itemList.add(item);
                    this.itemList_Orignal.add(item);
                }
            }
            this.soapResult = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception Occurs : " + e.getMessage());
        }
        return this.soapResult;
    }

    private void fillItemsLayout() {
        System.out.println("Inside fillItemsLayout");
        this.linearEntry.removeAllViews();
        if (this.itemList != null && this.itemList.size() > 0) {
            int itemListSize = this.itemList.size();
            int itemRowSize = (this.itemList.size() / 5) + (this.itemList.size() % 5 > 0 ? GROUP : 0);
            int j = 0;
            for (int i = 1; i <= itemRowSize; i++) {
                TextView textView;
                LayoutParams tvParams;
                TableRow tableRow = new TableRow(this);
                LayoutParams trParams = new LayoutParams(-1, -2);
                trParams.setMargins(GROUP, GROUP, 0, 0);
                while (j < i * 5 && j < itemListSize) {
                    Item item = (Item) this.itemList.get(j);
                    textView = new TextView(this);
                    tvParams = new LayoutParams(0, -1, 0.2f);
                    tvParams.setMargins(0, 0, GROUP, GROUP);
                    textView.setPadding(GROUP, 5, GROUP, 5);
                    textView.setGravity(17);
                    textView.setTextSize(15.0f);
                    textView.setText(item.getRsiDesc());
                    textView.setTextColor(Color.BLACK);
                    textView.setContentDescription(item.getRsiId());
                    textView.setOnClickListener(this);
                    if ((j + GROUP) % FAV == 0) {
                        textView.setBackgroundResource(R.color.item_even);
                    } else {
                        textView.setBackgroundResource(R.color.item_odd);
                    }
                    textView.setMinLines(ITEMS);
                    tableRow.addView(textView, tvParams);
                    j += GROUP;
                }
                if (j == itemListSize) {
                    while (j < 5 * itemRowSize) {
                        System.out.println("Extra Values");
                        textView = new TextView(this);
                        tvParams = new LayoutParams(0, -1, 0.2f);
                        tvParams.setMargins(0, 0, GROUP, GROUP);
                        textView.setPadding(GROUP, 5, GROUP, 5);
                        textView.setGravity(17);
                        textView.setTextSize(15.0f);
                        textView.setText("No Items");
                        textView.setTextColor(Color.BLACK);
                        textView.setContentDescription("No Items Found");
                        textView.setMinLines(ITEMS);
                        tableRow.addView(textView, tvParams);
                        j += GROUP;
                    }
                }
                this.linearEntry.addView(tableRow, trParams);
            }
        }
    }

    private void refillKOTEntry(String itemId) {
        this.selectedItem = itemId;
        addKOTEntry();
    }

    private void addKOTEntryFromItem(String selectedItemId) {
        if (this.itemIdList != null && this.itemIdList.size() > 0 && this.itemIdList.contains(selectedItemId)) {
            Item item = (Item) this.itemList.get(this.itemIdList.indexOf(selectedItemId));
            KOT kot;
            if (this.kotMap.containsKey(selectedItemId)) {
                kot = (KOT) this.kotMap.get(selectedItemId);
                if (this.quantity == 0) {
                    kot.setKotQty(new StringBuilder(String.valueOf(Integer.parseInt(kot.getKotQty()) + GROUP)).toString());
                } else {
                    kot.setKotQty(new StringBuilder(String.valueOf(this.quantity)).toString());
                    this.quantity = 0;
                }
            } else {
                kot = new KOT();
                System.out.println("Selected Table : " + this.selectedTable);
                kot.setKotRef(this.selectedTable.getTableRef());
                kot.setKotSlNo(new StringBuilder(String.valueOf(this.kotMap.size() + GROUP)).toString());
                kot.setKotOutlet(this.outletId);
                kot.setKotStatus("0");
                kot.setKotTId(this.tableId);
                kot.setKotItId(item.getRsiId());
                kot.setKotItemDesc(item.getRsiDesc());
                kot.setKotQty("1");

                kot.setKotPrice(new StringBuilder(String.valueOf(Float.parseFloat(item.getRsiCost()))).toString());
                kot.setKotGroup(item.getRsiGroup());
                kot.setKotCat(item.getRsiCatId());
                kot.setKotOperId(this.tabletId);
                this.kotMap.put(item.getRsiId(), kot);
            }
        }
        addKOTEntry();
    }

    private void addKOTEntry() {
        this.tl.removeAllViews();
        this.numberFormat = NumberFormat.getInstance();
        this.numberFormat.setMinimumFractionDigits(FAV);
        this.numberFormat.setMaximumFractionDigits(FAV);
        int i = 1;
        for (KOT kotTemp : this.kotMap.values()) {
            TableRow tr = new TableRow(this);
            new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT).setMargins(1, 1, 0, 0);
            tr.setBackgroundColor(Color.BLACK);
            tr.setContentDescription(kotTemp.getKotItId());
            tr.setOnClickListener(new C00022());
            TextView textView = new TextView(this);
            LayoutParams tvParams = new LayoutParams(0, LayoutParams.MATCH_PARENT, 0.12f);
            tvParams.setMargins(0, 0, 1, 1);
            kotTemp.setKotSlNo(new StringBuilder(String.valueOf(i)).toString());
            textView.setText(kotTemp.getKotSlNo());
            textView.setGravity(17);
            textView.setMinLines(FAV);
            if (this.selectedItem.equalsIgnoreCase(kotTemp.getKotItId())) {
                textView.setBackgroundResource(R.drawable.cell_shape_selected);
            } else {
                textView.setBackgroundResource(R.drawable.cell_shape_contents);
                if (i % FAV == 0) {
                    textView.setBackgroundColor(getResources().getColor(R.color.row_even));
                }
            }
            textView.setTextAppearance(getApplicationContext(), R.style.contentsTextStyle);
            tr.addView(textView, tvParams);
            textView = new TextView(this);
            tvParams = new LayoutParams(0, -1, 0.55f);
            tvParams.setMargins(0, 0, GROUP, GROUP);
            textView.setText(kotTemp.getKotItemDesc());
            textView.setGravity(17);
            textView.setMinLines(FAV);
            if (this.selectedItem.equalsIgnoreCase(kotTemp.getKotItId())) {
                textView.setBackgroundResource(R.drawable.cell_shape_selected);
            } else {
                textView.setBackgroundResource(R.drawable.cell_shape_contents);
                if (i % FAV == 0) {
                    textView.setBackgroundColor(getResources().getColor(R.color.row_even));
                }
            }
            textView.setTextAppearance(getApplicationContext(), R.style.contentsTextStyle);
            tr.addView(textView, tvParams);
            textView = new TextView(this);
            tvParams = new LayoutParams(0, -1, 0.13f);
            tvParams.setMargins(0, 0, GROUP, GROUP);
            textView.setText(kotTemp.getKotQty());
            textView.setGravity(17);
            textView.setMinLines(FAV);
            if (this.selectedItem.equalsIgnoreCase(kotTemp.getKotItId())) {
                textView.setBackgroundResource(R.drawable.cell_shape_selected);
            } else {
                textView.setBackgroundResource(R.drawable.cell_shape_contents);
                if (i % FAV == 0) {
                    textView.setBackgroundColor(getResources().getColor(R.color.row_even));
                }
            }
            textView.setTextAppearance(getApplicationContext(), R.style.contentsTextStyle);
            tr.addView(textView, tvParams);
            textView = new TextView(this);
            tvParams = new LayoutParams(0, -1, 0.2f);
            tvParams.setMargins(0, 0, GROUP, GROUP);
            textView.setText(this.numberFormat.format((double) Float.parseFloat(kotTemp.getKotPrice())));
            textView.setGravity(17);
            textView.setMinLines(FAV);
            if (this.selectedItem.equalsIgnoreCase(kotTemp.getKotItId())) {
                textView.setBackgroundResource(R.drawable.cell_shape_selected);
            } else {
                textView.setBackgroundResource(R.drawable.cell_shape_contents);
                if (i % FAV == 0) {
                    textView.setBackgroundColor(getResources().getColor(R.color.row_even));
                }
            }
            textView.setTextAppearance(getApplicationContext(), R.style.contentsTextStyle);
            tr.addView(textView, tvParams);
            this.tl.addView(tr);
            i++;
        }
    }

    private void increaseQuantity(String selectedItemId) {
        if (this.kotMap.containsKey(selectedItemId)) {
            KOT kot = (KOT) this.kotMap.get(selectedItemId);
            float itemPrice = Float.parseFloat(kot.getKotPrice());
            if (!kot.getKotQty().equals("1")) {
                itemPrice = Float.parseFloat(kot.getKotPrice()) / Float.parseFloat(kot.getKotQty());
            }
            kot.setKotQty(new StringBuilder(String.valueOf(Integer.parseInt(kot.getKotQty()) + 1)).toString());
        }
        addKOTEntry();
    }

    private void decreaseQuantity(String selectedItemId) {
        if (this.kotMap.containsKey(selectedItemId)) {
            KOT kot = (KOT) this.kotMap.get(selectedItemId);
            if (Integer.parseInt(kot.getKotQty()) > 1) {
                float itemPrice = Float.parseFloat(kot.getKotPrice());
                if (!kot.getKotQty().equals("1")) {
                    itemPrice = Float.parseFloat(kot.getKotPrice()) / Float.parseFloat(kot.getKotQty());
                }
                kot.setKotQty(new StringBuilder(String.valueOf(Integer.parseInt(kot.getKotQty()) - 1)).toString());
            } else {
                this.kotMap.remove(selectedItemId);
            }
        }
        addKOTEntry();
    }

    protected void modifyQuantity(String selectedItemId) {
        Builder alert = new Builder(this);
        alert.setTitle("Quantity");
        alert.setMessage("Enter your quantity");
        EditText inputQuantity = new EditText(this);
        inputQuantity.setInputType(FAV);
        alert.setView(inputQuantity);
        alert.setPositiveButton("OK", new C00033(selectedItemId, inputQuantity));
        alert.setNegativeButton("CANCEL", null);
        alert.show();
    }

    private void deleteSelectedItem(String selectedItemId) {
        if (this.kotMap.containsKey(selectedItemId)) {
            this.kotMap.remove(selectedItemId);
        }
        addKOTEntry();
    }

    protected void showAlert(String message) {
        Builder alert = new Builder(this);
        alert.setTitle("Alert Message");
        alert.setMessage(message);
        alert.setNegativeButton("OK", null);
        alert.show();
    }


    private boolean saveOrUpdateKOTEntry() {
        this.soapResult = false;
        if (this.kotMap != null && this.kotMap.size() > 0) {
            if (clickedButton.equalsIgnoreCase(Constants.COMMAND_SAVE)) {
                this.METHOD_NAME = "saveKOT";
            } else if (clickedButton.equalsIgnoreCase(Constants.COMMAND_PRINT)) {
                this.METHOD_NAME = "saveAndPrintKOT";
            } else if (clickedButton.equalsIgnoreCase(Constants.COMMAND_BILL)) {
                this.METHOD_NAME = "savePrintAndBillKot";
            }
            try {
                PropertyInfo propertyInfo;
                SoapObject request = new SoapObject(Constants.NAMESPACE, this.METHOD_NAME);
                for (KOT kot : this.kotMap.values()) {
                    propertyInfo = new PropertyInfo();
                    propertyInfo.setName("kotEntry");
                    kot.setKotPrice(new StringBuilder(String.valueOf(Float.parseFloat(kot.getKotPrice()))).toString());
                    propertyInfo.setValue(kot);
                    propertyInfo.setType(KOT.class);
                    request.addProperty(propertyInfo);
                }

                Table table = this.selectedTable;
                table.setTableId(this.tableId);
                table.setTableOutlet(this.outletId);
                table.setTableCaptainId(Utils.getUserId(this));
                table.setTableCover(FAV);
                table.setTableOccupied("1");
                propertyInfo = new PropertyInfo();
                propertyInfo.setName("tableInfo");
                propertyInfo.setValue(table);
                propertyInfo.setType(Table.class);
                request.addProperty(propertyInfo);
                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.setAddAdornments(false);
                envelope.implicitTypes = true;
                envelope.setOutputSoapObject(request);
                HttpTransportSE httpTransportSE = new HttpTransportSE("http://" + Utils.getKotIpAddress(this) + "/" + URL + this.WSDL);
                httpTransportSE.debug = true;
                httpTransportSE.call(this.SOAP_ACTION, envelope);
//                Log.e(TAG, "saveOrUpdateKOTEntry: Url " + "http://" + Utils.getKotIpAddress(this) + "/" + URL + this.WSDL);
//                Log.e(TAG, "saveOrUpdateKOTEntry: method " + this.SOAP_ACTION);
//                Log.e(TAG, "doInBackground: request " + httpTransportSE.requestDump);
//                Log.e(TAG, "doInBackground: response " + httpTransportSE.responseDump);
//                Log.e(TAG, "saveOrUpdateKOTEntry: " + request.toString());
                Object soapResponse = envelope.getResponse();

                System.out.println(soapResponse);
                if (soapResponse.toString().equalsIgnoreCase(Constants.TRUE)) {
                    this.soapResult = true;
                }
            } catch (Exception e) {
                this.soapResult = false;
                System.out.println("Exception Occurs : " + e.getMessage());
                e.printStackTrace();
            }
        }
        return this.soapResult;
    }

    @SuppressLint({"HandlerLeak"})
    private void getSoapResponse(Activity activity, int methodSelector) {
        serviceMessage = new C00044();
        handleAlerts = new Handler();
        this.t1 = new Thread(new C00055());
        this.t2 = new Thread(new C00146(methodSelector));
        if (isInternetConnectionOn()) {
            if (this.progressDialog == null) {
                this.progressDialog = new ProgressDialog(this);
                this.progressDialog.setMessage(indicatorMessage);
//            this.progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                this.progressDialog.setCancelable(false);
                this.progressDialog.show();
            }
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
        finish();
    }
}
