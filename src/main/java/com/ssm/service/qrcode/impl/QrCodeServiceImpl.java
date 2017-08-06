package com.ssm.service.qrcode.impl;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.ssm.common.util.NumericUtils;
import com.ssm.common.util.PropertiesLoader;
import com.ssm.service.qrcode.QrCodeService;

/**
 * @Description: 生成二维码服务类
 * @author harry.zhang
 * @CreateDate: 2017年7月10日
 * @version 1.0
 */
@Service
public class QrCodeServiceImpl implements QrCodeService {

	@Override
	public BufferedImage genQrCode() throws Exception {
		PropertiesLoader propertiesLoader = new PropertiesLoader("qr_code_config.properties");

		String appUrl = propertiesLoader.getProperty("qrCode.url");
		int qrWidth = Integer.parseInt(propertiesLoader.getProperty("qrCode.width"));
		int qrHeight = Integer.parseInt(propertiesLoader.getProperty("qrCode.height"));

		String invitecode = genRandomCode(8, new HashSet<String>());
		BufferedImage bfImage = genTwoDimcode(appUrl + "?invitecode=" + invitecode, qrWidth, qrHeight, "");
		return bfImage;

	}

	private static MultiFormatWriter mutiWriter = new MultiFormatWriter();

	/**
	 * 生成二维码
	 * 
	 * @param content
	 *            二维码内容
	 * @param width
	 *            二维码宽度
	 * @param height
	 *            二维码高度
	 * @param centerImagePath
	 *            中间图片
	 * @return BufferedImage
	 * @throws WriterException
	 * @throws IOException
	 */
	private static BufferedImage genTwoDimcode(String content, int width, int height, String centerImagePath)
			throws WriterException, IOException {
		// 读取源图像
		BufferedImage scaleImage = scale(centerImagePath, width / 4, height / 4, true);
		int[][] centerPixels = new int[width / 4][height / 4];
		for (int i = 0; i < scaleImage.getWidth(); i++) {
			for (int j = 0; j < scaleImage.getHeight(); j++) {
				centerPixels[i][j] = scaleImage.getRGB(i, j);
			}
		}

		Map<EncodeHintType, Object> hint = new HashMap<EncodeHintType, Object>();
		hint.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hint.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.Q);
		hint.put(EncodeHintType.MARGIN, 0);

		// 生成二维码
		BitMatrix matrix = mutiWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hint);
		// 二维矩阵转为一维像素数组
		// int halfW = matrix.getWidth() / 2;
		// int halfH = matrix.getHeight() / 2;
		int[] pixels = new int[width * height];

		for (int y = 0; y < matrix.getHeight(); y++) {
			for (int x = 0; x < matrix.getWidth(); x++) {
				// 此处可以修改二维码的颜色，可以分别制定二维码和背景的颜色；
				// 0x0000ff00 绿色 0x00ff0000 红色 0xff000000 黑色 0xfffffff 白色 0xffea9999 粉红色
				pixels[y * width + x] = matrix.get(x, y) ? 0xffea9999 : 0xfffffff;
			}
		}

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		image.getRaster().setDataElements(0, 0, width, height, pixels);

		return image;
	}

	/**
	 * 把传入的原始图像按高度和宽度进行缩放，生成符合要求的图标
	 * 
	 * @param centerImageFile
	 *            源文件地址
	 * @param height
	 *            目标高度
	 * @param width
	 *            目标宽度
	 * @param hasFiller
	 *            比例不对时是否需要补白：true为补白; false为不补白;
	 * @throws IOException
	 */
	private static BufferedImage scale(String centerImageFile, int height, int width, boolean hasFiller)
			throws IOException {
		double ratio = 0.0; // 缩放比例
		File file = new File(centerImageFile);
		BufferedImage centerImage;
		if (file.exists()) {
			centerImage = ImageIO.read(file);
		} else {
			centerImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		}
		Image destImage = centerImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		// 计算比例
		if ((centerImage.getHeight() > height) || (centerImage.getWidth() > width)) {
			if (centerImage.getHeight() > centerImage.getWidth()) {
				ratio = (new Integer(height)).doubleValue() / centerImage.getHeight();
			} else {
				ratio = (new Integer(width)).doubleValue() / centerImage.getWidth();
			}
			AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
			destImage = op.filter(centerImage, null);
		}
		if (hasFiller) {// 补白
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D graphic = image.createGraphics();
			graphic.setColor(Color.white);
			graphic.fillRect(0, 0, width, height);
			if (width == destImage.getWidth(null))
				graphic.drawImage(destImage, 0, (height - destImage.getHeight(null)) / 2, destImage.getWidth(null),
						destImage.getHeight(null), Color.white, null);
			else
				graphic.drawImage(destImage, (width - destImage.getWidth(null)) / 2, 0, destImage.getWidth(null),
						destImage.getHeight(null), Color.white, null);
			graphic.dispose();
			destImage = image;
		}
		return (BufferedImage) destImage;
	}

	// 随机种子, 默认以当前时间为种子
	private static long seed_orignal = System.currentTimeMillis();

	/**
	 * 
	 * @Title: GenRandomCode @Description: 生成单个不重复随机字符串 @param character_len
	 *         生成字符串 的总长度 @return @throws
	 */
	private static String genRandomCode(int character_len, HashSet<String> code_set) {

		int count = 0; // 生成的字符串的长度
		int code_pos = 0; // 单次生成的随机串位置
		StringBuffer random_code_buf = new StringBuffer(4);

		// 传入一个seed参数即可保证生成的随机数不同
		Random r = new Random(seed_orignal++);
		while (count < character_len) {

			// 取绝对值，防止生成负数
			code_pos = Math.abs(r.nextInt(NumericUtils.max_num));

			if (code_pos >= 0 && code_pos < NumericUtils.digits_32.length) {
				random_code_buf.append(NumericUtils.digits_32[code_pos]);
				++count;
			}
		}

		String random_code = random_code_buf.toString();
		if (random_code != null && random_code.length() == character_len) {

			// true if this set did not already contain the specified element
			if (code_set != null && code_set.add(random_code)) {
				return random_code;
			} else {
				// 如果生成的随机数重复了，随机种子重复的几率较大，变化种子
				seed_orignal++;
				return genRandomCode(character_len, code_set);
			}

		} else {
			// 如果生成的随机数重复了，随机种子重复的几率较大，变化种子
			seed_orignal++;
			return genRandomCode(character_len, code_set);
		}
	}

}
