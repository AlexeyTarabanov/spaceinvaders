package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
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

    public EnemyFleet() {
        createShips();
    }

    // создает корабли и заполняет ими список(ships)
    private void createShips() {

        ships = new ArrayList<>();

        // учли, что оптимальным расстоянием от верхней границы экрана до первого сверху ряда кораблей будет 12 ячеек.
        for (int x = 0; x < COLUMNS_COUNT; x++) {
            for (int y = 0; y < ROWS_COUNT; y++) {
                ships.add(new EnemyShip(x * STEP, y * STEP + 12));
            }
        }
    }

    // отрисовка вражеских кораблей
    public void draw(Game game) {
        for (EnemyShip enemyShip : ships) {
            enemyShip.draw(game);
        }
    }

    // получаем левую границу
    // возвращает минимальную координату x среди всех вражеских кораблей из списка ships
    private double getLeftBorder() {
        double min = ships.get(0).x;

        for (EnemyShip ship : ships) {
            if (ship.x < min)
                min = ship.x;
        }
        return min;
    }

    // получаем правую границу
    // возвращает максимальное из значений (x + width) среди всех вражеских кораблей из списка ships
    private double getRightBorder() {
        double max = ships.get(0).x + ships.get(0).width;

        for (EnemyShip ship : ships) {
            if ((ship.x + ship.width) > max)
                max = ship.x + ship.width;
        }
        return max;
    }

}
