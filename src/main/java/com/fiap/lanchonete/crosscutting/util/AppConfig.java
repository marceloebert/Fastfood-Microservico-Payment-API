package com.fiap.lanchonete.crosscutting.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Value("${production.api.get-url}")
    private String getProductionApiUrl;

    @Value("${production.api.change-url}")
    private String getChangeProductionApiUrl;


    public String getProductionApiUrl() {
        return getProductionApiUrl;
    }

    public String getChangeProductionApiUrl() {
        return getChangeProductionApiUrl;
    }
}
