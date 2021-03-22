package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;

// отвечает за пули
public class Bullet extends GameObject {

    // величина изменения координаты y
    // (так как пули летают только вверх или вниз - при их движении меняется только координата y)
    private int dy;
    public boolean isAlive = true;

    public Bullet(double x, double y, Direction direction) {
        super(x, y);
        setMatrix(ShapeMatrix.BULLET);
        if (direction == Direction.UP)
            dy = -1;
        else
            dy = 1;
    }

    public void move() {
        this.y += dy;
    }

    public void kill() {
        isAlive = false;
    }
}
