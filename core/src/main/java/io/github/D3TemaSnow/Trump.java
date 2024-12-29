package io.github.D3TemaSnow;


import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;


public class Trump extends Character {
    public Sound sound;
    public Trump(Texture img, float x, float y, Sound sound){
        super(img, x, y, 300, 300);
        this.sound = sound;
    }

    @Override
    void onClick() {
        sound.play();
//        snd.stop();
//        snd1.stop();
//        if (isLeav) {
//            snd.play();
//            isLeav = false;
//        } else {
//            snd1.play();
//            isLeav = true;
//        }
    }
}
