/**
 * Description: using loops to draw sequences of objects
 * @author: EdricLai
*/

import processing.core.PApplet;

public class Sketch extends PApplet {
  /*
   * called once
   * global variables
   */
  int intWidth = 600;
  int intHeight = 600;
  float fltQuadWidth = intWidth / 2;
  float fltQuadHeight = intHeight / 2;
  float fltSpaceX;
  float fltSpaceY;
  float fltPosX;
  float fltPosY;
  float fltRotation;

  /**
   * called once
   * initial general settings
  */
  public void settings() {
    // screen size
    size(intWidth, intHeight);
  }

  /** 
   * called once
   * initial sketch settings
   */
  public void setup() {
    // global settings
    strokeWeight(intWidth * intHeight / 100000);
    background(255, 255, 255);

    // quadrant 1: draws circles
    // initializes variables
    fltSpaceX = fltQuadWidth / 6;
    fltSpaceY = fltQuadHeight / 6;
    // repeated horizontally
    for (fltPosX = fltQuadWidth + fltSpaceX; fltPosX <= fltQuadWidth * 2 - fltSpaceX; fltPosX += fltSpaceX){
      // repeated vertically
      for (fltPosY = 0 + fltSpaceY; fltPosY <= fltQuadHeight - fltSpaceY; fltPosY += fltSpaceY){
        // draws circles
        fill(255, 0, 155);
        ellipse(fltPosX, fltPosY, fltQuadWidth / 10, fltQuadHeight / 10);
      }
    }

    // quadrant 2: draws lines
    // initializes variables
    fltSpaceX = fltQuadWidth / 9;
    fltSpaceY = fltQuadHeight / 9;
    // repeated horizontally
    for (fltPosX = 0; fltPosX <= fltQuadWidth; fltPosX += fltSpaceX){
      line(fltPosX, 0, fltPosX, fltQuadHeight);
    }
    // repeated vertically
    for (fltPosY = 0; fltPosY <= fltQuadHeight; fltPosY += fltSpaceY){
      line(0, fltPosY, fltQuadWidth, fltPosY);
    }

    // quadrant 4: draws flower
    // translates system origin to quadrant 4
    translate(fltQuadWidth * 1.5f, fltQuadHeight * 1.5f);
    // repeats 8 times
    for (int i = 0; i <= 7; i++){
        // rotates and draws petal every iteration
        rotate(radians(45));
        fill(255, 155, 0);
        ellipse(0, fltQuadHeight / 5, fltQuadWidth / 10, fltQuadHeight / 3);
    }
    // draws center of flower
    fill(0, 155, 0);
    ellipse(0, 0, fltQuadWidth / 5, fltQuadHeight / 5);

    // quadrant 3: draws gradient
    // translates system origin to 0,0
    translate(fltQuadWidth * -1.5f, fltQuadHeight * -1.5f);
    // initializes variables
    fltSpaceX = fltQuadWidth / 300;
    // repeated horizontally
    for (fltPosX = 0; fltPosX <= fltQuadWidth; fltPosX += fltSpaceX){
        // draws brighter line every iteration
        stroke(fltPosX * 0.75f, fltPosX * 0.75f, fltPosX * 0.75f);
        line(fltPosX, fltQuadHeight, fltPosX, fltQuadHeight * 2);
    }
  }
}