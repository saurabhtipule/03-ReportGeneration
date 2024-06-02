package com.example.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.entity.EligibilityEntity;
import com.example.repository.EligdtlsRepository;
import com.example.request.SearchRequest;
import com.example.response.SearchResponse;
import com.example.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private EligdtlsRepository repo;

	@Override
	public List<String> getPlanNames() {

		return repo.getUniquePlanNames();
	}

	@Override
	public List<String> getPlanStatuses() {

		return repo.getUniquePlanStatuses();
	}

	@Override
	public List<SearchResponse> searchPlans(SearchRequest request) {

		List<EligibilityEntity> findAll = null;
		if (request == null) {
			findAll = repo.findAll();

		} else {

			EligibilityEntity entity = new EligibilityEntity();
			String planName = request.getPlanName();
			String planStatus = request.getPlanStatus();
			LocalDate startDate = request.getStartDate();
			LocalDate endDate = request.getEndDate();

			if (planName != null && !planName.equals("")) {
				entity.setPlanName(planName);
			}

			if (planStatus != null && !planStatus.equals("")) {
				entity.setPlanStatus(planStatus);
			}

			if (startDate != null && endDate != null) {
				entity.setStartDate(startDate);
				entity.setEndDate(endDate);
			}

			Example<EligibilityEntity> of = Example.of(entity);

			findAll = repo.findAll(of);

			// User can select planName and click on Search Button
			// user can select planStatus and Click on Search button
			// user can select planName and planStatus and click on Search button

			// user can select startDate and EndDate and click on Search button
			// user can select planName , StartDate ,EndDate and click on Search button
			// user can select planName,planStatus , startDate ,EndDate and click on search
			// button

		}

		List<SearchResponse> list = new ArrayList<SearchResponse>();

		for (EligibilityEntity e : findAll) {
			SearchResponse sr = new SearchResponse();
			BeanUtils.copyProperties(e, sr);
			list.add(sr);
		}

		return list;
	}

}
