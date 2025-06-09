package com.jackbutler.fetch_interview_assessment.service.rules;

import com.jackbutler.fetch_interview_assessment.model.Item;
import com.jackbutler.fetch_interview_assessment.model.Receipt;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EveryTwoItemsRuleTest {

    @Test
    public void fiveItems_returns10Points() {
        Receipt receipt = Receipt.builder()
                .items(List.of(
                        Item.builder().build(),
                        Item.builder().build(),
                        Item.builder().build(),
                        Item.builder().build(),
                        Item.builder().build()
                ))
                .build();

        EveryTwoItemsRule rule = new EveryTwoItemsRule();

        int actual = rule.processReceipt(receipt);

        assertThat(actual).isEqualTo(10);
    }

    @Test
    public void threeItems_returns5Points() {
        Receipt receipt = Receipt.builder()
                .items(List.of(
                        Item.builder().build(),
                        Item.builder().build(),
                        Item.builder().build()
                ))
                .build();

        EveryTwoItemsRule rule = new EveryTwoItemsRule();

        int actual = rule.processReceipt(receipt);

        assertThat(actual).isEqualTo(5);
    }
}