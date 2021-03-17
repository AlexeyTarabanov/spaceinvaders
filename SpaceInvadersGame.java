package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;

/**
 Шаг 1.
 1. Создал класс SpaceInvadersGame, который наследует класс Game
 - в классе объявил 2 поля, отвечающих за ширину и высоту (WIDTH и HEIGHT)
 2. Задаем игровое поле:
 - переопределил метод initialize(), он будет запускать игру
 - в нем вызвал метод setScreenSize(), который задает ширину и высоту игрового поля

 Шаг 2.
 1. В классе SpaceInvadersGame:
 создал и реализовал методы:
 - createGame(), drawScene(), drawField()
 2. В методе initialize(), вызвал метод createGame()

 Шаг 3.
 */

public class SpaceInvadersGame extends Game {

    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;

    // запускает игру
    @Override
    public void initialize() {
        // задает ширину и высоту
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    // здесь будем создавать все эл-ты игры
    private void createGame() {
        drawScene();
    }

    // отрисовка эл-тов
    private void drawScene() {
        drawField();
    }

    // отрисовка поля
    private void drawField() {}
}
