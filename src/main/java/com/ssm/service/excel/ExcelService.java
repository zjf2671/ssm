package com.ssm.service.excel;

import java.util.List;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.ssm.po.recipe.RecipeCountPO;

public interface ExcelService {
	
	public SXSSFWorkbook exportExcel(List<RecipeCountPO> list) throws Exception;
	
	

}
