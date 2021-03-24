package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// будет хранить в себе общие свойства космических кораблей
public class Ship extends GameObject {

    public boolean isAlive = true;
    // список матриц для кадров анимации
    private List<int[][]> frames;
    // индекс текущего кадра анимации
    private int frameIndex;

    public Ship(double x, double y) {
        super(x, y);
    }

    // устанавливает матрицу и задает анимацию
    public void setStaticView(int[][] viewFrame) {
        setMatrix(viewFrame);
        frames = new ArrayList<>();
        frames.add(viewFrame);
        frameIndex = 0;
    }

    // передает кадры анимации
    // Он принимает массив кадров(матриц) и передает их списку frames.
    public void setAnimatedView(int[][]... viewFrames) {
        setMatrix(viewFrames[0]);
        frames = Arrays.asList(viewFrames);
        frameIndex = 0;
    }

    public Bullet fire() {
        return null;
    }

    public void kill() {
        isAlive = false;
    }

    // перключает на следующий кадр анимации
    // устанавливает в поле matrix следующий кадр анимации, если это возможно
    public void nextFrame() {
        frameIndex += 1;
        if (frameIndex < frames.size()) {
            matrix = frames.get(frameIndex);
        }
    }

    @Override
    public void draw(Game game) {
        super.draw(game);
        nextFrame();
    }
}
