package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.ShapeMatrix;

import java.util.ArrayList;
import java.util.List;

// будет хранить список кораблей
public class EnemyFleet {

    // количество рядов кораблей
    private static final int ROWS_COUNT = 3;
    // количество кораблей в ряду
    private static final int COLUMNS_COUNT = 10;
    // расстояние между левыми верхними углами соседних кораблей
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;
    // список кораблей вржеского флота
    private List<EnemyShip> ships;

    // создает корабли и заполнять ими список(ships)
    private void createShips() {
        ships = new ArrayList<>();
    }

}
