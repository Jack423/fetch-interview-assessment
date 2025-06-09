package com.jackbutler.fetch_interview_assessment.service.rules;

import com.jackbutler.fetch_interview_assessment.model.Receipt;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TotalRoundDollarRuleTest {

    @Test
    public void totalNoCents_returnsCorrectPoints() {
        Receipt receipt = Receipt.builder()
                .total(35.35)
                .build();

        TotalRoundDollarRule rule = new TotalRoundDollarRule();

        int actual = rule.processReceipt(receipt);

        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void totalWithCents_returnsCorrectPoints() {
        Receipt receipt = Receipt.builder()
                .total(35.00)
                .build();

        TotalRoundDollarRule rule = new TotalRoundDollarRule();

        int actual = rule.processReceipt(receipt);

        assertThat(actual).isEqualTo(50);
    }
}