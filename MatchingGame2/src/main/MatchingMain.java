package main;

import data.Data;
import game.Game;
import graphics.NewWindow;
import graphics.Window;

public class MatchingMain {
	static NewWindow window;
	
	public static void main(String[] args) {
		Data.load();
//		Window.init();
		Game.init();
		window = new NewWindow();
		window.start();
		new Thread(Game.getUpdateLoop(), "Loop").start();
	}

	public static NewWindow getWindow() {
		return window;
	}
}
