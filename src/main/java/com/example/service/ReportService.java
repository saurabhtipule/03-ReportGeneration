package com.example.service;

import java.util.List;

import com.example.request.SearchRequest;
import com.example.response.SearchResponse;

public interface ReportService {
	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatuses();
	
	public List<SearchResponse> searchPlans(SearchRequest request);

	
	
}
