package io.github.D3TemaSnow;


import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;


public class Snowman extends Character {
    public static final float WIDTH = 240;
    public static final float HEIGHT = 300;
    public Sound[] sounds;
    public int currentSound = 0;
    public Snowman(Texture img, float x, float y, Sound[] sounds){
        super(img, x, y, WIDTH, HEIGHT);
        this.sounds = sounds;
    }

    @Override
    void onClick() {
        if (sounds.length > 0) {
            sounds[currentSound].stop();
            currentSound ++;
            if (currentSound == sounds.length) {
                currentSound = 0;
            }
            sounds[currentSound].play();
        }
    }
}
