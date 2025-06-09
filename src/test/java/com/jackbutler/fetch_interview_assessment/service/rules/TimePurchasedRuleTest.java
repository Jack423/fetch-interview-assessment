package com.jackbutler.fetch_interview_assessment.service.rules;

import com.jackbutler.fetch_interview_assessment.model.Receipt;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class TimePurchasedRuleTest {

    @Test
    public void timePurchasedOutsideBounds_returnsCorrectPoints() {
        Receipt receipt = Receipt.builder()
                .purchaseTime(LocalTime.of(13, 1))
                .build();

        TimePurchasedRule rule = new TimePurchasedRule();

        int actual = rule.processReceipt(receipt);

        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void timePurchasedInsideBounds_returnsCorrectPoints() {
        Receipt receipt = Receipt.builder()
                .purchaseTime(LocalTime.of(15, 1))
                .build();

        TimePurchasedRule rule = new TimePurchasedRule();

        int actual = rule.processReceipt(receipt);

        assertThat(actual).isEqualTo(10);
    }
}