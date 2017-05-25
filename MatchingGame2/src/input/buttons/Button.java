package input.buttons;

import input.Cursor;

public abstract class Button {
	protected int x, y, width, height;
//	protected boolean hovered;
	
	public Button(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public abstract void click();
	
	public boolean contains(Cursor cursor) {
		return cursor.getX()>=x&&cursor.getX()<=x+width&&cursor.getY()>=y&&cursor.getY()<=y+height;
	}
	
//	public boolean isHovered() {
//		return hovered;
//	}

//	public void setHovered(boolean hovered) {
//		this.hovered = hovered;
//	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "Button\t"+x+","+y+"\t"+width+", "+height;
	}
	
	
}
