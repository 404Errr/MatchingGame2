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
	boolean SHOW_CORRECT = false;//highlight the correct choice
	boolean AUTO_NEXT = false;//automatically advance to the next question when user gets it correct
	boolean ALLOW_GUESS_AFTER_CORRECT = false;//allow user to guess after they found the correct answer
	boolean REQUIRE_ANSWER = true;//only allow the next button to work if user has made a guess
	boolean PERSISTENT = true;//show items as correct choice MAX_SHOWINGS times
	int MAX_SHOWINGS = 1;//maximum times an item can be the correct choice (only if PERSISTENT is true)
	boolean PERSISTENT_ONCE_CORRECT = true;//only stop showing an item when the user gets it correct
	boolean RESET_PERSITENCE_WHEN_OUT_OF_ITEMS = true;//if false, program will end when all items have been shown MAX_SHOWINGS times
	
	int BUTTON_SPACING = 10;//space between buttons
	int BUTTON_NEXT_X = BUTTON_SPACING;
	int BUTTON_NEXT_Y = BUTTON_SPACING;
	int BUTTON_NEXT_WIDTH = 120;//size of the next buttons
	int BUTTON_NEXT_HEIGHT = 60;
	int BUTTON_CHOICE_GRID_X_COUNT = 3;
	int BUTTON_CHOICE_GRID_Y_COUNT = 1;
	int BUTTON_CHOICE_GRID_X = BUTTON_SPACING;
	int BUTTON_CHOICE_GRID_Y = BUTTON_NEXT_HEIGHT+(BUTTON_SPACING*2);
	int BUTTON_CHOICE_WIDTH = 140; 
	int BUTTON_CHOICE_HEIGHT = 60;
	
	int IMAGE_NAME = 0, NAME = 1, ID = 2, GRADE = 3;//config file content order
	File IMAGE_FOLDER = new File("src/pictures");//directory of images
	String[] EXTENSIONS = new String[] {".png", ".jpg"};//recognized image extenstion types
	String CONFIG_DIR = "src/config/items";//directory of config file
	
	List<String> IMAGE_LOCATION = new ArrayList<>();//location of every valid image
	
	class IO {
		private static List<String[]> itemConfig;

		static {
			try {
				List<String> tempItemConfig = Files.readAllLines(Paths.get(CONFIG_DIR));
				itemConfig = new ArrayList<>();
				for (int i = 0;i<tempItemConfig.size();i++) {
					if (tempItemConfig.get(i).startsWith("//")) continue;
					String[] line = tempItemConfig.get(i).split(":");
					itemConfig.add(line);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static String lookup(String imageName, int type) {
			try {
				for (String[] line:itemConfig) {
					if (imageName.substring(0, imageName.indexOf(".")).equals(line[IMAGE_NAME])) return line[type]; 
				}
			}
			catch (Exception e) {}
			return "";
		}
		
		public static String lookupName(String imageName) {
			return lookup(imageName, NAME);
		}
		
		public static int lookupId(String imageName) {
			return Integer.parseInt(lookup(imageName, ID));
		}
		
		public static int lookupGrade(String imageName) {
			return Integer.valueOf(lookup(imageName, GRADE));
		}

		public static BufferedImage getImage(String fileName) {
			String path = IMAGE_FOLDER+"/"+fileName;
			try {
				return ImageIO.read(new File(path));
			}
			catch (Exception e) {
				System.err.println("couldnt load image at :\t"+path);
			}
			return null;
		}
	}
	
	static void loadImages() {//load image paths
		FilenameFilter imageFilter = new FilenameFilter() {
			@Override
			public boolean accept(File file, String name) {//check if file is a type of picture (has one of EXT)
				for (String ext:EXTENSIONS) if (name.endsWith(ext)) return true;
				return false;
			}
		};
		if (IMAGE_FOLDER.isDirectory()) {
			for (File picture:IMAGE_FOLDER.listFiles(imageFilter)) {//load each of the pictures paths
				IMAGE_LOCATION.add(picture.getName());
			}
		}
	}
	
	int NONE = 0, RIGHT = 1, WRONG = 2;
}
