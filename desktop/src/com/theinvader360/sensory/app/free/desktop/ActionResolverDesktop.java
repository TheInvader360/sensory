package com.theinvader360.sensory.app.free.desktop;

import com.theinvader360.sensory.app.free.ActionResolver;

public class ActionResolverDesktop implements ActionResolver {
  
  @Override
  public void openUri(String uri) {
    System.out.println("Open URI: " + uri);
  }

  @Override
  public void quitApplication() {
    System.exit(0);
  }
  
}
