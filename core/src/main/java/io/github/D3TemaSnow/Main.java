package io.github.D3TemaSnow;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public class Main extends ApplicationAdapter {
    public static final float SCR_WIDTH = 1600;
    public static final float SCR_HEIGHT = 900;
    public SpriteBatch batch;
    public Vector3 touch;

    public Texture imgBackGround;
    public Texture imgSnow;
    public Texture imgSnowman;
    public Sound snd1;
    public Sound snd2;
    public Snow[] snow = new Snow[200];
    public Snowman snowman;

    @Override
    public void create() {
        batch = new SpriteBatch();
        imgBackGround = new Texture("background.jpg");
        touch = new Vector3();
        imgSnow = new Texture("wasp.jpg");
        imgSnowman = new Texture("trump.jpg");
        snd1 = Gdx.audio.newSound(Gdx.files.internal("wasp.mp3"));
        snd2 = Gdx.audio.newSound(Gdx.files.internal("trump.mp3"));
        snowman = new Snowman(imgSnowman,200,100, snd1);
        for (int i = 0; i < snow.length; i++) {
            int size = MathUtils.random(70, 120);
            int x = (int) MathUtils.random(size + 20, SCR_WIDTH - 20 - size);
            int y = (int) (SCR_HEIGHT + 20 + size + MathUtils.random(0, SCR_HEIGHT));
            snow[i] = new Snow(imgSnow,x,y, size);

        }


    }

    @Override
    public void render() {
        if (Gdx.input.justTouched()) {
            touch.set(Gdx.input.getX(), (SCR_HEIGHT - Gdx.input.getY()), 0);
            if (snowman.hit(touch.x, touch.y)) {
                snowman.onClick();
            }

            for (Snow w : snow){
                if (w.hit(touch.x, touch.y)) {
                    w.onClick();
                }
            }
        }
        for (Snow w : snow) w.fly();
        batch.begin();
        batch.draw(imgBackGround, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        batch.draw(snowman.img, snowman.x, snowman.y, snowman.width, snowman.height);
        for (Snow w : snow) {
            batch.draw(w.img, w.x, w.y, w.width, w.height);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        imgBackGround.dispose();
        imgSnow.dispose();
        imgSnowman.dispose();
        snd1.dispose();
        snd2.dispose();
    }
}
