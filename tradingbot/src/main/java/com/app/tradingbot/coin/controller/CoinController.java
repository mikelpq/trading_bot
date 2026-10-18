package com.app.tradingbot.coin.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.tradingbot.coin.domain.Coin;
import com.tradingbot.coin.service.CoinService;

@RestController
@RequestMapping("/tb/coin")
public class CoinController {

   private final CoinService coinService;

   @Autowired
   public CoinController(CoinService coinService) {
      this.coinService = coinService;
   }

   @GetMapping("/getCoin/{coin}/{currency}")
   public Coin getCoin(@PathVariable String coin, @PathVariable String currency) {
      return coinService.getCoin(coin, currency);
   }

   @GetMapping("/getAllCoins")
   public List<Coin> getAllCoins() {
      return coinService.getAllCoins();
   }
}
