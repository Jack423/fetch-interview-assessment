package com.jackbutler.fetch_interview_assessment.service.rules;

import com.jackbutler.fetch_interview_assessment.model.Receipt;
import com.jackbutler.fetch_interview_assessment.service.PointCalculatorVisitor;

public class MultipleOfTwentyFiveRule implements PointCalculatorVisitor {

    /**
     * Awards 25 points if the order total is a multiple of 0.25.
     * @param receipt containing order information.
     * @return number of points for the given criteria
     */
    @Override
    public int processReceipt(Receipt receipt) {
        return receipt.getTotal() % 0.25 == 0 ? 25 : 0;
    }
}
