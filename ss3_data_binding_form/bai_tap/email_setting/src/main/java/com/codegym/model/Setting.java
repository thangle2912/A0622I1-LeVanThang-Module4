package com.codegym.model;

public class Setting {
    private String language;
    private int pageSize;
    private boolean spamFilter;
    private String signature;

    public Setting() {
    }


    public Setting( String language, int pageSize, boolean spamFilter, String signature) {

        this.language = language;
        this.pageSize = pageSize;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }


    public String getLanguage() {
        return language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
