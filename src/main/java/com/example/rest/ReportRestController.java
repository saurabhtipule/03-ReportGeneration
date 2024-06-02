package com.example.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.reports.ExcelGenerator;
import com.example.reports.PdfGenerator;
import com.example.request.SearchRequest;
import com.example.response.SearchResponse;
import com.example.service.ReportService;

@RestController
public class ReportRestController {

	@Autowired
	private ReportService service;

	@GetMapping(value = "/plan-names")
	public List<String> getPlanNames() {
		return service.getPlanNames();
	}

	@GetMapping(value = "/plan-statuses")
	public List<String> getPlanStatuses() {
		return service.getPlanStatuses();
	}

	@PostMapping(value = "/search")
	public List<SearchResponse> search(@RequestBody SearchRequest request) {
		return service.searchPlans(request);
	}

	@GetMapping(value = "/excel")
	public void generateExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Plans.xls";
		response.setHeader(headerKey, headerValue);

		List<SearchResponse> searchResponses = service.searchPlans(null);
		ExcelGenerator excelGenerator = new ExcelGenerator();

		excelGenerator.generateExcel(searchResponses, response);
	}

	@GetMapping(value = "/pdf")
	public void generatePdf( HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Plans.pdf";
		response.setHeader(headerKey, headerValue);

		List<SearchResponse> searchResponses = service.searchPlans(null);

		PdfGenerator pdfGenerator = new PdfGenerator();
		pdfGenerator.generatePdf(searchResponses, response);

	}

}
