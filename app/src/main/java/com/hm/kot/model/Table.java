package com.hm.kot.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.xmlpull.v1.XmlPullParser;

public class Table implements Parcelable, KvmSerializable {
    private String tableId;
    private String tableOutlet;
    private String tableWaiterId;
    private String tableCaptainId;
    private String tableTime;
    private int tableCover;
    private String tableOccupied;
    private String tableRef;
    private int tableIsParcel;
    private String tableMaxCvr;
    private String tableGuestName;
    private String tableResFrom;
    private String tableResTo;
    private String tableResCvr;
    private String tableBookedBy;
    private int tableIsRes;
    private String tableTotal;

    /**
     *
     */
    public Table() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param parcel
     */
    public Table(Parcel parcel) {
        readFromParcel(parcel);
    }

    /**
     * @return the tableId
     */
    public String getTableId() {
        return tableId;
    }

    /**
     * @param tableId the tableId to set
     */
    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    /**
     * @return the tableOutlet
     */
    public String getTableOutlet() {
        return tableOutlet;
    }

    /**
     * @param tableOutlet the tableOutlet to set
     */
    public void setTableOutlet(String tableOutlet) {
        this.tableOutlet = tableOutlet;
    }

    /**
     * @return the tableWaiterId
     */
    public String getTableWaiterId() {
        return tableWaiterId;
    }

    /**
     * @param tableWaiterId the tableWaiterId to set
     */
    public void setTableWaiterId(String tableWaiterId) {
        this.tableWaiterId = tableWaiterId;
    }

    /**
     * @return the tableCaptainId
     */
    public String getTableCaptainId() {
        return tableCaptainId;
    }

    /**
     * @param tableCaptainId the tableCaptainId to set
     */
    public void setTableCaptainId(String tableCaptainId) {
        this.tableCaptainId = tableCaptainId;
    }

    /**
     * @return the tableTime
     */
    public String getTableTime() {
        return tableTime;
    }

    /**
     * @param tableTime the tableTime to set
     */
    public void setTableTime(String tableTime) {
        this.tableTime = tableTime;
    }

    /**
     * @return the tableCover
     */
    public int getTableCover() {
        return tableCover;
    }

    /**
     * @param tableCover the tableCover to set
     */
    public void setTableCover(int tableCover) {
        this.tableCover = tableCover;
    }

    /**
     * @return the tableOccupied
     */
    public String getTableOccupied() {
        return tableOccupied;
    }

    /**
     * @param tableOccupied the tableOccupied to set
     */
    public void setTableOccupied(String tableOccupied) {
        this.tableOccupied = tableOccupied;
    }

    /**
     * @return the tableRef
     */
    public String getTableRef() {
        return tableRef;
    }

    /**
     * @param tableRef the tableRef to set
     */
    public void setTableRef(String tableRef) {
        this.tableRef = tableRef;
    }

    /**
     * @return the tableIsParcel
     */
    public int getTableIsParcel() {
        return tableIsParcel;
    }

    /**
     * @param tableIsParcel the tableIsParcel to set
     */
    public void setTableIsParcel(int tableIsParcel) {
        this.tableIsParcel = tableIsParcel;
    }

    /**
     * @return the tableMaxCvr
     */
    public String getTableMaxCvr() {
        return tableMaxCvr;
    }

    /**
     * @param tableMaxCvr the tableMaxCvr to set
     */
    public void setTableMaxCvr(String tableMaxCvr) {
        this.tableMaxCvr = tableMaxCvr;
    }

    /**
     * @return the tableGuestName
     */
    public String getTableGuestName() {
        return tableGuestName;
    }

    /**
     * @param tableGuestName the tableGuestName to set
     */
    public void setTableGuestName(String tableGuestName) {
        this.tableGuestName = tableGuestName;
    }

    /**
     * @return the tableResFrom
     */
    public String getTableResFrom() {
        return tableResFrom;
    }

    /**
     * @param tableResFrom the tableResFrom to set
     */
    public void setTableResFrom(String tableResFrom) {
        this.tableResFrom = tableResFrom;
    }

    /**
     * @return the tableResTo
     */
    public String getTableResTo() {
        return tableResTo;
    }

    /**
     * @param tableResTo the tableResTo to set
     */
    public void setTableResTo(String tableResTo) {
        this.tableResTo = tableResTo;
    }

    /**
     * @return the tableResCvr
     */
    public String getTableResCvr() {
        return tableResCvr;
    }

    /**
     * @param tableResCvr the tableResCvr to set
     */
    public void setTableResCvr(String tableResCvr) {
        this.tableResCvr = tableResCvr;
    }

    /**
     * @return the tableBookedBy
     */
    public String getTableBookedBy() {
        return tableBookedBy;
    }

    /**
     * @param tableBookedBy the tableBookedBy to set
     */
    public void setTableBookedBy(String tableBookedBy) {
        this.tableBookedBy = tableBookedBy;
    }

    /**
     * @return the tableIsRes
     */
    public int getTableIsRes() {
        return tableIsRes;
    }

    /**
     * @param tableIsRes the tableIsRes to set
     */
    public void setTableIsRes(int tableIsRes) {
        this.tableIsRes = tableIsRes;
    }

    /**
     * @return the tableTotal
     */
    public String getTableTotal() {
        return tableTotal;
    }

    /**
     * @param tableTotal the tableTotal to set
     */
    public void setTableTotal(String tableTotal) {
        this.tableTotal = tableTotal;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Table ["
                + (tableId != null ? "tableId=" + tableId + ", " : "")
                + (tableOutlet != null ? "tableOutlet=" + tableOutlet + ", "
                : "")
                + (tableWaiterId != null ? "tableWaiterId=" + tableWaiterId
                + ", " : "")
                + "tableCaptainId="
                + tableCaptainId
                + ", "
                + (tableTime != null ? "tableTime=" + tableTime + ", " : "")
                + "tableCover="
                + tableCover
                + ", tableOccupied="
                + tableOccupied
                + ", tableRef="
                + tableRef
                + ", tableIsParcel="
                + tableIsParcel
                + ", tableMaxCvr="
                + tableMaxCvr
                + ", "
                + (tableGuestName != null ? "tableGuestName=" + tableGuestName
                + ", " : "")
                + (tableResFrom != null ? "tableResFrom=" + tableResFrom + ", "
                : "")
                + (tableResTo != null ? "tableResTo=" + tableResTo + ", " : "")
                + "tableResCvr="
                + tableResCvr
                + ", "
                + (tableBookedBy != null ? "tableBookedBy=" + tableBookedBy
                + ", " : "") + "tableIsRes=" + tableIsRes
                + ", tableTotal=" + tableTotal + "]";
    }

    /* (non-Javadoc)
     * @see android.os.Parcelable#describeContents()
     */
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see android.os.Parcelable#writeToParcel(android.os.Parcel, int)
     */
    public void writeToParcel(Parcel dest, int flags) {
        // TODO Auto-generated method stub
        // The writeParcel method needs the flag
        // as well - but thats easy.
        dest.writeString(tableId);
        dest.writeString(tableOutlet);
        dest.writeString(tableWaiterId);
        dest.writeString(tableCaptainId);
        dest.writeString(tableTime);
        dest.writeInt(tableCover);
        dest.writeString(tableOccupied);
        dest.writeString(tableMaxCvr);
        dest.writeString(tableRef);
    }

    /**
     * @param parcel
     */
    private void readFromParcel(Parcel parcel) {

        // We just need to read back each
        // field in the order that it was
        // written to the parcel
        tableId = parcel.readString();
        tableOutlet = parcel.readString();
        tableWaiterId = parcel.readString();
        tableCaptainId = parcel.readString();
        tableTime = parcel.readString();
        tableCover = parcel.readInt();
        tableOccupied = parcel.readString();
        tableMaxCvr = parcel.readString();
        tableRef = parcel.readString();
    }

    /**
     *
     */
    @SuppressWarnings("rawtypes")
    public static final Parcelable.Creator CREATOR =
            new Parcelable.Creator() {
                public Table createFromParcel(Parcel parcel) {
                    return new Table(parcel);
                }

                public Table[] newArray(int size) {
                    return new Table[size];
                }
            };

    public Object getProperty(int arg0) {
        // TODO Auto-generated method stub
        switch (arg0) {
            case 0:
                return tableId;
            case 1:
                return tableOutlet;
            case 2:
                return tableWaiterId;
            case 3:
                return tableCaptainId;
            case 4:
                return tableTime;
            case 5:
                return tableCover;
            case 6:
                return tableOccupied;
            case 7:
                return tableRef;
            case 8:
                return tableIsParcel;
            case 9:
                return tableMaxCvr;
            case 10:
                return tableGuestName;
            case 11:
                return tableResFrom;
            case 12:
                return tableResTo;
            case 13:
                return tableResCvr;
            case 14:
                return tableBookedBy;
            case 15:
                return tableIsRes;
            case 16:
                return tableTotal;
        }
        return null;
    }

    public int getPropertyCount() {
        // TODO Auto-generated method stub
        return 17;
    }

    @SuppressWarnings("rawtypes")
    public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo arg2) {
        // TODO Auto-generated method stub
        switch (arg0) {
            case 0:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableId";
                break;
            case 1:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableOutlet";
                break;
            case 2:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableWaiterId";
                break;
            case 3:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableCaptainId";
                break;
            case 4:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableTime";
                break;
            case 5:
                arg2.type = PropertyInfo.INTEGER_CLASS;
                arg2.name = "tableCover";
                break;
            case 6:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableOccupied";
                break;
            case 7:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableRef";
                break;
            case 8:
                arg2.type = PropertyInfo.INTEGER_CLASS;
                arg2.name = "tableIsParcel";
                break;
            case 9:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableMaxCvr";
                break;
            case 10:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableGuestName";
                break;
            case 11:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableResFrom";
                break;
            case 12:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableResTo";
                break;
            case 13:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableResCvr";
                break;
            case 14:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableBookedBy";
                break;
            case 15:
                arg2.type = PropertyInfo.INTEGER_CLASS;
                arg2.name = "tableIsRes";
                break;
            case 16:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "tableTotal";
                break;
            default:
                break;
        }
    }

    public void setProperty(int arg0, Object arg1) {
        // TODO Auto-generated method stub
        switch (arg0) {
            case 0:
                tableId = arg1.toString();
            case 1:
                tableOutlet = arg1.toString();
            case 2:
                tableWaiterId = arg1.toString();
            case 3:
                tableCaptainId = arg1.toString();
            case 4:
                tableTime = arg1.toString();
            case 5:
                tableCover = Integer.parseInt(arg1.toString());
            case 6:
                tableOccupied = arg1.toString();
            case 7:
                tableRef = arg1.toString();
            case 8:
                tableIsParcel = Integer.parseInt(arg1.toString());
            case 9:
                tableMaxCvr = arg1.toString();
            case 10:
                tableGuestName = arg1.toString();
            case 11:
                tableResFrom = arg1.toString();
            case 12:
                tableResTo = arg1.toString();
            case 13:
                tableResCvr = arg1.toString();
            case 14:
                tableBookedBy = arg1.toString();
            case 15:
                tableIsRes = Integer.parseInt(arg1.toString());
            case 16:
                tableTotal = arg1.toString();
            default:
                break;
        }
    }

}
