package com.hm.kot.model;

import org.xmlpull.v1.XmlPullParser;

public class Group {
    private String groupDesc;
    private String groupId;
    private int groupNo;
    private String groupRem;
    private float groupSalVal;

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public int getGroupNo() {
        return this.groupNo;
    }

    public void setGroupNo(int groupNo) {
        this.groupNo = groupNo;
    }

    public String getGroupDesc() {
        return this.groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public float getGroupSalVal() {
        return this.groupSalVal;
    }

    public void setGroupSalVal(float groupSalVal) {
        this.groupSalVal = groupSalVal;
    }

    public String getGroupRem() {
        return this.groupRem;
    }

    public void setGroupRem(String groupRem) {
        this.groupRem = groupRem;
    }

    public String toString() {
        return "Group [" + (this.groupId != null ? "groupId=" + this.groupId + ", " : XmlPullParser.NO_NAMESPACE) + "groupNo=" + this.groupNo + ", " + (this.groupDesc != null ? "groupDesc=" + this.groupDesc + ", " : XmlPullParser.NO_NAMESPACE) + "groupSalVal=" + this.groupSalVal + ", " + (this.groupRem != null ? "groupRem=" + this.groupRem : XmlPullParser.NO_NAMESPACE) + "]";
    }
}
