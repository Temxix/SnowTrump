package io.github.D3TemaSnow;

import static io.github.D3TemaSnow.Main.SCR_HEIGHT;
import static io.github.D3TemaSnow.Main.SCR_WIDTH;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

public class Snow extends Character {
    float stepX;
    float stepY;
    public Snow(Texture img, float x, float y, float size){
        super(img, x, y, size, size);
        stepX = MathUtils.random(-0.5f, 0);
        stepY = MathUtils.random(-1f, -2f);
    }

    @Override
    void onClick() {
        stepY = -10;
    }
    public void fly(){
        x += stepX;
        y += stepY;

        if (y < -100) {
            x = MathUtils.random(width + 20, SCR_WIDTH-20-width);
            y = SCR_HEIGHT + 20 + height;
            stepX = MathUtils.random(-0.5f, 0);
            stepY = MathUtils.random(-1f, -2f);
        }
    }
}
