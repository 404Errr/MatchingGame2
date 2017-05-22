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
//	private static boolean[] gradeFilter;//TODO
//	private static List<Integer> gradeFilter;

	public static void init() {
		allItems = new ArrayList<>();
		availableItems = new ArrayList<>();
		currentItemOptions = new ArrayList<>();
		for (String imageName:IMAGE_LOCATION) {
			allItems.add(new Item(imageName));//temporary
		}
//		gradeFilter = new boolean[4];
		window = new Window();
		refreshAvailableItems();
		next();
		updateLoop = new UpdateLoop();
		updateLoop.run();
	}

	public static void refillChoices() {
		Collections.shuffle(availableItems);//shuffle available items
		currentItemOptions.clear();//empty options
		boolean found = false;
		for (int i = 0;!found&&i<availableItems.size();i++) {//if it hasnt found a valid correct item yet
			if (PERSISTENT!=TRUE||availableItems.get(i).getTimesShown()<MAX_SHOWINGS) {//if not persistent (pick 0) else pick only if hasnt been shown
				correctItem = availableItems.get(i);
				currentItemOptions.add(correctItem);
				found = true;
			}
		}
		for (int i = 0;currentItemOptions.size()<CHOICE_COUNT&&i<availableItems.size();i++) {
			if (availableItems.get(i)!=correctItem) currentItemOptions.add(availableItems.get(i));//fill the rest of the choices with items that arent the correct item
		}
		
		if (TRUE==PERSISTENT&&!found) outOfAvailableItems();//if out of available items
		Collections.shuffle(currentItemOptions);//shuffle choices
	}
	
	public static void refreshAvailableItems() {
		availableItems.clear();
		for (int i = 0;i<allItems.size();i++) {
//			if (filter(allItems.get(i))) {//if the item fits the filter, add it to available
			availableItems.add(allItems.get(i));
//			}
		}
	}

	public static void outOfAvailableItems() {//TODO
		currentItemOptions = new ArrayList<>();
		correctItem = null;
		window.initButtons();
		System.out.println("no more available items");
		//restart? end program? BSOD?
	}
	
	public static void proccessGuess() {//TODO
		if (foundCorrect()) {
			System.out.println("+correct");
			//change a score?
		}
		else {
			for (int i = 0;i<window.getButtons().size();i++) {
				Button button = window.getButtons().get(i);
				if (button instanceof ChoiceButton) {
					if (((ChoiceButton) button).getItem()==guess) ((ChoiceButton) button).setWrong(true);
				}
			}
			System.out.println("-incorrect");
			//change a score?
		}
	}
	
	public static void pick(Item item) {//pick (guess) the item
		System.out.println("picked "+item);
		guess = item;
		proccessGuess();
		if (foundCorrect()&&AUTO_NEXT==TRUE) next();
	}
	
	public static void next() {//go to next set of choices
		if (TRUE==REQUIRE_ANSWER&&!guessed()) {//if didnt guess
			System.out.println("didn't guess yet");
			return;
		}
		if (correctItem!=null) System.out.println("next");
		if (guessed()&&((foundCorrect()&&PERSISTENT_ONCE_CORRECT==TRUE&&PERSISTENT==TRUE)||PERSISTENT==TRUE)) correctItem.shown();//increment the use counter on the correct item
		guess = null;//reset guess
		refillChoices();//refill options
		
		refreshButtons();
	}
	
	public static void refreshButtons() {
		int i = 0;
		for (Button choiceButton:Game.getWindow().getButtons()) {
			if (choiceButton instanceof ChoiceButton) {
				Item item = null;
				if (!currentItemOptions.isEmpty()) item = currentItemOptions.get(i);
				((ChoiceButton) choiceButton).setItem(item);//set the items of the choice buttons
				((ChoiceButton) choiceButton).setWrong(false);
				i++;
			}
		}
	}
	
//	private static boolean filter(Item item) {
//		if (!gradeFilter.length&&!gradeFilter.contains(item.getGrade())) return false;
//		return true;
//	}

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

//	public static boolean[] getFilter() {
//		return gradeFilter;
//	}
//	
//	public static void toggleGrade(int index) {
//		gradeFilter.remove(index);
//	}

	public static UpdateLoop getUpdateLoop() {
		return updateLoop;
	}

	public static Window getWindow() {
		return window;
	}
	
	private static boolean TRUE = true;//ignore this
}
