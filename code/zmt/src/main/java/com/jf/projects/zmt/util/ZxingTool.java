package com.jf.projects.zmt.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class ZxingTool {
	private static final int IMAGE_WIDTH = 80;
	private static final int IMAGE_HEIGHT = 80;
	private static final int IMAGE_HALF_WIDTH = IMAGE_WIDTH / 2;
	private static final int FRAME_WIDTH = 2;

	/**
	 * 生成二维码
	 * 
	 * @param context
	 *            二维码内容
	 * @param width
	 *            二维码图片宽度
	 * @param height
	 *            二维码图片高度
	 * @return
	 */
	public static BufferedImage encodeQRcode(String context, int width,
			int height) {
		BufferedImage qrCode = null;
		try {
			Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			BitMatrix bitMatrix = new MultiFormatWriter().encode(context,
					BarcodeFormat.QR_CODE, width, height, hints);
			qrCode = MatrixToImageWriter.toBufferedImage(bitMatrix);
		} catch (WriterException ex) {
			Logger.getLogger(ZxingTool.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		return qrCode;
	}

	/**
	 * 生成带有logo标志的二维码
	 * 
	 * @param context
	 *            二维码存储内容
	 * @param width
	 *            二维码宽度
	 * @param height
	 *            二维码高度
	 * @param logoPath
	 *            二维码logo路径
	 * @return
	 */
	public static BufferedImage encodeLogoQRcode(String context, int width,
			int height, String logoPath) {
		BufferedImage logoQRcode = null;
		try {
			// 读取Logo图像
			BufferedImage logoImage = scale(logoPath, IMAGE_WIDTH,
					IMAGE_HEIGHT, true);
			int[][] srcPixels = new int[IMAGE_WIDTH][IMAGE_HEIGHT];
			for (int i = 0; i < logoImage.getWidth(); i++) {
				for (int j = 0; j < logoImage.getHeight(); j++) {
					srcPixels[i][j] = logoImage.getRGB(i, j);
				}
			}

			Map<EncodeHintType, Object> hint = new HashMap<EncodeHintType, Object>();
			hint.put(EncodeHintType.CHARACTER_SET, "utf-8");
			hint.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

			BitMatrix bitMatrix = new MultiFormatWriter().encode(context,
					BarcodeFormat.QR_CODE, width, height, hint);

			// 二维矩阵转为一维像素数组
			int halfW = bitMatrix.getWidth() / 2;
			int halfH = bitMatrix.getHeight() / 2;

			int[] pixels = new int[width * height];

			for (int y = 0; y < bitMatrix.getHeight(); y++) {
				for (int x = 0; x < bitMatrix.getWidth(); x++) {
					// 读取图片
					if (x > halfW - IMAGE_HALF_WIDTH
							&& x < halfW + IMAGE_HALF_WIDTH
							&& y > halfH - IMAGE_HALF_WIDTH
							&& y < halfH + IMAGE_HALF_WIDTH) {
						pixels[y * width + x] = srcPixels[x - halfW
								+ IMAGE_HALF_WIDTH][y - halfH
								+ IMAGE_HALF_WIDTH];
					}
					// 在图片四周形成边框
					else if ((x > halfW - IMAGE_HALF_WIDTH - FRAME_WIDTH
							&& x < halfW - IMAGE_HALF_WIDTH + FRAME_WIDTH
							&& y > halfH - IMAGE_HALF_WIDTH - FRAME_WIDTH && y < halfH
							+ IMAGE_HALF_WIDTH + FRAME_WIDTH)
							|| (x > halfW + IMAGE_HALF_WIDTH - FRAME_WIDTH
									&& x < halfW + IMAGE_HALF_WIDTH
											+ FRAME_WIDTH
									&& y > halfH - IMAGE_HALF_WIDTH
											- FRAME_WIDTH && y < halfH
									+ IMAGE_HALF_WIDTH + FRAME_WIDTH)
							|| (x > halfW - IMAGE_HALF_WIDTH - FRAME_WIDTH
									&& x < halfW + IMAGE_HALF_WIDTH
											+ FRAME_WIDTH
									&& y > halfH - IMAGE_HALF_WIDTH
											- FRAME_WIDTH && y < halfH
									- IMAGE_HALF_WIDTH + FRAME_WIDTH)
							|| (x > halfW - IMAGE_HALF_WIDTH - FRAME_WIDTH
									&& x < halfW + IMAGE_HALF_WIDTH
											+ FRAME_WIDTH
									&& y > halfH + IMAGE_HALF_WIDTH
											- FRAME_WIDTH && y < halfH
									+ IMAGE_HALF_WIDTH + FRAME_WIDTH)) {
						pixels[y * width + x] = 0xfffffff;
					} else {
						// 此处可以修改二维码的颜色，可以分别制定二维码和背景的颜色；
						pixels[y * width + x] = bitMatrix.get(x, y) ? 0xff000000
								: 0xfffffff;
					}
				}
			}
			logoQRcode = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			logoQRcode.getRaster().setDataElements(0, 0, width, height, pixels);
		} catch (WriterException ex) {
			Logger.getLogger(ZxingTool.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		return logoQRcode;
	}

	/**
	 * 解析读取二维码
	 * 
	 * @param qrCodePath
	 *            二维码图片路径
	 * @return
	 */
	public static String decodeQRcode(String qrCodePath) {
		BufferedImage image;
		String qrCodeText = null;
		try {
			image = ImageIO.read(new File(qrCodePath));
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
			Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
			hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
			// 对图像进行解码
			Result result = new MultiFormatReader().decode(binaryBitmap, hints);
			qrCodeText = result.getText();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return qrCodeText;
	}

	/**
	 * 对图片进行缩放
	 * 
	 * @param imgPath
	 *            图片路径
	 * @param width
	 *            图片缩放后的宽度
	 * @param height
	 *            图片缩放后的高度
	 * @param hasFiller
	 *            是否补白
	 * @return
	 */
	public static BufferedImage scale(String imgPath, int width, int height,
			boolean hasFiller) {
		double ratio = 0.0; // 缩放比例
		File file = new File(imgPath);
		BufferedImage srcImage = null;
		try {
			srcImage = ImageIO.read(file);
		} catch (IOException ex) {
			Logger.getLogger(ZxingTool.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		Image finalImage;
		finalImage = srcImage.getScaledInstance(width, height,
				BufferedImage.SCALE_SMOOTH);
		// 计算比例
		if ((srcImage.getHeight() > height) || (srcImage.getWidth() > width)) {
			if (srcImage.getHeight() > srcImage.getWidth()) {
				ratio = (new Integer(height)).doubleValue()
						/ srcImage.getHeight();
			} else {
				ratio = (new Integer(width)).doubleValue()
						/ srcImage.getWidth();
			}
			AffineTransformOp op = new AffineTransformOp(
					AffineTransform.getScaleInstance(ratio, ratio), null);
			finalImage = op.filter(srcImage, null);
		}
		if (hasFiller) {// 补白
			BufferedImage image = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D graphic = image.createGraphics();
			graphic.setColor(Color.white);
			graphic.fillRect(0, 0, width, height);
			if (width == finalImage.getWidth(null)) {
				graphic.drawImage(finalImage, 0,
						(height - finalImage.getHeight(null)) / 2,
						finalImage.getWidth(null), finalImage.getHeight(null),
						Color.white, null);
			} else {
				graphic.drawImage(finalImage,
						(width - finalImage.getWidth(null)) / 2, 0,
						finalImage.getWidth(null), finalImage.getHeight(null),
						Color.white, null);
				graphic.dispose();
				finalImage = image;
			}
		}
		return (BufferedImage) finalImage;
	}

	/**
	 * 将图片存入指定目录
	 * 
	 * @param image
	 *            二维码图片
	 * @param format
	 *            格式"jpg"
	 * @param file
	 *            文件
	 * @throws IOException
	 */
	public static void writeToFile(BufferedImage image, String format, File file)
			throws IOException {
		if (!ImageIO.write(image, format, file)) {
			throw new IOException("Could not write an image of format "
					+ format + " to " + file);
		}
	}

	public static void writeToStream(BufferedImage image, BitMatrix matrix,
			String format, OutputStream stream) throws IOException {
		if (!ImageIO.write(image, format, stream)) {
			throw new IOException("Could not write an image of format "
					+ format);
		}
	}

	public static void pressText(String pressText, File qrFile, int fontStyle,
			Color color, int fontSize) throws Exception {
		pressText = new String(pressText.getBytes(), "utf-8");
		// String[] text = pressText.split("-");
		// String code = text[0];
		// String number = text[1];
		Image src = ImageIO.read(qrFile);
		int imageW = src.getWidth(null);
		int imageH = src.getHeight(null);
		BufferedImage image = new BufferedImage(imageW, imageH,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.createGraphics();
		g.drawImage(src, 0, 0, imageW, imageH, null); // 设置画笔的颜色
		g.setColor(color); // 设置字体
		Font font = new Font("宋体", fontStyle, fontSize);
		FontMetrics metrics = g.getFontMetrics(font); // 文字在图片中的坐标 这里设置在中间
		int startX = (110 - metrics.stringWidth(pressText)) / 2;
		int startY = 98;
		g.setFont(font);
		g.drawString(pressText, startX, startY);
		g.dispose();
		FileOutputStream out = new FileOutputStream(qrFile);
		ImageIO.write(image, "jpg", out);
		out.close();
	}

	/*
	 * public static void main(String[] args) {
	 * System.out.println(ZxingTool.decodeQRcode("d:/000000002.jpg")); }
	 */
}
