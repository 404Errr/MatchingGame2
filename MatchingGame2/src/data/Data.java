package data;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public interface Data {
	int UPS = 30;

	int IMAGE_SIZE = 400;//, UI_PADDING = 20, UI_BUTTON_HEIGHT = 40;

	int CHOICE_COUNT = 3;//number of multiple choice options

	List<String> IMAGE_PATHS = new ArrayList<>();

	File FOLDER = new File("src/pictures");
	String[] EXTS = new String[] {".png", ".jpg"};

	static BufferedImage getImage(String fileName) {
		try {
			return ImageIO.read(new File(FOLDER+"/"+fileName));//temporary
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	static void load() {//load image paths
		FilenameFilter imageFilter = new FilenameFilter() {
			@Override
			public boolean accept(File f, String name) {//check if file is a type of picture
				for (String ext:EXTS) if (name.endsWith(ext)) return true;
				return false;
			}
		};
		if (FOLDER.isDirectory()) {
			for (File picture:FOLDER.listFiles(imageFilter)) {//load each of the pictures paths
				IMAGE_PATHS.add(picture.getName());
//				IMAGES.add(picture);
//				System.out.println("loaded "+picture.getName());
			}
		}
	}

}
