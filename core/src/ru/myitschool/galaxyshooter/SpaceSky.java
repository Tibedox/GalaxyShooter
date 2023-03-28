package ru.myitschool.galaxyshooter;

import static ru.myitschool.galaxyshooter.GalaxyShooter.SCR_HEIGHT;
import static ru.myitschool.galaxyshooter.GalaxyShooter.SCR_WIDTH;

public class SpaceSky extends GalaxyObject{

    public SpaceSky(float y) {
        super(0, y, SCR_WIDTH, SCR_HEIGHT);
        vy = -1;
    }

    @Override
    void move() {
        super.move();
        outOfScreen();
    }

    void outOfScreen() {
        if(y<-height) {
            y = height;
        }
    }
}
