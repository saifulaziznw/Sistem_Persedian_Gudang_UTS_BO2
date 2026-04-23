package com.utspbo2.utssistempersediaangudang.Menu;

import java.util.Scanner;
import com.utspbo2.utssistempersediaangudang.Helper.InputHelper;
import com.utspbo2.utssistempersediaangudang.Strategy.GudangStrategy;
import com.utspbo2.utssistempersediaangudang.Factory.GudangFactory;
import com.utspbo2.utssistempersediaangudang.Repository.GudangRepository;
import com.utspbo2.utssistempersediaangudang.Strategy.GudangStrategyContext;

public class MenuAplikasi {

    private static Scanner input = new Scanner(System.in);

    public void mainMenu() {
        int pilih;
        GudangRepository penyimpananData = new GudangRepository();
        GudangStrategyContext context = new GudangStrategyContext();
        GudangStrategy strat;
        do {
            System.out.println("\n===== Menu Admin =====");
            System.out.println("1. Lihat Daftar Persedian Gudang");
            System.out.println("2. Tambah Data Persediaan Gudang");
            System.out.println("3. Kurangi Data Stok Persediaan Gudang");
            System.out.println("4. Hapus Data Persediaan Gudang");
            System.out.println("5. Ubah Data Persediaan Gudang");
            System.out.println("6. Cari Data Barang Persediaan Gudang");
            System.out.println("0. Keluar Aplikasi");

            pilih = InputHelper.readInt("Masukkan Pilihan Menu: ");

            switch (pilih) {
                case 1:
                    strat = GudangFactory.createGudangStrat("LihatData");
                    context.setStrat(strat);
                    context.prosesStrategy(penyimpananData);
                    break;
                case 2:
                    strat = GudangFactory.createGudangStrat("TambahData");
                    context.setStrat(strat);
                    context.prosesStrategy(penyimpananData);
                    break;
                case 3:
                    strat = GudangFactory.createGudangStrat("KurangiStok");
                    context.setStrat(strat);
                    context.prosesStrategy(penyimpananData);
                    break;
                case 4:
                    strat = GudangFactory.createGudangStrat("HapusBarang");
                    context.setStrat(strat);
                    context.prosesStrategy(penyimpananData);
                    break;
                case 5:
                    strat = GudangFactory.createGudangStrat("UbahData");
                    context.setStrat(strat);
                    context.prosesStrategy(penyimpananData);
                    break;
                case 6:
                    strat = GudangFactory.createGudangStrat("CariData");
                    context.setStrat(strat);
                    context.prosesStrategy(penyimpananData);
                    break;
                case 0: {
                    System.out.println("Keluar Dari Aplikasi");
                    InputHelper.pause();
                    return;
                }
                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilih != 0);
    }
}
