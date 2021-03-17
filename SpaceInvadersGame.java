package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

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
 1. В классе SpaceInvadersGame:
 - реализовал метод drawField()
 2. Создал пакет gameobjects, в нем создал класс GameObject.
 3. В классе GameObject:
 - объявил 2 поля x и y (координаты объекта)
 - добавил конструктор
 4. В пакете gameobjects создал класс Star, который наследуется от класса GameObject

 Шаг 4.
 1. В классе Star:
 - объявил и проинициализировал поле STAR_SIGN (отображение звезды)
 - объявил и реализовал метод draw()
 2. В классе SpaceInvadersGame:
 - объявил поле List<Star> stars, где будем хранить список звезд
 - создал и реализовал метод createStars()
 3. В методе createGame() вызвал метод createStars()
 4. В методе drawField(), у каждого объекта из списка stars вызвал метод draw(Game), для отображения звезд на игровом поле

 Шаг 5.
 1. В классе GameObject:
 - добавил поле поле matrix типа int[][]
 - добавил поля width и height (габаритные размеры объекта)
 - создал и реализовал метод void setMatrix (сеттер для массива)
 - создал и реализовал метод draw(Game game) - отображает игровой объект на экране

 Шаг 6.
 */

public class SpaceInvadersGame extends Game {

    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;

    private List<Star> stars;

    // запускает игру
    @Override
    public void initialize() {
        // задает ширину и высоту
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    // здесь будем создавать все эл-ты игры
    private void createGame() {
        createStars();
        drawScene();
    }

    // отрисовка эл-тов
    private void drawScene() {
        drawField();
    }

    // отрисовка поля
    private void drawField() {
        for (int x = 0; x < HEIGHT; x++) {
            for (int y = 0; y < WIDTH; y++) {
                // установить значение ячейки
                setCellValueEx(x, y, Color.BLACK, "");
            }
        }

        // отображение звезд на игровом поле
        for (Star star : stars) {
            star.draw(this);
        }
    }

    // создает звезды
    private void createStars() {
        stars = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            stars.add(new Star(i, i));
        }
    }
}
