package fileTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class FileInfo {

	public static void main(String[] args) {
		// fileInfo();
		// fileList();
		// fileCreateDelete();
		fileCopy();
	}

	private static void fileCopy() {
		// File file = new File("D:\\FileUpTest/wallpaper.jpg"); 이렇게 해도됨
		try {
			FileInputStream fis = new FileInputStream("D:\\FileUpTest/wallpaper.jpg"); // (file)
			FileOutputStream fos = new FileOutputStream("D:\\FileUpTest/wallpaper_copy.jpg");

			byte[] temp = new byte[100];
			int size = 0;
			while ((size = fis.read(temp)) != -1) {
				fos.write(temp);
			}

			fis.close();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void fileCreateDelete() {
		File file = new File("D:\\FileUpTest/doc.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File folder = new File("D:\\FileUpTest/img");
		folder.mkdir();

		File file2 = new File("D:\\FileUpTest/wallpaper.jpg");
//		file2.delete();
	}

	private static void fileList() {
		File file = new File("D:/Dev");
		if (file.isDirectory()) {
			String[] list = file.list();
			for (String temp : list) {
				System.out.println(temp);
				System.out.println("------------------");
			}
		}

	}

	public static void fileInfo() {
		File file = new File("D:\\FileUpTest/wallpaper.jpg");
		System.out.println("파일크기 :" + file.length());
		System.out.println("파일경로:" + file.getPath());
		System.out.println("파일시간" + new Date(file.lastModified()));
		System.out.println("---------------------");
	}

}
