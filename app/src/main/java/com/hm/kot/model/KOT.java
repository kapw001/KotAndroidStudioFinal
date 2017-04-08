/**
 * 
 */
package com.hm.kot.model;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

/**
 * @author jaiganeshk
 *
 */
public class KOT implements KvmSerializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3968547277867752700L;
	
	private String kotRef;
	private String kotNo;
	private String kotSlNo;
	private String kotOutlet;
	private String kotStatus;
	private String kotDate;
	private String kotTime;
	private String kotTId;
	private String kotRoomId;
	private String kotGuestId;
	private String kotWaitId;
	private String kotCapId;
	private String kotItId;
	private String kotQty;
	private String kotPrice;
	private String kotGroup;
	private String kotMno;
	private String kotCat;
	private String kotFinYear;
	private String kotShift;
	private String kotSession;
	private String kotOperId;
	private String kotItemDesc;
	
	/**
	 * 
	 */
	public KOT() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param kotRef
	 * @param kotNo
	 * @param kotSlNo
	 * @param kotOutlet
	 * @param kotStatus
	 * @param kotDate
	 * @param kotTime
	 * @param kotTId
	 * @param kotRoomId
	 * @param kotGuestId
	 * @param kotWaitId
	 * @param kotCapId
	 * @param kotItId
	 * @param kotQty
	 * @param kotPrice
	 * @param kotGroup
	 * @param kotMno
	 * @param kotCat
	 * @param kotFinYear
	 * @param kotShift
	 * @param kotSession
	 * @param kotOperId
	 * @param kotItemDesc
	 */
	public KOT(String kotRef, String kotNo, String kotSlNo, String kotOutlet,
			String kotStatus, String kotDate, String kotTime, String kotTId,
			String kotRoomId, String kotGuestId, String kotWaitId,
			String kotCapId, String kotItId, String kotQty, String kotPrice,
			String kotGroup, String kotMno, String kotCat, String kotFinYear,
			String kotShift, String kotSession, String kotOperId,
			String kotItemDesc) {
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

	/**
	 * @return the kotRef
	 */
	public String getKotRef() {
		return kotRef;
	}

	/**
	 * @param kotRef the kotRef to set
	 */
	public void setKotRef(String kotRef) {
		this.kotRef = kotRef;
	}

	/**
	 * @return the kotNo
	 */
	public String getKotNo() {
		return kotNo;
	}

	/**
	 * @param kotNo the kotNo to set
	 */
	public void setKotNo(String kotNo) {
		this.kotNo = kotNo;
	}

	/**
	 * @return the kotSlNo
	 */
	public String getKotSlNo() {
		return kotSlNo;
	}

	/**
	 * @param kotSlNo the kotSlNo to set
	 */
	public void setKotSlNo(String kotSlNo) {
		this.kotSlNo = kotSlNo;
	}

	/**
	 * @return the kotOutlet
	 */
	public String getKotOutlet() {
		return kotOutlet;
	}

	/**
	 * @param kotOutlet the kotOutlet to set
	 */
	public void setKotOutlet(String kotOutlet) {
		this.kotOutlet = kotOutlet;
	}

	/**
	 * @return the kotStatus
	 */
	public String getKotStatus() {
		return kotStatus;
	}

	/**
	 * @param kotStatus the kotStatus to set
	 */
	public void setKotStatus(String kotStatus) {
		this.kotStatus = kotStatus;
	}

	/**
	 * @return the kotDate
	 */
	public String getKotDate() {
		return kotDate;
	}

	/**
	 * @param kotDate the kotDate to set
	 */
	public void setKotDate(String kotDate) {
		this.kotDate = kotDate;
	}

	/**
	 * @return the kotTime
	 */
	public String getKotTime() {
		return kotTime;
	}

	/**
	 * @param kotTime the kotTime to set
	 */
	public void setKotTime(String kotTime) {
		this.kotTime = kotTime;
	}

	/**
	 * @return the kotTId
	 */
	public String getKotTId() {
		return kotTId;
	}

	/**
	 * @param kotTId the kotTId to set
	 */
	public void setKotTId(String kotTId) {
		this.kotTId = kotTId;
	}

	/**
	 * @return the kotRoomId
	 */
	public String getKotRoomId() {
		return kotRoomId;
	}

	/**
	 * @param kotRoomId the kotRoomId to set
	 */
	public void setKotRoomId(String kotRoomId) {
		this.kotRoomId = kotRoomId;
	}

	/**
	 * @return the kotGuestId
	 */
	public String getKotGuestId() {
		return kotGuestId;
	}

	/**
	 * @param kotGuestId the kotGuestId to set
	 */
	public void setKotGuestId(String kotGuestId) {
		this.kotGuestId = kotGuestId;
	}

	/**
	 * @return the kotWaitId
	 */
	public String getKotWaitId() {
		return kotWaitId;
	}

	/**
	 * @param kotWaitId the kotWaitId to set
	 */
	public void setKotWaitId(String kotWaitId) {
		this.kotWaitId = kotWaitId;
	}

	/**
	 * @return the kotCapId
	 */
	public String getKotCapId() {
		return kotCapId;
	}

	/**
	 * @param kotCapId the kotCapId to set
	 */
	public void setKotCapId(String kotCapId) {
		this.kotCapId = kotCapId;
	}

	/**
	 * @return the kotItId
	 */
	public String getKotItId() {
		return kotItId;
	}

	/**
	 * @param kotItId the kotItId to set
	 */
	public void setKotItId(String kotItId) {
		this.kotItId = kotItId;
	}

	/**
	 * @return the kotQty
	 */
	public String getKotQty() {
		return kotQty;
	}

	/**
	 * @param kotQty the kotQty to set
	 */
	public void setKotQty(String kotQty) {
		this.kotQty = kotQty;
	}

	/**
	 * @return the kotPrice
	 */
	public String getKotPrice() {
		return kotPrice.replaceAll(",","");
	}

	/**
	 * @param kotPrice the kotPrice to set
	 */
	public void setKotPrice(String kotPrice) {
		this.kotPrice = kotPrice;
	}

	/**
	 * @return the kotGroup
	 */
	public String getKotGroup() {
		return kotGroup;
	}

	/**
	 * @param kotGroup the kotGroup to set
	 */
	public void setKotGroup(String kotGroup) {
		this.kotGroup = kotGroup;
	}

	/**
	 * @return the kotMno
	 */
	public String getKotMno() {
		return kotMno;
	}

	/**
	 * @param kotMno the kotMno to set
	 */
	public void setKotMno(String kotMno) {
		this.kotMno = kotMno;
	}

	/**
	 * @return the kotCat
	 */
	public String getKotCat() {
		return kotCat;
	}

	/**
	 * @param kotCat the kotCat to set
	 */
	public void setKotCat(String kotCat) {
		this.kotCat = kotCat;
	}

	/**
	 * @return the kotFinYear
	 */
	public String getKotFinYear() {
		return kotFinYear;
	}

	/**
	 * @param kotFinYear the kotFinYear to set
	 */
	public void setKotFinYear(String kotFinYear) {
		this.kotFinYear = kotFinYear;
	}

	/**
	 * @return the kotShift
	 */
	public String getKotShift() {
		return kotShift;
	}

	/**
	 * @param kotShift the kotShift to set
	 */
	public void setKotShift(String kotShift) {
		this.kotShift = kotShift;
	}

	/**
	 * @return the kotSession
	 */
	public String getKotSession() {
		return kotSession;
	}

	/**
	 * @param kotSession the kotSession to set
	 */
	public void setKotSession(String kotSession) {
		this.kotSession = kotSession;
	}

	/**
	 * @return the kotOperId
	 */
	public String getKotOperId() {
		return kotOperId;
	}

	/**
	 * @param kotOperId the kotOperId to set
	 */
	public void setKotOperId(String kotOperId) {
		this.kotOperId = kotOperId;
	}

	/**
	 * @return the kotItemDesc
	 */
	public String getKotItemDesc() {
		return kotItemDesc;
	}

	/**
	 * @param kotItemDesc the kotItemDesc to set
	 */
	public void setKotItemDesc(String kotItemDesc) {
		this.kotItemDesc = kotItemDesc;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "KOT [" + (kotRef != null ? "kotRef=" + kotRef + ", " : "")
				+ (kotNo != null ? "kotNo=" + kotNo + ", " : "")
				+ (kotSlNo != null ? "kotSlNo=" + kotSlNo + ", " : "")
				+ (kotOutlet != null ? "kotOutlet=" + kotOutlet + ", " : "")
				+ (kotStatus != null ? "kotStatus=" + kotStatus + ", " : "")
				+ (kotDate != null ? "kotDate=" + kotDate + ", " : "")
				+ (kotTime != null ? "kotTime=" + kotTime + ", " : "")
				+ (kotTId != null ? "kotTId=" + kotTId + ", " : "")
				+ (kotRoomId != null ? "kotRoomId=" + kotRoomId + ", " : "")
				+ (kotGuestId != null ? "kotGuestId=" + kotGuestId + ", " : "")
				+ (kotWaitId != null ? "kotWaitId=" + kotWaitId + ", " : "")
				+ (kotCapId != null ? "kotCapId=" + kotCapId + ", " : "")
				+ (kotItId != null ? "kotItId=" + kotItId + ", " : "")
				+ (kotQty != null ? "kotQty=" + kotQty + ", " : "")
				+ (kotPrice != null ? "kotPrice=" + kotPrice + ", " : "")
				+ (kotGroup != null ? "kotGroup=" + kotGroup + ", " : "")
				+ (kotMno != null ? "kotMno=" + kotMno + ", " : "")
				+ (kotCat != null ? "kotCat=" + kotCat + ", " : "")
				+ (kotFinYear != null ? "kotFinYear=" + kotFinYear + ", " : "")
				+ (kotShift != null ? "kotShift=" + kotShift + ", " : "")
				+ (kotSession != null ? "kotSession=" + kotSession + ", " : "")
				+ (kotOperId != null ? "kotOperId=" + kotOperId + ", " : "")
				+ (kotItemDesc != null ? "kotItemDesc=" + kotItemDesc : "")
				+ "]";
	}

	/* (non-Javadoc)
	 * @see org.ksoap2.serialization.KvmSerializable#getProperty(int)
	 */
	public Object getProperty(int arg0) {
		// TODO Auto-generated method stub
		switch(arg0){
		case 0:
			return kotRef;
		case 1:
			return kotNo;
		case 2:
			return kotSlNo;
		case 3:
			return kotOutlet;
		case 4:
			return kotStatus;
		case 5:
			return kotDate;
		case 6:
			return kotTime;
		case 7:
			return kotTId;
		case 8:
			return kotRoomId;
		case 9:
			return kotGuestId;
		case 10:
			return kotWaitId;
		case 11:
			return kotCapId;
		case 12:
			return kotItId;
		case 13:
			return kotQty;
		case 14:
			return kotPrice;
		case 15:
			return kotGroup;
		case 16:
			return kotMno;
		case 17:
			return kotCat;
		case 18:
			return kotFinYear;
		case 19:
			return kotShift;
		case 20:
			return kotSession;
		case 21:
			return kotOperId;
		case 22:
			return kotItemDesc;
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see org.ksoap2.serialization.KvmSerializable#getPropertyCount()
	 */
	public int getPropertyCount() {
		// TODO Auto-generated method stub
		return 23;
	}

	/* (non-Javadoc)
	 * @see org.ksoap2.serialization.KvmSerializable#getPropertyInfo(int, java.util.Hashtable, org.ksoap2.serialization.PropertyInfo)
	 */
	@SuppressWarnings("rawtypes")
	public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo arg2) {
		// TODO Auto-generated method stub
		switch(arg0){
		case 0:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotRef";
            break;
		case 1:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotNo";
            break;
		case 2:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotSlNo";
            break;
		case 3:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotOutlet";
            break;
		case 4:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotStatus";
            break;
		case 5:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotDate";
            break;
		case 6:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotTime";
            break;
		case 7:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotTId";
            break;
		case 8:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotRoomId";
            break;
		case 9:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotGuestId";
            break;
		case 10:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotWaitId";
            break;
		case 11:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotCapId";
            break;
		case 12:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotItId";
            break;
		case 13:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotQty";
            break;
		case 14:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotPrice";
            break;
		case 15:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotGroup";
            break;
		case 16:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotMno";
            break;
		case 17:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotCat";
            break;
		case 18:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotFinYear";
            break;
		case 19:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotShift";
            break;
		case 20:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotSession";
            break;
		case 21:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotOperId";
            break;
		case 22:
			arg2.type = PropertyInfo.STRING_CLASS;
            arg2.name = "kotItemDesc";
            break;
        default : 
        	break;
		}
	}

	/* (non-Javadoc)
	 * @see org.ksoap2.serialization.KvmSerializable#setProperty(int, java.lang.Object)
	 */
	public void setProperty(int arg0, Object arg1) {
		// TODO Auto-generated method stub
		switch(arg0){
		case 0:
			kotRef = arg1.toString();
	        break;
		case 1:
			kotNo = arg1.toString();
	        break;
		case 2:
			kotSlNo = arg1.toString();
	        break;
		case 3:
			kotOutlet = arg1.toString();
	        break;
		case 4:
			kotStatus = arg1.toString();
	        break;
		case 5:
			kotDate = arg1.toString();
	        break;
		case 6:
			kotTime = arg1.toString();
	        break;
		case 7:
			kotTId = arg1.toString();
	        break;
		case 8:
			kotRoomId = arg1.toString();
	        break;
		case 9:
			kotGuestId = arg1.toString();
	        break;
		case 10:
			kotWaitId = arg1.toString();
	        break;
		case 11:
			kotCapId = arg1.toString();
	        break;
		case 12:
			kotItId = arg1.toString();
	        break;
		case 13:
			kotQty = arg1.toString();
	        break;
		case 14:
			kotPrice = arg1.toString();
	        break;
		case 15:
			kotGroup = arg1.toString();
	        break;
		case 16:
			kotMno = arg1.toString();
	        break;
		case 17:
			kotCat = arg1.toString();
	        break;
		case 18:
			kotFinYear = arg1.toString();
	        break;
		case 19:
			kotShift = arg1.toString();
	        break;
		case 20:
			kotSession = arg1.toString();
	        break;
		case 21:
			kotOperId = arg1.toString();
	        break;
		case 22:
			kotItemDesc = arg1.toString();
	        break;
        default : 
        	break;
		}
	}
	
}