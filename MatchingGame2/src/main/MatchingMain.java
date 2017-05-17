package main;

import data.Data;
import game.Game;

public class MatchingMain {	
	public static void main(String[] args) {
		Data.loadImages();
		Game.init();
		Game.getUpdateLoop().run();
	}
}
