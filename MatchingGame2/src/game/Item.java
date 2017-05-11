package game;

import java.awt.image.BufferedImage;

import data.Data;

public class Item {
	private String imagePath;//file name
	private int grade;//graduation year/grade
	private String name;//name

	public Item(String imagePath, int grade) {
		this.imagePath = imagePath;
		this.grade = grade;
		this.name = imagePath;//temporary
	}

	public BufferedImage getImage() {
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
		return "grade: " + grade + ", name: " + name;
	}



}
