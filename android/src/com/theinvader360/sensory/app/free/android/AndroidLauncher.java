package com.theinvader360.sensory.app.free.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.theinvader360.sensory.app.free.ActionResolver;
import com.theinvader360.sensory.app.free.Sensory;

public class AndroidLauncher extends AndroidApplication implements ActionResolver {
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
    config.useAccelerometer = false;
    config.useCompass = false;
    config.useImmersiveMode = true;
    initialize(new Sensory(this), config);
  }
  
  @Override
  public void quitApplication() {
    finish();
  }
  
}
