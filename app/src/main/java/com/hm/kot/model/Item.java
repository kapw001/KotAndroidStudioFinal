package com.hm.kot.model;

import org.xmlpull.v1.XmlPullParser;

public class Item {
    private String rsiBQty;
    private String rsiCatId;
    private float rsiClBal;
    private String rsiCost;
    private float rsiDQty;
    private String rsiDate;
    private String rsiDesc;
    private float rsiFcPer;
    private String rsiGroup;
    private String rsiId;
    private int rsiIsDis;
    private String rsiIsStock;
    private float rsiKQty;
    private String rsiKitcher;
    private String rsiLc;
    private String rsiMPeriod;
    private float rsiMonth1;
    private float rsiMonth10;
    private float rsiMonth11;
    private float rsiMonth12;
    private float rsiMonth2;
    private float rsiMonth3;
    private float rsiMonth4;
    private float rsiMonth44;
    private float rsiMonth5;
    private float rsiMonth6;
    private float rsiMonth7;
    private float rsiMonth8;
    private float rsiMonth9;
    private float rsiOpBal;
    private float rsiPNumber;
    private float rsiPSize;
    private float rsiPrice;
    private float rsiPrice1;
    private float rsiPrice2;
    private float rsiPrice3;
    private float rsiPrice4;
    private float rsiPrice5;
    private float rsiPrice6;
    private float rsiPrice7;
    private float rsiPrice8;
    private float rsiPrice9;
    private String rsiPsUnit;
    private float rsiTaxPer;
    private float rsiTaxPer1;
    private float rsiTaxPer2;
    private float rsiTaxPer3;
    private float rsiTaxPer4;
    private float rsiTaxPer5;
    private float rsiTaxPer6;
    private float rsiTaxPer7;
    private float rsiTaxPer8;
    private float rsiTaxPer9;
    private String rsiTime;
    private float rsiTotal;
    private float rsiTotals;
    private String rsiType;
    private String rsiUnit;

    public String getRsiId() {
        return this.rsiId;
    }

    public void setRsiId(String rsiId) {
        this.rsiId = rsiId;
    }

    public String getRsiDesc() {
        return this.rsiDesc;
    }

    public void setRsiDesc(String rsiDesc) {
        this.rsiDesc = rsiDesc;
    }

    public String getRsiUnit() {
        return this.rsiUnit;
    }

    public void setRsiUnit(String rsiUnit) {
        this.rsiUnit = rsiUnit;
    }

    public String getRsiType() {
        return this.rsiType;
    }

    public void setRsiType(String rsiType) {
        this.rsiType = rsiType;
    }

    public String getRsiGroup() {
        return this.rsiGroup;
    }

    public void setRsiGroup(String rsiGroup) {
        this.rsiGroup = rsiGroup;
    }

    public String getRsiCatId() {
        return this.rsiCatId;
    }

    public void setRsiCatId(String rsiCatId) {
        this.rsiCatId = rsiCatId;
    }

    public String getRsiIsStock() {
        return this.rsiIsStock;
    }

    public void setRsiIsStock(String rsiIsStock) {
        this.rsiIsStock = rsiIsStock;
    }

    public String getRsiCost() {
        return this.rsiCost.replaceAll(",", "");
    }

    public void setRsiCost(String rsiCost) {
        this.rsiCost = rsiCost;
    }

    public float getRsiPrice() {
        return this.rsiPrice;
    }

    public void setRsiPrice(float rsiPrice) {
        this.rsiPrice = rsiPrice;
    }

    public float getRsiPrice1() {
        return this.rsiPrice1;
    }

    public void setRsiPrice1(float rsiPrice1) {
        this.rsiPrice1 = rsiPrice1;
    }

    public float getRsiPrice2() {
        return this.rsiPrice2;
    }

    public void setRsiPrice2(float rsiPrice2) {
        this.rsiPrice2 = rsiPrice2;
    }

    public float getRsiPrice3() {
        return this.rsiPrice3;
    }

    public void setRsiPrice3(float rsiPrice3) {
        this.rsiPrice3 = rsiPrice3;
    }

    public float getRsiPrice4() {
        return this.rsiPrice4;
    }

    public void setRsiPrice4(float rsiPrice4) {
        this.rsiPrice4 = rsiPrice4;
    }

    public float getRsiPrice5() {
        return this.rsiPrice5;
    }

    public void setRsiPrice5(float rsiPrice5) {
        this.rsiPrice5 = rsiPrice5;
    }

    public float getRsiPrice6() {
        return this.rsiPrice6;
    }

    public void setRsiPrice6(float rsiPrice6) {
        this.rsiPrice6 = rsiPrice6;
    }

    public float getRsiPrice7() {
        return this.rsiPrice7;
    }

    public void setRsiPrice7(float rsiPrice7) {
        this.rsiPrice7 = rsiPrice7;
    }

    public float getRsiPrice8() {
        return this.rsiPrice8;
    }

    public void setRsiPrice8(float rsiPrice8) {
        this.rsiPrice8 = rsiPrice8;
    }

    public float getRsiPrice9() {
        return this.rsiPrice9;
    }

    public void setRsiPrice9(float rsiPrice9) {
        this.rsiPrice9 = rsiPrice9;
    }

    public float getRsiTaxPer() {
        return this.rsiTaxPer;
    }

    public void setRsiTaxPer(float rsiTaxPer) {
        this.rsiTaxPer = rsiTaxPer;
    }

    public float getRsiTaxPer1() {
        return this.rsiTaxPer1;
    }

    public void setRsiTaxPer1(float rsiTaxPer1) {
        this.rsiTaxPer1 = rsiTaxPer1;
    }

    public float getRsiTaxPer2() {
        return this.rsiTaxPer2;
    }

    public void setRsiTaxPer2(float rsiTaxPer2) {
        this.rsiTaxPer2 = rsiTaxPer2;
    }

    public float getRsiTaxPer3() {
        return this.rsiTaxPer3;
    }

    public void setRsiTaxPer3(float rsiTaxPer3) {
        this.rsiTaxPer3 = rsiTaxPer3;
    }

    public float getRsiTaxPer4() {
        return this.rsiTaxPer4;
    }

    public void setRsiTaxPer4(float rsiTaxPer4) {
        this.rsiTaxPer4 = rsiTaxPer4;
    }

    public float getRsiTaxPer5() {
        return this.rsiTaxPer5;
    }

    public void setRsiTaxPer5(float rsiTaxPer5) {
        this.rsiTaxPer5 = rsiTaxPer5;
    }

    public float getRsiTaxPer6() {
        return this.rsiTaxPer6;
    }

    public void setRsiTaxPer6(float rsiTaxPer6) {
        this.rsiTaxPer6 = rsiTaxPer6;
    }

    public float getRsiTaxPer7() {
        return this.rsiTaxPer7;
    }

    public void setRsiTaxPer7(float rsiTaxPer7) {
        this.rsiTaxPer7 = rsiTaxPer7;
    }

    public float getRsiTaxPer8() {
        return this.rsiTaxPer8;
    }

    public void setRsiTaxPer8(float rsiTaxPer8) {
        this.rsiTaxPer8 = rsiTaxPer8;
    }

    public float getRsiTaxPer9() {
        return this.rsiTaxPer9;
    }

    public void setRsiTaxPer9(float rsiTaxPer9) {
        this.rsiTaxPer9 = rsiTaxPer9;
    }

    public String getRsiLc() {
        return this.rsiLc;
    }

    public void setRsiLc(String rsiLc) {
        this.rsiLc = rsiLc;
    }

    public float getRsiTotals() {
        return this.rsiTotals;
    }

    public void setRsiTotals(float rsiTotals) {
        this.rsiTotals = rsiTotals;
    }

    public String getRsiPsUnit() {
        return this.rsiPsUnit;
    }

    public void setRsiPsUnit(String rsiPsUnit) {
        this.rsiPsUnit = rsiPsUnit;
    }

    public String getRsiDate() {
        return this.rsiDate;
    }

    public void setRsiDate(String rsiDate) {
        this.rsiDate = rsiDate;
    }

    public String getRsiTime() {
        return this.rsiTime;
    }

    public void setRsiTime(String rsiTime) {
        this.rsiTime = rsiTime;
    }

    public float getRsiPSize() {
        return this.rsiPSize;
    }

    public void setRsiPSize(float rsiPSize) {
        this.rsiPSize = rsiPSize;
    }

    public String getRsiMPeriod() {
        return this.rsiMPeriod;
    }

    public void setRsiMPeriod(String rsiMPeriod) {
        this.rsiMPeriod = rsiMPeriod;
    }

    public float getRsiPNumber() {
        return this.rsiPNumber;
    }

    public void setRsiPNumber(float rsiPNumber) {
        this.rsiPNumber = rsiPNumber;
    }

    public float getRsiTotal() {
        return this.rsiTotal;
    }

    public void setRsiTotal(float rsiTotal) {
        this.rsiTotal = rsiTotal;
    }

    public String getRsiKitcher() {
        return this.rsiKitcher;
    }

    public void setRsiKitcher(String rsiKitcher) {
        this.rsiKitcher = rsiKitcher;
    }

    public String getRsiBQty() {
        return this.rsiBQty;
    }

    public void setRsiBQty(String rsiBQty) {
        this.rsiBQty = rsiBQty;
    }

    public float getRsiKQty() {
        return this.rsiKQty;
    }

    public void setRsiKQty(float rsiKQty) {
        this.rsiKQty = rsiKQty;
    }

    public float getRsiDQty() {
        return this.rsiDQty;
    }

    public void setRsiDQty(float rsiDQty) {
        this.rsiDQty = rsiDQty;
    }

    public int getRsiIsDis() {
        return this.rsiIsDis;
    }

    public void setRsiIsDis(int rsiIsDis) {
        this.rsiIsDis = rsiIsDis;
    }

    public float getRsiFcPer() {
        return this.rsiFcPer;
    }

    public void setRsiFcPer(float rsiFcPer) {
        this.rsiFcPer = rsiFcPer;
    }

    public float getRsiOpBal() {
        return this.rsiOpBal;
    }

    public void setRsiOpBal(float rsiOpBal) {
        this.rsiOpBal = rsiOpBal;
    }

    public float getRsiClBal() {
        return this.rsiClBal;
    }

    public void setRsiClBal(float rsiClBal) {
        this.rsiClBal = rsiClBal;
    }

    public float getRsiMonth1() {
        return this.rsiMonth1;
    }

    public void setRsiMonth1(float rsiMonth1) {
        this.rsiMonth1 = rsiMonth1;
    }

    public float getRsiMonth2() {
        return this.rsiMonth2;
    }

    public void setRsiMonth2(float rsiMonth2) {
        this.rsiMonth2 = rsiMonth2;
    }

    public float getRsiMonth3() {
        return this.rsiMonth3;
    }

    public void setRsiMonth3(float rsiMonth3) {
        this.rsiMonth3 = rsiMonth3;
    }

    public float getRsiMonth4() {
        return this.rsiMonth4;
    }

    public void setRsiMonth4(float rsiMonth4) {
        this.rsiMonth4 = rsiMonth4;
    }

    public float getRsiMonth5() {
        return this.rsiMonth5;
    }

    public void setRsiMonth5(float rsiMonth5) {
        this.rsiMonth5 = rsiMonth5;
    }

    public float getRsiMonth6() {
        return this.rsiMonth6;
    }

    public void setRsiMonth6(float rsiMonth6) {
        this.rsiMonth6 = rsiMonth6;
    }

    public float getRsiMonth7() {
        return this.rsiMonth7;
    }

    public void setRsiMonth7(float rsiMonth7) {
        this.rsiMonth7 = rsiMonth7;
    }

    public float getRsiMonth8() {
        return this.rsiMonth8;
    }

    public void setRsiMonth8(float rsiMonth8) {
        this.rsiMonth8 = rsiMonth8;
    }

    public float getRsiMonth9() {
        return this.rsiMonth9;
    }

    public void setRsiMonth9(float rsiMonth9) {
        this.rsiMonth9 = rsiMonth9;
    }

    public float getRsiMonth10() {
        return this.rsiMonth10;
    }

    public void setRsiMonth10(float rsiMonth10) {
        this.rsiMonth10 = rsiMonth10;
    }

    public float getRsiMonth11() {
        return this.rsiMonth11;
    }

    public void setRsiMonth11(float rsiMonth11) {
        this.rsiMonth11 = rsiMonth11;
    }

    public float getRsiMonth12() {
        return this.rsiMonth12;
    }

    public void setRsiMonth12(float rsiMonth12) {
        this.rsiMonth12 = rsiMonth12;
    }

    public float getRsiMonth44() {
        return this.rsiMonth44;
    }

    public void setRsiMonth44(float rsiMonth44) {
        this.rsiMonth44 = rsiMonth44;
    }

    public String toString() {
        return "Item [" + (this.rsiId != null ? "rsiId=" + this.rsiId + ", " : XmlPullParser.NO_NAMESPACE) + (this.rsiDesc != null ? "rsiDesc=" + this.rsiDesc + ", " : XmlPullParser.NO_NAMESPACE) + (this.rsiUnit != null ? "rsiUnit=" + this.rsiUnit + ", " : XmlPullParser.NO_NAMESPACE) + "rsiType=" + this.rsiType + ", " + (this.rsiGroup != null ? "rsiGroup=" + this.rsiGroup + ", " : XmlPullParser.NO_NAMESPACE) + (this.rsiCatId != null ? "rsiCatId=" + this.rsiCatId + ", " : XmlPullParser.NO_NAMESPACE) + "rsiIsStock=" + this.rsiIsStock + ", rsiCost=" + this.rsiCost + ", rsiPrice=" + this.rsiPrice + ", rsiPrice1=" + this.rsiPrice1 + ", rsiPrice2=" + this.rsiPrice2 + ", rsiPrice3=" + this.rsiPrice3 + ", rsiPrice4=" + this.rsiPrice4 + ", rsiPrice5=" + this.rsiPrice5 + ", rsiPrice6=" + this.rsiPrice6 + ", rsiPrice7=" + this.rsiPrice7 + ", rsiPrice8=" + this.rsiPrice8 + ", rsiPrice9=" + this.rsiPrice9 + ", rsiTaxPer=" + this.rsiTaxPer + ", rsiTaxPer1=" + this.rsiTaxPer1 + ", rsiTaxPer2=" + this.rsiTaxPer2 + ", rsiTaxPer3=" + this.rsiTaxPer3 + ", rsiTaxPer4=" + this.rsiTaxPer4 + ", rsiTaxPer5=" + this.rsiTaxPer5 + ", rsiTaxPer6=" + this.rsiTaxPer6 + ", rsiTaxPer7=" + this.rsiTaxPer7 + ", rsiTaxPer8=" + this.rsiTaxPer8 + ", rsiTaxPer9=" + this.rsiTaxPer9 + ", " + (this.rsiLc != null ? "rsiLc=" + this.rsiLc + ", " : XmlPullParser.NO_NAMESPACE) + "rsiTotals=" + this.rsiTotals + ", " + (this.rsiPsUnit != null ? "rsiPsUnit=" + this.rsiPsUnit + ", " : XmlPullParser.NO_NAMESPACE) + (this.rsiDate != null ? "rsiDate=" + this.rsiDate + ", " : XmlPullParser.NO_NAMESPACE) + (this.rsiTime != null ? "rsiTime=" + this.rsiTime + ", " : XmlPullParser.NO_NAMESPACE) + "rsiPSize=" + this.rsiPSize + ", " + (this.rsiMPeriod != null ? "rsiMPeriod=" + this.rsiMPeriod + ", " : XmlPullParser.NO_NAMESPACE) + "rsiPNumber=" + this.rsiPNumber + ", rsiTotal=" + this.rsiTotal + ", " + (this.rsiKitcher != null ? "rsiKitcher=" + this.rsiKitcher + ", " : XmlPullParser.NO_NAMESPACE) + "rsiBQty=" + this.rsiBQty + ", rsiKQty=" + this.rsiKQty + ", rsiDQty=" + this.rsiDQty + ", rsiIsDis=" + this.rsiIsDis + ", rsiFcPer=" + this.rsiFcPer + ", rsiOpBal=" + this.rsiOpBal + ", rsiClBal=" + this.rsiClBal + ", rsiMonth1=" + this.rsiMonth1 + ", rsiMonth2=" + this.rsiMonth2 + ", rsiMonth3=" + this.rsiMonth3 + ", rsiMonth4=" + this.rsiMonth4 + ", rsiMonth5=" + this.rsiMonth5 + ", rsiMonth6=" + this.rsiMonth6 + ", rsiMonth7=" + this.rsiMonth7 + ", rsiMonth8=" + this.rsiMonth8 + ", rsiMonth9=" + this.rsiMonth9 + ", rsiMonth10=" + this.rsiMonth10 + ", rsiMonth11=" + this.rsiMonth11 + ", rsiMonth12=" + this.rsiMonth12 + ", rsiMonth44=" + this.rsiMonth44 + "]";
    }
}
