package affinestate;
import processing.core.*;

abstract public class ProcessingState extends BasicState<ProcessingStateManager> {
  abstract public void draw();
  abstract public void mousePressed();
  abstract public void mouseReleased();
  abstract public void mouseDragged();
  abstract public void mouseClicked();
  abstract public void mouseMoved();
  abstract public void keyPressed();
  abstract public void keyReleased();
  abstract public void stop();
  abstract public void dispose();
}

