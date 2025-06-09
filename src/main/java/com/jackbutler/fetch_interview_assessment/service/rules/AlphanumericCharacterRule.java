package com.jackbutler.fetch_interview_assessment.service.rules;

import com.jackbutler.fetch_interview_assessment.model.Receipt;
import com.jackbutler.fetch_interview_assessment.service.PointCalculatorVisitor;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class AlphanumericCharacterRule implements PointCalculatorVisitor {

    /**
     * Calculate one point for every alphanumeric character in the retailer name.
     * @param receipt {@link Receipt} containing order information.
     * @return int containing the number of points.
     */
    @Override
    public int processReceipt(Receipt receipt) {
        Pattern pattern = Pattern.compile("[A-Za-z0-9]");
        Matcher matcher = pattern.matcher(receipt.getRetailer());

        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            result.append(matcher.group());
        }

        return result.length();
    }
}
