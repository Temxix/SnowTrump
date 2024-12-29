//package io.github.D3TemaSnow;
//
//import com.badlogic.gdx.audio.Sound;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.math.MathUtils;
//
//public class Wasp extends Character {
//    public Wasp(float x, float y, Texture img, Sound snd, Sound snd1){
//        super(x, y, img, snd, snd1);
//    }
//
//    @Override
//    void onClick() {
//        stepX = 0;
//        stepY = -10;
//        isLeave = true;
//    }
//    public void fly(){
//        x += stepX;
//        y += stepY;
//
//        if (y < -100) {
//            x = MathUtils.random(width + 20, SCR_WIDTH-20-width);
//            y = SCR_HEIGHT + 20 + height;
//            stepX = MathUtils.random(-0.5f, 0);
//            stepY = MathUtils.random(-1f, -2f);
//        }
//    }
//
//    boolean hit(float tx, float ty){
//        return x<tx && tx<x+width && y<ty && ty<y+height;
//    }
//}
