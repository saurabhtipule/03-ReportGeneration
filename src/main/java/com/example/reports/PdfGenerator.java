package com.example.reports;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.response.SearchResponse;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfGenerator {

	public void generatePdf(List<SearchResponse> searchResponses, HttpServletResponse response) throws Exception {

		Document document = new Document();

		PdfWriter pdfWriter = PdfWriter.getInstance(document, response.getOutputStream());

		document.open();

		Font font = new Font(Font.HELVETICA, 14, Font.BOLDITALIC, Color.black);

		Paragraph para = new Paragraph("Eligibility Details", font);

		document.add(para);

		PdfPTable table = new PdfPTable(9);

		table.addCell("SR.No");
		table.addCell("Holder Name");
		table.addCell("Holder SSN");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Start Date");
		table.addCell("End Date");
		table.addCell("Benefit Amount");
		table.addCell("Denial Reason");

		int srno = 1;

		for (SearchResponse searchResponse : searchResponses) {

			table.addCell(String.valueOf(srno));
			table.addCell(searchResponse.getHolderName());
			table.addCell(String.valueOf(searchResponse.getHolderSsn()));
			table.addCell(searchResponse.getPlanName());
			table.addCell(searchResponse.getPlanStatus());
			table.addCell(String.valueOf(searchResponse.getStartDate()));
			table.addCell(String.valueOf(searchResponse.getEndDate()));
			table.addCell(String.valueOf(searchResponse.getBenefitAmt()));
			table.addCell(searchResponse.getDenielReason());
			srno++;
		}

		document.add(table);

		document.close();
		pdfWriter.close();
	}

}
