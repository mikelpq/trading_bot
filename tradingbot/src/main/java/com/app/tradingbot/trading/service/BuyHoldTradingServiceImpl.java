package com.app.tradingbot.trading.service;

import com.app.tradingbot.shared.PositionTO;
import com.app.tradingbot.trading.domain.TradeSignal;
import org.springframework.stereotype.Component;

@Component("buyHoldTrading")
public class BuyHoldTradingServiceImpl implements PaperTradingService {

    private final Long STOP_LOSS = -5L;
    private final Long TAKE_PROFIT = 10L;

    //TODO: will need rework XD
    @Override
    public TradeSignal eval(PositionTO positionTO) {
        if (positionTO == null || positionTO.getCoin() == null) {
            return TradeSignal.STAND;
        }

        final double currentPosition = positionTO.getCurrentPosition();
        final double accPosition = currentPosition - positionTO.getCoin().getSpotPrice();

        if (accPosition <= STOP_LOSS || accPosition >= TAKE_PROFIT) {
            return TradeSignal.SELL;

        } else if (accPosition > 0 && accPosition < TAKE_PROFIT) {
            return TradeSignal.BUY;
        }

        return TradeSignal.STAND;
    }
}