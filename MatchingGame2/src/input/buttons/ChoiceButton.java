package input.buttons;

import game.Game;
import game.Item;

public class ChoiceButton extends Button {
	private Item item;
	private boolean wrong, correct;//make int TODO
	
	public ChoiceButton(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void click() {
		Game.pick(item);
	}

	public boolean isWrong() {
		return wrong;
	}

	public void setWrong(boolean wrong) {
		this.wrong = wrong;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public void setItem(Item item) {
		wrong = false;
		correct = false;
		this.item = item;
	}
	
	public Item getItem() {
		return item;
	}

	@Override
	public String toString() {
		return "Choice"+super.toString();
	}
	
	
}
