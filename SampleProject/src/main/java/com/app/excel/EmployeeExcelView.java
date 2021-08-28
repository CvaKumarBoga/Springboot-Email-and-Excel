package com.app.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Employee;
@Component
public class EmployeeExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//1.set file name
		response.addHeader("Content-Disposition", "attachment;Employee.xlsx");
		//2.read data from model
		@SuppressWarnings("unchecked")
		List <Employee> list=(List<Employee>)model.get("list");
		//3.create one new sheet
		Sheet sheet = workbook.createSheet("Employee");
		//4.create header
		setHead(sheet);
		//5.create body
		setBody(sheet,list);


	}
	private void setHead(Sheet sheet) {
		// TODO Auto-generated method stub
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("STATUS");
		row.createCell(3).setCellValue("EMAIL");
		row.createCell(4).setCellValue("SALARY");

	}
	private void setBody(Sheet sheet, List<Employee> list) {
		// TODO Auto-generated method stub
		int rowNum=1;
		for(Employee e:list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(e.getId());
			row.createCell(1).setCellValue(e.getName());
			row.createCell(2).setCellValue(e.getStatus());
			row.createCell(3).setCellValue(e.getEmail());
			row.createCell(4).setCellValue(e.getSalary());

		}

	}

}
