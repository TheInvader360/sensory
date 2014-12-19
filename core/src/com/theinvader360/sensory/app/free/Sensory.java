package com.theinvader360.sensory.app.free;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class Sensory extends Game {
  
  public static final float WIDTH = 800f;
  public static final float HEIGHT = 480f;
  public ActionResolver actionResolver;
  public MenuScreen menuScreen;
  public GameScreen gameScreen;
  
  public Sensory(ActionResolver actionResolver) {
    this.actionResolver = actionResolver;
  }
  
  @Override
  public void create() {
    Assets.instance.init();
    Gdx.input.setCatchBackKey(true);
    menuScreen = new MenuScreen(this);
    gameScreen = new GameScreen(this);
    setScreen(menuScreen);
  }
  
  @Override
  public void resume() {
    Assets.instance.init();
  }
  
  @Override
  public void dispose() {
    Assets.instance.dispose();
    menuScreen.dispose();
    gameScreen.dispose();
  }
  
}
