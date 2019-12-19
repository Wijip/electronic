package com.example.electronic;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class electronic {
    public String nama_elec;
    public int harga_elec;
    public String gambar_elec;
    public int dummy;

    public int getDummy() {

        dummy = 0;

        return dummy;
    }

    public electronic(){

    }

    public electronic(String nama_elec, int harga_elec, String gambar_elec) {
        this.nama_elec = nama_elec;
        this.harga_elec = harga_elec;
        this.gambar_elec = gambar_elec;
    }

    public String getnama_elec() {
        return nama_elec;
    }

    public void setNama_elec(String nama_makanan) {
        this.nama_elec = nama_elec;
    }

    public int getharga_elec() {
        return harga_elec;
    }

    public void setharga_elec(int harga_makanan) {
        this.harga_elec= harga_elec;
    }

    public String getgambar_elec() {
        return gambar_elec;
    }

    public void setgambar_elec(String gambar_elec) {
        this.gambar_elec = gambar_elec;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("nama_elec", nama_elec);
        result.put("gambar_elec", gambar_elec);
        result.put("harga_elec", harga_elec);
        return result;
    }

}
