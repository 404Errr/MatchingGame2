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

	int CHOICE_COUNT = 3;//number of multiple choice options
	boolean AUTO_NEXT = true;
	boolean REQUIRE_ANSWER = false;
	boolean PERSISTENT = true;//show items as correct choice limited number of times
	int MAX_SHOWINGS = 2; 
	boolean PERSISTENT_ONCE_CORRECT = true;//only stop showing an item when the user gets it correct 
//	boolean SHOW_CORRECT = true;
	
	
	File FOLDER = new File("src/pictures");
	String[] EXTENSIONS = new String[] {".png", ".jpg"};
	String NAMES_DIR = "src/names/names";
	
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
			catch (Exception e) {
				e.printStackTrace();
			}
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
			catch (Exception e) {
				e.printStackTrace();
			}
			return -1;
		}
	}
	
	add thingy lookup grade
	
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
}
