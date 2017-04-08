package com.hm.kot.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

public class KOTBack implements Parcelable, KvmSerializable {
    private static final long serialVersionUID = 3968547277867752700L;
    private String kotCapId;
    private String kotCat;
    private String kotDate;
    private String kotFinYear;
    private String kotGroup;
    private String kotGuestId;
    private String kotItId;
    private String kotItemDesc;
    private String kotMno;
    private String kotNo;
    private String kotOperId;
    private String kotOutlet;
    private String kotPrice;
    private String kotQty;
    private String kotRef;
    private String kotRoomId;
    private String kotSession;
    private String kotShift;
    private String kotSlNo;
    private String kotStatus;
    private String kotTId;
    private String kotTime;
    private String kotWaitId;

    public KOTBack() {
    }

    public KOTBack(String kotRef, String kotNo, String kotSlNo, String kotOutlet, String kotStatus, String kotDate, String kotTime, String kotTId, String kotRoomId, String kotGuestId, String kotWaitId, String kotCapId, String kotItId, String kotQty, String kotPrice, String kotGroup, String kotMno, String kotCat, String kotFinYear, String kotShift, String kotSession, String kotOperId, String kotItemDesc) {
        this.kotRef = kotRef;
        this.kotNo = kotNo;
        this.kotSlNo = kotSlNo;
        this.kotOutlet = kotOutlet;
        this.kotStatus = kotStatus;
        this.kotDate = kotDate;
        this.kotTime = kotTime;
        this.kotTId = kotTId;
        this.kotRoomId = kotRoomId;
        this.kotGuestId = kotGuestId;
        this.kotWaitId = kotWaitId;
        this.kotCapId = kotCapId;
        this.kotItId = kotItId;
        this.kotQty = kotQty;
        this.kotPrice = kotPrice;
        this.kotGroup = kotGroup;
        this.kotMno = kotMno;
        this.kotCat = kotCat;
        this.kotFinYear = kotFinYear;
        this.kotShift = kotShift;
        this.kotSession = kotSession;
        this.kotOperId = kotOperId;
        this.kotItemDesc = kotItemDesc;
    }

    protected KOTBack(Parcel in) {
        kotCapId = in.readString();
        kotCat = in.readString();
        kotDate = in.readString();
        kotFinYear = in.readString();
        kotGroup = in.readString();
        kotGuestId = in.readString();
        kotItId = in.readString();
        kotItemDesc = in.readString();
        kotMno = in.readString();
        kotNo = in.readString();
        kotOperId = in.readString();
        kotOutlet = in.readString();
        kotPrice = in.readString();
        kotQty = in.readString();
        kotRef = in.readString();
        kotRoomId = in.readString();
        kotSession = in.readString();
        kotShift = in.readString();
        kotSlNo = in.readString();
        kotStatus = in.readString();
        kotTId = in.readString();
        kotTime = in.readString();
        kotWaitId = in.readString();
    }

    public static final Creator<KOTBack> CREATOR = new Creator<KOTBack>() {
        @Override
        public KOTBack createFromParcel(Parcel in) {
            return new KOTBack(in);
        }

        @Override
        public KOTBack[] newArray(int size) {
            return new KOTBack[size];
        }
    };

    public String getKotRef() {
        return this.kotRef;
    }

    public void setKotRef(String kotRef) {
        this.kotRef = kotRef;
    }

    public String getKotNo() {
        return this.kotNo;
    }

    public void setKotNo(String kotNo) {
        this.kotNo = kotNo;
    }

    public String getKotSlNo() {
        return this.kotSlNo;
    }

    public void setKotSlNo(String kotSlNo) {
        this.kotSlNo = kotSlNo;
    }

    public String getKotOutlet() {
        return this.kotOutlet;
    }

    public void setKotOutlet(String kotOutlet) {
        this.kotOutlet = kotOutlet;
    }

    public String getKotStatus() {
        return this.kotStatus;
    }

    public void setKotStatus(String kotStatus) {
        this.kotStatus = kotStatus;
    }

    public String getKotDate() {
        return this.kotDate;
    }

    public void setKotDate(String kotDate) {
        this.kotDate = kotDate;
    }

    public String getKotTime() {
        return this.kotTime;
    }

    public void setKotTime(String kotTime) {
        this.kotTime = kotTime;
    }

    public String getKotTId() {
        return this.kotTId;
    }

    public void setKotTId(String kotTId) {
        this.kotTId = kotTId;
    }

    public String getKotRoomId() {
        return this.kotRoomId;
    }

    public void setKotRoomId(String kotRoomId) {
        this.kotRoomId = kotRoomId;
    }

    public String getKotGuestId() {
        return this.kotGuestId;
    }

    public void setKotGuestId(String kotGuestId) {
        this.kotGuestId = kotGuestId;
    }

    public String getKotWaitId() {
        return this.kotWaitId;
    }

    public void setKotWaitId(String kotWaitId) {
        this.kotWaitId = kotWaitId;
    }

    public String getKotCapId() {
        return this.kotCapId;
    }

    public void setKotCapId(String kotCapId) {
        this.kotCapId = kotCapId;
    }

    public String getKotItId() {
        return this.kotItId;
    }

    public void setKotItId(String kotItId) {
        this.kotItId = kotItId;
    }

    public String getKotQty() {
        return this.kotQty;
    }

    public void setKotQty(String kotQty) {
        this.kotQty = kotQty;
    }

    public String getKotPrice() {
        return this.kotPrice;
    }

    public void setKotPrice(String kotPrice) {
        this.kotPrice = kotPrice;
    }

    public String getKotGroup() {
        return this.kotGroup;
    }

    public void setKotGroup(String kotGroup) {
        this.kotGroup = kotGroup;
    }

    public String getKotMno() {
        return this.kotMno;
    }

    public void setKotMno(String kotMno) {
        this.kotMno = kotMno;
    }

    public String getKotCat() {
        return this.kotCat;
    }

    public void setKotCat(String kotCat) {
        this.kotCat = kotCat;
    }

    public String getKotFinYear() {
        return this.kotFinYear;
    }

    public void setKotFinYear(String kotFinYear) {
        this.kotFinYear = kotFinYear;
    }

    public String getKotShift() {
        return this.kotShift;
    }

    public void setKotShift(String kotShift) {
        this.kotShift = kotShift;
    }

    public String getKotSession() {
        return this.kotSession;
    }

    public void setKotSession(String kotSession) {
        this.kotSession = kotSession;
    }

    public String getKotOperId() {
        return this.kotOperId;
    }

    public void setKotOperId(String kotOperId) {
        this.kotOperId = kotOperId;
    }

    public String getKotItemDesc() {
        return this.kotItemDesc;
    }

    public void setKotItemDesc(String kotItemDesc) {
        this.kotItemDesc = kotItemDesc;
    }

    public String toString() {
        return "KOT [" + (this.kotRef != null ? "kotRef=" + this.kotRef + ", " :"") + (this.kotNo != null ? "kotNo=" + this.kotNo + ", " : "") + (this.kotSlNo != null ? "kotSlNo=" + this.kotSlNo + ", " : "") + (this.kotOutlet != null ? "kotOutlet=" + this.kotOutlet + ", " : "") + (this.kotStatus != null ? "kotStatus=" + this.kotStatus + ", " : "") + (this.kotDate != null ? "kotDate=" + this.kotDate + ", " : "") + (this.kotTime != null ? "kotTime=" + this.kotTime + ", " : "") + (this.kotTId != null ? "kotTId=" + this.kotTId + ", " : "") + (this.kotRoomId != null ? "kotRoomId=" + this.kotRoomId + ", " : "") + (this.kotGuestId != null ? "kotGuestId=" + this.kotGuestId + ", " : "") + (this.kotWaitId != null ? "kotWaitId=" + this.kotWaitId + ", " : "") + (this.kotCapId != null ? "kotCapId=" + this.kotCapId + ", " : "") + (this.kotItId != null ? "kotItId=" + this.kotItId + ", " : "") + (this.kotQty != null ? "kotQty=" + this.kotQty + ", " : "") + (this.kotPrice != null ? "kotPrice=" + this.kotPrice + ", " : "") + (this.kotGroup != null ? "kotGroup=" + this.kotGroup + ", " : "") + (this.kotMno != null ? "kotMno=" + this.kotMno + ", " : "") + (this.kotCat != null ? "kotCat=" + this.kotCat + ", " : "") + (this.kotFinYear != null ? "kotFinYear=" + this.kotFinYear + ", " : "") + (this.kotShift != null ? "kotShift=" + this.kotShift + ", " :"") + (this.kotSession != null ? "kotSession=" + this.kotSession + ", " : "") + (this.kotOperId != null ? "kotOperId=" + this.kotOperId + ", " :"") + (this.kotItemDesc != null ? "kotItemDesc=" + this.kotItemDesc :"") + "]";
    }

    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0 /*0*/:
                return this.kotRef;
            case 1/*1*/:
                return this.kotNo;
            case 2 /*2*/:
                return this.kotSlNo;
            case 3 /*3*/:
                return this.kotOutlet;
            case 4 /*4*/:
                return this.kotStatus;
            case 5 /*5*/:
                return this.kotDate;
            case 6 /*6*/:
                return this.kotTime;
            case 7 /*7*/:
                return this.kotTId;
            case 8/*8*/:
                return this.kotRoomId;
            case 9/*9*/:
                return this.kotGuestId;
            case 10 /*10*/:
                return this.kotWaitId;
            case 11:
                return this.kotCapId;
            case 12:
                return this.kotItId;
            case 13:
                return this.kotQty;
            case 14:
                return this.kotPrice;
            case 15:
                return this.kotGroup;
            case 16:
                return this.kotMno;
            case 17:
                return this.kotCat;
            case 18:
                return this.kotFinYear;
            case 19:
                return this.kotShift;
            case 20:
                return this.kotSession;
            case 21:
                return this.kotOperId;
            case 22:
                return this.kotItemDesc;
            default:
                return null;
        }
    }

    public int getPropertyCount() {
        return 23;
    }

    public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo arg2) {
        switch (arg0) {
            case 0 /*0*/:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotRef";
            case 1 /*1*/:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotNo";
            case 2/*2*/:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotSlNo";
            case 3 /*3*/:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotOutlet";
            case 4/*4*/:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotStatus";
            case 5 /*5*/:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotDate";
            case 6/*6*/:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotTime";
            case 7/*7*/:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotTId";
            case 8/*8*/:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotRoomId";
            case 9 /*9*/:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotGuestId";
            case 10 /*10*/:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotWaitId";
            case 11:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotCapId";
            case 12:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotItId";
            case 13:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotQty";
            case 14:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotPrice";
            case 15:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotGroup";
            case 16:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotMno";
            case 17:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotCat";
            case 18:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotFinYear";
            case 19:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotShift";
            case 20:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotSession";
            case 21:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotOperId";
            case 22:
                arg2.type = PropertyInfo.STRING_CLASS;
                arg2.name = "kotItemDesc";
            default:
        }
    }

    public void setProperty(int arg0, Object arg1) {
        switch (arg0) {
            case 0 /*0*/:
                this.kotRef = arg1.toString();
            case 1 /*1*/:
                this.kotNo = arg1.toString();
            case 2 /*2*/:
                this.kotSlNo = arg1.toString();
            case 3/*3*/:
                this.kotOutlet = arg1.toString();
            case 4/*4*/:
                this.kotStatus = arg1.toString();
            case 5/*5*/:
                this.kotDate = arg1.toString();
            case 6/*6*/:
                this.kotTime = arg1.toString();
            case 7 /*7*/:
                this.kotTId = arg1.toString();
            case 8/*8*/:
                this.kotRoomId = arg1.toString();
            case 9/*9*/:
                this.kotGuestId = arg1.toString();
            case 10 /*10*/:
                this.kotWaitId = arg1.toString();
            case 11:
                this.kotCapId = arg1.toString();
            case 12:
                this.kotItId = arg1.toString();
            case 13:
                this.kotQty = arg1.toString();
            case 14:
                this.kotPrice = arg1.toString();
            case 15:
                this.kotGroup = arg1.toString();
            case 16:
                this.kotMno = arg1.toString();
            case 17:
                this.kotCat = arg1.toString();
            case 18:
                this.kotFinYear = arg1.toString();
            case 19:
                this.kotShift = arg1.toString();
            case 20:
                this.kotSession = arg1.toString();
            case 21:
                this.kotOperId = arg1.toString();
            case 22:
                this.kotItemDesc = arg1.toString();
            default:
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(kotCapId);
        dest.writeString(kotCat);
        dest.writeString(kotDate);
        dest.writeString(kotFinYear);
        dest.writeString(kotGroup);
        dest.writeString(kotGuestId);
        dest.writeString(kotItId);
        dest.writeString(kotItemDesc);
        dest.writeString(kotMno);
        dest.writeString(kotNo);
        dest.writeString(kotOperId);
        dest.writeString(kotOutlet);
        dest.writeString(kotPrice);
        dest.writeString(kotQty);
        dest.writeString(kotRef);
        dest.writeString(kotRoomId);
        dest.writeString(kotSession);
        dest.writeString(kotShift);
        dest.writeString(kotSlNo);
        dest.writeString(kotStatus);
        dest.writeString(kotTId);
        dest.writeString(kotTime);
        dest.writeString(kotWaitId);
    }
}
