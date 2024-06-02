package com.example.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchResponse {

	private Long caseNum;

	private String planName;

	private String planStatus;

	private String holderName;

	private Double benefitAmt;

	private String denielReason;

	private LocalDate startDate;

	private LocalDate endDate;

	private Long holderSsn;

}
