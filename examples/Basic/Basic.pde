import affinestate.*;

ProcessingStateManager psm;

void setup() {
  size(800, 600);
  smooth();
  
  psm = new ProcessingStateManager(this);
  
  psm.put("main", new CircleState());
  
  psm.put("other", new LineState());  

  psm.setState("main");
}


void draw() {
  shadowText("Press <SPACE> to change states, any other key to alter colours", 20, 20);
}

void shadowText(String txt, float x, float y) {
  fill(64);
  rect(x - 20, y - 20, x + textWidth(txt) + 20, 30);
  fill(0);
  textSize(22);
  text(txt, x, y);
  fill(255);
  text(txt, x + 1, y + 1);
  
}