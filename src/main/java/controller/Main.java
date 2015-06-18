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
			// . �摜�ǂݍ���
			BufferedImage image = ImageIO.read(new File(filename));
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

			// . �f�R�[�h
			Reader reader = new MultiFormatReader();
			Result result = reader.decode(bitmap);

			// . �o�[�R�[�h�t�H�[�}�b�g
			BarcodeFormat format = result.getBarcodeFormat();

			// . �o�[�R�[�h�R���e���c�i�ǂݎ�茋�ʁj
			String text = result.getText();
			System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
};