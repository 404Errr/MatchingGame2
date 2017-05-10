package game;

import java.awt.image.BufferedImage;

import data.Data;

public class Item {
//	private BufferedImage image;//picture
	private String imageDir;//file directory/name
	private int grade;//grade level
	private String name;//name
	
	public Item(/*BufferedImage image, */String image, int group, String name) {
		this.imageDir = image;
		this.grade = group;
		this.name = name.substring(0, name.indexOf(".png"));//temporary
	}

	public BufferedImage getImage() {
//		return image;
		return Data.getImage(imageDir);
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
