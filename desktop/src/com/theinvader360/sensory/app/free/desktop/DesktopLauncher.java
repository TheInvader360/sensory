package com.theinvader360.sensory.app.free.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.theinvader360.sensory.app.free.Sensory;

public class DesktopLauncher {
  
  public static void main(String[] arg) {
    LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    config.width = 800;
    config.height = 480;
    new LwjglApplication(new Sensory(new ActionResolverDesktop()), config);
  }
  
}
