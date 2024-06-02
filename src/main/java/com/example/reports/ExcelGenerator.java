package com.example.reports;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.example.response.SearchResponse;

public class ExcelGenerator {

	public void generateExcel(List<SearchResponse> searchResponses, HttpServletResponse resp) throws IOException {

		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet("Plan");

		HSSFRow hssfRow = sheet.createRow(0);

		hssfRow.createCell(0).setCellValue("S.No");
		hssfRow.createCell(1).setCellValue("Holder Name");
		hssfRow.createCell(2).setCellValue("Holder SSN");
		hssfRow.createCell(3).setCellValue("Plan Name");
		hssfRow.createCell(4).setCellValue("Plan Status");
		hssfRow.createCell(5).setCellValue("Start Date");
		hssfRow.createCell(6).setCellValue("End Date");
		hssfRow.createCell(7).setCellValue("Benefit Amount");
		hssfRow.createCell(8).setCellValue("Deniel Reason");

		for (int i = 0; i < searchResponses.size(); i++) {

			HSSFRow dataRow = sheet.createRow(i + 1);
			SearchResponse response = searchResponses.get(i);

			dataRow.createCell(0).setCellValue(i + 1);
			dataRow.createCell(1).setCellValue(response.getHolderName());
			dataRow.createCell(2).setCellValue(response.getHolderSsn());
			dataRow.createCell(3).setCellValue(response.getPlanName());
			dataRow.createCell(4).setCellValue(response.getPlanStatus());
			dataRow.createCell(5).setCellValue(String.valueOf(response.getStartDate()));
			dataRow.createCell(6).setCellValue(String.valueOf(response.getEndDate()));
			dataRow.createCell(7).setCellValue(String.valueOf(response.getBenefitAmt()));
			dataRow.createCell(8).setCellValue(response.getDenielReason());
			
		}
		workbook.write(resp.getOutputStream());
		workbook.close();

	}

}
