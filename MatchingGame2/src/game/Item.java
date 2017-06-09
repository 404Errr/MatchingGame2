package game;

import java.awt.image.BufferedImage;

import data.Data;

public class Item {
	private String imagePath;//file name and directory
	private int id;
	private int grade;//graduation year/grade
	private int timesShown;//how many times the item has been the correct answer
	private String name;//name of the item

	public Item(String imagePath) {
		this.imagePath = imagePath;
		this.grade = Data.IO.lookupGrade(imagePath);
		this.name = Data.IO.lookupName(imagePath);
		this.id = Data.IO.lookupId(imagePath);
	}

	public BufferedImage getImage() {//returns the image associated with this item
		return Data.IO.getImage(imagePath);
	}

	public int getGrade() {
		return grade;
	}

	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}

	public void shown() {
		timesShown++;
	}

	public int getTimesShown() {
		return timesShown;
	}
	
	public void setTimesShown(int timesShown) {
		this.timesShown = timesShown;
	}

	@Override
	public String toString() {
		return name+"\tgrade: "+grade+"\tid: "+id;
	}

	


}
