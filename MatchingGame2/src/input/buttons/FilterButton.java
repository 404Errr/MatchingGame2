package input.buttons;

public class FilterButton extends Button {

	private int num;
	private boolean on;
	
	public FilterButton(int x, int y, int width, int height, int num, boolean on) {
		super(x, y, width, height);
		this.num = num;
		this.on = on;
	}

	@Override
	public void click() {
		toggle();
	}

	public boolean isOn() {
		return on;
	}
	
	public void setOn(boolean on) {
		this.on = on;
	}
	
	public void toggle() {
		on = !on;
	}
	
	public int getNum() {
		return num;
	}

}
