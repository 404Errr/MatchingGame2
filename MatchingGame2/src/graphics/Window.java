package graphics;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import data.Data;
import input.Input;
import input.buttons.Button;
import input.buttons.ChoiceButton;
import input.buttons.NextButton;

@SuppressWarnings("serial")
public class Window extends JFrame implements Data {
	private Input input;
	private Renderer renderer;
	private List<Button> buttons;
	
	public Window() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);//maximize window
		input = new Input();
		addKeyListener(input);
		addMouseMotionListener(input);
		addMouseListener(input);
		addMouseWheelListener(input);
		initButtons();
		renderer = new Renderer();
		add(renderer);
		setVisible(true);
	}

	public void initButtons() {
		buttons = new ArrayList<>();
		buttons.add(new NextButton(BUTTON_NEXT_X, BUTTON_NEXT_Y, BUTTON_NEXT_WIDTH, BUTTON_NEXT_HEIGHT));
		if (BUTTON_CHOICE_GRID_X_COUNT*BUTTON_CHOICE_GRID_Y_COUNT<CHOICE_COUNT==TRUE) System.err.println("Not enough buttons");
		int i = 0;
		for (int y = 0;i<CHOICE_COUNT&&y<BUTTON_CHOICE_GRID_Y_COUNT;y++) {
			for (int x = 0;i<CHOICE_COUNT&&x<BUTTON_CHOICE_GRID_X_COUNT;x++) {
				buttons.add(new ChoiceButton(
					BUTTON_CHOICE_GRID_X+x*(BUTTON_CHOICE_WIDTH+BUTTON_SPACING), 
					BUTTON_CHOICE_GRID_Y+y*(BUTTON_CHOICE_HEIGHT+BUTTON_SPACING), 
					BUTTON_CHOICE_WIDTH,
					BUTTON_CHOICE_HEIGHT
				));
				i++;
			}
		}
//		for (int i = 0;i<;i++) {
//			buttons.add(new ChoiceButton(10+180*i, 80, 160, 60));
//		}
	}
	
	public Renderer getRenderer() {
		return renderer;
	}

	public List<Button> getButtons() {
		return buttons;
	}

	public Input getInput() {
		return input;
	}
	
	private static boolean TRUE = true;//ignore this
}
