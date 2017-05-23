package data;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public interface Data {
	int UPS = 30;

	GraphicsDevice SCREEN = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	
	int IMAGE_SIZE = 400;//width
	int IMAGE_X = SCREEN.getDisplayMode().getWidth()/2-IMAGE_SIZE/2;
	int IMAGE_Y = 40;

	int CHOICE_COUNT = 10;//number of multiple choice options
	boolean AUTO_NEXT = false;//automatically advance to the next question when correct
	boolean REQUIRE_ANSWER = false;
	boolean PERSISTENT = true;//show items as correct choice limited number of times
	int MAX_SHOWINGS = 1; 
	boolean PERSISTENT_ONCE_CORRECT = true;//only stop showing an item when the user gets it correct 
	boolean SHOW_CORRECT = false;
	
	int BUTTON_SPACING = 10;
	int BUTTON_NEXT_X = BUTTON_SPACING;
	int BUTTON_NEXT_Y = BUTTON_SPACING;
	int BUTTON_NEXT_WIDTH = 120; 
	int BUTTON_NEXT_HEIGHT = 60;
	int BUTTON_CHOICE_GRID_X_COUNT = 1;
	int BUTTON_CHOICE_GRID_Y_COUNT = 100;
	int BUTTON_CHOICE_GRID_X = BUTTON_SPACING;
	int BUTTON_CHOICE_GRID_Y = BUTTON_NEXT_HEIGHT+(BUTTON_SPACING*2);
	int BUTTON_CHOICE_WIDTH = 160; 
	int BUTTON_CHOICE_HEIGHT = 60;
	
	
	
	File FOLDER = new File("src/pictures");
	String[] EXTENSIONS = new String[] {".png", ".jpg"};
	String NAMES_DIR = "src/config/items";
	
	List<String> IMAGE_LOCATION = new ArrayList<>();//location of every valid image
	
	class IO {
		private static List<String> ITEM_CONFIG;

		static {
			try {
				ITEM_CONFIG = Files.readAllLines(Paths.get(NAMES_DIR));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static String lookupName(String imageName) {
			try {
				if (ITEM_CONFIG==null) ITEM_CONFIG = Files.readAllLines(Paths.get(NAMES_DIR));
				for (String line:ITEM_CONFIG) {
					if (line.startsWith("//")) continue;//comments can be made
					String[] split = line.split(":");
					if (imageName.substring(0, imageName.indexOf(".")).equals(split[1])) return split[0]; 
				}
			}
			catch (Exception e) {}
			return "";
		}
		
		public static int lookupId(String imageName) {
			try {
				if (ITEM_CONFIG==null) ITEM_CONFIG = Files.readAllLines(Paths.get(NAMES_DIR));
				for (String line:ITEM_CONFIG) {
					if (line.startsWith("//")) continue;//comments can be made
					String[] split = line.split(":");
					if (imageName.substring(0, imageName.indexOf(".")).equals(split[1])) return Integer.valueOf(split[2]); 
				}
			}
			catch (Exception e) {}
			return -1;
		}
		
		public static int lookupGrade(String imageName) {
			try {
				if (ITEM_CONFIG==null) ITEM_CONFIG = Files.readAllLines(Paths.get(NAMES_DIR));
				for (String line:ITEM_CONFIG) {
					if (line.startsWith("//")) continue;//comments can be made
					String[] split = line.split(":");
					if (imageName.substring(0, imageName.indexOf(".")).equals(split[1])) return Integer.valueOf(split[3]); 
				}
			}
			catch (Exception e) {}
			return -1;
		}
	}
	
	static BufferedImage getImage(String fileName) {//temporary
		try {
			return ImageIO.read(new File(FOLDER+"/"+fileName));//temporary
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	static void loadImages() {//load image paths
		FilenameFilter imageFilter = new FilenameFilter() {
			@Override
			public boolean accept(File f, String name) {//check if file is a type of picture
				for (String ext:EXTENSIONS) if (name.endsWith(ext)) return true;
				return false;
			}
		};
		if (FOLDER.isDirectory()) {
			for (File picture:FOLDER.listFiles(imageFilter)) {//load each of the pictures paths
				IMAGE_LOCATION.add(picture.getName());
//				IMAGES.add(picture);
//				System.out.println("loaded "+picture.getName());
			}
		}
	}
	
	int NONE = 0, RIGHT = 1, WRONG = 2;
}
