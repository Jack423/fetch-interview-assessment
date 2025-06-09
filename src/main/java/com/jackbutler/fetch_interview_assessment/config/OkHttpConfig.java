package com.jackbutler.fetch_interview_assessment.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;

public class OkHttpConfig {

    @Bean
    public OkHttpClient httpClient() {
        return new OkHttpClient.Builder().build();
    }
}
