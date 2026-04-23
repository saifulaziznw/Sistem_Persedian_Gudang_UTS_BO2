package com.utspbo2.utssistempersediaangudang.Factory;

import com.utspbo2.utssistempersediaangudang.Strategy.CariDataStrategy;
import com.utspbo2.utssistempersediaangudang.Strategy.GudangStrategy;
import com.utspbo2.utssistempersediaangudang.Strategy.HapusDataStrategy;
import com.utspbo2.utssistempersediaangudang.Strategy.KurangiStokStrategy;
import com.utspbo2.utssistempersediaangudang.Strategy.LihatDataGudang;
import com.utspbo2.utssistempersediaangudang.Strategy.TambahDataStrategy;
import com.utspbo2.utssistempersediaangudang.Strategy.UbahDataStrategy;

public class GudangFactory {

    private GudangStrategy gudangStrategy;

    public static GudangStrategy createGudangStrat(String jenis) {
        if (jenis.equalsIgnoreCase("LihatData")) {
            return new LihatDataGudang();
        } else if (jenis.equalsIgnoreCase("TambahData")) {
            return new TambahDataStrategy();
        } else if (jenis.equalsIgnoreCase("KurangiStok")) {
            return new KurangiStokStrategy();
        } else if (jenis.equalsIgnoreCase("HapusBarang")) {
            return new HapusDataStrategy();
        } else if (jenis.equalsIgnoreCase("UbahData")) {
            return new UbahDataStrategy();
        } else if (jenis.equalsIgnoreCase("CariData")) {
            return new CariDataStrategy();
        }
        System.out.println("Jenis Proses " + jenis + " Tidak Tersedia.");
        return null;
    }
}
