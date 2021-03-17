package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.ShapeMatrix;

// корабль представителя вражеского флота
public class EnemyShip extends Ship{

    public EnemyShip(double x, double y) {
        super(x, y);
        // задаем матрицу
        setStaticView(ShapeMatrix.ENEMY);
    }
}
