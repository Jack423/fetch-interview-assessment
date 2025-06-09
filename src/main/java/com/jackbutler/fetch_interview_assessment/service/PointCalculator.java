package com.jackbutler.fetch_interview_assessment.service;

import com.jackbutler.fetch_interview_assessment.model.Receipt;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PointCalculator implements PointCalculatorProvider {

    private final Receipt receipt;

    @Override
    public int accept(PointCalculatorVisitor visitor) {
        return visitor.processReceipt(receipt);
    }
}
