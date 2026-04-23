package com.utspbo2.utssistempersediaangudang.Strategy;

import com.utspbo2.utssistempersediaangudang.Repository.GudangRepository;
import com.utspbo2.utssistempersediaangudang.Helper.InputHelper;
import com.utspbo2.utssistempersediaangudang.Model.Barang;
import java.util.ArrayList;

public class UbahDataStrategy implements GudangStrategy {

    @Override
    public void prosesGudang(GudangRepository repository) {
        InputHelper input = new InputHelper();
        System.out.println("\n\n============================================================");
        System.out.println("=               UBAH DATA PERSEDIAAN GUDANG               =");
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
        String kode = input.readString("\nMasukkan Kode Barang yang ingin diubah: ");
        Barang barang = repository.cariByKode(kode);

        if (barang == null) {
            System.out.println("Kode " + kode + " tidak ditemukan!");
            input.pause();
            return;
        }
        System.out.println("\nKosongkan / tekan Enter untuk skip field yang tidak ingin diubah.");

        String namaBaru = InputHelper.readStringSkipable("Nama Barang", barang.getNama());
        barang.setNama(namaBaru);

        // Stok — skip jika kosong
        System.out.print("Stok (Lama: " + barang.getStok() + ", Tekan Enter untuk skip): ");
        String stokInput = InputHelper.readString("", true);
        if (!stokInput.isEmpty()) {
            try {
                barang.setStok(Integer.parseInt(stokInput));
            } catch (NumberFormatException e) {
                System.out.println("Input stok tidak valid, stok tidak diubah.");
            }
        }

        // Harga — skip jika kosong
        System.out.print("Harga (Lama: " + barang.getHarga() + ", Tekan Enter untuk skip): ");
        String hargaInput = InputHelper.readString("", true);
        if (!hargaInput.isEmpty()) {
            try {
                barang.setHarga(Double.parseDouble(hargaInput));
            } catch (NumberFormatException e) {
                System.out.println("Input harga tidak valid, harga tidak diubah.");
            }
        }

        System.out.println("\nData barang berhasil diubah!");
        System.out.printf("%-10s | %-20s | %-8s | %-15s\n", "Kode", "Nama", "Stok", "Harga");
        System.out.println("----------------------------------------------------------");
        System.out.println(barang.PrintString());
   
        input.pause();
    }
}
