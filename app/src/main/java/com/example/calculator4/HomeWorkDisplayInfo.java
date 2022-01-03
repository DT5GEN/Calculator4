package com.example.calculator4;

import android.os.Parcel;
import android.os.Parcelable;

public class HomeWorkDisplayInfo implements Parcelable {

    public String displayInfo;
    public String otherInfo;

    public HomeWorkDisplayInfo(String displayInfo, String otherInfo){
        this.displayInfo = displayInfo;
        this.otherInfo = otherInfo;
    }


    protected HomeWorkDisplayInfo(Parcel in) {
        displayInfo = in.readString();
        otherInfo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.displayInfo);
        dest.writeString(this.otherInfo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator CREATOR = new Creator() {
        @Override
        public HomeWorkDisplayInfo createFromParcel(Parcel in) {
            return new HomeWorkDisplayInfo(in);
        }

        @Override
        public HomeWorkDisplayInfo[] newArray(int size) {
            return new HomeWorkDisplayInfo[size];
        }
    };
    public String getDisplayInfo() { return displayInfo;}

    public void setDisplayInfo(String displayInfo) {this.displayInfo = displayInfo;}

    public String getOtherInfo() { return otherInfo;}

    public void setOtherInfo(String otherInfo) {this.otherInfo = otherInfo;}
}