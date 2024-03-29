package ru.myitschool.galaxyshooter;

import static ru.myitschool.galaxyshooter.GalaxyShooter.SCR_WIDTH;

public class SpaceShip extends GalaxyObject{
    int lives = 1; // количество жизней

    public SpaceShip(float x, float y, float width, float height) {
        super(x, y, width, height); // передаём параметры в родительский класс
    }

    @Override
    void move() {
        super.move(); // вызываем move родителя
        outOfScreen(); // проверка на вылет за пределы экрана
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
