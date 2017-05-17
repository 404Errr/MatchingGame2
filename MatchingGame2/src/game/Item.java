package game;

import java.awt.image.BufferedImage;

import data.Data;

public class Item {
	private String imagePath;//file name and directory
	private int grade;//graduation year/grade
	private int timesShown;//how many times the item has been the correct answer
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

	public void shown() {
		timesShown++;
	}

	public int getTimesShown() {
		return timesShown;
	}

	@Override
	public String toString() {
		return name+"\tgrade: "+grade;
	}



}
