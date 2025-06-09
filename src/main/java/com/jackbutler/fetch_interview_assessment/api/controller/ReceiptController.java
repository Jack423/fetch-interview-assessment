package com.jackbutler.fetch_interview_assessment.api.controller;

import com.jackbutler.fetch_interview_assessment.api.model.PointsResponse;
import com.jackbutler.fetch_interview_assessment.api.model.ProcessReceiptResponse;
import com.jackbutler.fetch_interview_assessment.model.Receipt;
import com.jackbutler.fetch_interview_assessment.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/receipts")
public class ReceiptController {

    private final ReceiptService receiptService;

    @PostMapping("/process")
    public ProcessReceiptResponse processReceipt(@RequestBody Receipt receipt) {
        return ProcessReceiptResponse.builder()
                .id(receiptService.saveReceipt(receipt))
                .build();
    }

    @GetMapping("/{id}/points")
    public PointsResponse calculatePoints(@PathVariable("id") String id) {
        return PointsResponse.builder()
                .points(receiptService.calculatePoints(id))
                .build();
    }
}
