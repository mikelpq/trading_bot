package com.app.tradingbot.coin.service;

import com.app.tradingbot.api.coinbase.CoinbaseClient;
import com.app.tradingbot.coin.domain.Coin;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class CoinService {

   private final CoinbaseClient coinbaseClient = new CoinbaseClient();

    public Coin getCoin(String name, String currency) {
       return coinbaseClient.getCoinPrice(name, currency);
    } 

    public List<Coin> getAllCoins() {
      return coinbaseClient.getCoins();
   }
}