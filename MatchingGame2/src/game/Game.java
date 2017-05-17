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
		for (String imageName:IMAGE_NAMES) {
			int tempGrade = (int) (Math.random()*4)+9;
			allItems.add(new Item(imageName, tempGrade));
		}
		gradeFilter = new ArrayList<>();
		window = new Window();
		refreshAvailableItems();
		next();
		updateLoop = new UpdateLoop();
		updateLoop.run();
	}

	public static void refillChoices() {//TODO
		Collections.shuffle(availableItems);//shuffle available items
		currentItemOptions.clear();//empty options
		boolean found = false;
		for (int i = 0;!found&&i<availableItems.size();i++) {//if it hasnt found a valid correct item
			if (PERSISTENT!=TRUE||availableItems.get(i).getTimesShown()<1) {//if not persistent (pick 0) else pick only if hasnt been shown
				correctItem = availableItems.get(i);
				currentItemOptions.add(correctItem);
				found = true;
			}
		}
		for (int i = 0;currentItemOptions.size()<CHOICE_COUNT&&i<availableItems.size();i++) {
			if (availableItems.get(i)!=correctItem) currentItemOptions.add(availableItems.get(i));//fill the rest of the choices with items that arent the correct item
		}
		correctItem.used();//increment the use counter on the correct item
		if (TRUE==PERSISTENT&&!found) outOfAvailableItems();//if out of available items
		Collections.shuffle(currentItemOptions);//shuffle choices
	}
	
	public static void refreshAvailableItems() {
		availableItems.clear();
		for (int i = 0;i<allItems.size();i++) {
			if (filter(allItems.get(i))) availableItems.add(allItems.get(i));//if the item fits the filter, add it to available
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
	
	public static void pick(Item item) {//pick (guess) the item
		guess = item;
		System.out.println("picked "+item);
		proccessGuess();
		if (foundCorrect()&&AUTO_NEXT==TRUE) next();
	}
	
	public static void next() {//go to next set of choices
		if (TRUE==REQUIRE_ANSWER&&!guessed()) {//if didnt guess
			System.out.println("didn't guess yet");
			return;
		}
		if (correctItem!=null) System.out.println("next");
		guess = null;//reset guess
		refillChoices();//refill options
		int i = 0;
		for (Button choiceButton:Game.getWindow().getButtons()) {
			if (choiceButton instanceof ChoiceButton) {
				((ChoiceButton) choiceButton).setItem(currentItemOptions.get(i));//set the items of the choice buttons
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
		return correctItem!=null&&guess!=null&&correctItem==guess;
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
