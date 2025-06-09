package com.jackbutler.fetch_interview_assessment.config.feign;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "feign")
public record FeignConfigurationProperties() {
}
