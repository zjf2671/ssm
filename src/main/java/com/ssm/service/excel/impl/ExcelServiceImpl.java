package com.ssm.service.excel.impl;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Service;

import com.ssm.po.recipe.RecipeCountPO;
import com.ssm.service.excel.ExcelService;

@Service
public class ExcelServiceImpl implements ExcelService{
	public SXSSFWorkbook exportExcel(List<RecipeCountPO> list) throws Exception{
		//
		SXSSFWorkbook  wb = new SXSSFWorkbook (-1);
		
		Sheet sheet = wb.createSheet("recipe_count");
		Font f = wb.createFont();
		f.setColor(HSSFColor.RED.index);
		
		CellStyle style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setFont(f);
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("id");
		cell.setCellStyle(style);
		cell= row.createCell(1);
		cell.setCellValue("食材名称");
		cell.setCellStyle(style);
		cell=row.createCell(2);
		cell.setCellValue("使用此食材的菜谱数量");
		cell.setCellStyle(style);
		cell=row.createCell(3);
		cell.setCellValue("菜谱名称中包含的数量");
		cell.setCellStyle(style);
		
		for(int i=0;i<list.size();i++){
			RecipeCountPO po = list.get(i);
			row = sheet.createRow(i+1);
			row.createCell(0).setCellValue(po.getId());
			row.createCell(1).setCellValue(po.getName());;
			row.createCell(2).setCellValue(po.getRecipecount());
			row.createCell(3).setCellValue(po.getRecipecount());
		}
		
		return wb;
		
	}
}
