package com.app.tradingbot.trading.service;


import com.app.tradingbot.shared.PositionTO;
import com.app.tradingbot.trading.domain.Trade;
import com.app.tradingbot.trading.domain.TradeSignal;

public interface PaperTradingService {

    TradeSignal eval(PositionTO positionTO);
}