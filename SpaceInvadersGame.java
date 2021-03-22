package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.gameobjects.EnemyFleet;
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
 1. В пакете gameobjects создал класс Ship
 (будет хранить в себе общие свойства космических кораблей)
 2. В классе Ship
 - добавил метод setStaticView(int[][] viewFrame)
 (будет устанавливать матрицу и задавать анимацию)
 3. В пакете gameobjects создал класс EnemyShip и конструктор
 (корабль представителя вражеского флота)

 Шаг 7.
 1. В пакете gameobjects создал класс EnemyFleet
 (будет хранить список кораблей)
 2. В классе EnemyFleet:
 - создал и проинициализировал переменные ROWS_COUNT, COLUMNS_COUNT, STEP
 (количество рядов кораблей, количество кораблей в ряду, расстояние между левыми верхними углами соседних кораблей)
 - создал поле ships типа List<EnemyShip>
 (список кораблей вражеского флота)
 - создал метод createShips(). Проинициализировал в нем поле ships

 Шаг 8.
 1. В классе SpaceInvadersGame:
 - создал поле enemyFleet и проинициализировал в методе createGame()
 - переопредилил метод onTurn(int) родительского класса Game
 (все, что будет происходить на каждом шаге, выполняется в этом методе)
 2. В классе EnemyFleet:
 - создал конструктор
 - реализовал метод createShips

 Шаг 9.
 1. Создал enum Direction
 (будет хранить направления движений)
 2. В классе EnemyShip:
  - создал и реализовал метод move()
 (движение вражеского корабля)
 3. В классе EnemyFleet:
 - создал и реализовал метод getLeftBorder()
 (возвращает минимальную координату x среди всех вражеских кораблей из списка ships)
 - создал и реализовал метод getRightBorder()
 (возвращает максимальное из значений (x + width) среди всех вражеских кораблей из списка ships)

 Шаг 10.
 1. В классе EnemyFleet:
  - создал и проинициализировал поле Direction direction
 (напрвление движения)
  - создал и реализовал метод getSpeed()
  - создал метод move()
 (движение)
 2. В классе SpaceInvadersGame:
 - создал и реализовал метод moveSpaceObjects()
 (будет двигать объекты)

 Шаг 11.
 1. В классе EnemyFleet:
  - реализовал метод move()

 Шаг 12.
 1. В пакете gameobjects:
  - создал класс Bullet
 (отвечающий за пули)
 2. В классе Bullet:
  - создал поля int dy и
 (будет отвечать за величину изменения координаты y)
  - создал и реализовал метод move()

 Шаг 13.
 1.

 */

public class SpaceInvadersGame extends Game {

    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;

    private List<Star> stars;

    private EnemyFleet enemyFleet;

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
        enemyFleet = new EnemyFleet();
        drawScene();
        // задает частоту работы этого метода onTurn
        setTurnTimer(40);
    }

    // все, что будет происходить на каждом шаге, выполняется в этом методе
    @Override
    public void onTurn(int step) {
        // так как корабли передвигаются на каждом такте игры
        moveSpaceObjects();
        drawScene();
    }

    // отрисовка эл-тов
    private void drawScene() {
        drawField();
        enemyFleet.draw(this);
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

    // будет двигать объекты
    private void moveSpaceObjects() {
        enemyFleet.move();
    }
}
