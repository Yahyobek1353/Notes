package com.example.notes;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Note implements Parcelable {
    private String title;
    private String deskription;
    private String data;
    private int img;

    public Note(String title, String deskription, String data, int img) {
        this.title = title;
        this.deskription = deskription;
        this.data = data;
        this.img = img;
    }

    protected Note(Parcel in) {
        title = in.readString();
        deskription = in.readString();
        data = in.readString();
        img = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getDeskription() {
        return deskription;
    }

    public String getData() {
        return data;
    }

    public int getImg() {
        return img;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDeskription(String deskription) {
        this.deskription = deskription;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", deskription='" + deskription + '\'' +
                ", data='" + data + '\'' +
                ", img=" + img +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(deskription);
        parcel.writeString(data);
        parcel.writeInt(img);
    }
}
