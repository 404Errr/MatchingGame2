package input.buttons;

import game.Game;

public class NextButton extends Button {
	public NextButton(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void click() {
		System.out.println("next");
		Game.next();
	}

	@Override
	public String toString() {
		return "Next"+super.toString();
	}
}
