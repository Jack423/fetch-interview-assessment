package com.jackbutler.fetch_interview_assessment.service.rules;

import com.jackbutler.fetch_interview_assessment.model.Receipt;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class DayPurchasedRuleTest {

    @Test
    public void jan1_returnsCorrectPoints() {
        Receipt receipt = Receipt.builder()
                .purchaseDate(LocalDate.of(2022, 1, 1))
                .build();

        DayPurchasedRule dayPurchasedRule = new DayPurchasedRule();

        int actual = dayPurchasedRule.processReceipt(receipt);

        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void jan2_returns0Points() {
        Receipt receipt = Receipt.builder()
                .purchaseDate(LocalDate.of(2022, 1, 2))
                .build();

        DayPurchasedRule dayPurchasedRule = new DayPurchasedRule();

        int actual = dayPurchasedRule.processReceipt(receipt);

        assertThat(actual).isEqualTo(0);
    }
}