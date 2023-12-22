package Qrcode;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class QRCodeGenerator {
	 public static void main(String[] args) {
	        String myText = "Hello, QR Code!"; // 轉換的文字

	        int width = 300; // 圖片的寬度
	        int height = 300; // 圖片的高度
	        String fileType = "png"; // 圖片文件類型

	        try {
	            QRCodeWriter qrCodeWriter = new QRCodeWriter();
	            BitMatrix bitMatrix = qrCodeWriter.encode(myText, BarcodeFormat.QR_CODE, width, height);

	            Path path = FileSystems.getDefault().getPath("path/to/your/QRCode.png"); // 替換你想保存的路徑

	            // 將 BitMatrix 轉換為 BufferedImage
	            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	            for (int x = 0; x < width; x++) {
	                for (int y = 0; y < height; y++) {
	                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
	                }
	            }

	            // 將 BufferedImage 寫入到文件
	            File outputFile = new File(path.toString());
	            ImageIO.write(image, fileType, outputFile);

	            System.out.println("QR Code generated successfully!");
	        } catch (WriterException | IOException e) {
	            System.out.println("Could not generate QR Code: " + e);
	        }
	    }
}
