package com.app.tradingbot.coin.domain;

import com.tradingbot.shared.OidAndVersion;

public class Coin extends OidAndVersion{
   private String name;
   private String symbol;
   private double sellPrice;
   private double buyPrice;
   private double spotPrice;
   private String currency;

   public Coin(String name, String symbol, double sellPrice, double buyPrice, double spotPrice, String currency) {
    this.name = name;
    this.symbol = symbol;
    this.sellPrice = sellPrice;
    this.buyPrice = buyPrice;
    this.spotPrice = spotPrice;
    this.currency = currency;
   }

   public Coin(String name, String symbol) {
    this.name = name;
    this.symbol = symbol;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   public String getSymbol() {
       return symbol;
   }

   public void setSymbol(String symbol) {
       this.symbol = symbol;
   }

   public double getSellPrice() {
    return sellPrice;
   }

   public void setSellPrice(double sellPrice) {
    this.sellPrice = sellPrice;
   }

   public double getBuyPrice() {
    return buyPrice;
   }

   public void setBuyPrice(double buyPrice) {
    this.buyPrice = buyPrice;
   }

   public double getSpotPrice() {
    return spotPrice;
   }

   public void setSpotPrice(double spotPrice) {
    this.spotPrice = spotPrice;
   }

   public String getCurrency() {
       return currency;
   }

   public void setCurrency(String currency) {
       this.currency = currency;
   }
}
