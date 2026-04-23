package com.utspbo2.utssistempersediaangudang.Repository;

import java.util.ArrayList;
import com.utspbo2.utssistempersediaangudang.Model.Barang;

public class GudangRepository {

    private static ArrayList<Barang> dataBarang;

    public GudangRepository() {
        dataBarang = new ArrayList<>();
        dataBarang.add(new Barang("BRG1", "Semen Portland", 150, 65000.00));
        dataBarang.add(new Barang("BRG2", "Besi Beton 10mm", 200, 85000.00));
        dataBarang.add(new Barang("BRG3", "Cat Tembok 5kg0", 75, 12000.00));
        dataBarang.add(new Barang("BRG4", "Cat Tembok 5kg1", 75, 12000.00));
        dataBarang.add(new Barang("BRG5", "Cat Tembok 5kg2", 75, 12000.00));
    }

    public void tambahData(Barang barang) {
        dataBarang.add(barang);
    }

    public boolean hapusData(String kode) {
        return dataBarang.removeIf(b -> b.getKode().equalsIgnoreCase(kode));
    }

    public Barang cariByKode(String kode) {
        for (Barang b : dataBarang) {
            if (b.getKode().equalsIgnoreCase(kode)) {
                return b;
            }
        }
        return null;
    }

    public static ArrayList<Barang> cariByNama(String nama) {
        ArrayList<Barang> hasil = new ArrayList<>();
        for (Barang b : dataBarang) {
            if (b.getNama().toLowerCase().contains(nama.toLowerCase())) {
                hasil.add(b);
            }
        }
        return hasil;
    }

    public static ArrayList<Barang> getAll() {
        return new ArrayList<>(dataBarang);
    }

    public boolean isKodeExist(String kode) {
        return cariByKode(kode) != null;
    }
}
