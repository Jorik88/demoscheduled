package com.example.alex.demoscheduled.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "app.balance")
@Data
@RefreshScope
@Component
public class BalanceSchedulerConfiguration {

    private Long updateIntervalMs;
}
