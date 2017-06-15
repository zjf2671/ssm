package com.ssm.controller.excel;

import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.common.BaseSpringController;
import com.ssm.po.recipe.RecipeCountPO;
import com.ssm.service.excel.ExcelService;
import com.ssm.service.recipe.RecipeCountService;

@Controller
@RequestMapping("/excel")
public class ExcelController extends BaseSpringController {
	
	@Autowired
	private ExcelService excelService;
	
	@Autowired
	private RecipeCountService recipeCountService;
	
	@RequestMapping("/exportExcel")
	public void exportExcel(HttpServletResponse response) {
		
		try {
			List<RecipeCountPO> list = recipeCountService.findList();
			SXSSFWorkbook wb = excelService.exportExcel(list);
			OutputStream out = response.getOutputStream();
			response.reset();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			String fileName = dtf.format(LocalDateTime.now());
			response.setHeader("Content-disposition", "attachement; filename=" + fileName + ".xlsx");
			response.setContentType("application/msexcel");
			wb.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			//throw new BusinessException("导出出错");
			
		}
		
	}
	

}
