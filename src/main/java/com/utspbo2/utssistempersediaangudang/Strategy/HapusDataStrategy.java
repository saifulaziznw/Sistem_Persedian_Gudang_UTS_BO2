package com.utspbo2.utssistempersediaangudang.Strategy;

import com.utspbo2.utssistempersediaangudang.Repository.GudangRepository;
import com.utspbo2.utssistempersediaangudang.Helper.InputHelper;
import com.utspbo2.utssistempersediaangudang.Model.Barang;
import java.util.ArrayList;

public class HapusDataStrategy implements GudangStrategy {

    @Override
    public void prosesGudang(GudangRepository repository) {
        InputHelper input = new InputHelper();
        System.out.println("\n\n============================================================");
        System.out.println("=              HAPUS DATA PERSEDIAAN GUDANG                =");
        System.out.println("============================================================");
        String nama = input.readString("Masukkan Nama Barang: ");
        ArrayList<Barang> hasil = repository.cariByNama(nama);

        if (hasil.isEmpty()) {
            System.out.println("Barang dengan nama " + nama + " tidak ditemukan!");
            input.pause();
            return;
        }

        // Tampilkan semua hasil yang cocok
        System.out.println(
                "\nBarang ditemukan:");
        System.out.printf(
                "%-10s | %-20s | %-8s | %-15s\n", "Kode", "Nama", "Stok", "Harga");
        System.out.println(
                "----------------------------------------------------------");
        for (Barang b : hasil) {
            System.out.println(b.PrintString());
        }

        //Pilih dengan kode
        String kode = input.readString("\nMasukkan Kode Barang yang ingin dikurangi: ");
        Barang barang = repository.cariByKode(kode);

        if (barang == null) {
            System.out.println("Kode " + kode + " tidak ditemukan!");
            return;
        }

        repository.hapusData(kode);
        System.out.println("Barang berhasil dengan kode" + kode + " dihapus dari repository.");

        input.pause();
    }

}
