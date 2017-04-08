package com.hm.kot.model;

import org.xmlpull.v1.XmlPullParser;

public class Captain {
    private String captainDoj;
    private String captainId;
    private String captainName;
    private float captainPer;
    private String captainRem;

    public String getCaptainId() {
        return this.captainId;
    }

    public void setCaptainId(String captainId) {
        this.captainId = captainId;
    }

    public String getCaptainName() {
        return this.captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public String getCaptainDoj() {
        return this.captainDoj;
    }

    public void setCaptainDoj(String captainDoj) {
        this.captainDoj = captainDoj;
    }

    public float getCaptainPer() {
        return this.captainPer;
    }

    public void setCaptainPer(float captainPer) {
        this.captainPer = captainPer;
    }

    public String getCaptainRem() {
        return this.captainRem;
    }

    public void setCaptainRem(String captainRem) {
        this.captainRem = captainRem;
    }

    public String toString() {
        String str;
        StringBuilder append = new StringBuilder("Captain [").append(this.captainId != null ? "captainId=" + this.captainId + ", " : XmlPullParser.NO_NAMESPACE);
        if (this.captainName != null) {
            str = "captainName=" + this.captainName + ", ";
        } else {
            str = XmlPullParser.NO_NAMESPACE;
        }
        append = append.append(str).append(this.captainDoj != null ? "captainDoj=" + this.captainDoj + ", " : XmlPullParser.NO_NAMESPACE).append("captainPer=").append(this.captainPer).append(", ");
        if (this.captainRem != null) {
            str = "captainRem=" + this.captainRem;
        } else {
            str = XmlPullParser.NO_NAMESPACE;
        }
        return append.append(str).append("]").toString();
    }
}
