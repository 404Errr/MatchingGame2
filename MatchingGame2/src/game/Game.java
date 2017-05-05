package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import data.Data;

public class Game implements Data {
	private static UpdateLoop updateLoop;
	private static List<Item> allItems, items, ItemOptions;
	
	public static void init() {
		updateLoop = new UpdateLoop();
		allItems = new ArrayList<>();
		for (File image:IMAGES) {
			try {
				allItems.add(new Item(ImageIO.read(image), image.getName()));
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static UpdateLoop getUpdateLoop() {
		return updateLoop;
	}
}
