package com.example.charmi.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

public class OffStageDataItem implements Parcelable {

    private String day;
    private String dayname;
    private int dayno;
    private String date;
    private String eventname;
    private String eventtime;
    private String place;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDayname() {
        return dayname;
    }

    public void setDayname(String dayname) {
        this.dayname = dayname;
    }

    public int getDayno() {
        return dayno;
    }

    public void setDayno(int dayno) {
        this.dayno = dayno;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getEventtime() {
        return eventtime;
    }

    public void setEventtime(String eventtime) {
        this.eventtime = eventtime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.day);
        dest.writeString(this.dayname);
        dest.writeInt(this.dayno);
        dest.writeString(this.date);
        dest.writeString(this.eventname);
        dest.writeString(this.eventtime);
        dest.writeString(this.place);
    }

    public OffStageDataItem() {
    }

    protected OffStageDataItem(Parcel in) {
        this.day = in.readString();
        this.dayname = in.readString();
        this.dayno = in.readInt();
        this.date = in.readString();
        this.eventname = in.readString();
        this.eventtime = in.readString();
        this.place = in.readString();
    }

    public static final Parcelable.Creator<OffStageDataItem> CREATOR = new Parcelable.Creator<OffStageDataItem>() {
        @Override
        public OffStageDataItem createFromParcel(Parcel source) {
            return new OffStageDataItem(source);
        }

        @Override
        public OffStageDataItem[] newArray(int size) {
            return new OffStageDataItem[size];
        }
    };
}
