
class LineState extends BasicProcessingState {
    int col = color(255);
    float scale = 1;
    
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
      stroke(col, 32);
      final ProcessingStateManager owner = getOwner();
      
      float dX = owner.mouseX - owner.pmouseX;
      float dY = owner.mouseY - owner.pmouseY;
      float dist = sqrt(dX*dX + dY*dY);
      if (dist > scale) {
        scale = lerp(scale, dist, 0.1);
      } else {
        scale = lerp(scale, dist, 0.01);
      }
      dist *= scale;
      dist += 10;
      for (int i=0; i < 20; i++) {
        float ang = random(-PI, PI);
        line(owner.mouseX, owner.mouseY, owner.mouseX + dist*cos(ang), owner.mouseY + dist*sin(ang));
      }
      
      shadowText(String.format("%.2f : %.2f", dist, scale), 20, 60);
    }
    public void keyPressed() {
      if (getOwner().key == ' ') {
        setState("main");
      }
    }  
}