package com.theinvader360.sensory.app.free;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable {
  
  public static final Assets instance = new Assets();
  private AssetManager assetManager;
  public AssetSkins skins;
  public AssetParticles particles;
  public AssetSounds sounds;
  
  private Assets() {
  }
  
  public void init() {
    if (assetManager == null) assetManager = new AssetManager();
    assetManager.load("uiskin.json", Skin.class);
    assetManager.load("burst.p", ParticleEffect.class);
    assetManager.load("sound.wav", Sound.class);
    assetManager.finishLoading();
    skins = new AssetSkins(assetManager);
    particles = new AssetParticles(assetManager);
    sounds = new AssetSounds(assetManager);
  }
  
  @Override
  public void dispose() {
    assetManager.dispose();
    assetManager = null;
  }
  
  public class AssetSkins {
    public final Skin uiSkin;
    
    public AssetSkins(AssetManager am) {
      uiSkin = am.get("uiskin.json", Skin.class);
      uiSkin.getFont("default-font").getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
    }
  }
  
  public class AssetParticles {
    public final ParticleEffect burst;
    public final ParticleEffectPool burstPool;
    
    public AssetParticles(AssetManager am) {
      burst = am.get("burst.p", ParticleEffect.class);
      burstPool = new ParticleEffectPool(burst, 1, 100);
    }
  }
  
  public class AssetSounds {
    public final Sound sound;
    
    public AssetSounds(AssetManager am) {
      sound = am.get("sound.wav", Sound.class);
    }
  }
  
}
