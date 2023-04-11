package ru.myitschool.galaxyshooter;

public class ShipShot extends GalaxyObject{
    public ShipShot(float x, float y, float width, float height) {
        super(x, y, width, height);
        vy = 8;
    }

    @Override
    void move() {
        super.move();
        outOfScreen();
    }

    boolean outOfScreen() {
       return y > height/2;
    }
}
