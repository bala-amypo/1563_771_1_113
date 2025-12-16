package com.example.Academy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Academy.entity.RepeatOffenderRecord;
@Service
public interface RepeatOffenderRecordService {
    RepeatOffenderRecord refreshRepeatOffernderData(Long studentId);
    RepeatOffenderRecord getRecordByStudent( Long studentId);
    List<PenaltyActionService> getAllRepeatOffenders();
}
