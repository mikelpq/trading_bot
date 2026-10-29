package com.app.tradingbot.trading.controller;

import com.app.tradingbot.coin.domain.Coin;
import com.app.tradingbot.shared.PositionTO;
import com.app.tradingbot.trading.domain.Trade;
import com.app.tradingbot.trading.domain.TradeSignal;
import com.app.tradingbot.trading.service.PaperTradingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaperTradingController {

    private final PaperTradingService paperTradingService;

    @Autowired
    public PaperTradingController(PaperTradingService paperTradingService) {
        this.paperTradingService = paperTradingService;
    }

    @GetMapping
    public TradeSignal eval(PositionTO positionTO) {
        return paperTradingService.eval(positionTO);
    }
}