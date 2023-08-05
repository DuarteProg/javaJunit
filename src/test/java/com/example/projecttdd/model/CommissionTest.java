package com.example.projecttdd.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootTest
public class CommissionTest {

    @TestConfiguration
    static class ComissionConfiguration {

        @Bean
        Commission commission() {
            return new Commission();
        }
    }

    @Autowired
    Commission commission;

    @Test
    public void should_calculate_100_dollars_to_sales_of_1000_with_10_per_cent() {
        Double salesValue = 1000.00;
        Double commissionValue = 100.00;

        Double valueCalculated = commission.calculate(salesValue);

        Assertions.assertEquals(commissionValue, valueCalculated);
    }

    @Test
    public void should_calculate_300_dollars_to_sales_of_2000_with_15_per_cent() {
        Double salesValue = 2000.00;
        Double commissionValue = 300.00;

        Double valueCalculated = commission.calculate(salesValue);

        Assertions.assertEquals(commissionValue, valueCalculated);
    }
}
