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
		allItems = new ArrayList<>();
		availableItems = new ArrayList<>();
		currentItemOptions = new ArrayList<>();
		for (String image:IMAGE_PATHS) {
			int tempGrade = (int) (Math.random()*4)+9;
			allItems.add(new Item(image, tempGrade));
		}
		gradeFilter = new ArrayList<>();
		window = new Window();
		refreshAvailableItems();
		next();
		updateLoop = new UpdateLoop();
		updateLoop.run();
	}

//	public static void refillChoices() {
//		//refreshAvailableItems();
//		boolean found = false;
//		for (int i = 0;i<availableItems.size();i++) if (TRUE==PERSISTENT&&availableItems.get(i).getTimesShown()<1) found = true;
//		if (TRUE==PERSISTENT&&!found) {
//			outOfAvailableItems();
//			return;
//		}
//		do {
//			Collections.shuffle(availableItems);
//			currentItemOptions.clear();
//			for (int i = 0;i<CHOICE_COUNT&&i<availableItems.size();i++)	currentItemOptions.add(availableItems.get(i));
//			correctItem = currentItemOptions.get(0);
//			
//		} while (TRUE==PERSISTENT&&correctItem.getTimesShown()>0);
//		correctItem.shown();
//		Collections.shuffle(currentItemOptions);
////		for (int i = 0;i<currentItemOptions.size();i++) System.out.println(currentItemOptions.get(i));
////		System.out.println("correct: "+correctItem);
//	}

	public static void refillChoices() {todo//TODO
		Collections.shuffle(availableItems);
		currentItemOptions.clear();
		for (int i = 0;i<availableItems.size();i++) {
			if (correctItem==null&&(TRUE==PERSISTENT&&correctItem.getTimesShown()<1)) {
				currentItemOptions.add(availableItems.get(i));
				correctItem = availableItems.get(i);
			}
			if (currentItemOptions.size()<CHOICE_COUNT) currentItemOptions.add(availableItems.get(i));
		}
		Collections.shuffle(currentItemOptions);
		
//			if (correctItem==null&&(TRUE==PERSISTENT&&correctItem.getTimesShown()<1)) {
//				correctItem = item;
//				currentItemOptions.add(item);
//			}
//			if (correctItem!=item) {
//				currentItemOptions.add(item);
//			}
	}
	
	public static void refreshAvailableItems() {
		availableItems.clear();
		for (int i = 0;i<allItems.size();i++) {
			if (filter(allItems.get(i))) availableItems.add(allItems.get(i));
		}
	}

	public static void outOfAvailableItems() {
		System.out.println("no more available items");
	}
	
	public static void proccessGuess() {//TODO
		if (foundCorrect()) {
			System.out.println("+correct");
			//change score?
		}
		else {
			System.out.println("-incorrect");
			//change score?
		}
	}
	
	public static void pick(Item item) {//pick an item
		guess = item;
		System.out.println("picked "+item);
		proccessGuess();
		if (foundCorrect()&&AUTO_NEXT==TRUE) next();
	}
	
	public static void next() {//go to next set of choices
		if (correctItem!=null&&TRUE==REQUIRE_ANSWER&&!guessed()) {
			System.out.println("didn't guess yet");
			return;
		}
		if (correctItem!=null) System.out.println("next");
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

	public static boolean guessed() {
		return guess!=null;
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
	
	private static boolean TRUE = true;//ignore this
}
