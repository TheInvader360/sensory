package com.theinvader360.sensory.app.free;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class MenuScreen implements Screen {
  
  private Sensory sensory;
  private Stage stage;
  private Table table;
  private ShapeRenderer shapeRenderer;
  
  public MenuScreen(final Sensory sensory) {
    this.sensory = sensory;
    stage = new Stage();
    stage.setViewport(new StretchViewport(Sensory.WIDTH, Sensory.HEIGHT));
    table = new Table();
    table.setFillParent(true);
    table.defaults().pad(10);
    shapeRenderer = new ShapeRenderer();
    TextButton playButton = new TextButton("Start", Assets.instance.skins.uiSkin);
    playButton.addListener(new ClickListener() {
      public void clicked(InputEvent event, float x, float y) {
        sensory.setScreen(sensory.gameScreen);
      }
    });
    TextButton aboutButton = new TextButton("About", Assets.instance.skins.uiSkin);
    aboutButton.addListener(new ClickListener() {
      public void clicked(InputEvent event, float x, float y) {
        sensory.setScreen(sensory.aboutScreen);
      }
    });
    TextButton quitButton = new TextButton("Quit", Assets.instance.skins.uiSkin);
    quitButton.addListener(new ClickListener() {
      public void clicked(InputEvent event, float x, float y) {
        sensory.actionResolver.quitApplication();
      }
    });
    table.row();
    table.add(playButton).size(300, 100).fill();
    table.row();
    table.add(aboutButton).size(300, 30).fill();
    table.row();
    table.add(quitButton).size(300, 30).fill();
    stage.addActor(table);
  }
  
  @Override
  public void render(float delta) {
    Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    shapeRenderer.setProjectionMatrix(stage.getBatch().getProjectionMatrix());
    shapeRenderer.begin(ShapeType.Filled);
    shapeRenderer.rect(0, 0, Sensory.WIDTH, Sensory.HEIGHT, Color.BLUE, Color.CYAN, Color.YELLOW, Color.RED);
    shapeRenderer.end();
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
