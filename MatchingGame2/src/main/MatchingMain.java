package main;

import data.Data;
import game.Game;
import graphics.Window;

public class MatchingMain {
	static Window window;
	
	public static void main(String[] args) {
		Data.load();
		Game.init();
		window = new Window();
		Game.getUpdateLoop().run();
	}

	public static Window getWindow() {
		return window;
	}
}
