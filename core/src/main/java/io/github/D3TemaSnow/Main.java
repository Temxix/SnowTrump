package io.github.D3TemaSnow;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class Main extends ApplicationAdapter {
    public static final float SCR_WIDTH = 1600;
    public static final float SCR_HEIGHT = 900;
    public SpriteBatch batch;
    public Vector3 touch;

    public Texture imgBackGround;
//    public Texture imgWasp;
    public Texture imgTrump;
//    public Sound sndWasp;
    public Sound sndTrump;
//    public Wasp[] wasp = new Wasp[200];
    public Trump trump;

    @Override
    public void create() {
        batch = new SpriteBatch();
        imgBackGround = new Texture("background.jpg");
        touch = new Vector3();
//        imgWasp = new Texture("wasp.jpg");
        imgTrump = new Texture("trump.jpg");
//        sndWasp = Gdx.audio.newSound(Gdx.files.internal("wasp.mp3"));
        sndTrump = Gdx.audio.newSound(Gdx.files.internal("trump.mp3"));
        trump = new Trump(imgTrump,200,200, sndTrump);
    }

    @Override
    public void render() {
        if (Gdx.input.justTouched()) {
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (trump.hit(touch.x, touch.y)) {
                trump.onClick();
            }
        }

        batch.begin();
        batch.draw(imgBackGround, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        batch.draw(trump.img, trump.x, trump.y, trump.width, trump.height);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        imgBackGround.dispose();
//        imgWasp.dispose();
        imgTrump.dispose();
//        sndWasp.dispose();
        sndTrump.dispose();
    }
}
