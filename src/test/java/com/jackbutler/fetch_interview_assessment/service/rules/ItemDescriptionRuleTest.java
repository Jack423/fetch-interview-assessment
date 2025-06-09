package com.jackbutler.fetch_interview_assessment.service.rules;

import com.jackbutler.fetch_interview_assessment.model.Item;
import com.jackbutler.fetch_interview_assessment.model.Receipt;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescriptionRuleTest {
    @Test
    public void itemDescription_calculatesPointsCorrectly() {
        Receipt receipt = Receipt.builder()
                .items(List.of(
                        Item.builder()
                                .shortDescription("Mountain Dew 12PK")
                                .price(6.49)
                                .build(),
                        Item.builder()
                                .shortDescription("Emils Cheese Pizza")
                                .price(12.00)
                                .build(),
                        Item.builder()
                                .shortDescription("Knorr Creamy Chicken")
                                .price(1.99)
                                .build(),
                        Item.builder()
                                .shortDescription("Doritos Nacho Cheese")
                                .price(3.35)
                                .build(),
                        Item.builder()
                                .shortDescription("   Klarbrunn 12-PK 12 FL OZ  ")
                                .price(12.00)
                                .build()
                ))
                .build();

        ItemDescriptionRule rule = new ItemDescriptionRule();

        int actual = rule.processReceipt(receipt);

        assertThat(actual).isEqualTo(6);
    }
}