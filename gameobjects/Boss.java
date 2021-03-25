package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.ShapeMatrix;

// главарь врагов
public class Boss extends EnemyShip {

    // отсчет тактов
    private int frameCount = 0;

    public Boss(double x, double y) {
        super(x, y);
        setAnimatedView(ShapeMatrix.BOSS_ANIMATION_FIRST, ShapeMatrix.BOSS_ANIMATION_SECOND);
    }

    // будет менять кадр один раз в 10 тактов
    @Override
    public void nextFrame() {
        frameCount++;
        if (frameCount % 10 == 0 || !isAlive) {
            super.nextFrame();
        }
    }
}
