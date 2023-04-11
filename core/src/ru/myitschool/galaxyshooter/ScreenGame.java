package ru.myitschool.galaxyshooter;

import static ru.myitschool.galaxyshooter.GalaxyShooter.SCR_HEIGHT;
import static ru.myitschool.galaxyshooter.GalaxyShooter.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;

public class ScreenGame implements Screen {
    GalaxyShooter gs;

    Texture imgSpaceSky;
    Texture imgShip;
    Texture imgEnemy;
    Texture imgShot;

    SpaceSky[] sky = new SpaceSky[2];
    SpaceShip ship;
    ArrayList<EnemyShip> enemy = new ArrayList<>();
    ArrayList<ShipShot> shots = new ArrayList<>();

    long timeEnemySpawn, timeEnemyInterval = 1500;
    long timeShotSpawn, timeShotInterval = 500;

    public ScreenGame(GalaxyShooter galaxyShooter){
        gs = galaxyShooter;

        imgSpaceSky = new Texture("stars.png");
        imgShip = new Texture("ship.png");
        imgEnemy = new Texture("enemy.png");
        imgShot = new Texture("shipshot.png");

        sky[0] = new SpaceSky(0);
        sky[1] = new SpaceSky(SCR_HEIGHT);
        ship = new SpaceShip(SCR_WIDTH/2, 100, 100, 100);
    }

    @Override
    public void show() {
        
    }

    @Override
    public void render(float delta) {
        // касания экрана
        if(Gdx.input.isTouched()){
            gs.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            gs.camera.unproject(gs.touch);
            ship.vx = (gs.touch.x - ship.x)/50;
        }

        // события игры
        for (int i = 0; i < sky.length; i++) {
            sky[i].move();
        }

        spawnEnemy();
        for (int i = 0; i < enemy.size(); i++) {
            enemy.get(i).move();
        }

        spawnShots();
        for (int i = 0; i < shots.size(); i++) {
            shots.get(i).move();
        }

        ship.move();

        // вывод изображений
        gs.camera.update();
        gs.batch.setProjectionMatrix(gs.camera.combined);
        gs.batch.begin();
        for (int i = 0; i < sky.length; i++) {
            gs.batch.draw(imgSpaceSky, sky[i].x, sky[i].y, sky[i].width, sky[i].height);
        }
        for (int i = 0; i < enemy.size(); i++) {
            gs.batch.draw(imgEnemy, enemy.get(i).getX(), enemy.get(i).getY(), enemy.get(i).width, enemy.get(i).height);
        }
        for (int i = 0; i < shots.size(); i++) {
            gs.batch.draw(imgShot, shots.get(i).getX(), shots.get(i).getY(), shots.get(i).width, shots.get(i).height);
        }
        gs.batch.draw(imgShip, ship.getX(), ship.getY(), ship.width, ship.height);
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
        imgSpaceSky.dispose();
        imgShip.dispose();
        imgEnemy.dispose();
        imgShot.dispose();
    }

    void spawnEnemy() {
        if(timeEnemySpawn+timeEnemyInterval < TimeUtils.millis()) {
            enemy.add(new EnemyShip(100, 100));
            timeEnemySpawn = TimeUtils.millis();
        }
    }

    void spawnShots() {
        if(timeShotSpawn+timeShotInterval < TimeUtils.millis()) {
            shots.add(new ShipShot(ship.x, ship.y, ship.width, ship.height));
            timeShotSpawn = TimeUtils.millis();
        }
    }
}
