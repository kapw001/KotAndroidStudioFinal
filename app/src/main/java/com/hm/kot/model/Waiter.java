package com.hm.kot.model;

import org.xmlpull.v1.XmlPullParser;

public class Waiter {
    private String waiterDoj;
    private String waiterId;
    private String waiterName;
    private float waiterPer;
    private String waiterRem;

    public String getWaiterId() {
        return this.waiterId;
    }

    public void setWaiterId(String waiterId) {
        this.waiterId = waiterId;
    }

    public String getWaiterName() {
        return this.waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public String getWaiterDoj() {
        return this.waiterDoj;
    }

    public void setWaiterDoj(String waiterDoj) {
        this.waiterDoj = waiterDoj;
    }

    public float getWaiterPer() {
        return this.waiterPer;
    }

    public void setWaiterPer(float waiterPer) {
        this.waiterPer = waiterPer;
    }

    public String getWaiterRem() {
        return this.waiterRem;
    }

    public void setWaiterRem(String waiterRem) {
        this.waiterRem = waiterRem;
    }

    public String toString() {
        String str;
        StringBuilder append = new StringBuilder("Waiter [").append(this.waiterId != null ? "waiterId=" + this.waiterId + ", " : XmlPullParser.NO_NAMESPACE).append(this.waiterName != null ? "waiterName=" + this.waiterName + ", " : XmlPullParser.NO_NAMESPACE).append(this.waiterDoj != null ? "waiterDoj=" + this.waiterDoj + ", " : XmlPullParser.NO_NAMESPACE).append("waiterPer=").append(this.waiterPer).append(", ");
        if (this.waiterRem != null) {
            str = "waiterRem=" + this.waiterRem;
        } else {
            str = XmlPullParser.NO_NAMESPACE;
        }
        return append.append(str).append("]").toString();
    }
}
