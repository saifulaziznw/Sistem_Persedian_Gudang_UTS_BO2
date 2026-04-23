package com.utspbo2.utssistempersediaangudang.Strategy;

import com.utspbo2.utssistempersediaangudang.Model.Barang;
import com.utspbo2.utssistempersediaangudang.Repository.GudangRepository;
import com.utspbo2.utssistempersediaangudang.Helper.InputHelper;
import java.util.ArrayList;

public class KurangiStokStrategy implements GudangStrategy {

    private InputHelper input = new InputHelper();

    @Override
    public void prosesGudang(GudangRepository repository) {
        System.out.println("\n\n============================================================");
        System.out.println("=             KURANGI STOK BARANG GUDANG                   =");
        System.out.println("============================================================");

        String nama = input.readString("Masukkan Nama Barang: ");
        ArrayList<Barang> hasil = repository.cariByNama(nama);

        if (hasil.isEmpty()) {
            System.out.println("Barang dengan nama " + nama + " tidak ditemukan!");
            input.pause();
            return;
        }

        // Tampilkan semua hasil yang cocok
        System.out.println("\nBarang ditemukan:");
        System.out.printf("%-10s | %-20s | %-8s | %-15s\n", "Kode", "Nama", "Stok", "Harga");
        System.out.println("----------------------------------------------------------");
        for (Barang b : hasil) {
            System.out.println(b.PrintString());
        }

        //Pilih dengan kode
        String kode = input.readString("\nMasukkan Kode Barang yang ingin dikurangi: ");
        Barang barang = repository.cariByKode(kode);

        if (barang == null) {
            System.out.println("Kode " + kode + " tidak ditemukan!");
            input.pause();
            return;
        }

        //Input jumlah kurang
        Integer jumlah = input.readInt("Masukkan Jumlah Stok yang diambil: ");

        if (jumlah > barang.getStok()) {
            System.out.println("Gagal! Stok tidak mencukupi. Stok tersedia: " + barang.getStok());
            input.pause();
            return;
        }

        barang.setStok(barang.getStok() - jumlah);
        System.out.println("Stok berhasil dikurangi. Sisa stok: " + barang.getStok());
        
        input.pause();
    }
}
