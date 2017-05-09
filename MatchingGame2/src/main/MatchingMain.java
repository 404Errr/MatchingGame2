package main;

import data.Data;
import game.Game;
import graphics.Window;

public class MatchingMain {
	public static void main(String[] args) {
		Data.load();
		Window.init();
		Game.init();
		
		Game.refillChoices();
		
		Thread update = new Thread(Game.getUpdateLoop(), "Loop");
		update.start();
	}
}
