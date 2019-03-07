package com.example.alex.demoscheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BalanceScheduler {

    @Autowired
    private ConfigurableEnvironment env;

    @Scheduled(fixedDelayString = "${app.balance.updateIntervalMs}")
    public void updateBalance() {
        System.out.println("UPADATED");

        String property = env.getProperty("app.balance.updateIntervalMs");
        System.out.println(property);
    }
}
