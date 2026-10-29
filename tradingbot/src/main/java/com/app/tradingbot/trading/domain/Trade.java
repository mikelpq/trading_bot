package com.app.tradingbot.trading.domain;

import com.app.tradingbot.coin.domain.Coin;
import com.app.tradingbot.shared.PositionTO;

public class Trade {
    private final PositionTO position;
    private TradeSignal signal;

    public Trade(PositionTO position) {
        this.position = position;
    }

    public PositionTO getPosition() {
        return position;
    }

    public TradeSignal getSignal() {
        return signal;
    }

    public void setSignal(TradeSignal signal) {
        this.signal = signal;
    }
}