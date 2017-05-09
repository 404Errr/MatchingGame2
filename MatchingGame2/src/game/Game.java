package game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import data.Data;

public class Game implements Data {
	private static UpdateLoop updateLoop;
	private static List<Item> allItems, items, currentItemOptions;
	private static Item correctItem;
	
	public static void init() {
		updateLoop = new UpdateLoop();
		allItems = new ArrayList<>();
		for (File image:IMAGES) {
			try {
				int tempGrade = (int) (Math.random()*4+9);
				allItems.add(new Item(ImageIO.read(image), tempGrade, image.getName()));
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		items = new ArrayList<>();
		items.addAll(allItems);
	}
	
	public static void refillChoices() {
		currentItemOptions.clear();
		for (int i = 0;i<CHOICE_COUNT;i++) currentItemOptions.add(items.get((int) (Math.random()*items.size())));
		correctItem = currentItemOptions.get((int) (Math.random()*currentItemOptions.size()));
	}
	
	public static UpdateLoop getUpdateLoop() {
		return updateLoop;
	}
}
