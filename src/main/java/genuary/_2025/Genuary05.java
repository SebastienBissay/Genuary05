package genuary._2025;

import processing.core.PApplet;

import static genuary._2025.parameters.Parameters.*;
import static genuary._2025.save.SaveUtil.saveSketch;

public class Genuary05 extends PApplet {
    public static void main(String[] args) {
        PApplet.main(Genuary05.class);
    }

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
        randomSeed(SEED);
    }

    @Override
    public void setup() {
        background(BACKGROUND_COLOR.red(), BACKGROUND_COLOR.green(), BACKGROUND_COLOR.green());
        stroke(STROKE_COLOR.red(), STROKE_COLOR.green(), STROKE_COLOR.blue(), STROKE_COLOR.alpha());
        noLoop();
    }

    @Override
    public void draw() {
        for (int i = 0; i < WIDTH / 2; i++) {
            if (random(1) < DARK_PROBABILITY) {
                fill(FILL_COLOR.red(), FILL_COLOR.green(), FILL_COLOR.blue(), FILL_COLOR.alpha());
            } else {
                fill(BACKGROUND_COLOR.red(), BACKGROUND_COLOR.green(), BACKGROUND_COLOR.blue());
            }
            drawParallelepiped(random(MARGIN, WIDTH - MARGIN), random(MARGIN, HEIGHT - MARGIN),
                    SCALE * floor(random(MIN_WIDTH, MAX_WIDTH)),
                    SCALE * floor(random(MIN_HEIGHT, MAX_HEIGHT)),
                    SCALE * floor(random(MIN_DEPTH, MAX_DEPTH)));
        }
        saveSketch(this);
    }

    private void drawParallelepiped(float x, float y, float width, float height, float depth) {
        beginShape();
        vertex(x + width, y + height);
        vertex(x, y + height);
        vertex(x, y);
        vertex(x + depth * cos(ANGLE), y - depth * sin(ANGLE));
        vertex(x + width + depth * cos(ANGLE), y - depth * sin(ANGLE));
        vertex(x + width + depth * cos(ANGLE), y + height - depth * sin(ANGLE));
        vertex(x + width, y + height);
        vertex(x + width, y);
        vertex(x + width + depth * cos(ANGLE), y - depth * sin(ANGLE));
        endShape();
        line(x, y, x + width, y);
    }
}