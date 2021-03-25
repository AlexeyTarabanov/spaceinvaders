package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;
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

    // в зависимости от кадра анимации, босс будет стрелять из разных пушек
    @Override
    public Bullet fire() {
        if (!isAlive) {
            return null;
        }

        if (matrix == ShapeMatrix.BOSS_ANIMATION_FIRST) {
            return new Bullet(x + 6, y + height, Direction.DOWN);
        } else {
            return new Bullet(x, y + height, Direction.DOWN);
        }
    }

    @Override
    public void kill() {
        if (isAlive) {
            isAlive = false;
            // задаем кадры анимации взрыва
            setAnimatedView(ShapeMatrix.KILL_BOSS_ANIMATION_FIRST,
                    ShapeMatrix.KILL_BOSS_ANIMATION_SECOND, ShapeMatrix.KILL_BOSS_ANIMATION_THIRD);
        }
    }
}
