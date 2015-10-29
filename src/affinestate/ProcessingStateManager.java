package affinestate;

import affinestate.ProcessingState;
import processing.core.*;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class ProcessingStateManager extends StateManager<ProcessingState> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PApplet applet;
	String[] methods = { "draw", "mouseEvent", "keyEvent", "stop", "dispose" };
	public int mouseX, mouseY;
	public int pmouseX, pmouseY;
	public int key, keyCode;

	public ProcessingStateManager(PApplet applet) {
		super();
		this.applet = applet;

		for (String methodName : methods) {
			applet.registerMethod(methodName, this);
		}
	}

	public void draw() {
		onUpdate();
		if (currentState != null) {
			currentState.draw();
		}
		pmouseX = mouseX;
		pmouseY = mouseY;		
	}

	public void mouseEvent(MouseEvent e) {
		if (currentState == null) return;
		
		mouseX = e.getX();
		mouseY = e.getY();

		switch (e.getAction()) {
		case MouseEvent.PRESS:
			currentState.mousePressed();
			break;
		case MouseEvent.RELEASE:
			currentState.mouseReleased();
			break;
		case MouseEvent.DRAG:
			currentState.mouseDragged();
			break;
		case MouseEvent.CLICK:
			currentState.mouseClicked();
			break;
		case MouseEvent.MOVE:
			currentState.mouseMoved();
			break;
		}
	}

	public void keyEvent(KeyEvent e) {
		if (currentState == null) return;
		
		key = e.getKey();
		keyCode = e.getKeyCode();

		switch (e.getAction()) {
		case KeyEvent.PRESS:
			currentState.keyPressed();
			break;
		case KeyEvent.RELEASE:
			currentState.keyReleased();
			break;
		}

	}

	public void stop() {
		if (currentState == null) return;
		
		currentState.stop();
	}

	public void dispose() {
		if (currentState == null) return;
		
		currentState.dispose();
	}
}