/*
By Jose Catarino

Bouncy Game, built for fun
Run on Processing

Previous version:

Current version:
      v0               // moving bar, moving ball with gravity motion

*/

int ballX = 400;                                // starting x-axis position of ball
int ballY = 400;                                // starting y-axis position of ball
int speed = 0;                                  // starting speed
int gravity = 1;                                // gravity constant
float angle = 0;                                // angle of deflection in x-axis
int barLength = 120;                            // half-length of bar
int barPos = barLength + (400 - barLength);     // correct position of bar to middle of bar

void setup () {

size(800, 800);
}



void draw() {

  background(0);
  block(600, 80);                               // place block at (x,y) location
  barMove();                                    // initialise bar and move with right and left arrow keys
  ball(ballX, ballY);                           // initialse ball
  ballBounceHeight(38);                         // set bouncing height, must be declared
  ballY += gravityBounce();                     // ball bounces with gravity
  ballX += bounceOffset();                      // ball is deflected depended on wich part of the bar it hits

  println(barPos);


}

void ballBounceHeight (int g) {
  if (ballY == 725 && ballX > (barPos - barLength) && ballX < (barPos + barLength)) {
    speed = -g;
  }
}

void block (int blockX, int blockY) {
  fill(151, 13, 13);
  rect(blockX, blockY, 70, 40);
}


void bar(int a) {
  fill(255);
  noStroke();
  rect(a - (barLength - 30), 750, (barLength - 30) * 2, 20);
  triangle(a - (barLength - 30), 750, a - barLength, 770, a - (barLength - 30), 770);
  triangle(a + (barLength - 30), 750, a + barLength, 770, a + (barLength - 30), 770);
}


void barMove() {
  bar(barPos);
  if (barPos <= 30){
    barPos = 30;
  }
  else if (barPos >= 770){
    barPos = 770;
  }
}


void ball(int b, int c) {
  fill(255);
  ellipse(b, c, 50, 50);
}


int gravityBounce() {
  if (speed >= 0) {
    speed = speed + gravity;
  }
  if (speed < 0) {
    speed = speed + gravity;
  }
  return speed;
}


void keyPressed (){
  if (key == CODED) {
    if (keyCode == LEFT) {
      barPos -= 50;
    }
    if (keyCode == RIGHT) {
      barPos += 50;
    }
  }
}


float bounceOffset() {
  if (ballX < 25 || ballX > 725) {
    angle = -angle;
  }
  if (ballY == 725 && ballX > (barPos - barLength) && ballX < (barPos + barLength)) {
    angle = angle + (barPos - ballX);
    angle = angle * -.05;
  }
  return angle;
}
