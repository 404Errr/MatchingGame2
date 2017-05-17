package input.buttons;

import game.Game;
import game.Item;

public class ChoiceButton extends Button {
	private Item item;
	
	public ChoiceButton(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void click() {
		Game.pick(item);
	}

	public void setItem(Item item) {
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
