package com.theinvader360.sensory.app.free;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class AboutScreen implements Screen {
  
  private Sensory sensory;
  private Stage stage;
  private Table table;
  
  public AboutScreen(final Sensory sensory) {
    this.sensory = sensory;
    stage = new Stage();
    stage.setViewport(new StretchViewport(Sensory.WIDTH, Sensory.HEIGHT));
    table = new Table();
    table.setFillParent(true);
    table.defaults().pad(10);
    TextButton menuButton = new TextButton("Menu", Assets.instance.skins.uiSkin);
    menuButton.addListener(new ClickListener() {
      public void clicked(InputEvent event, float x, float y) {
        sensory.setScreen(sensory.menuScreen);
      }
    });
    TextButton googleButton = new TextButton("Google Play", Assets.instance.skins.uiSkin);
    googleButton.addListener(new ClickListener() {
      public void clicked(InputEvent event, float x, float y) {
        sensory.actionResolver.openUri("https://play.google.com/store/apps/developer?id=TheInvader360");
      }
    });
    TextButton facebookButton = new TextButton("Facebook", Assets.instance.skins.uiSkin);
    facebookButton.addListener(new ClickListener() {
      public void clicked(InputEvent event, float x, float y) {
        sensory.actionResolver.openUri("http://www.facebook.com/TheInvader360");
      }
    });
    TextButton twitterButton = new TextButton("Twitter", Assets.instance.skins.uiSkin);
    twitterButton.addListener(new ClickListener() {
      public void clicked(InputEvent event, float x, float y) {
        sensory.actionResolver.openUri("http://twitter.com/TheInvader360");
      }
    });
    TextButton blogButton = new TextButton("Blog", Assets.instance.skins.uiSkin);
    blogButton.addListener(new ClickListener() {
      public void clicked(InputEvent event, float x, float y) {
        sensory.actionResolver.openUri("http://theinvader360.blogspot.co.uk");
      }
    });
    TextButton youtubeButton = new TextButton("Youtube", Assets.instance.skins.uiSkin);
    youtubeButton.addListener(new ClickListener() {
      public void clicked(InputEvent event, float x, float y) {
        sensory.actionResolver.openUri("http://www.youtube.com/user/TheInvader360");
      }
    });
    TextButton githubButton = new TextButton("Github", Assets.instance.skins.uiSkin);
    githubButton.addListener(new ClickListener() {
      public void clicked(InputEvent event, float x, float y) {
        sensory.actionResolver.openUri("http://github.com/TheInvader360");
      }
    });
    Label textLabel = new Label("", Assets.instance.skins.uiSkin);
    textLabel.setWrap(true);
    textLabel.setText(""
        + "TheInvader360 is an indie game developer making small, fun, casual games for mobile devices.\n"
        + "Thanks for playing, and don't forget to check out my other games :)\n"
        + "\n"
        + "Sensory is a small open source android app that demonstrates various LibGdx features.\n"
        + "* Touch the screen to trigger a particle effect\n"
        + "* Keep touching to spawn more particles (new particle effects triggered every 0.2 seconds)\n"
        + "* Multitouch enabled, touch up to 10 points at once to spawn from multiple touchpoints simultaneously\n"
        + "\n"
        + "Android software buttons are hidden in an effort to minimise accidental app closure.\n"
        + "Tap the unobtrusive close (x) button to close the play screen, then tap the quit button to quit the app.\n"
        + "\n"
        + "There are three main target audiences:\n"
        + "* Developers interested in LibGdx (particle effects, object pooling, multitouch, screen transitions, etc.)\n"
        + "* Babies - a little time spent interacting with this app should help improve hand-eye coordination.\n"
        + "* Children and adults with certain learning disabilites or special education needs.\n"
        + "");
    table.row().expandX();
    table.add(googleButton).size(110, 50);
    table.add(facebookButton).size(110, 50);
    table.add(twitterButton).size(110, 50);
    table.add(blogButton).size(110, 50);
    table.add(youtubeButton).size(110, 50);
    table.add(githubButton).size(110, 50);
    table.row();
    table.add(textLabel).colspan(6).align(Align.left);
    table.row();
    table.add(menuButton).size(300, 30).colspan(6).fill();
    stage.addActor(table);
  }
  
  @Override
  public void render(float delta) {
    Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    stage.act(delta);
    stage.draw();
  }
  
  @Override
  public void resize(int width, int height) {
    stage.getViewport().update(width, height, true);
  }
  
  @Override
  public void show() {
    Gdx.input.setInputProcessor(stage);
  }
  
  @Override
  public void hide() {
    Gdx.input.setInputProcessor(null);
  }
  
  @Override
  public void dispose() {
    stage.dispose();
  }
  
  @Override
  public void pause() {
  }
  
  @Override
  public void resume() {
  }
  
}
