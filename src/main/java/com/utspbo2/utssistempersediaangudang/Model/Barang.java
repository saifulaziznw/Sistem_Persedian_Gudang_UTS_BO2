package com.utspbo2.utssistempersediaangudang.Model;

public class Barang {

    private String kode, nama;
    private Integer jumlahStok;
    private Double harga;

    //Constructor
    public Barang(String kode, String nama, Integer jumlah, Double harga) {
        this.kode = kode;
        this.nama = nama;
        this.jumlahStok = jumlah;
        this.harga = harga;
    }

    //Getter
    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return jumlahStok;
    }

    public double getHarga() {
        return harga;
    }

    //Setter
    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setStok(int stok) {
        this.jumlahStok = stok;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String PrintString() {
        return String.format("| %-8s | %-20s | %-6d | Rp%,.0f", kode, nama, jumlahStok, harga);
    }
}
