package com.example.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "ELIGIBILITY_DTLS")
@Entity
@Data
public class EligibilityEntity {

	@Id
	@GeneratedValue
	@Column(name = "ELIG_ID")
	private Integer eligId;

	@Column(name = "CASE_NUM")
	private Long caseNum;

	@Column(name = "PLAN_NAME")
	private String planName;

	@Column(name = "PLAN_STATUS")
	private String planStatus;

	@Column(name = "HOLDER_NAME")
	private String holderName;

	@Column(name = "BENEFIT_AMT")
	private Double benefitAmt;

	@Column(name = "DENIEL_RESN")
	private String denielReason;

	@Column(name = "START_DATE")
	private LocalDate startDate;

	@Column(name = "END_DATE")
	private LocalDate endDate;

	@Column(name = "HOLDER_SSN")
	private Long holderSsn;
	
	int i=10;

}
