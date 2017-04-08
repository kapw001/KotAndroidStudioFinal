package com.hm.kot.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.xmlpull.v1.XmlPullParser;

import java.util.Hashtable;

public class TableBackUp implements Parcelable, KvmSerializable {
    public static Creator CREATOR;
    private String tableBookedBy;
    private String tableCaptainId;
    private int tableCover;
    private String tableGuestName;
    private String tableId;
    private int tableIsParcel;
    private int tableIsRes;
    private String tableMaxCvr;
    private String tableOccupied;
    private String tableOutlet;
    private String tableRef;
    private String tableResCvr;
    private String tableResFrom;
    private String tableResTo;
    private String tableTime;
    private String tableTotal;
    private String tableWaiterId;

    public TableBackUp() {
//        CREATOR = new C00001();
    }

    /* renamed from: com.hm.kot.model.Table.1 */
    class C00001 implements Creator {
        C00001() {
        }

        public TableBackUp createFromParcel(Parcel parcel) {
            return new TableBackUp(parcel);
        }

        public TableBackUp[] newArray(int size) {
            return new TableBackUp[size];
        }
    }

    public TableBackUp(Parcel parcel) {
        readFromParcel(parcel);
        CREATOR = new C00001();
    }

    public String getTableId() {
        return this.tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getTableOutlet() {
        return this.tableOutlet;
    }

    public void setTableOutlet(String tableOutlet) {
        this.tableOutlet = tableOutlet;
    }

    public String getTableWaiterId() {
        return this.tableWaiterId;
    }

    public void setTableWaiterId(String tableWaiterId) {
        this.tableWaiterId = tableWaiterId;
    }

    public String getTableCaptainId() {
        return this.tableCaptainId;
    }

    public void setTableCaptainId(String tableCaptainId) {
        this.tableCaptainId = tableCaptainId;
    }

    public String getTableTime() {
        return this.tableTime;
    }

    public void setTableTime(String tableTime) {
        this.tableTime = tableTime;
    }

    public int getTableCover() {
        return this.tableCover;
    }

    public void setTableCover(int tableCover) {
        this.tableCover = tableCover;
    }

    public String getTableOccupied() {
        return this.tableOccupied;
    }

    public void setTableOccupied(String tableOccupied) {
        this.tableOccupied = tableOccupied;
    }

    public String getTableRef() {
        return this.tableRef;
    }

    public void setTableRef(String tableRef) {
        this.tableRef = tableRef;
    }

    public int getTableIsParcel() {
        return this.tableIsParcel;
    }

    public void setTableIsParcel(int tableIsParcel) {
        this.tableIsParcel = tableIsParcel;
    }

    public String getTableMaxCvr() {
        return this.tableMaxCvr;
    }

    public void setTableMaxCvr(String tableMaxCvr) {
        this.tableMaxCvr = tableMaxCvr;
    }

    public String getTableGuestName() {
        return this.tableGuestName;
    }

    public void setTableGuestName(String tableGuestName) {
        this.tableGuestName = tableGuestName;
    }

    public String getTableResFrom() {
        return this.tableResFrom;
    }

    public void setTableResFrom(String tableResFrom) {
        this.tableResFrom = tableResFrom;
    }

    public String getTableResTo() {
        return this.tableResTo;
    }

    public void setTableResTo(String tableResTo) {
        this.tableResTo = tableResTo;
    }

    public String getTableResCvr() {
        return this.tableResCvr;
    }

    public void setTableResCvr(String tableResCvr) {
        this.tableResCvr = tableResCvr;
    }

    public String getTableBookedBy() {
        return this.tableBookedBy;
    }

    public void setTableBookedBy(String tableBookedBy) {
        this.tableBookedBy = tableBookedBy;
    }

    public int getTableIsRes() {
        return this.tableIsRes;
    }

    public void setTableIsRes(int tableIsRes) {
        this.tableIsRes = tableIsRes;
    }

    public String getTableTotal() {
        return this.tableTotal;
    }

    public void setTableTotal(String tableTotal) {
        this.tableTotal = tableTotal;
    }

    public String toString() {
        String str;
        StringBuilder append = new StringBuilder("Table [").append(this.tableId != null ? "tableId=" + this.tableId + ", " : XmlPullParser.NO_NAMESPACE);
        if (this.tableOutlet != null) {
            str = "tableOutlet=" + this.tableOutlet + ", ";
        } else {
            str = XmlPullParser.NO_NAMESPACE;
        }
        append = append.append(str).append(this.tableWaiterId != null ? "tableWaiterId=" + this.tableWaiterId + ", " : XmlPullParser.NO_NAMESPACE).append("tableCaptainId=").append(this.tableCaptainId).append(", ").append(this.tableTime != null ? "tableTime=" + this.tableTime + ", " : XmlPullParser.NO_NAMESPACE).append("tableCover=").append(this.tableCover).append(", tableOccupied=").append(this.tableOccupied).append(", tableRef=").append(this.tableRef).append(", tableIsParcel=").append(this.tableIsParcel).append(", tableMaxCvr=").append(this.tableMaxCvr).append(", ").append(this.tableGuestName != null ? "tableGuestName=" + this.tableGuestName + ", " : XmlPullParser.NO_NAMESPACE);
        if (this.tableResFrom != null) {
            str = "tableResFrom=" + this.tableResFrom + ", ";
        } else {
            str = XmlPullParser.NO_NAMESPACE;
        }
        return append.append(str).append(this.tableResTo != null ? "tableResTo=" + this.tableResTo + ", " : XmlPullParser.NO_NAMESPACE).append("tableResCvr=").append(this.tableResCvr).append(", ").append(this.tableBookedBy != null ? "tableBookedBy=" + this.tableBookedBy + ", " : XmlPullParser.NO_NAMESPACE).append("tableIsRes=").append(this.tableIsRes).append(", tableTotal=").append(this.tableTotal).append("]").toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tableId);
        dest.writeString(this.tableOutlet);
        dest.writeString(this.tableWaiterId);
        dest.writeString(this.tableCaptainId);
        dest.writeString(this.tableTime);
        dest.writeInt(this.tableCover);
        dest.writeString(this.tableOccupied);
        dest.writeString(this.tableMaxCvr);
        dest.writeString(this.tableRef);
    }

    private void readFromParcel(Parcel parcel) {
        this.tableId = parcel.readString();
        this.tableOutlet = parcel.readString();
        this.tableWaiterId = parcel.readString();
        this.tableCaptainId = parcel.readString();
        this.tableTime = parcel.readString();
        this.tableCover = parcel.readInt();
        this.tableOccupied = parcel.readString();
        this.tableMaxCvr = parcel.readString();
        this.tableRef = parcel.readString();
    }
//
//    static {
//        CREATOR = new C00001();
//    }

    public Object getProperty(int arg0) {
        switch (arg0) {
            case XmlPullParser.START_DOCUMENT /*0*/:
                return this.tableId;
            case XmlPullParser.END_DOCUMENT /*1*/:
                return this.tableOutlet;
            case XmlPullParser.START_TAG /*2*/:
                return this.tableWaiterId;
            case XmlPullParser.END_TAG /*3*/:
                return this.tableCaptainId;
            case XmlPullParser.TEXT /*4*/:
                return this.tableTime;
            case XmlPullParser.CDSECT /*5*/:
                return Integer.valueOf(this.tableCover);
            case XmlPullParser.ENTITY_REF /*6*/:
                return this.tableOccupied;
            case XmlPullParser.IGNORABLE_WHITESPACE /*7*/:
                return this.tableRef;
            case XmlPullParser.PROCESSING_INSTRUCTION /*8*/:
                return Integer.valueOf(this.tableIsParcel);
            case XmlPullParser.COMMENT /*9*/:
                return this.tableMaxCvr;
            case XmlPullParser.DOCDECL /*10*/:
                return this.tableGuestName;
            case 11:
                return this.tableResFrom;
            case 12:
                return this.tableResTo;
            case 13:
                return this.tableResCvr;
            case 14:
                return this.tableBookedBy;
            case 15:
                return Integer.valueOf(this.tableIsRes);
            case 16:
                return this.tableTotal;
            default:
                return null;
        }
    }

    public int getPropertyCount() {
        return 17;
    }

    public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo arg2) {
        switch (arg0) {
            case XmlPullParser.START_DOCUMENT /*0*/:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableId";
            case XmlPullParser.END_DOCUMENT /*1*/:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableOutlet";
            case XmlPullParser.START_TAG /*2*/:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableWaiterId";
            case XmlPullParser.END_TAG /*3*/:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableCaptainId";
            case XmlPullParser.TEXT /*4*/:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableTime";
            case XmlPullParser.CDSECT /*5*/:
                arg2.type = PropertyInfo.INTEGER_CLASS;
                arg2.name = "tableCover";
            case XmlPullParser.ENTITY_REF /*6*/:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableOccupied";
            case XmlPullParser.IGNORABLE_WHITESPACE /*7*/:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableRef";
            case XmlPullParser.PROCESSING_INSTRUCTION /*8*/:
                arg2.type = PropertyInfo.INTEGER_CLASS;
                arg2.name = "tableIsParcel";
            case XmlPullParser.COMMENT /*9*/:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableMaxCvr";
            case XmlPullParser.DOCDECL /*10*/:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableGuestName";
            case 11:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableResFrom";
            case 12:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableResTo";
            case 13:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableResCvr";
            case 14:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableBookedBy";
            case 15:
                arg2.type = PropertyInfo.INTEGER_CLASS;
                arg2.name = "tableIsRes";
            case 16:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableTotal";
            default:
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(int r2, Object r3) {
        /*
        r1 = this;
        switch(r2) {
            case 0: goto L_0x0004;
            case 1: goto L_0x000a;
            case 2: goto L_0x0010;
            case 3: goto L_0x0016;
            case 4: goto L_0x001c;
            case 5: goto L_0x0022;
            case 6: goto L_0x002c;
            case 7: goto L_0x0032;
            case 8: goto L_0x0038;
            case 9: goto L_0x0042;
            case 10: goto L_0x0048;
            case 11: goto L_0x004e;
            case 12: goto L_0x0054;
            case 13: goto L_0x005a;
            case 14: goto L_0x0060;
            case 15: goto L_0x0066;
            case 16: goto L_0x0070;
            default: goto L_0x0003;
        };
    L_0x0003:
        return;
    L_0x0004:
        r0 = r3.toString();
        r1.tableId = r0;
    L_0x000a:
        r0 = r3.toString();
        r1.tableOutlet = r0;
    L_0x0010:
        r0 = r3.toString();
        r1.tableWaiterId = r0;
    L_0x0016:
        r0 = r3.toString();
        r1.tableCaptainId = r0;
    L_0x001c:
        r0 = r3.toString();
        r1.tableTime = r0;
    L_0x0022:
        r0 = r3.toString();
        r0 = java.lang.Integer.parseInt(r0);
        r1.tableCover = r0;
    L_0x002c:
        r0 = r3.toString();
        r1.tableOccupied = r0;
    L_0x0032:
        r0 = r3.toString();
        r1.tableRef = r0;
    L_0x0038:
        r0 = r3.toString();
        r0 = java.lang.Integer.parseInt(r0);
        r1.tableIsParcel = r0;
    L_0x0042:
        r0 = r3.toString();
        r1.tableMaxCvr = r0;
    L_0x0048:
        r0 = r3.toString();
        r1.tableGuestName = r0;
    L_0x004e:
        r0 = r3.toString();
        r1.tableResFrom = r0;
    L_0x0054:
        r0 = r3.toString();
        r1.tableResTo = r0;
    L_0x005a:
        r0 = r3.toString();
        r1.tableResCvr = r0;
    L_0x0060:
        r0 = r3.toString();
        r1.tableBookedBy = r0;
    L_0x0066:
        r0 = r3.toString();
        r0 = java.lang.Integer.parseInt(r0);
        r1.tableIsRes = r0;
    L_0x0070:
        r0 = r3.toString();
        r1.tableTotal = r0;
        goto L_0x0003;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hm.kot.model.Table.setProperty(int, java.lang.Object):void");
    }
}
