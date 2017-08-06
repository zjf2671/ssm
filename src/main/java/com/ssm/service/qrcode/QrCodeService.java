package com.ssm.service.qrcode;

import java.awt.image.BufferedImage;

/**
 * @Description: 生成二维码服务接口 
 * @author harry.zhang
 * @CreateDate:	2017年7月10日
 * @version 1.0
 */
public interface QrCodeService {
	
	public BufferedImage genQrCode() throws Exception;

}
