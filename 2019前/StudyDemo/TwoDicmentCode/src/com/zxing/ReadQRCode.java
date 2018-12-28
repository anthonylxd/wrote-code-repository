package com.zxing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import sun.applet.Main;

/**
 * 解析二维码
 * @author Anthony
 *
 */

public class ReadQRCode {

	public static void main(String[] args) throws IOException, NotFoundException{
		MultiFormatReader formatReader = new MultiFormatReader();
		File file = new File("C:/Temp/code.png");
		
		BufferedImage image = ImageIO.read(file);
		
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
		
		//定义二维码参数
		HashMap codeParam = new HashMap<>();
		codeParam.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		codeParam.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M); 		
		
		Result result = formatReader.decode(binaryBitmap,codeParam);
		
		System.out.println("解析结果" + result.toString());
		System.out.println("二维码格式类型"+result.getBarcodeFormat());
		System.out.println("二维码文本内容"+result.getText());
	}
}
