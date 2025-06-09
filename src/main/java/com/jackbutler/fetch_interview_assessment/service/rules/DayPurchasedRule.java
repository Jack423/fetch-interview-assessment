package com.jackbutler.fetch_interview_assessment.service.rules;

import com.jackbutler.fetch_interview_assessment.model.Receipt;
import com.jackbutler.fetch_interview_assessment.service.PointCalculatorVisitor;

public class DayPurchasedRule implements PointCalculatorVisitor {

    /**
     * Awards 6 points if the day purchased is odd.
     * @param receipt containing order information.
     * @return number of points for the given criteria
     */
    @Override
    public int processReceipt(Receipt receipt) {
        return receipt.getPurchaseDate().getDayOfMonth() % 2 != 0 ? 6 : 0;
    }
}
