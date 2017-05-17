package data;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
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
	
	List<String> IMAGE_PATHS = new ArrayList<>();//location of every valid image

	File FOLDER = new File("src/pictures");
	String[] EXTENSIONS = new String[] {".png", ".jpg"};

	static BufferedImage getImage(String fileName) {//temporary
		try {
			return ImageIO.read(new File(FOLDER+"/"+fileName));//temporary
		}
		catch (IOException e) {
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
				IMAGE_PATHS.add(picture.getName());
//				IMAGES.add(picture);
//				System.out.println("loaded "+picture.getName());
			}
		}
	}

}
