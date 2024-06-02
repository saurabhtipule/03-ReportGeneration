package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.EligibilityEntity;

public interface EligdtlsRepository extends JpaRepository<EligibilityEntity, Integer> {

	@Query("select distinct(planName) FROM EligibilityEntity")
	public List<String> getUniquePlanNames();
	
	@Query("select distinct(planStatus) from EligibilityEntity")
	public List<String> getUniquePlanStatuses();
}
