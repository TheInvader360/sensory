package com.theinvader360.sensory.app.free;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;

import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration;
import com.theinvader360.sensory.app.free.Sensory;

public class IOSLauncher extends IOSApplication.Delegate implements ActionResolver {

  @Override
  protected IOSApplication createApplication() {
    IOSApplicationConfiguration config = new IOSApplicationConfiguration();
    return new IOSApplication(new Sensory(this), config);
  }
  
  public static void main(String[] argv) {
    NSAutoreleasePool pool = new NSAutoreleasePool();
    UIApplication.main(argv, null, IOSLauncher.class);
    pool.close();
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
