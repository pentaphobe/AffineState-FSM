
class CircleState extends BasicProcessingState {
    int col = color(random(256), random(256), random(256));
    
    public void onEnter() {
      println("Entered " + this.getName());
      background(0);
    }
    public void onExit() {
      println("Exited " + this.getName());
    }
    public void onUpdate() {
    }
    public void draw() {
      colorMode(HSB);
      noStroke();
      for (int i=0; i < 100; i++) {
        float x = random(width);
        float y = random(height);
        
        float dx = getOwner().mouseX - x;
        float dy = getOwner().mouseY - y;      
        float dist = sqrt(dx*dx + dy*dy) / (float)width;
        fill(hue(col), saturation(col), 360 * dist, 64);
        ellipse(x, y, random(100), random(100));
      }
      colorMode(RGB);
    }
    public void keyPressed() {
      col = color(random(256), random(256), random(256));
      if (getOwner().key == ' ') {
        setState("other");
      }
    }  
}