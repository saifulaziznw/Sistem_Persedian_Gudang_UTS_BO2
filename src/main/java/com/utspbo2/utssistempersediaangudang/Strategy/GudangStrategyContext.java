package com.utspbo2.utssistempersediaangudang.Strategy;

import com.utspbo2.utssistempersediaangudang.Strategy.GudangStrategy;
import com.utspbo2.utssistempersediaangudang.Repository.GudangRepository;
public class GudangStrategyContext {

    private GudangStrategy strat;
    public void setStrat(GudangStrategy strats) {
        this.strat = strats;
    }

    public void prosesStrategy(GudangRepository repository) {
        strat.prosesGudang(repository);
    }
}
