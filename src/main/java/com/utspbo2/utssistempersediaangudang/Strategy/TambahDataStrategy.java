package com.utspbo2.utssistempersediaangudang.Strategy;

import com.utspbo2.utssistempersediaangudang.Model.Barang;
import com.utspbo2.utssistempersediaangudang.Repository.GudangRepository;
import com.utspbo2.utssistempersediaangudang.Helper.InputHelper;
import java.util.ArrayList;

public class TambahDataStrategy implements GudangStrategy {

    private String barangke;
    private InputHelper input = new InputHelper();

    @Override
    public void prosesGudang(GudangRepository repository) {
        ArrayList<Barang> getData = repository.getAll();
        if (!getData.isEmpty()) {
            int size = getData.size() - 1;
            int increment = size + 1;
            barangke = Integer.toString(increment + 1);
        } else {
            barangke = "1";
        }
        String kode = "BRG" + barangke;
        System.out.println("\n\n============================================================");
        System.out.println("=              TAMBAH DATA PERSEDIAAN GUDANG               =");
        System.out.println("============================================================");

        System.out.println("Kode Barang : " + kode);
        String nama = input.readString("Masukkan Nama Barang: ");
        Integer stok = input.readInt("Masukkan Jumlah Stok Barang: ");
        Double harga = input.readDouble("Masukkan Harga Barang: ");

        Barang barangBaru = new Barang(kode, nama, stok, harga);
        repository.tambahData(barangBaru);

        System.out.println("Barang berhasil ditambahkan dengan kode: " + kode + " dengan nama barang: " + nama);
        input.pause();
    }
}
