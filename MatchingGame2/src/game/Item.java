package game;

import java.awt.image.BufferedImage;

public class Item {
	private BufferedImage image;
	private int grade;//grade level
	private String name;
	
	public Item(BufferedImage image, int group, String name) {
		this.image = image;
		this.grade = group;
		this.name = name.substring(0, name.indexOf(".png"));//temporary
	}

	public BufferedImage getImage() {
		return image;
	}

	public int getGrade() {
		return grade;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "grade: " + grade + ", name: " + name;
	}
	
	
	
}
