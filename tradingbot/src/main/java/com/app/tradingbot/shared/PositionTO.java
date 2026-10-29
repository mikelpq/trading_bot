package com.app.tradingbot.shared;

import com.app.tradingbot.coin.domain.Coin;

public class PositionTO {
    private Coin coin;
    private double currentPosition;

    public Coin getCoin() {
        return coin;
    }

    public double getCurrentPosition() {
        return currentPosition;
    }
}
