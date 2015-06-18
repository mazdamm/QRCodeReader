package main.java.controller;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class Main {

	public static void main(String[] args) throws WriterException {
		System.out.println("start");
		createQRCode();
		System.out.println("end");
	}
	
	private static void createQRCode()
			throws WriterException {
		String filename = "c:/machimura.jpg";
		try {
			// . 画像読み込み
			BufferedImage image = ImageIO.read(new File(filename));
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

			// . デコード
			Reader reader = new MultiFormatReader();
			Result result = reader.decode(bitmap);

			// . バーコードフォーマット
			BarcodeFormat format = result.getBarcodeFormat();

			// . バーコードコンテンツ（読み取り結果）
			String text = result.getText();
			System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
};