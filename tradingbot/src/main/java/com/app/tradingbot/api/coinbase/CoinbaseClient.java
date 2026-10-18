package com.app.tradingbot.api.coinbase;

import org.springframework.web.reactive.function.client.WebClient;

import com.app.tradingbot.coin.domain.Coin;

import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class CoinbaseClient {

    private final String URL = "https://api.coinbase.com/v2";

    public Coin getCoinPrice(String coin, String currency) {
        JSONObject obj = getResponse("/prices/" + coin + "-" + currency + "/buy");
        final String buyPrice = obj.getString("amount");

        obj = getResponse("/prices/" + coin + "-" + currency + "/sell");
        final String sellPrice = obj.getString("amount");

        obj = getResponse("/prices/" + coin + "-" + currency + "/spot");
        final String spotPrice = obj.getString("amount");


        return new Coin("Bitcoin", coin, Double.parseDouble(sellPrice), Double.parseDouble(buyPrice), Double.parseDouble(spotPrice), currency);
    }

    public List<Coin> getCoins() {
        final WebClient webClient = WebClient.create(URL);

        final Mono<String> response = webClient.get()
            .uri("/currencies/crypto")
            .retrieve()
            .bodyToMono(String.class);

        final JSONArray arr = new JSONObject(response.block()).getJSONArray("data");
        final List<Coin> coins = new ArrayList<>();

        for (int i = 0; i < arr.length(); i++) {
            final JSONObject obj = arr.getJSONObject(i);
            final String name = obj.getString("name");
            final String symbol = obj.getString("code");

            coins.add(new Coin(name, symbol));
        }

        return coins;
    }


    private JSONObject getResponse(String uri) {
        final WebClient webClient = WebClient.create(URL);

        final Mono<String> responseBuy = webClient.get()
            .uri(uri)
            .retrieve()
            .bodyToMono(String.class);

        return new JSONObject(responseBuy.block()).getJSONObject("data");
    }


}
