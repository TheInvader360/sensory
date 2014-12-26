package com.theinvader360.sensory.app.free.android;

import android.content.Intent;
import android.net.Uri;
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
  public void openUri(String uri) {
    Uri myUri = Uri.parse(uri);
    Intent intent = new Intent(Intent.ACTION_VIEW, myUri);
    startActivity(intent);
  }
  
  @Override
  public void quitApplication() {
    finish();
  }
  
}
