package ru.myitschool.galaxyshooter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class ImageButton {
    float x, y;
    float width, height;
    Texture img;

    public ImageButton(Texture img, float x, float y, float width, float height){
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    boolean hit(float tx, float ty){
        return x < tx && tx < x+width && y < ty && ty < y+height;
    }
}
