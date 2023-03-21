package ru.myitschool.galaxyshooter;

import static ru.myitschool.galaxyshooter.GalaxyShooter.SCR_HEIGHT;
import static ru.myitschool.galaxyshooter.GalaxyShooter.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenSettings implements Screen {
    GalaxyShooter gs;
    InputKeyboard keyboard; // экранная клавиатура

    Texture imgBackGround;

    TextButton btnName;
    TextButton btnSound;
    TextButton btnMusic;
    TextButton btnClearTable;
    TextButton btnBack;

    // состояние - вводим ли имя?
    boolean isEnterName;

    public ScreenSettings(GalaxyShooter galaxyShooter){
        gs = galaxyShooter;
        keyboard = new InputKeyboard(SCR_WIDTH, SCR_HEIGHT/2, 10);
        imgBackGround = new Texture("space01.jpg");
        btnName = new TextButton(gs.font, "Name: "+gs.playerName, 100, 700);
        btnSound = new TextButton(gs.font, "Sound on", 100, 600);
        btnMusic = new TextButton(gs.font, "Music on", 100, 500);
        btnClearTable = new TextButton(gs.font, "Clear records", 100, 400);
        btnBack = new TextButton(gs.font, "Back", 100, 100);
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
            if(isEnterName) {
                if(keyboard.endOfEdit(gs.touch.x, gs.touch.y)){
                    isEnterName = false;
                    gs.playerName = keyboard.getText();
                    btnName.text = "Name: "+gs.playerName;
                }
            } else {
                if (btnName.hit(gs.touch.x, gs.touch.y)) {
                    isEnterName = true;
                }
                if (btnSound.hit(gs.touch.x, gs.touch.y)) {
                    gs.sound = !gs.sound;
                    if (gs.sound) {
                        btnSound.text = "Sound on";
                    } else {
                        btnSound.text = "Sound off";
                    }
                }
                if (btnMusic.hit(gs.touch.x, gs.touch.y)) {
                    gs.music = !gs.music;
                    if (gs.music) {
                        btnMusic.text = "Music on";
                    } else {
                        btnMusic.text = "Music off";
                    }
                }
                if (btnClearTable.hit(gs.touch.x, gs.touch.y)) {
                    btnClearTable.text = "Records cleared";
                }
                if (btnBack.hit(gs.touch.x, gs.touch.y)) {
                    gs.setScreen(gs.screenIntro);
                    btnClearTable.text = "Clear records";
                }
            }
        }

        // события игры


        // вывод изображений
        gs.camera.update();
        gs.batch.setProjectionMatrix(gs.camera.combined);
        gs.batch.begin();
        gs.batch.draw(imgBackGround, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnName.font.draw(gs.batch, btnName.text, btnName.x, btnName.y);
        btnSound.font.draw(gs.batch, btnSound.text, btnSound.x, btnSound.y);
        btnMusic.font.draw(gs.batch, btnMusic.text, btnMusic.x, btnMusic.y);
        btnClearTable.font.draw(gs.batch, btnClearTable.text, btnClearTable.x, btnClearTable.y);
        btnBack.font.draw(gs.batch, btnBack.text, btnBack.x, btnBack.y);
        if(isEnterName) {
            keyboard.draw(gs.batch);
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
        imgBackGround.dispose();
        keyboard.dispose();
    }
}
