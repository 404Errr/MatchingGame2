package game;

import java.awt.image.BufferedImage;

import data.Data;

public class Item {
	private String imageName;//file name
	private int grade;//graduation year/grade
	private String name;//name

	public Item(String imageName, int grade, String name) {
		this.imageName = imageName;
		this.grade = grade;
		this.name = name.substring(0, name.indexOf(".png"));//temporary
	}

	public BufferedImage getImage() {
		return Data.getImage(imageName);
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
