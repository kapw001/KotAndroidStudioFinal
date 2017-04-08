package com.hm.kot.model;

import org.xmlpull.v1.XmlPullParser;

public class Category {
    private String categoryDesc;
    private String categoryId;
    private int categoryNo;
    private float categoryQtyVal;
    private float categorySalVal;

    public String getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getCategoryNo() {
        return this.categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getCategoryDesc() {
        return this.categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public float getCategorySalVal() {
        return this.categorySalVal;
    }

    public void setCategorySalVal(float categorySalVal) {
        this.categorySalVal = categorySalVal;
    }

    public float getCategoryQtyVal() {
        return this.categoryQtyVal;
    }

    public void setCategoryQtyVal(float categoryQtyVal) {
        this.categoryQtyVal = categoryQtyVal;
    }

    public String toString() {
        String str;
        StringBuilder append = new StringBuilder("Category [").append(this.categoryId != null ? "categoryId=" + this.categoryId + ", " : XmlPullParser.NO_NAMESPACE).append("categoryNo=").append(this.categoryNo).append(", ");
        if (this.categoryDesc != null) {
            str = "categoryDesc=" + this.categoryDesc + ", ";
        } else {
            str = XmlPullParser.NO_NAMESPACE;
        }
        return append.append(str).append("categorySalVal=").append(this.categorySalVal).append(", categoryQtyVal=").append(this.categoryQtyVal).append("]").toString();
    }
}
