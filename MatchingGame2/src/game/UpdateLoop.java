package game;

import data.Data;
import graphics.Window;

public class UpdateLoop implements Runnable, Data {
	@Override
	public void run() {
//		System.out.println("UPS: "+UPS);
		final long updateSpeed = 1000000000/UPS;
		long startTime = 0, wait = 0;
		while (true) {
			startTime = System.nanoTime();
			update();
			Window.getRenderer().repaint();
			wait = (updateSpeed-(System.nanoTime()-startTime))/1000000;
			try {
				if (wait>0) Thread.sleep(wait);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void update() {
		try {
		
			
			
		}
		catch (Exception e) {
			System.out.println("update error");
			e.printStackTrace();
		}
	}
}
