package com.utspbo2.utssistempersediaangudang.Strategy;

import com.utspbo2.utssistempersediaangudang.Model.Barang;
import com.utspbo2.utssistempersediaangudang.Repository.GudangRepository;
import com.utspbo2.utssistempersediaangudang.Helper.InputHelper;
import java.util.ArrayList;

public class LihatDataGudang implements GudangStrategy {

    //Proses ambil data dari GudangRepository dan Print datanya.
    @Override
    public void prosesGudang(GudangRepository repository) {
        ArrayList<Barang> semua = repository.getAll();

        if (semua.isEmpty()) {
            System.out.println("\n\nDaftar Barang di Gudang:");
            System.out.println("DATA GUDANG KOSONG!");
        } else {
            System.out.println("\n\nDaftar Barang di Gudang:");
            System.out.printf("%-10s | %-20s | %-8s | %-15s\n",
                    "Kode", "Nama", "Stok", "Harga");
            System.out.println("----------------------------------------------------------");
            for (Barang barang : semua) {
                System.out.println(barang.PrintString());
            }
            InputHelper.pause();
        }
    }
}
