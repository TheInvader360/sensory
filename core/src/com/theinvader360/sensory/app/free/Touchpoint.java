package com.theinvader360.sensory.app.free;

import com.badlogic.gdx.math.MathUtils;

public class Touchpoint {
  
  public static float TIMER_MAX = 0.2f;
  private float[] color;
  private float x;
  private float y;
  private float timer = TIMER_MAX;
  
  public Touchpoint(float x, float y) {
    assignColor();
    setPosition(x, y);
  }
  
  public float[] getColor() {
    return color;
  }
  
  public float getX() {
    return x;
  }
  
  public float getY() {
    return y;
  }
  
  public float getTimer() {
    return timer;
  }
  
  public void setPosition(float x, float y) {
    this.x = x;
    this.y = y;
  }
  
  private void assignColor() {
    int rand = MathUtils.random(0, 12);
    if (rand == 0) color = new float[] { 1.0f, 0.0f, 0.0f };
    if (rand == 1) color = new float[] { 1.0f, 0.5f, 0.0f };
    if (rand == 2) color = new float[] { 1.0f, 1.0f, 0.0f };
    if (rand == 3) color = new float[] { 0.5f, 1.0f, 0.0f };
    if (rand == 4) color = new float[] { 0.0f, 1.0f, 0.0f };
    if (rand == 5) color = new float[] { 0.0f, 1.0f, 0.5f };
    if (rand == 6) color = new float[] { 0.0f, 1.0f, 1.0f };
    if (rand == 7) color = new float[] { 0.0f, 0.5f, 1.0f };
    if (rand == 8) color = new float[] { 0.0f, 0.0f, 1.0f };
    if (rand == 9) color = new float[] { 0.5f, 0.0f, 1.0f };
    if (rand == 10) color = new float[] { 1.0f, 0.0f, 1.0f };
    if (rand == 11) color = new float[] { 1.0f, 0.0f, 0.5f };
    if (rand == 12) color = new float[] { 1.0f, 1.0f, 1.0f };
  }
  
  public void resetTimer() {
    timer = 0;
  }
  
  public void update(float delta) {
    timer += delta;
  }
  
}
