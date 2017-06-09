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
	
	public static void run() {
		allItems = new ArrayList<>();
		availableItems = new ArrayList<>();
		currentItemOptions = new ArrayList<>();
		for (String imageName:IMAGE_LOCATION) {
			allItems.add(new Item(imageName));//temporary
		}
		window = new Window();
		refreshAvailableItems();
		next(true);
		updateLoop = new UpdateLoop();
		updateLoop.run();
	}

	public static void refillChoices() {
		Collections.shuffle(availableItems);//shuffle available items
		currentItemOptions.clear();//empty options
		boolean found = false;
		for (int i = 0;!found&&i<availableItems.size();i++) {//if it hasnt found a valid correct item yet
			if (PERSISTENT!=TRUE||availableItems.get(i).getTimesShown()<MAX_SHOWINGS) {//if not persistent (pick 0) else pick only if hasnt been shown MAX_SHOWINGS-1 times
				setCorrectItem(availableItems.get(i));
				currentItemOptions.add(correctItem);
				found = true;//found a valid correct item
			}
		}
		for (int i = 0;currentItemOptions.size()<CHOICE_COUNT&&i<availableItems.size();i++) {
			if (availableItems.get(i)!=correctItem) {
				currentItemOptions.add(availableItems.get(i));//fill the rest of the choices with items that aren't the correct item
			}
		}
		if (TRUE==PERSISTENT&&!found) {
			outOfAvailableItems();//if out of available items
		}
		Collections.shuffle(currentItemOptions);//shuffle choices
	}

	public static void resetPersistence() {
		for (int i = 0;i<availableItems.size();i++) {
			availableItems.get(i).setTimesShown(0);
		}
	}
	
	public static void refreshAvailableItems() {
		availableItems.clear();
		for (int i = 0;i<allItems.size();i++) {
			availableItems.add(allItems.get(i));
		}
	}

	public static void outOfAvailableItems() {
		if (RESET_PERSITENCE_WHEN_OUT_OF_ITEMS==TRUE) {
			resetPersistence();
			next(true);
			return;
		}
		currentItemOptions = new ArrayList<>();
		setCorrectItem(null);
		window.initButtons();
		System.out.println("no more available items");
		//restart? end program? BSOD? TODO
	}
	
	public static void proccessGuess() {
		if (foundCorrect()) {
			System.out.println("+correct");
			//change a score?
		}
		else {
			System.out.println("-incorrect");
			//change a score?
		}
		for (int i = 0;i<window.getButtons().size();i++) {
			Button button = window.getButtons().get(i);
			if (button instanceof ChoiceButton) {
				ChoiceButton cButton = ((ChoiceButton) button);
				if (cButton.getItem()==guess) {
					if (foundCorrect()) {cButton.setRightWrong(RIGHT); 
					
					}
					else {cButton.setRightWrong(WRONG);
					
					}
				}
			}
		}
	}
	
	public static void pick(Item item) {//pick (guess) the item
		System.out.println("picked "+item);
		if (!foundCorrect()&&ALLOW_GUESS_AFTER_CORRECT!=TRUE) {
			guess = item;
		}
		else System.out.println("already guessed");
		proccessGuess();
		if (foundCorrect()&&AUTO_NEXT==TRUE) next(false);
	}
	
	public static void next(boolean force) {//go to next set of choices
		if (!force&&TRUE==REQUIRE_ANSWER&&!guessed()) {//if didnt guess
			System.out.println("didn't guess yet");
			return;
		}
		if (guessed()&&((foundCorrect()&&PERSISTENT_ONCE_CORRECT==TRUE&&PERSISTENT==TRUE)||PERSISTENT==TRUE)) {
			correctItem.shown();//increment the use counter on the correct item
		}
		guess = null;//reset guess
		refillChoices();//refill options
		refreshButtons();
	}
	
	public static void refreshButtons() {
		int i = 0;
		for (Button choiceButton:Game.getWindow().getButtons()) {
			if (choiceButton instanceof ChoiceButton) {
				Item item = null;
				if (!currentItemOptions.isEmpty()) {
					item = currentItemOptions.get(i);
				}
				((ChoiceButton) choiceButton).setItem(item);//set the items of the choice buttons
				((ChoiceButton) choiceButton).setRightWrong(NONE);
				i++;
			}
		}
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
	
	public static void setCorrectItem(Item correctItem) {
		Game.correctItem = correctItem;
		if (correctItem!=null) window.getRenderer().setImage(correctItem.getImage());
		else window.getRenderer().setImage(null);
	}

	public static UpdateLoop getUpdateLoop() {
		return updateLoop;
	}

	public static Window getWindow() {
		return window;
	}
	
	private static boolean TRUE = true;//ignore this
}
