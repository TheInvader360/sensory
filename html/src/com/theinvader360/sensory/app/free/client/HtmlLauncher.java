package com.theinvader360.sensory.app.free.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.theinvader360.sensory.app.free.ActionResolver;
import com.theinvader360.sensory.app.free.Sensory;

public class HtmlLauncher extends GwtApplication implements ActionResolver {
  
  @Override
  public GwtApplicationConfiguration getConfig() {
    return new GwtApplicationConfiguration(480, 320);
  }
  
  @Override
  public ApplicationListener getApplicationListener() {
    return new Sensory(this);
  }
  
  @Override
  public void openUri(String uri) {
    // TODO
  }
  
  @Override
  public void quitApplication() {
    // TODO
  }

}
