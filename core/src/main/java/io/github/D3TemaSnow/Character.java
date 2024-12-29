package io.github.D3TemaSnow;

import com.badlogic.gdx.graphics.Texture;

abstract public class Character {
    public float x;
    public float y;
    public float width;
    public float height;
    public Texture img;


    public Character(Texture img, float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.width = width;
        this.height = height;
    }

    boolean hit(float tx, float ty){
        return
            x < tx && tx < x + width && y < ty && ty < y + height;
    }
    abstract void onClick();
}
