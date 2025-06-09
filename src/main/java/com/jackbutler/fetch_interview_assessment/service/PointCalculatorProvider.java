package com.jackbutler.fetch_interview_assessment.service;

public interface PointCalculatorProvider {
    int accept(PointCalculatorVisitor visitor);
}
