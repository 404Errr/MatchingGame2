package input.buttons;

import data.Data;
import game.Game;
import game.Item;

public class ChoiceButton extends Button implements Data {
	private Item item;
	private int rightWrong;
	
	public ChoiceButton(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void click() {
		Game.pick(item);
	}

	public int getRightWrong() {
		return rightWrong;
	}

	public void setRightWrong(int rightWrong) {
		this.rightWrong = rightWrong;
	}

	public void setItem(Item item) {
		rightWrong = NONE;
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
