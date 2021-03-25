package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

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
    // напрвление движения
    private Direction direction = Direction.RIGHT;

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

    // возвращает минимум среди значений:
    // 2.0 и (3.0 / количество кораблей в списке ships).
    private double getSpeed() {
        // максимальная скорость вражеских кораблей не должна превышать значение 2
        return Math.min(2.0, 3.0 / ships.size());
    }

    // движение
    // когда корабли подлетают к краю экрана, они меняют направление на противоположное и опускаются ниже.
    public void move() {
        boolean flag = false;

        if (!ships.isEmpty()) {
            if (direction == Direction.LEFT && getLeftBorder() < 0) {
                direction = Direction.RIGHT;
                flag = true;
            }
            if (direction == Direction.RIGHT && getRightBorder() > SpaceInvadersGame.WIDTH) {
                direction = Direction.LEFT;
                flag = true;
            }

            for (EnemyShip ship : ships) {
                if (flag) {
                    ship.move(Direction.DOWN, getSpeed());
                } else {
                    ship.move(direction, getSpeed());
                }
            }
        }
    }

    // вызывает метод fire у одного из кораблей флота, выбранного случайно.
    // кроме того, флот будет стрелять с вероятностью COMPLEXITY процентов.
    public Bullet fire(Game game) {
        if (ships.isEmpty()) {
            return null;
        }
        if (game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY) > 0) {
            return null;
        }

        return ships.get(game.getRandomNumber(ships.size())).fire();
    }

    // проверка попаданий пуль игрока во вражеские корабли
    public void verifyHit(List<Bullet> bullets) {
        for (Ship ship : ships) {
            for (Bullet bullet : bullets) {
                // если пересечение корабля и пули есть и корабль "жив" и эта пуля "живая"
                if (ship.isCollision(bullet) && ship.isAlive && bullet.isAlive) {
                    ship.kill();
                    bullet.kill();
                }
            }
        }
    }

    // удаляет из списка "убитые" корабли
    public void deleteHiddenShips() {
        ships.removeIf(ship -> !ship.isVisible());
    }
}
