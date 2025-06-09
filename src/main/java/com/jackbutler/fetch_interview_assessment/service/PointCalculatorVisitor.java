package com.jackbutler.fetch_interview_assessment.service;

import com.jackbutler.fetch_interview_assessment.model.Receipt;

public interface PointCalculatorVisitor {
    int processReceipt(Receipt receipt);
}
