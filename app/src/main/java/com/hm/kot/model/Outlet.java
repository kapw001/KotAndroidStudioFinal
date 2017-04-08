package com.hm.kot.model;

import java.io.Serializable;
import org.xmlpull.v1.XmlPullParser;

public class Outlet implements Serializable {
    private static final long serialVersionUID = 7362224904993541617L;
    private int outletAllowFood;
    private int outletAllowLiq;
    private int outletBPrintAfterSave;
    private String outletBillMsg1;
    private String outletBillMsg2;
    private String outletBillPort;
    private String outletBillPrinter;
    private int outletBillSkip;
    private String outletBillStaType;
    private int outletCashOnly;
    private String outletCompany;
    private int outletCoverCrg;
    private int outletDefaultPrint;
    private String outletDesc;
    private int outletEpsonCut;
    private int outletEpsonFont;
    private String outletFacil;
    private String outletFinYear;
    private String outletFoId;
    private String outletFobCode;
    private String outletId;
    private int outletIsBPrompt;
    private int outletIsBToken;
    private int outletIsBillAutoSet;
    private int outletIsLinkFo;
    private float outletIsPp;
    private int outletIsPromote;
    private float outletIsRnd;
    private int outletIsSave;
    private int outletIsSerParcel;
    private int outletIsSerTax;
    private int outletKotLSkip;
    private String outletKotPStyle;
    private String outletKotPort;
    private String outletKotPrinter;
    private String outletKotStaType;
    private int outletLSkipRev;
    private int outletLSkipTear;
    private float outletLastBill;
    private float outletLastKot;
    private float outletLastNc;
    private float outletLastPur;
    private float outletLiqPno;
    private float outletLiqVno;
    private int outletNo;
    private String outletOpType;
    private int outletOpenKot;
    private float outletParcper;
    private int outletRoundOff;
    private int outletScbBill;
    private int outletScbBillSet;
    private int outletSerFoodOnly;
    private float outletSerTax;
    private float outletSerTaxFoodOnly;
    private float outletSerper;
    private String outletTDesc;
    private float outletTableGrace;
    private String outletTableGraceDisp;
    private float outletTableTimer;
    private int outletTax2SerChg;
    private int outletUseMKot;
    private int outletValMKot;
    private int outletVno;

    public String getOutletId() {
        return this.outletId;
    }

    public void setOutletId(String outletId) {
        this.outletId = outletId;
    }

    public String getOutletDesc() {
        return this.outletDesc;
    }

    public void setOutletDesc(String outletDesc) {
        this.outletDesc = outletDesc;
    }

    public int getOutletNo() {
        return this.outletNo;
    }

    public void setOutletNo(int outletNo) {
        this.outletNo = outletNo;
    }

    public String getOutletOpType() {
        return this.outletOpType;
    }

    public void setOutletOpType(String outletOpType) {
        this.outletOpType = outletOpType;
    }

    public String getOutletTDesc() {
        return this.outletTDesc;
    }

    public void setOutletTDesc(String outletTDesc) {
        this.outletTDesc = outletTDesc;
    }

    public String getOutletFinYear() {
        return this.outletFinYear;
    }

    public void setOutletFinYear(String outletFinYear) {
        this.outletFinYear = outletFinYear;
    }

    public int getOutletIsLinkFo() {
        return this.outletIsLinkFo;
    }

    public void setOutletIsLinkFo(int outletIsLinkFo) {
        this.outletIsLinkFo = outletIsLinkFo;
    }

    public String getOutletFoId() {
        return this.outletFoId;
    }

    public void setOutletFoId(String outletFoId) {
        this.outletFoId = outletFoId;
    }

    public float getOutletParcper() {
        return this.outletParcper;
    }

    public void setOutletParcper(float outletParcper) {
        this.outletParcper = outletParcper;
    }

    public float getOutletSerper() {
        return this.outletSerper;
    }

    public void setOutletSerper(float outletSerper) {
        this.outletSerper = outletSerper;
    }

    public int getOutletRoundOff() {
        return this.outletRoundOff;
    }

    public void setOutletRoundOff(int outletRoundOff) {
        this.outletRoundOff = outletRoundOff;
    }

    public float getOutletLastKot() {
        return this.outletLastKot;
    }

    public void setOutletLastKot(float outletLastKot) {
        this.outletLastKot = outletLastKot;
    }

    public String getOutletKotPort() {
        return this.outletKotPort;
    }

    public void setOutletKotPort(String outletKotPort) {
        this.outletKotPort = outletKotPort;
    }

    public int getOutletUseMKot() {
        return this.outletUseMKot;
    }

    public void setOutletUseMKot(int outletUseMKot) {
        this.outletUseMKot = outletUseMKot;
    }

    public int getOutletValMKot() {
        return this.outletValMKot;
    }

    public void setOutletValMKot(int outletValMKot) {
        this.outletValMKot = outletValMKot;
    }

    public int getOutletKotLSkip() {
        return this.outletKotLSkip;
    }

    public void setOutletKotLSkip(int outletKotLSkip) {
        this.outletKotLSkip = outletKotLSkip;
    }

    public String getOutletKotStaType() {
        return this.outletKotStaType;
    }

    public void setOutletKotStaType(String outletKotStaType) {
        this.outletKotStaType = outletKotStaType;
    }

    public String getOutletKotPStyle() {
        return this.outletKotPStyle;
    }

    public void setOutletKotPStyle(String outletKotPStyle) {
        this.outletKotPStyle = outletKotPStyle;
    }

    public float getOutletLastBill() {
        return this.outletLastBill;
    }

    public void setOutletLastBill(float outletLastBill) {
        this.outletLastBill = outletLastBill;
    }

    public String getOutletBillPort() {
        return this.outletBillPort;
    }

    public void setOutletBillPort(String outletBillPort) {
        this.outletBillPort = outletBillPort;
    }

    public int getOutletBillSkip() {
        return this.outletBillSkip;
    }

    public void setOutletBillSkip(int outletBillSkip) {
        this.outletBillSkip = outletBillSkip;
    }

    public String getOutletBillStaType() {
        return this.outletBillStaType;
    }

    public void setOutletBillStaType(String outletBillStaType) {
        this.outletBillStaType = outletBillStaType;
    }

    public int getOutletIsBillAutoSet() {
        return this.outletIsBillAutoSet;
    }

    public void setOutletIsBillAutoSet(int outletIsBillAutoSet) {
        this.outletIsBillAutoSet = outletIsBillAutoSet;
    }

    public int getOutletIsBPrompt() {
        return this.outletIsBPrompt;
    }

    public void setOutletIsBPrompt(int outletIsBPrompt) {
        this.outletIsBPrompt = outletIsBPrompt;
    }

    public int getOutletIsBToken() {
        return this.outletIsBToken;
    }

    public void setOutletIsBToken(int outletIsBToken) {
        this.outletIsBToken = outletIsBToken;
    }

    public int getOutletBPrintAfterSave() {
        return this.outletBPrintAfterSave;
    }

    public void setOutletBPrintAfterSave(int outletBPrintAfterSave) {
        this.outletBPrintAfterSave = outletBPrintAfterSave;
    }

    public float getOutletLastNc() {
        return this.outletLastNc;
    }

    public void setOutletLastNc(float outletLastNc) {
        this.outletLastNc = outletLastNc;
    }

    public float getOutletIsRnd() {
        return this.outletIsRnd;
    }

    public void setOutletIsRnd(float outletIsRnd) {
        this.outletIsRnd = outletIsRnd;
    }

    public float getOutletIsPp() {
        return this.outletIsPp;
    }

    public void setOutletIsPp(float outletIsPp) {
        this.outletIsPp = outletIsPp;
    }

    public String getOutletKotPrinter() {
        return this.outletKotPrinter;
    }

    public void setOutletKotPrinter(String outletKotPrinter) {
        this.outletKotPrinter = outletKotPrinter;
    }

    public String getOutletBillPrinter() {
        return this.outletBillPrinter;
    }

    public void setOutletBillPrinter(String outletBillPrinter) {
        this.outletBillPrinter = outletBillPrinter;
    }

    public String getOutletFobCode() {
        return this.outletFobCode;
    }

    public void setOutletFobCode(String outletFobCode) {
        this.outletFobCode = outletFobCode;
    }

    public int getOutletVno() {
        return this.outletVno;
    }

    public void setOutletVno(int outletVno) {
        this.outletVno = outletVno;
    }

    public int getOutletDefaultPrint() {
        return this.outletDefaultPrint;
    }

    public void setOutletDefaultPrint(int outletDefaultPrint) {
        this.outletDefaultPrint = outletDefaultPrint;
    }

    public int getOutletLSkipTear() {
        return this.outletLSkipTear;
    }

    public void setOutletLSkipTear(int outletLSkipTear) {
        this.outletLSkipTear = outletLSkipTear;
    }

    public int getOutletLSkipRev() {
        return this.outletLSkipRev;
    }

    public void setOutletLSkipRev(int outletLSkipRev) {
        this.outletLSkipRev = outletLSkipRev;
    }

    public int getOutletEpsonCut() {
        return this.outletEpsonCut;
    }

    public void setOutletEpsonCut(int outletEpsonCut) {
        this.outletEpsonCut = outletEpsonCut;
    }

    public String getOutletBillMsg1() {
        return this.outletBillMsg1;
    }

    public void setOutletBillMsg1(String outletBillMsg1) {
        this.outletBillMsg1 = outletBillMsg1;
    }

    public String getOutletBillMsg2() {
        return this.outletBillMsg2;
    }

    public void setOutletBillMsg2(String outletBillMsg2) {
        this.outletBillMsg2 = outletBillMsg2;
    }

    public int getOutletAllowLiq() {
        return this.outletAllowLiq;
    }

    public void setOutletAllowLiq(int outletAllowLiq) {
        this.outletAllowLiq = outletAllowLiq;
    }

    public int getOutletAllowFood() {
        return this.outletAllowFood;
    }

    public void setOutletAllowFood(int outletAllowFood) {
        this.outletAllowFood = outletAllowFood;
    }

    public int getOutletScbBill() {
        return this.outletScbBill;
    }

    public void setOutletScbBill(int outletScbBill) {
        this.outletScbBill = outletScbBill;
    }

    public int getOutletScbBillSet() {
        return this.outletScbBillSet;
    }

    public void setOutletScbBillSet(int outletScbBillSet) {
        this.outletScbBillSet = outletScbBillSet;
    }

    public float getOutletLiqVno() {
        return this.outletLiqVno;
    }

    public void setOutletLiqVno(float outletLiqVno) {
        this.outletLiqVno = outletLiqVno;
    }

    public int getOutletTax2SerChg() {
        return this.outletTax2SerChg;
    }

    public void setOutletTax2SerChg(int outletTax2SerChg) {
        this.outletTax2SerChg = outletTax2SerChg;
    }

    public int getOutletOpenKot() {
        return this.outletOpenKot;
    }

    public void setOutletOpenKot(int outletOpenKot) {
        this.outletOpenKot = outletOpenKot;
    }

    public int getOutletIsPromote() {
        return this.outletIsPromote;
    }

    public void setOutletIsPromote(int outletIsPromote) {
        this.outletIsPromote = outletIsPromote;
    }

    public float getOutletLiqPno() {
        return this.outletLiqPno;
    }

    public void setOutletLiqPno(float outletLiqPno) {
        this.outletLiqPno = outletLiqPno;
    }

    public float getOutletLastPur() {
        return this.outletLastPur;
    }

    public void setOutletLastPur(float outletLastPur) {
        this.outletLastPur = outletLastPur;
    }

    public int getOutletCoverCrg() {
        return this.outletCoverCrg;
    }

    public void setOutletCoverCrg(int outletCoverCrg) {
        this.outletCoverCrg = outletCoverCrg;
    }

    public int getOutletIsSave() {
        return this.outletIsSave;
    }

    public void setOutletIsSave(int outletIsSave) {
        this.outletIsSave = outletIsSave;
    }

    public String getOutletCompany() {
        return this.outletCompany;
    }

    public void setOutletCompany(String outletCompany) {
        this.outletCompany = outletCompany;
    }

    public String getOutletFacil() {
        return this.outletFacil;
    }

    public void setOutletFacil(String outletFacil) {
        this.outletFacil = outletFacil;
    }

    public int getOutletCashOnly() {
        return this.outletCashOnly;
    }

    public void setOutletCashOnly(int outletCashOnly) {
        this.outletCashOnly = outletCashOnly;
    }

    public int getOutletEpsonFont() {
        return this.outletEpsonFont;
    }

    public void setOutletEpsonFont(int outletEpsonFont) {
        this.outletEpsonFont = outletEpsonFont;
    }

    public int getOutletIsSerParcel() {
        return this.outletIsSerParcel;
    }

    public void setOutletIsSerParcel(int outletIsSerParcel) {
        this.outletIsSerParcel = outletIsSerParcel;
    }

    public float getOutletTableGrace() {
        return this.outletTableGrace;
    }

    public void setOutletTableGrace(float outletTableGrace) {
        this.outletTableGrace = outletTableGrace;
    }

    public String getOutletTableGraceDisp() {
        return this.outletTableGraceDisp;
    }

    public void setOutletTableGraceDisp(String outletTableGraceDisp) {
        this.outletTableGraceDisp = outletTableGraceDisp;
    }

    public float getOutletTableTimer() {
        return this.outletTableTimer;
    }

    public void setOutletTableTimer(float outletTableTimer) {
        this.outletTableTimer = outletTableTimer;
    }

    public int getOutletIsSerTax() {
        return this.outletIsSerTax;
    }

    public void setOutletIsSerTax(int outletIsSerTax) {
        this.outletIsSerTax = outletIsSerTax;
    }

    public float getOutletSerTax() {
        return this.outletSerTax;
    }

    public void setOutletSerTax(float outletSerTax) {
        this.outletSerTax = outletSerTax;
    }

    public int getOutletSerFoodOnly() {
        return this.outletSerFoodOnly;
    }

    public void setOutletSerFoodOnly(int outletSerFoodOnly) {
        this.outletSerFoodOnly = outletSerFoodOnly;
    }

    public float getOutletSerTaxFoodOnly() {
        return this.outletSerTaxFoodOnly;
    }

    public void setOutletSerTaxFoodOnly(float outletSerTaxFoodOnly) {
        this.outletSerTaxFoodOnly = outletSerTaxFoodOnly;
    }

    public String toString() {
        String str;
        StringBuilder append = new StringBuilder("Outlet [").append(this.outletId != null ? "outletId=" + this.outletId + ", " : XmlPullParser.NO_NAMESPACE).append(this.outletDesc != null ? "outletDesc=" + this.outletDesc + ", " : XmlPullParser.NO_NAMESPACE).append("outletNo=").append(this.outletNo).append(", ");
        if (this.outletOpType != null) {
            str = "outletOpType=" + this.outletOpType + ", ";
        } else {
            str = XmlPullParser.NO_NAMESPACE;
        }
        append = append.append(str);
        if (this.outletTDesc != null) {
            str = "outletTDesc=" + this.outletTDesc + ", ";
        } else {
            str = XmlPullParser.NO_NAMESPACE;
        }
        append = append.append(str).append(this.outletFinYear != null ? "outletFinYear=" + this.outletFinYear + ", " : XmlPullParser.NO_NAMESPACE).append("outletIsLinkFo=").append(this.outletIsLinkFo).append(", ").append(this.outletFoId != null ? "outletFoId=" + this.outletFoId + ", " : XmlPullParser.NO_NAMESPACE).append("outletParcper=").append(this.outletParcper).append(", outletSerper=").append(this.outletSerper).append(", outletRoundOff=").append(this.outletRoundOff).append(", outletLastKot=").append(this.outletLastKot).append(", ").append(this.outletKotPort != null ? "outletKotPort=" + this.outletKotPort + ", " : XmlPullParser.NO_NAMESPACE).append("outletUseMKot=").append(this.outletUseMKot).append(", outletValMKot=").append(this.outletValMKot).append(", outletKotLSkip=").append(this.outletKotLSkip).append(", ").append(this.outletKotStaType != null ? "outletKotStaType=" + this.outletKotStaType + ", " : XmlPullParser.NO_NAMESPACE).append(this.outletKotPStyle != null ? "outletKotPStyle=" + this.outletKotPStyle + ", " : XmlPullParser.NO_NAMESPACE).append("outletLastBill=").append(this.outletLastBill).append(", ").append(this.outletBillPort != null ? "outletBillPort=" + this.outletBillPort + ", " : XmlPullParser.NO_NAMESPACE).append("outletBillSkip=").append(this.outletBillSkip).append(", ").append(this.outletBillStaType != null ? "outletBillStaType=" + this.outletBillStaType + ", " : XmlPullParser.NO_NAMESPACE).append("outletIsBillAutoSet=").append(this.outletIsBillAutoSet).append(", outletIsBPrompt=").append(this.outletIsBPrompt).append(", outletIsBToken=").append(this.outletIsBToken).append(", outletBPrintAfterSave=").append(this.outletBPrintAfterSave).append(", outletLastNc=").append(this.outletLastNc).append(", outletIsRnd=").append(this.outletIsRnd).append(", outletIsPp=").append(this.outletIsPp).append(", ").append(this.outletKotPrinter != null ? "outletKotPrinter=" + this.outletKotPrinter + ", " : XmlPullParser.NO_NAMESPACE).append(this.outletBillPrinter != null ? "outletBillPrinter=" + this.outletBillPrinter + ", " : XmlPullParser.NO_NAMESPACE).append(this.outletFobCode != null ? "outletFobCode=" + this.outletFobCode + ", " : XmlPullParser.NO_NAMESPACE).append("outletVno=").append(this.outletVno).append(", outletDefaultPrint=").append(this.outletDefaultPrint).append(", outletLSkipTear=").append(this.outletLSkipTear).append(", outletLSkipRev=").append(this.outletLSkipRev).append(", outletEpsonCut=").append(this.outletEpsonCut).append(", ").append(this.outletBillMsg1 != null ? "outletBillMsg1=" + this.outletBillMsg1 + ", " : XmlPullParser.NO_NAMESPACE).append(this.outletBillMsg2 != null ? "outletBillMsg2=" + this.outletBillMsg2 + ", " : XmlPullParser.NO_NAMESPACE).append("outletAllowLiq=").append(this.outletAllowLiq).append(", outletAllowFood=").append(this.outletAllowFood).append(", outletScbBill=").append(this.outletScbBill).append(", outletScbBillSet=").append(this.outletScbBillSet).append(", outletLiqVno=").append(this.outletLiqVno).append(", outletTax2SerChg=").append(this.outletTax2SerChg).append(", outletOpenKot=").append(this.outletOpenKot).append(", outletIsPromote=").append(this.outletIsPromote).append(", outletLiqPno=").append(this.outletLiqPno).append(", outletLastPur=").append(this.outletLastPur).append(", outletCoverCrg=").append(this.outletCoverCrg).append(", outletIsSave=").append(this.outletIsSave).append(", ").append(this.outletCompany != null ? "outletCompany=" + this.outletCompany + ", " : XmlPullParser.NO_NAMESPACE);
        if (this.outletFacil != null) {
            str = "outletFacil=" + this.outletFacil + ", ";
        } else {
            str = XmlPullParser.NO_NAMESPACE;
        }
        return append.append(str).append("outletCashOnly=").append(this.outletCashOnly).append(", outletEpsonFont=").append(this.outletEpsonFont).append(", outletIsSerParcel=").append(this.outletIsSerParcel).append(", outletTableGrace=").append(this.outletTableGrace).append(", ").append(this.outletTableGraceDisp != null ? "outletTableGraceDisp=" + this.outletTableGraceDisp + ", " : XmlPullParser.NO_NAMESPACE).append("outletTableTimer=").append(this.outletTableTimer).append(", outletIsSerTax=").append(this.outletIsSerTax).append(", outletSerTax=").append(this.outletSerTax).append(", outletSerFoodOnly=").append(this.outletSerFoodOnly).append(", outletSerTaxFoodOnly=").append(this.outletSerTaxFoodOnly).append("]").toString();
    }
}
