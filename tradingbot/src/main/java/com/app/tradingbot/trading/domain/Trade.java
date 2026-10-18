package com.app.tradingbot.trading.domain;

import com.app.tradingbot.coin.domain.Coin;

public class Trade {
    private final Coin coin;

    public Trade(Coin coin) {
        this.coin = coin;
    }

    public Coin getCoin() {
        return coin;
    }
}