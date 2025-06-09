package com.jackbutler.fetch_interview_assessment.service.rules;

import com.jackbutler.fetch_interview_assessment.model.Receipt;
import com.jackbutler.fetch_interview_assessment.service.PointCalculatorVisitor;

public class EveryTwoItemsRule implements PointCalculatorVisitor {

    /**
     * Awards 5 points for every 2 items on the receipt.
     * @param receipt containing order information.
     * @return number of points for the given criteria
     */
    @Override
    public int processReceipt(Receipt receipt) {
        return (int) Math.floor((double) receipt.getItems().size() / 2) * 5;
    }
}
