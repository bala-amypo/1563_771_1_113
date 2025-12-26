package com.example.demo.util;

import com.example.demo.entity.IntegrityCase;
import java.util.List;

public class RepeatOffenderCalculator {

    public int calculateTotalCases(List<IntegrityCase> cases) {
        return cases == null ? 0 : cases.size();
    }

    public String calculateSeverity(int totalCases) {
        if (totalCases >= 4) return "HIGH";
        if (totalCases >= 2) return "MEDIUM";
        return "LOW";
    }
}
