package game;

import java.awt.image.BufferedImage;

public class Item {
	private BufferedImage image;
	private int group;//grade level
	private String name;
	
	public Item(BufferedImage image, int group, String name) {
		this.image = image;
		this.group = group;
		this.name = name.substring(0, name.indexOf(".png"));
	}

	public BufferedImage getImage() {
		return image;
	}

	public int getGroup() {
		return group;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "grade: " + group + ", name: " + name;
	}
	
	
	
}
