package game;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

public class Item {
	BufferedImage image;
	List<String> details;
	
	public Item(BufferedImage image, String... details) {
		this.image = image;
		this.details = Arrays.asList(details);
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public List<String> getDetails() {
		return details;
	}
}
