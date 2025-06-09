package com.jackbutler.fetch_interview_assessment.service.rules;

import com.jackbutler.fetch_interview_assessment.model.Receipt;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MultipleOfTwentyFiveRuleTest {

    @Test
    public void totalIsNotAMultiple_returnsCorrectPoints() {
        Receipt receipt = Receipt.builder()
                .total(35.35)
                .build();

        MultipleOfTwentyFiveRule rule = new MultipleOfTwentyFiveRule();

        int actual = rule.processReceipt(receipt);

        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void totalIsAMultiple_returnsCorrectPoints() {
        Receipt receipt = Receipt.builder()
                .total(35.25)
                .build();

        MultipleOfTwentyFiveRule rule = new MultipleOfTwentyFiveRule();

        int actual = rule.processReceipt(receipt);

        assertThat(actual).isEqualTo(25);
    }
}