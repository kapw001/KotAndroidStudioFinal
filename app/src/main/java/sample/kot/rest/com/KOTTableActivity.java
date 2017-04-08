package sample.kot.rest.com;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
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
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.hm.kot.model.KOT;
import com.hm.kot.model.Table;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParser;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import static android.content.ContentValues.TAG;

@SuppressLint({"WorldReadableFiles"})
public class KOTTableActivity extends Activity implements OnClickListener, OnItemClickListener, TextWatcher {
    private static final int KOT = 2;
    private static final int TABLE = 1;
    private static final String URL = "KOTService/services/";
    private static Handler handleAlerts;
    private static String isServiceAvailable;
    private static Handler serviceMessage;
    private String METHOD_NAME;
    private String SOAP_ACTION;
    private String WSDL;
    Button btnDeleteEntry;
    Button btnExit;
    Button btnKot;
    Button btnPrintBill;
    Button btnPrintKot;
    Button btnSave;
    private List<KOT> kotList;
    private Map<String, KOT> kotMap;
    ListView listTablesView;
    private NumberFormat numberFormat;
    private String outletId;
    private String outletName;
    private ProgressDialog progressDialog;
    List<TableRowItem> rowItems;
    private String selectedKOTNumber;
    Table selectedTable;
    private String selectedTableAvailability;
    private String selectedTableId;
    private boolean soapResult;
    private Thread t1;
    private Thread t2;
    TableLayout tableLayoutKot;
    private List<Table> tablesList;
    private List<Table> filteredtablesList;
    TextView windowTitleView;

    boolean refillTableItemSelected = false;

    private EditText search;

    private CustomBaseAdapter customBaseAdapter;
//    List<TableRowItem> rowItems;

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        final List<Table> filteredModelList = filter(this.tablesList, s.toString());

        List<Map<String, Object>> data = new ArrayList();
        if (filteredModelList != null) {
            int tableSize = filteredModelList.size();
            this.rowItems = new ArrayList();
            for (int i = 0; i < tableSize; i++) {
                int imageId;
                String tableRef;
                Table table = (Table) filteredModelList.get(i);
                if (table.getTableOccupied().equals("1")) {
                    imageId = R.drawable.occupied_indicator;
                    tableRef = table.getTableRef();
                } else {
                    imageId = R.drawable.vacant_indicator;
                    tableRef = XmlPullParser.NO_NAMESPACE;
                }
                this.rowItems.add(new TableRowItem(imageId, " " + table.getTableId(), tableRef));
            }
            customBaseAdapter.updateList(this.rowItems);
        }
        if (filteredModelList != null) {
            filteredtablesList.clear();
            filteredtablesList.addAll(filteredModelList);
        }

    }


    private List<Table> filter(List<Table> models, String query) {
        query = query.toLowerCase();
        final List<Table> filteredModelList = new ArrayList<>();
        if (!filteredModelList.isEmpty()) {
            for (Table model : models) {

                final String text = model.getTableId().toLowerCase();
                if (text.contains(query)) {
                    filteredModelList.add(model);
                }

            }
        }


        return filteredModelList;
    }

    @Override
    public void afterTextChanged(Editable s) {

    }


    /* renamed from: sample.kot.rest.com.KOTTableActivity.1 */
    class C00201 implements Runnable {
        C00201() {
        }

        public void run() {
            KOTTableActivity.this.fillTableLayout();
        }
    }

    /* renamed from: sample.kot.rest.com.KOTTableActivity.2 */
    class C00212 implements OnClickListener {
        C00212() {
        }

        public void onClick(View v) {
            KOTTableActivity.this.refillTableLayout(v.getContentDescription().toString());
        }
    }

    /* renamed from: sample.kot.rest.com.KOTTableActivity.3 */
    class C00223 implements OnClickListener {
        C00223() {
        }

        public void onClick(View v) {
            KOTTableActivity.this.refillTableLayout(v.getContentDescription().toString());
        }
    }

    /* renamed from: sample.kot.rest.com.KOTTableActivity.4 */
    class C00234 extends Handler {
        C00234() {
        }

        public void handleMessage(Message msg) {
            KOTTableActivity.isServiceAvailable = (String) msg.obj;
        }
    }

    /* renamed from: sample.kot.rest.com.KOTTableActivity.5 */
    class C00245 implements Runnable {
        C00245() {
        }

        public void run() {


            while (!KOTTableActivity.this.soapResult) {
                try {
                    System.out.println("Sleeping");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    if (KOTTableActivity.this.progressDialog != null) {

                        KOTTableActivity.this.progressDialog.dismiss();
                        KOTTableActivity.this.progressDialog = null;
                    }
                    System.out.println("Thread Exception : " + e.getMessage());
                    return;
                }
            }

            try {
                System.out.println("Sleeping");
                Thread.sleep(1000);
                if (KOTTableActivity.this.progressDialog != null) {
                    KOTTableActivity.this.progressDialog.dismiss();
                    KOTTableActivity.this.progressDialog = null;
                }
            } catch (InterruptedException e) {
                if (KOTTableActivity.this.progressDialog != null) {
                    KOTTableActivity.this.progressDialog.dismiss();
                    KOTTableActivity.this.progressDialog = null;
                }
                System.out.println("Thread Exception : " + e.getMessage());
                return;
            }


        }
    }

    /* renamed from: sample.kot.rest.com.KOTTableActivity.6 */
    class C00286 implements Runnable {
        private final /* synthetic */ int val$methodSelector;

        /* renamed from: sample.kot.rest.com.KOTTableActivity.6.1 */
        class C00251 implements Runnable {
            C00251() {
            }

            public void run() {
                KOTTableActivity.this.populateTables();
            }
        }

        /* renamed from: sample.kot.rest.com.KOTTableActivity.6.2 */
        class C00262 implements Runnable {
            C00262() {
            }

            public void run() {
                Utils.showAlert(KOTTableActivity.this, Constants.SERVICE_UNAVAILABLE, Constants.TRY_AGAIN);
            }
        }

        /* renamed from: sample.kot.rest.com.KOTTableActivity.6.3 */
        class C00273 implements Runnable {
            C00273() {
            }

            public void run() {
                Utils.showAlert(KOTTableActivity.this, Constants.SERVICE_UNAVAILABLE, Constants.TRY_AGAIN);
            }
        }

        C00286(int i) {
            this.val$methodSelector = i;
        }

        public void run() {
            Utils.checkServiceAvailability(KOTTableActivity.this, KOTTableActivity.serviceMessage, Constants.REQUEST_TIME_OUT.intValue());
            while (XmlPullParser.NO_NAMESPACE.equals(KOTTableActivity.isServiceAvailable)) {
                try {
                    Thread.sleep((long) Constants.SLEEP_TIME_1000.intValue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            switch (this.val$methodSelector) {
                case KOTTableActivity.TABLE /*1*/:
                    if (Constants.TRUE.equalsIgnoreCase(KOTTableActivity.isServiceAvailable) && KOTTableActivity.this.loadTables()) {
                        KOTTableActivity.handleAlerts.post(new C00251());
                        return;
                    }
                    KOTTableActivity.this.soapResult = true;
                    KOTTableActivity.handleAlerts.post(new C00262());
                case KOTTableActivity.KOT /*2*/:
                    if (Constants.TRUE.equalsIgnoreCase(KOTTableActivity.isServiceAvailable) && KOTTableActivity.this.loadKotEntries()) {
                        System.out.println("Inside ");
                        return;
                    }
                    KOTTableActivity.handleAlerts.post(new C00273());
                    KOTTableActivity.this.soapResult = true;
                default:
            }
        }
    }

    public KOTTableActivity() {
        this.selectedTable = null;
        this.outletId = null;
        this.outletName = null;
        this.selectedTableId = null;
        this.selectedTableAvailability = null;
        this.selectedKOTNumber = XmlPullParser.NO_NAMESPACE;
        this.kotList = null;
        this.tablesList = null;
        this.METHOD_NAME = "getTables";
        this.SOAP_ACTION = new StringBuilder(Constants.NAMESPACE).append(this.METHOD_NAME).toString();
        this.kotMap = null;
        this.WSDL = "TableAction?wsdl";
        this.soapResult = false;
        this.numberFormat = null;
    }

    static {
        isServiceAvailable = XmlPullParser.NO_NAMESPACE;
    }

    public void onCreate(Bundle saved) {
        super.onCreate(saved);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.table_kot);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build();
        StrictMode.setThreadPolicy(policy);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar);
        rowItems = new ArrayList<>();
        customBaseAdapter = new CustomBaseAdapter(this, this.rowItems);

        this.listTablesView = (ListView) findViewById(R.id.tableNames);
        listTablesView.setAdapter(customBaseAdapter);
        this.btnPrintBill = (Button) findViewById(R.id.btnTablePrintBill);
        this.btnPrintKot = (Button) findViewById(R.id.btnTablePrintKot);
        this.btnDeleteEntry = (Button) findViewById(R.id.btnTableDeleteEntry);
        this.search = (EditText) findViewById(R.id.inputSearch);
        this.btnSave = (Button) findViewById(R.id.btnTableSave);
        this.btnExit = (Button) findViewById(R.id.btnTableExit);
        this.btnKot = (Button) findViewById(R.id.btnTableKot);
        this.windowTitleView = (TextView) findViewById(R.id.window_title);
        this.tableLayoutKot = (TableLayout) findViewById(R.id.tableLayoutKot);
        this.listTablesView.setOnItemClickListener(this);
        this.btnPrintBill.setOnClickListener(this);
        this.btnPrintKot.setOnClickListener(this);
        this.btnDeleteEntry.setOnClickListener(this);
        this.btnSave.setOnClickListener(this);
        this.btnExit.setOnClickListener(this);
        this.btnKot.setOnClickListener(this);
        this.search.addTextChangedListener(this);
        this.outletId = getSharedPreferences("myPrefs", Context.MODE_PRIVATE).getString("outletId", "nothing");
        this.outletName = getSharedPreferences("myPrefs", Context.MODE_PRIVATE).getString("outletName", "nothing");
        this.windowTitleView.setText(getText(R.string.app_name) + " - " + this.outletName + " - Tables");
        getSoapResponse(this, this.outletId, TABLE);
    }

    public void onClick(View clickedButton) {

        if (clickedButton == btnSave) {
            return;
        } else if (clickedButton == btnPrintKot) {
            if (saveOrUpdateKOTEntry(this, Constants.COMMAND_PRINT)) {
                Intent intent = new Intent(KOTTableActivity.this, KOTTableActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else {
                Utils.showAlert(this, "Printing Failed", "Failed to print orders. Please try again");
            }
        } else if (clickedButton == btnPrintBill) {
            if (saveOrUpdateKOTEntry(this, Constants.COMMAND_BILL)) {
                Intent intent = new Intent(KOTTableActivity.this, KOTTableActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else {
                Utils.showAlert(this, "Billing Failed", "Failed to bill orders. Please try again");
            }
        } else if (clickedButton == btnKot) {
            // Set Table ID and Name in Preferences
            openKOTEntry();
        } else if (clickedButton == btnExit) {
            finish();
        }
    }

    private void openKOTEntry() {
        Editor prefsEditor = getSharedPreferences("myPrefs", Context.MODE_PRIVATE).edit();
        prefsEditor.putString("tableId", this.selectedTableId);
        prefsEditor.putString("tableAvailability", this.selectedTableAvailability);
        prefsEditor.commit();
        if (getSharedPreferences("myPrefs", Context.MODE_PRIVATE).getString("tableId", "nothing").equals("nothing")) {
            Utils.showAlert(this, "Table not selected", "Please select a Table");
            return;
        }
        Table table = this.selectedTable;
        Intent intents = getIntent();
        Bundle bundle = new Bundle();
        bundle.putParcelable("tableInfo", table);
        intents.putExtras(bundle);
        intents.setClass(this, KOTEntryActivity.class);
        intents.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intents.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intents);
    }


    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        Editor prefsEditor = getSharedPreferences("myPrefs", Context.MODE_PRIVATE).edit();
        prefsEditor.putInt("position", position);
        prefsEditor.putBoolean("firsttime", false);
        prefsEditor.commit();

        view.getFocusables(position);
        view.setSelected(true);
        this.selectedTable = (Table) this.filteredtablesList.get(position);
        this.selectedTableId = this.selectedTable.getTableId();
        this.selectedTableAvailability = this.selectedTable.getTableOccupied();
        this.windowTitleView.setText(getText(R.string.app_name) + " - " + this.outletName + " - Table" + this.selectedTableId);
        if (this.selectedTable.getTableOccupied().equals("1")) {
            getSoapResponse(this, this.outletId, KOT);
        } else {
            openKOTEntry();
        }

//        Toast.makeText(this, "Make Request  ", Toast.LENGTH_SHORT).show();
    }

    private boolean loadTables() {
        this.soapResult = false;
        try {
            SoapObject request = new SoapObject(Constants.NAMESPACE, this.METHOD_NAME);
            System.out.println("Outlet ID : " + this.outletId);
            request.addProperty("outletId", this.outletId);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(request);
            new HttpTransportSE("http://" + Utils.getKotIpAddress(this) + "/" + URL + this.WSDL).call(this.SOAP_ACTION, envelope);
            Vector soapResponse = (Vector) envelope.getResponse();
            System.out.println("Outlet Tables Response : " + soapResponse);
            if (soapResponse != null && soapResponse.size() > 0) {
                System.out.println("Response List Size : " + soapResponse.size());
                int numberOfTables = soapResponse.size();
                String response = XmlPullParser.NO_NAMESPACE;
                String isOccupied = XmlPullParser.NO_NAMESPACE;
                this.tablesList = new ArrayList();
                this.filteredtablesList = new ArrayList<>();
                this.tablesList.clear();
                this.filteredtablesList.clear();
                for (int loopIterator = 0; loopIterator < numberOfTables; loopIterator++) {
                    Table table = new Table();
                    response = soapResponse.get(loopIterator).toString();
                    isOccupied = response.substring(response.indexOf("tableOccupied=") + 14, response.indexOf(";", response.indexOf("tableOccupied=")));
                    table.setTableId(response.substring(response.indexOf("tableId=") + 8, response.indexOf(";", response.indexOf("tableId="))));
                    table.setTableOccupied(isOccupied);
                    System.out.println("tableRef - " + response.substring(response.indexOf("tableRef=") + 9, response.indexOf(";", response.indexOf("tableRef="))));
                    table.setTableRef(response.substring(response.indexOf("tableRef=") + 9, response.indexOf(";", response.indexOf("tableRef="))));
                    this.tablesList.add(table);
                    this.filteredtablesList.add(table);
                }
            }
            this.soapResult = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception Occurs : " + e.getMessage());
        }
        return this.soapResult;
    }

    private void populateTables() {
        List<Map<String, Object>> data = new ArrayList();
        if (this.tablesList != null) {
            int tableSize = this.tablesList.size();
            this.rowItems = new ArrayList();
            for (int i = 0; i < tableSize; i++) {
                int imageId;
                String tableRef;
                Table table = (Table) this.tablesList.get(i);
                Log.e(TAG, "populateTables: table.getTableOccupied()  " + table.getTableOccupied());
                if (table.getTableOccupied().equals("1")) {
                    imageId = R.drawable.occupied_indicator;
                    tableRef = table.getTableRef();
                } else {
                    imageId = R.drawable.vacant_indicator;
                    tableRef = XmlPullParser.NO_NAMESPACE;
                }
                this.rowItems.add(new TableRowItem(imageId, " " + table.getTableId(), tableRef));
//                Log.e(TAG, "populateTables: table " + table.getTableId() + "  " + table.getTableRef());
            }
//            this.listTablesView.setAdapter(new CustomBaseAdapter(this, this.rowItems));
            customBaseAdapter.updateList(this.rowItems);

//            if (!getSharedPreferences("myPrefs", Context.MODE_PRIVATE).getBoolean("firsttime", true)) {
//
//                final int pos = getSharedPreferences("myPrefs", Context.MODE_PRIVATE).getInt("position", 0);
//
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        listTablesView.smoothScrollToPosition(pos);
////                    listTablesView.setSelection(pos);
//                        View wantedView = listTablesView.getChildAt(pos);
//                        wantedView.setFocusable(true);
//                        wantedView.setSelected(true);
////                    listTablesView.setPressed(true);
//                        listTablesView.performItemClick(listTablesView, pos, 0);
//                    }
//                }, 2000);
//            }


            return;
        }
        Map<String, Object> tablesMap = new HashMap(KOT);
        tablesMap.put("tableId", "No Tables Found");
        tablesMap.put("tableAvailability", XmlPullParser.NO_NAMESPACE);
        data.add(tablesMap);
        String[] strArr = new String[KOT];
        strArr[0] = "tableId";
        strArr[TABLE] = "tableAvailability";
        this.listTablesView.setAdapter(new SimpleAdapter(this, data, R.layout.outlet_tables_list_item, strArr, new int[]{R.id.tableId, R.id.tableAvailability}));


    }


    private boolean loadKotEntries() {
        this.soapResult = false;
        this.METHOD_NAME = "getKOTEntriesByTableId";
        this.selectedKOTNumber = XmlPullParser.NO_NAMESPACE;
        try {
            SoapObject request = new SoapObject(Constants.NAMESPACE, this.METHOD_NAME);
            System.out.println("selectedTableId : " + this.selectedTableId);
            Log.e(TAG, "selectedTableId : " + this.selectedTableId + " Table  " + this.selectedTable.toString());
            Table table = this.selectedTable;
            table.setTableId(this.selectedTableId);
            table.setTableOutlet(this.outletId);
            PropertyInfo propertyInfo = new PropertyInfo();
            propertyInfo.setName("tableInfo");
            propertyInfo.setValue(table);
            propertyInfo.setType(Table.class);
            request.addProperty(propertyInfo);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(request);
            new HttpTransportSE("http://" + Utils.getKotIpAddress(this) + "/" + URL + this.WSDL).call(this.SOAP_ACTION, envelope);
            Vector soapResponse = (Vector) envelope.getResponse();
            System.out.println("Table's KOTEntry Response : " + soapResponse);
            this.kotMap = new HashMap();
            this.kotList = new ArrayList();
            if (soapResponse != null && soapResponse.size() > 0) {
                System.out.println("Response List Size : " + soapResponse.size());
                int numberOfKOTEntries = soapResponse.size();
                for (int loopIterator = 0; loopIterator < numberOfKOTEntries; loopIterator++) {
                    String kotInfo = soapResponse.get(loopIterator).toString();
                    Log.e(TAG, "loadKotEntries: " + kotInfo.toString());
                    KOT kot = new KOT();
                    kot.setKotRef(kotInfo.substring(kotInfo.indexOf("kotRef=") + 7, kotInfo.indexOf(";", kotInfo.indexOf("kotRef="))));
                    kot.setKotNo(kotInfo.substring(kotInfo.indexOf("kotNo=") + 6, kotInfo.indexOf(";", kotInfo.indexOf("kotNo="))));
                    kot.setKotSlNo(kotInfo.substring(kotInfo.indexOf("kotSlNo=") + 8, kotInfo.indexOf(";", kotInfo.indexOf("kotSlNo="))));
                    kot.setKotTime(kotInfo.substring(kotInfo.indexOf("kotTime=") + 8, kotInfo.indexOf(";", kotInfo.indexOf("kotTime="))));
                    kot.setKotItId(kotInfo.substring(kotInfo.indexOf("kotItId=") + 8, kotInfo.indexOf(";", kotInfo.indexOf("kotItId="))));
                    kot.setKotItemDesc(kotInfo.substring(kotInfo.indexOf("kotItemDesc=") + 12, kotInfo.indexOf(";", kotInfo.indexOf("kotItemDesc="))));
                    kot.setKotQty(kotInfo.substring(kotInfo.indexOf("kotQty=") + 7, kotInfo.indexOf(";", kotInfo.indexOf("kotQty="))));
                    kot.setKotPrice(kotInfo.substring(kotInfo.indexOf("kotPrice=") + 9, kotInfo.indexOf(";", kotInfo.indexOf("kotPrice="))));
                    this.kotList.add(kot);
                    this.kotMap.put(kot.getKotNo(), kot);
                }
            }
            handleAlerts.post(new C00201());
            this.soapResult = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception Occurs : " + e.getMessage());
        }
        return true;
    }

    private void fillTableLayout() {
        System.out.println("Inside fillTableLayout");
        this.numberFormat = NumberFormat.getInstance();
        this.numberFormat.setMinimumFractionDigits(KOT);
        this.numberFormat.setMaximumFractionDigits(KOT);
        float grandTotal = 0.0f;
        int totalQuantity = 0;
        this.tableLayoutKot.removeAllViews();
        if (this.kotList != null && this.kotList.size() > 0) {
            TableRow tableRow;
            LayoutParams trParams;
            TextView textView;
            LayoutParams tvParams;
            int i = TABLE;
            for (KOT kot : this.kotList) {
                if (!(kot.getKotNo() == null || XmlPullParser.NO_NAMESPACE.equals(kot.getKotNo()) || "null".equals(kot.getKotNo()))) {
                    tableRow = new TableRow(this);
                    trParams = new LayoutParams(-1, -2);
                    trParams.setMargins(TABLE, TABLE, 0, 0);
                    tableRow.setContentDescription(kot.getKotNo());
                    tableRow.setBackgroundColor(getResources().getColor(R.color.tableback));
                    tableRow.setOnClickListener(new C00212());
                    textView = new TextView(this);
                    tvParams = new LayoutParams(0, -1, 0.15f);
                    tvParams.setMargins(0, 0, TABLE, TABLE);
                    textView.setPadding(10, 15, 10, 15);
                    textView.setText(kot.getKotNo());
                    if (this.selectedKOTNumber.equalsIgnoreCase(kot.getKotNo())) {
                        textView.setBackgroundResource(R.drawable.cell_shape_selected);
                    } else {
                        textView.setBackgroundResource(R.drawable.cell_shape_contents);
                    }
                    textView.setTextAppearance(getApplicationContext(), R.style.contentsTextStyle);
                    textView.setMinLines(TABLE);
                    if (i % KOT == 0) {
//                        textView.setBackgroundColor(-3355444);
                        textView.setBackgroundColor(getResources().getColor(R.color.row_even));
                    }
                    if (refillTableItemSelected && this.selectedKOTNumber.equalsIgnoreCase(kot.getKotNo())) {
                        textView.setBackgroundColor(getResources().getColor(R.color.row_ok));
                    }
                    tableRow.addView(textView, tvParams);
                    textView = new TextView(this);
                    tvParams = new LayoutParams(0, -1, 0.1f);
                    tvParams.setMargins(0, 0, TABLE, TABLE);
                    textView.setPadding(10, 15, 10, 15);
                    textView.setText(kot.getKotSlNo());
                    if (this.selectedKOTNumber.equalsIgnoreCase(kot.getKotNo())) {
                        textView.setBackgroundResource(R.drawable.cell_shape_selected);
                    } else {
                        textView.setBackgroundResource(R.drawable.cell_shape_contents);
                    }
                    textView.setTextAppearance(getApplicationContext(), R.style.contentsTextStyle);
                    textView.setMinLines(TABLE);
                    if (i % KOT == 0) {
                        textView.setBackgroundColor(getResources().getColor(R.color.row_even));
                    }
                    if (refillTableItemSelected && this.selectedKOTNumber.equalsIgnoreCase(kot.getKotNo())) {
                        textView.setBackgroundColor(getResources().getColor(R.color.row_ok));
                    }
                    tableRow.addView(textView, tvParams);
                    textView = new TextView(this);
                    tvParams = new LayoutParams(0, -1, 0.1f);
                    tvParams.setMargins(0, 0, TABLE, TABLE);
                    textView.setPadding(10, 15, 10, 15);
                    textView.setText(kot.getKotItId());
                    if (this.selectedKOTNumber.equalsIgnoreCase(kot.getKotNo())) {
                        textView.setBackgroundResource(R.drawable.cell_shape_selected);
                    } else {
                        textView.setBackgroundResource(R.drawable.cell_shape_contents);
                    }
                    textView.setTextAppearance(getApplicationContext(), R.style.contentsTextStyle);
                    textView.setMinLines(TABLE);
                    if (i % KOT == 0) {
//                        textView.setBackgroundColor(-3355444);
                        textView.setBackgroundColor(getResources().getColor(R.color.row_even));
                    }
                    if (refillTableItemSelected && this.selectedKOTNumber.equalsIgnoreCase(kot.getKotNo())) {
                        textView.setBackgroundColor(getResources().getColor(R.color.row_ok));
                    }
                    tableRow.addView(textView, tvParams);
                    textView = new TextView(this);
                    tvParams = new LayoutParams(0, -1, 0.3f);
                    tvParams.setMargins(0, 0, TABLE, TABLE);
                    textView.setPadding(10, 15, 10, 15);
                    textView.setText(kot.getKotItemDesc());
                    if (this.selectedKOTNumber.equalsIgnoreCase(kot.getKotNo())) {
                        textView.setBackgroundResource(R.drawable.cell_shape_selected);
                    } else {
                        textView.setBackgroundResource(R.drawable.cell_shape_contents);
                    }
                    textView.setTextAppearance(getApplicationContext(), R.style.contentsTextStyle);
                    textView.setMinLines(TABLE);
                    if (i % KOT == 0) {
//                        textView.setBackgroundColor(-3355444);
                        textView.setBackgroundColor(getResources().getColor(R.color.row_even));
                    }
                    if (refillTableItemSelected && this.selectedKOTNumber.equalsIgnoreCase(kot.getKotNo())) {
                        textView.setBackgroundColor(getResources().getColor(R.color.row_ok));
                    }
                    tableRow.addView(textView, tvParams);
                    textView = new TextView(this);
                    tvParams = new LayoutParams(0, -1, 0.05f);
                    tvParams.setMargins(0, 0, TABLE, TABLE);
                    textView.setPadding(10, 15, 10, 15);
                    textView.setText(kot.getKotQty());
                    if (this.selectedKOTNumber.equalsIgnoreCase(kot.getKotNo())) {
                        textView.setBackgroundResource(R.drawable.cell_shape_selected);
                    } else {
                        textView.setBackgroundResource(R.drawable.cell_shape_contents);
                    }
                    textView.setGravity(5);
                    textView.setTextAppearance(getApplicationContext(), R.style.contentsTextStyle);
                    textView.setMinLines(TABLE);
                    if (i % KOT == 0) {
//                        textView.setBackgroundColor(-3355444);
                        textView.setBackgroundColor(getResources().getColor(R.color.row_even));
                    }
                    if (refillTableItemSelected && this.selectedKOTNumber.equalsIgnoreCase(kot.getKotNo())) {
                        textView.setBackgroundColor(getResources().getColor(R.color.row_ok));
                    }
                    tableRow.addView(textView, tvParams);
                    textView = new TextView(this);
                    tvParams = new LayoutParams(0, -1, 0.1f);
                    tvParams.setMargins(0, 0, TABLE, TABLE);
                    textView.setPadding(10, 15, 10, 15);
                    textView.setText(kot.getKotPrice());
                    if (this.selectedKOTNumber.equalsIgnoreCase(kot.getKotNo())) {
                        textView.setBackgroundResource(R.drawable.cell_shape_selected);
                    } else {
                        textView.setBackgroundResource(R.drawable.cell_shape_contents);
                    }
                    textView.setGravity(5);
                    textView.setTextAppearance(getApplicationContext(), R.style.contentsTextStyle);
                    textView.setMinLines(TABLE);
                    if (i % KOT == 0) {
//                        textView.setBackgroundColor(-3355444);
                        textView.setBackgroundColor(getResources().getColor(R.color.row_even));
                    }
                    if (refillTableItemSelected && this.selectedKOTNumber.equalsIgnoreCase(kot.getKotNo())) {
                        textView.setBackgroundColor(getResources().getColor(R.color.row_ok));
                    }
                    tableRow.addView(textView, tvParams);
                    textView = new TextView(this);
                    tvParams = new LayoutParams(0, -1, 0.1f);
                    tvParams.setMargins(0, 0, TABLE, TABLE);
                    textView.setPadding(10, 15, 10, 15);
                    textView.setText(new StringBuilder(String.valueOf(this.numberFormat.format((double) (Float.parseFloat(kot.getKotPrice()) * Float.parseFloat(kot.getKotQty()))))).toString());
                    if (this.selectedKOTNumber.equalsIgnoreCase(kot.getKotNo())) {
                        textView.setBackgroundResource(R.drawable.cell_shape_selected);
                    } else {
                        textView.setBackgroundResource(R.drawable.cell_shape_contents);
                    }
                    textView.setGravity(5);
                    textView.setTextAppearance(getApplicationContext(), R.style.contentsTextStyle);
                    textView.setMinLines(TABLE);
                    if (i % KOT == 0) {
//                        textView.setBackgroundColor(-3355444);
                        textView.setBackgroundColor(getResources().getColor(R.color.row_even));
                    }
                    if (refillTableItemSelected && this.selectedKOTNumber.equalsIgnoreCase(kot.getKotNo())) {
                        textView.setBackgroundColor(getResources().getColor(R.color.row_ok));
                    }
                    tableRow.addView(textView, tvParams);
                    grandTotal += Float.parseFloat(kot.getKotPrice()) * Float.parseFloat(kot.getKotQty());
                    totalQuantity += Integer.parseInt(kot.getKotQty());
                    this.tableLayoutKot.addView(tableRow, trParams);
                    i += TABLE;
                }
            }


            if (this.tableLayoutKot.getChildCount() > 0) {
                tableRow = new TableRow(this);
                trParams = new LayoutParams(-1, -2);
                trParams.setMargins(TABLE, TABLE, TABLE, TABLE);
                tableRow.setContentDescription("Total");
                tableRow.setBackgroundResource(R.color.total_bg);
                tableRow.setOnClickListener(new C00223());
                textView = new TextView(this);
                tvParams = new LayoutParams(0, -1, 0.65f);
                tvParams.setMargins(0, 0, 0, TABLE);
                tvParams.span = 4;
                textView.setText("Total : ");
                textView.setGravity(5);
                textView.setPadding(10, 15, 10, 15);
                textView.setTextAppearance(getApplicationContext(), R.style.contentsTextStyle);
                textView.setMinLines(TABLE);
                tableRow.addView(textView, tvParams);
                textView = new TextView(this);
                tvParams = new LayoutParams(0, -1, 0.05f);
                tvParams.setMargins(0, 0, 0, TABLE);
                textView.setText(new StringBuilder(String.valueOf(totalQuantity)).toString());
                textView.setGravity(5);
                textView.setPadding(10, 15, 10, 15);
                textView.setTextAppearance(getApplicationContext(), R.style.contentsTextStyle);
                textView.setMinLines(TABLE);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                tableRow.addView(textView, tvParams);
                textView = new TextView(this);
                tvParams = new LayoutParams(0, -1, 0.1f);
                tvParams.setMargins(0, 0, 0, TABLE);
                textView.setText(XmlPullParser.NO_NAMESPACE);
                textView.setGravity(5);
                textView.setPadding(10, 15, 10, 15);
                textView.setTextAppearance(getApplicationContext(), R.style.contentsTextStyle);
                textView.setMinLines(TABLE);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                tableRow.addView(textView, tvParams);
                textView = new TextView(this);
                tvParams = new LayoutParams(0, -1, 0.1f);
                tvParams.setMargins(0, 0, 0, TABLE);
                tvParams.span = KOT;
                textView.setText(new StringBuilder(String.valueOf(this.numberFormat.format((double) grandTotal))).toString());
                textView.setGravity(5);
                textView.setPadding(10, 15, 10, 15);
                textView.setTextAppearance(getApplicationContext(), R.style.contentsTextStyle);
                textView.setMinLines(TABLE);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                tableRow.addView(textView, tvParams);
                this.tableLayoutKot.addView(tableRow, trParams);
            }
        }
        this.refillTableItemSelected = false;
    }

    private void refillTableLayout(String selectedKOTNo) {
        this.selectedKOTNumber = selectedKOTNo;
        this.refillTableItemSelected = true;
        fillTableLayout();
    }


    private boolean saveOrUpdateKOTEntry(Activity activity, String command) {
        if (this.kotMap == null || this.kotMap.size() <= 0) {
            return false;
        }
        this.WSDL = "KOTAction?wsdl";
        if (command.equalsIgnoreCase(Constants.COMMAND_SAVE)) {
            this.METHOD_NAME = "saveKOT";
        } else if (command.equalsIgnoreCase(Constants.COMMAND_PRINT)) {
            this.METHOD_NAME = "printKOT";
        } else if (command.equalsIgnoreCase(Constants.COMMAND_BILL)) {
            this.METHOD_NAME = "printBill";
        }
        try {
            SoapObject request = new SoapObject(Constants.NAMESPACE, this.METHOD_NAME);
            Table table = this.selectedTable;
            table.setTableId(this.selectedTableId);
            table.setTableOutlet(this.outletId);
            table.setTableCaptainId(Utils.getUserId(this));
            table.setTableCover(KOT);
            table.setTableOccupied("1");

            PropertyInfo propertyInfo = new PropertyInfo();
            propertyInfo.setName("kotEntry");
            propertyInfo.setValue(this.kotMap.get(this.selectedKOTNumber));
            propertyInfo.setType(KOT.class);
            request.addProperty(propertyInfo);

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
            httpTransportSE.call(this.SOAP_ACTION, envelope);
//            Log.e(TAG, "saveOrUpdateKOTEntry: Url " + "http://" + Utils.getKotIpAddress(this) + "/" + URL + this.WSDL);
//            Log.e(TAG, "saveOrUpdateKOTEntry: method " + this.SOAP_ACTION);
//            Log.e(TAG, "doInBackground: request " + httpTransportSE.requestDump);
//            Log.e(TAG, "doInBackground: response " + httpTransportSE.responseDump);

            Object soapResponse = envelope.getResponse();
//            System.out.println("Print kot " + soapResponse);
//            Log.e(TAG, "saveOrUpdateKOTEntry: " + request.toString());
//            Log.e(TAG, "saveOrUpdateKOTEntry: " + soapResponse);

            if (soapResponse.toString().equalsIgnoreCase(Constants.TRUE)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Exception Occurs : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"HandlerLeak"})
    private void getSoapResponse(Activity activity, String outletId, int methodSelector) {
        serviceMessage = new C00234();
        handleAlerts = new Handler();
        this.t1 = new Thread(new C00245());
        this.t2 = new Thread(new C00286(methodSelector));
        if (isInternetConnectionOn()) {
            if (this.progressDialog == null) {
                this.progressDialog = new ProgressDialog(this);
                this.progressDialog.setCancelable(false);
                this.progressDialog.setMessage("Loading Tables...");
//            this.progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                this.progressDialog.show();
            }
            this.t1.start();
            this.t2.start();
//            Toast.makeText(KOTTableActivity.this, "Work load", Toast.LENGTH_SHORT).show();
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
