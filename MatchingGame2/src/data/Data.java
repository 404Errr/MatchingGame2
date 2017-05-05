package data;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public interface Data {
	int UPS = 30;
	
	int IMAGE_SIZE = 400, UI_PADDING = 20, UI_BUTTON_HEIGHT = 40;

	Color COLOR_UI_BUTTON = new Color(50,50,255,255);
	Color COLOR_UI_BUTTON_HOVERED = new Color(100,100,255,255);

	int CHOICE_COUNT = 6;
	boolean SHOW_CORRECT = false, REPEATING_SETS = false;

	int REWARD_CORRECT = 1, REWARD_INCORRECT = -1;

	List<File> IMAGES = new ArrayList<>();
	
	File FOLDER = new File("src/pictures");
	String[] EXTS = new String[] {".png", ".jpg", ".bmp"};

	FilenameFilter IMAGE_FILTER = new FilenameFilter() {
		@Override
		public boolean accept(File f, String name) {
			for (String ext:EXTS) if (name.endsWith(ext)) return true;
			return false;
		}
	};
	
	static void load() {
		if (FOLDER.isDirectory()) {
			for (File picture:FOLDER.listFiles(IMAGE_FILTER)) {
				IMAGES.add(picture);
				System.out.println("loaded "+picture.getName());
			}
		}
	}

}
