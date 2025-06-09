package com.jackbutler.fetch_interview_assessment.service.rules;

import com.jackbutler.fetch_interview_assessment.model.Receipt;
import com.jackbutler.fetch_interview_assessment.service.PointCalculatorVisitor;

public class ItemDescriptionRule implements PointCalculatorVisitor {

    /**
     * Awards points based on the length of the item descriptions
     * @param receipt containing order information.
     * @return number of points for the given criteria
     */
    @Override
    public int processReceipt(Receipt receipt) {
        return receipt.getItems().stream()
                .filter(item -> item.getShortDescription().trim().length() % 3 == 0)
                .map(item -> (int) Math.ceil(item.getPrice() * 0.20))
                .reduce(0, Integer::sum);
    }
}
