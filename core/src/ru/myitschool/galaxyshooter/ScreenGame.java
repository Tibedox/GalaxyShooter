package ru.myitschool.galaxyshooter;

import static ru.myitschool.galaxyshooter.GalaxyShooter.SCR_HEIGHT;
import static ru.myitschool.galaxyshooter.GalaxyShooter.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenGame implements Screen {
    GalaxyShooter gs;

    Texture imgSpaceSky;

    SpaceSky[] sky = new SpaceSky[2];

    public ScreenGame(GalaxyShooter galaxyShooter){
        gs = galaxyShooter;

        imgSpaceSky = new Texture("gifcosmos.png");

        sky[0] = new SpaceSky(0);
        sky[1] = new SpaceSky(SCR_HEIGHT);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // касания экрана
        if(Gdx.input.justTouched()){
            gs.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            gs.camera.unproject(gs.touch);
        }

        // события игры
        for (int i = 0; i < sky.length; i++) {
            sky[i].move();
        }

        // вывод изображений
        gs.camera.update();
        gs.batch.setProjectionMatrix(gs.camera.combined);
        gs.batch.begin();
        for (int i = 0; i < sky.length; i++) {
            gs.batch.draw(imgSpaceSky, sky[i].x, sky[i].y, sky[i].width, sky[i].height);
        }

        gs.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
