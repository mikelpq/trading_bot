package com.app.tradingbot.config;

import com.app.tradingbot.api.coinbase.CoinbaseClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoinConfig {

    @Bean
    public CoinbaseClient coinbaseClient() {
        return new CoinbaseClient();
    }
}
