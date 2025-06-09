package com.jackbutler.fetch_interview_assessment.service;

import com.jackbutler.fetch_interview_assessment.model.NotFoundException;
import com.jackbutler.fetch_interview_assessment.model.Receipt;
import com.jackbutler.fetch_interview_assessment.service.rules.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReceiptService {

    private final Map<String, Receipt> receiptMap = new HashMap<>();

    public String saveReceipt(Receipt receipt) {
        String receiptId = UUID.randomUUID().toString();
        receiptMap.put(receiptId, receipt);
        return receiptId;
    }

    public int calculatePoints(String receiptId) {
        if (!receiptMap.containsKey(receiptId)) {
            throw new NotFoundException("Receipt ID not found");
        }

        int points = 0;
        Receipt receipt = receiptMap.get(receiptId);
        PointCalculator pointCalculator = new PointCalculator(receipt);

        points += pointCalculator.accept(new AlphanumericCharacterRule());
        points += pointCalculator.accept(new DayPurchasedRule());
        points += pointCalculator.accept(new EveryTwoItemsRule());
        points += pointCalculator.accept(new ItemDescriptionRule());
        points += pointCalculator.accept(new MultipleOfTwentyFiveRule());
        points += pointCalculator.accept(new TimePurchasedRule());
        points += pointCalculator.accept(new TotalRoundDollarRule());

        return points;
    }
}
