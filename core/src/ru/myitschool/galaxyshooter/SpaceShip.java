package ru.myitschool.galaxyshooter;

import static ru.myitschool.galaxyshooter.GalaxyShooter.SCR_WIDTH;

public class SpaceShip extends GalaxyObject{
    public SpaceShip(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    @Override
    void move() {
        super.move();
        outOfScreen();
    }

    void outOfScreen() {
        if(x<0 + width/2){
            vx = 0;
            x = 0 + width/2;
        }
        if(x>SCR_WIDTH - width/2) {
            vx = 0;
            x = SCR_WIDTH - width/2;
        }
    }
}
