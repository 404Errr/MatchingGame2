package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import data.Data;

public class Game implements Data {
	private static UpdateLoop updateLoop;
	private static List<Item> allItems, availableItems, currentItemOptions;
	private static Item correctItem;
	private static List<Integer> gradeFilter;

	public static void init() {
		updateLoop = new UpdateLoop();
		allItems = new ArrayList<>();
		availableItems = new ArrayList<>();
		currentItemOptions = new ArrayList<>();
		for (String image:IMAGE_PATHS) {
			int tempGrade = (int) (Math.random()*4)+9;
			allItems.add(new Item(image, tempGrade));
		}
		gradeFilter = new ArrayList<>();
		gradeFilter.add(9);
		refillChoices();
	}

	public static void refillChoices() {
		resetAvailableItems();
		currentItemOptions.clear();
		for (int i = 0;i<CHOICE_COUNT&&i<availableItems.size();i++) currentItemOptions.add(availableItems.get(i));
		correctItem = currentItemOptions.get((int) (Math.random()*currentItemOptions.size()));

		for (int i = 0;i<currentItemOptions.size();i++) System.out.println(currentItemOptions.get(i));
		System.out.println("correct: "+correctItem);
	}

	public static void resetAvailableItems() {
		availableItems.clear();
		for (int i = 0;i<allItems.size();i++) {
			if (filter(allItems.get(i))) availableItems.add(allItems.get(i));
		}
		Collections.shuffle(availableItems);
	}

	private static boolean filter(Item item) {
		if (!gradeFilter.isEmpty()&&!gradeFilter.contains(item.getGrade())) return false;
		return true;
	}

	public static List<Item> getAllItems() {
		return allItems;
	}

	public static List<Item> getCurrentItemOptions() {
		return currentItemOptions;
	}

	public static Item getCorrectItem() {
		return correctItem;
	}

	public static List<Integer> getGroupFilter() {
		return gradeFilter;
	}

	public static UpdateLoop getUpdateLoop() {
		return updateLoop;
	}
}
