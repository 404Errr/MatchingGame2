package game;

import java.awt.image.BufferedImage;

public class Item {
	private BufferedImage image;
	private int group;//grade level
	private String name;
	
	public Item(BufferedImage image, int group, String name) {
		this.image = image;
		this.group = group;
		this.name = name;
	}
	
	BufferedImage getImage() {
		return image;
	}
	
	int getGroup() {
		return group;
	}
	
	String getName() {
		return name;
	}
	
}
