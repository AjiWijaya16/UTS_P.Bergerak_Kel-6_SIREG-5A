package com.example.projectuts;

import android.os.Parcel;
import android.os.Parcelable;

public class List implements Parcelable {
    private String nama;
    private String deskripsi;
    private Integer photo;

    public String getName() {
        return nama;
    }

    public void setName(String nama) {
        this.nama = nama;
    }

    public String getDescription() {
        return deskripsi;
    }

    public void setDescription(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Integer getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.deskripsi);
        dest.writeInt(this.photo);
    }

    public List() {
    }

    private List(Parcel in) {
        this.nama = in.readString();
        this.deskripsi = in.readString();
        this.photo = in.readInt();
    }

    public static final Parcelable.Creator<List> CREATOR = new Parcelable.Creator<List>() {
        @Override
        public List createFromParcel(Parcel source) {
            return new List(source);
        }

        @Override
        public List[] newArray(int size) {
            return new List[size];
        }
    };
}
