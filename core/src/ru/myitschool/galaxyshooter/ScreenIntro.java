package ru.myitschool.galaxyshooter;

import static ru.myitschool.galaxyshooter.GalaxyShooter.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenIntro implements Screen {
    GalaxyShooter gs;
    Texture imgBackGround; // фоновое изображение
    TextButton btnPlay;
    TextButton btnSettings;
    TextButton btnAbout;
    TextButton btnExit;

    public ScreenIntro(GalaxyShooter galaxyShooter){
        gs = galaxyShooter;
        imgBackGround = new Texture("space00.jpg");
        btnPlay = new TextButton(gs.font, "Play", 100, 500);
        btnSettings = new TextButton(gs.font, "Settings", 100, 400);
        btnAbout = new TextButton(gs.font, "About", 100, 300);
        btnExit = new TextButton(gs.font, "Exit", 100, 200);
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
            if(btnPlay.hit(gs.touch.x, gs.touch.y)){
                gs.setScreen(gs.screenGame);
            }
            if(btnSettings.hit(gs.touch.x, gs.touch.y)){
                gs.setScreen(gs.screenSettings);
            }
            if(btnAbout.hit(gs.touch.x, gs.touch.y)){
                gs.setScreen(gs.screenAbout);
            }
            if(btnExit.hit(gs.touch.x, gs.touch.y)){
                Gdx.app.exit();
            }
        }

        // события игры


        // вывод изображений
        gs.camera.update();
        gs.batch.setProjectionMatrix(gs.camera.combined);
        gs.batch.begin();
        gs.batch.draw(imgBackGround, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnPlay.font.draw(gs.batch, btnPlay.text, btnPlay.x, btnPlay.y);
        btnSettings.font.draw(gs.batch, btnSettings.text, btnSettings.x, btnSettings.y);
        btnAbout.font.draw(gs.batch, btnAbout.text, btnAbout.x, btnAbout.y);
        btnExit.font.draw(gs.batch, btnExit.text, btnExit.x, btnExit.y);
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
        imgBackGround.dispose();
    }
}
