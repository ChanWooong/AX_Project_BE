package com.knuaf.chickenstock.analysis.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record StockAnalysis(
        String ticker,

        @JsonProperty("stock")
        String name,

        @JsonProperty("analysis_date")
        String analysisDate,

        String signal,
        String label,

        @JsonProperty("total_score")
        double totalScore,

        double confidence,

        @JsonProperty("xgboost_prob")
        double xgboostProb,

        @JsonProperty("xgboost_adj")
        double xgboostAdj,

        @JsonProperty("axis_weights")
        Map<String, Double> axisWeights,

        @JsonProperty("contributions")
        Map<String, Double> contruibutions,

        @JsonProperty("axis_scores")
        Map<String, Double> axisScores,

        @JsonIgnore
        @JsonProperty("insider_trades")
        List<InsiderTrade> insiderTrades
) {
    public record InsiderTrade(
            String date,
            String name,
            String type,
            int shares,
            double value
    ) {}
}