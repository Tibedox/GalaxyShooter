package ru.myitschool.galaxyshooter;

import static ru.myitschool.galaxyshooter.GalaxyShooter.SCR_HEIGHT;
import static ru.myitschool.galaxyshooter.GalaxyShooter.SCR_WIDTH;

import com.badlogic.gdx.math.MathUtils;

public class FragmentShip extends GalaxyObject{
    public FragmentShip(float x, float y, float size) {
        super(x, y, 0, 0);
        width = MathUtils.random(size/10, size/4);
        height = MathUtils.random(size/10, size/4);
        vx = MathUtils.random(-5f, 5f);
        vy = MathUtils.random(-5f, 5f);
    }

    boolean outOfScreen() {
       return x < -width/2 || x > SCR_WIDTH + width/2 || y < - height/2 || y > SCR_HEIGHT + height/2;
    }
}
