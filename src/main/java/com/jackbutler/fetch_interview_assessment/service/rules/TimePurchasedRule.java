package com.jackbutler.fetch_interview_assessment.service.rules;

import com.jackbutler.fetch_interview_assessment.model.Receipt;
import com.jackbutler.fetch_interview_assessment.service.PointCalculatorVisitor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;

@Slf4j
public class TimePurchasedRule implements PointCalculatorVisitor {

    /**
     * Award 10 points if the time purchased is after 2pm and before 4pm.
     *
     * @param receipt containing order information.
     * @return number of points for the given criteria
     */
    @Override
    public int processReceipt(Receipt receipt) {
        if (receipt.getPurchaseTime().isAfter(LocalTime.of(14, 0))
                && receipt.getPurchaseTime().isBefore(LocalTime.of(16, 0))) {
            log.info("Awarding 10 points for Time Purchased rule");
            return 10;
        }

        log.info("Awarding 0 points for Time Purchased rule");

        return 0;
    }
}
