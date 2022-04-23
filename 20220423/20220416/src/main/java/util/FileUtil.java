package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
	public static void saveImage(String root
			, String fname, byte[] data) 
					throws IOException {
		root += "/images";
		File file = new File(root);
		if(!file.exists()) file.mkdir();
		file = new File(root + "/"+ fname);
		FileOutputStream out = new FileOutputStream(file);
		out.write(data);
		out.close();
	}
}
