package com.example.alex.demoscheduled.configuration;

import com.example.alex.demoscheduled.BalanceScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.time.Instant;
import java.util.Date;
import static java.time.temporal.ChronoUnit.MILLIS;

@Configuration
@EnableScheduling
public class SchedulingConfiguration implements SchedulingConfigurer {

    private final BalanceScheduler balanceScheduler;
    private final BalanceSchedulerConfiguration balanceSchedulerConfiguration;

    @Autowired
    public SchedulingConfiguration(BalanceScheduler balanceScheduler, BalanceSchedulerConfiguration balanceSchedulerConfiguration) {
        this.balanceScheduler = balanceScheduler;
        this.balanceSchedulerConfiguration = balanceSchedulerConfiguration;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        System.out.println("IN");
        taskRegistrar.addTriggerTask(
                balanceScheduler::updateBalance,
                triggerContext -> {
                    Instant nextTriggerTime = Instant.now().plus(balanceSchedulerConfiguration.getUpdateIntervalMs(), MILLIS);
                    return Date.from(nextTriggerTime);
                });
    }
}
