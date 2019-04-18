package com.ray3k.hotswaptest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Core extends ApplicationAdapter {
    private Stage stage;
    private Skin skin;

	@Override
	public void create () {
        skin = new Skin(Gdx.files.internal("clean-crispy-ui.json"));
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        Table root = new Table();
        root.setFillParent(true);
        stage.addActor(root);

        Table table = new Table();
        table.setBackground(skin.getDrawable("textfield"));
        root.add(table).size(300, 150);

        table.defaults().uniform().fill();
        TextButton textButton = new TextButton("Resume", skin);
        table.add(textButton);

        table.row();
        textButton = new TextButton("Quit", skin);
        table.add(textButton);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act();
		stage.draw();

		if (Gdx.input.isKeyJustPressed(Input.Keys.F5)) {
		    dispose();
		    create();
        }
	}

    @Override
    public void resize(int width, int height) {
	    stage.getViewport().update(width, height, true);
    }

    @Override
	public void dispose () {
	    stage.dispose();
	    skin.dispose();
	}
}
