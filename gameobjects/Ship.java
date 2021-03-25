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
    // петля анимации
    private boolean loopAnimation = false;

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
    public void setAnimatedView(boolean isLoopAnimation, int[][]... viewFrames) {
        loopAnimation = isLoopAnimation;
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
        frameIndex++;
        if (frameIndex >= frames.size() && loopAnimation) {
            frameIndex = 0;
        }
        if (frameIndex < frames.size()) {
            matrix = frames.get(frameIndex);
        }
    }

    @Override
    public void draw(Game game) {
        super.draw(game);
        nextFrame();
    }

    // будет возвращать false после того, как у "неживого" корабля отобразится вся анимация
    public boolean isVisible() {
        if (!isAlive && frameIndex >= frames.size()) {
            return false;
        } else {
            return true;
        }
    }
}
