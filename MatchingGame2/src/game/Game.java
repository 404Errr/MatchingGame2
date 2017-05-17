package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import data.Data;
import graphics.Window;
import input.buttons.Button;
import input.buttons.ChoiceButton;

public class Game implements Data {
	private static Window window;
	private static UpdateLoop updateLoop;
	private static List<Item> allItems, availableItems, currentItemOptions;
	private static Item correctItem, guess;
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
//		gradeFilter.add(9);
		
		refillChoices();
		window = new Window();
		next();
	}

	public static void refillChoices() {
		refreshAvailableItems();
		currentItemOptions.clear();
		for (int i = 0;i<CHOICE_COUNT&&i<availableItems.size();i++) currentItemOptions.add(availableItems.get(i));
		correctItem = currentItemOptions.get((int) (Math.random()*currentItemOptions.size()));
//		for (int i = 0;i<currentItemOptions.size();i++) System.out.println(currentItemOptions.get(i));
//		System.out.println("correct: "+correctItem);
	}

	public static void refreshAvailableItems() {
		availableItems.clear();
		for (int i = 0;i<allItems.size();i++) {
			if (filter(allItems.get(i))) availableItems.add(allItems.get(i));
		}
		Collections.shuffle(availableItems);
	}

	public static void proccessGuess() {//TODO
		if (foundCorrect()) {
			System.out.println("correct");
		}
		else {
			System.out.println("incorrect");
		}
	}
	
	public static void pick(Item item) {//pick an item
		guess = item;
		System.out.println("picked "+item);
		proccessGuess();
	}
	
	public static void next() {//go to next set of choices
		guess = null;
		refillChoices();
		int i = 0;
		for (Button choiceButton:Game.getWindow().getButtons()) {
			if (choiceButton instanceof ChoiceButton) {
				((ChoiceButton) choiceButton).setItem(currentItemOptions.get(i));
				i++;
			}
		}
	}
	
	private static boolean filter(Item item) {
		if (!gradeFilter.isEmpty()&&!gradeFilter.contains(item.getGrade())) return false;
		return true;
	}

	public static boolean foundCorrect() {
		return correctItem==guess;
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

	public static Window getWindow() {
		return window;
	}
}
