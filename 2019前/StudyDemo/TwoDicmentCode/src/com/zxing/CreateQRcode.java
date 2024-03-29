package com.zxing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * zxing生成二维码
 * @author Anthony
 *
 */

public class CreateQRcode {

		public static void main(String[] args) {
			int width = 300;
			int height = 300;
			String format = "png";
			String content = "www.baidu.com";
			
			//定义二维码参数
			HashMap codeParam = new HashMap<>();
			codeParam.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			codeParam.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M); 
			codeParam.put(EncodeHintType.MARGIN, 2);
		
			try {
				BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height);			
				Path file = new File("C:/Temp/code.png").toPath();	
				MatrixToImageWriter.writeToPath(bitMatrix, format, file);
			
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriterException e) {
				e.printStackTrace();
			}
		 }
}
