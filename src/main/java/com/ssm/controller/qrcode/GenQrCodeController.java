package com.ssm.controller.qrcode;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.common.BaseSpringController;
import com.ssm.service.qrcode.QrCodeService;

/**
 * @Description: 生成二维码
 * @author harry.zhang
 * @CreateDate: 2017年7月10日
 * @version 1.0
 */
@Controller
@RequestMapping("/qrCode")
public class GenQrCodeController extends BaseSpringController {
	
	@Autowired
	private QrCodeService qrCodeService;

	@RequestMapping(value = "/genQrCode")
	public void genQrCode(HttpServletResponse response) {

		try {

			BufferedImage bfImage = qrCodeService.genQrCode();

			// 1.设置响应头控制浏览器浏览器以图片的方式打开
			response.setContentType("image/jpeg");

			// 2.设置响应头控制浏览器不缓存图片数据
			response.setDateHeader("expries", 0);
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");

			ImageIO.write(bfImage, "JPEG", response.getOutputStream());
			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
