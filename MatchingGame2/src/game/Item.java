package game;

import java.awt.image.BufferedImage;

import data.Data;

public class Item {
	private String imagePath;//file name and directory
	private int grade;//graduation year/grade
	private String name;//name of the item

	public Item(String imagePath, int grade) {
		this.imagePath = imagePath;
		this.grade = grade;
		this.name = imagePath;//temporary
	}

	public BufferedImage getImage() {//returns the image associated with the item
		return Data.getImage(imagePath);
	}

	public int getGrade() {
		return grade;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name+"\tgrade: "+grade;
	}



}
