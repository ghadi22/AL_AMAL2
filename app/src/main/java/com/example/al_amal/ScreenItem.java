package com.example.al_amal;

public class ScreenItem {
    String desc;
    int ScreenImg;

    public ScreenItem(String desc, int screenImg) {
        this.desc = desc;
        ScreenImg = screenImg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getScreenImg() {
        return ScreenImg;
    }

    public void setScreenImg(int screenImg) {
        ScreenImg = screenImg;
    }
}
