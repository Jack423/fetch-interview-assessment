package com.jackbutler.fetch_interview_assessment.service.rules;

import com.jackbutler.fetch_interview_assessment.model.Receipt;
import com.jackbutler.fetch_interview_assessment.service.PointCalculatorVisitor;

public class TotalRoundDollarRule implements PointCalculatorVisitor {

    /**
     * Awards 50 points if the order total is a whole number.
     * @param receipt containing order information.
     * @return number of points for the given criteria
     */
    @Override
    public int processReceipt(Receipt receipt) {
        return receipt.getTotal() % 1 == 0? 50 : 0;
    }
}
