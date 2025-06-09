package com.jackbutler.fetch_interview_assessment.service.rules;

import com.jackbutler.fetch_interview_assessment.model.Receipt;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AlphanumericCharacterRuleTest {

    @Test
    public void alphanumericCharacters_returnsCorrectNumberOfLetters() {
        Receipt receipt = Receipt.builder()
                .retailer("Blah blah blah *(^&(*#$% 1234")
                .build();

        AlphanumericCharacterRule alphanumericCharacterRule = new AlphanumericCharacterRule();

        int actual = alphanumericCharacterRule.processReceipt(receipt);

        assertThat(actual).isEqualTo(16);
    }
}