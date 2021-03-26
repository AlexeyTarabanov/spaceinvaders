package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;

// корабль представителя вражеского флота
public class EnemyShip extends Ship {

    public int score = 15;

    public EnemyShip(double x, double y) {
        super(x, y);
        // задаем матрицу
        setStaticView(ShapeMatrix.ENEMY);
    }

    // движение вражеского корабля
    public void move(Direction direction, double speed) {
        switch (direction) {
            case RIGHT:
                x += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case DOWN:
                y += 2;
                break;
        }
    }

    @Override
    public Bullet fire() {
        return new Bullet(x + 1, y + height, Direction.DOWN);
    }

    // уничтожение вражеского корабля
    @Override
    public void kill() {
        if (isAlive) {
            isAlive = false;
            // задает матрицы для анимации уничтожения
            setAnimatedView(false,
                    ShapeMatrix.KILL_ENEMY_ANIMATION_FIRST,
                    ShapeMatrix.KILL_ENEMY_ANIMATION_SECOND,
                    ShapeMatrix.KILL_ENEMY_ANIMATION_THIRD);
        }
    }
}
