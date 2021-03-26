package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Key;
import com.javarush.games.spaceinvaders.gameobjects.Bullet;
import com.javarush.games.spaceinvaders.gameobjects.EnemyFleet;
import com.javarush.games.spaceinvaders.gameobjects.PlayerShip;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.Iterator;
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
 1. В классе SpaceInvadersGame:
  - создал переменную COMPLEXITY
 (отвечает за сложность игры - вероятность выстрела вражеского корабля за один шаг игры)
 2. В классе Ship:
  - создал метод fire()
 (так как экземпляр этого класса мы не будем создавать - реализовывать метод будем в классах-наследниках)
 3. В классе EnemyShip:
  - переопредилил и реализовал метод fire()

 Шаг 14.
 1. В классе EnemyFleet:
  - создал и реализовал метод fire()

 Шаг 15.
 1. В классе SpaceInvadersGame:
 - создал переменную  enemyBullets типа List<Bullet>
 (вражеские пули)
 - добавил их отрисовку и движение
 - создал и реализовал метод removeDeadBullets()
 (удаляет вражеские пули)
 - создал метод check()
 (различные проверки на каждом шаге игры)

 Шаг 16.
 1. В пакете gameobjects:
  - создал класс PlayerShip
 (корабль игрока)
 2. В классе Ship:
  - создал переменную boolean isAlive
  - создал и реализовал метод kill()
 3. В классе Bullet:
  - создал и реализовал метод kill()

 Шаг 17.
 1. В классе PlayerShip
  - создал и реализовал метод verifyHit
 (проверяет попали ли вражеские пули в корабль игрока)
 2. В классе SpaceInvadersGame:
  - создал и проинициализировал переменную PlayerShip playerShip

 Шаг 18.
 1. В классе Ship:
  - создал поля frames типа List<int[][]> и frameIndex
 (хранит список матриц для кадров анимации и индекс текущего кадра анимации)
  - создал и реализовал метод setAnimatedView
 (передает кадры анимации)

 Шаг 19.
 1. В классе PlayerShip
  - реализовал метод kill() базового класса

 Шаг 20.
 1. В классе Ship:
  - создал и реализовал метод nextFrame
 (устанавливает в поле matrix следующий кадр анимации, если это возможно)
 2. Расширим функционал метода draw

 Шаг 21.
 1. В классе SpaceInvadersGame:
  - создал и реализовал метод stopGame()

 Шаг 22.
 1. В классе PlayerShip:
  - добавил поле Direction, проинициализировал его, добавил сеттер для него
 2. В классе SpaceInvadersGame:
  - переопределил метод onKeyPress

 Шаг 23.
 1. В классе PlayerShip:
  - создал и реализовал метод move()
 (движение корабля игрока)

 Шаг 24.
 1. В классе PlayerShip:
  - добавил геттер к полю Direction
 2. В классе SpaceInvadersGame:
  - переопределил и реализовал метод onKeyReleased(Key)
 (вызывается при отпускании клавиш)

 Шаг 25.
 1. В классе PlayerShip:
 - переопределил и реализовал метод fire()
 (создает пули)
 2. В классе SpaceInvadersGame:
 - добавил поле поле playerBullets типа List<Bullet>
 (пули игрока)

 Шаг 26.
 1. В классе SpaceInvadersGame:
 - создал и проинициализировал переменную PLAYER_BULLETS_MAX
 (максимальное количество пуль игрока)
 - в метод onKeyPress(key) добавил возможность стрелять по нажатию клавиши пробел
 - переопределил метод setCellValueEx(int, int, Color, String)

 Шаг 27.
 1. В классе EnemyShip:
 - переопределил и реализовал метод kill()
 (уничтожения вражеского корабля)
 2. В классе Ship
 - создал и реализовал метод isVisible()
 (будет возвращать false после того, как у "неживого" корабля отобразится вся анимация)

 Шаг 28.
 1. В классе EnemyFleet:
  - создал и реализовал метод verifyHit(List<Bullet> bullets)
 (проверка попаданий пуль игрока во вражеские корабли)
 - создал и реализовал метод deleteHiddenShips()
 (удаляет из списка "убитые" корабли)

 Шаг 29.
 1. В пакете gameobjects:
  - создал класс Boss
 (главарь врагов)
 2. В классе Boss:
  - создал и проинициализировал переменную frameCount
 (отсчет тактов)
  - переопределил и реализовал метод nextFrame()
 (будет менять кадр один раз в 10 тактов)
 3. В классе EnemyFleet:
  - в методе createShips создал Boss-a и добавил его в список кораблей вржеского флота

 Шаг 30.
 1. В классе Boss:
 - переопределил и реализовал метод fire()
 - переопределил и реализовал метод kill()

 Шаг 31.
 1. В классе Ship:
  - создал и проинициализировал поле loopAnimation
 (петля анимации)
  - заменил метод setAnimatedView(int[][]... viewFrames) на
 setAnimatedView(boolean isLoopAnimation, int[][]... viewFrames)
 (отвечает за бесконечность анимации)
  2. Отрефакторил методы:
   - nextFrame() класса Ship
   - kill() класса PlayerShip
   - kill() класса EnemyShip
   - kill() класса Boss
   - конструктор класса Boss

 Шаг 32.
 1. В классе EnemyFleet:
  - создал и реализовал метод getBottomBorder()
 (определяет координаты нижней границы вражеского флота)
  - создал и реализовал метод getShipsCount()
 (возвращает количество оставшихся кораблей вражеского флота)
 2. В классе PlayerShip:
  - создал и реализовал метод win()
 3. В классе SpaceInvadersGame:
  - в методе check() добавил условие проверки

 Шаг 33.
 1. В классе EnemyShip:
  - создал и проинициализировал поле score
 (счет очков)
 2. В классе EnemyFleet:
  - отрефакторил метод verifyHit()

 Шаг 34.
 1.

 */

public class SpaceInvadersGame extends Game {

    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;

    private List<Star> stars;

    private EnemyFleet enemyFleet;

    // сложность игры
    public static final int COMPLEXITY = 5;
    // вражеские пули
    private List<Bullet>  enemyBullets;
    // корабль игрока
    private PlayerShip playerShip;
    // пули игрока
    private List<Bullet> playerBullets;
    // максимальное количество пуль
    private static final int PLAYER_BULLETS_MAX = 1;
    private int score;

    private boolean isGameStopped;
    private int animationsCount;

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
        enemyBullets = new ArrayList<>();
        playerShip = new PlayerShip();
        isGameStopped = false;
        animationsCount = 0;
        playerBullets = new ArrayList<>();
        score = 0;
        drawScene();
        // задает частоту работы этого метода onTurn
        setTurnTimer(40);
    }

    // все, что будет происходить на каждом шаге, выполняется в этом методе
    @Override
    public void onTurn(int step) {
        // так как корабли передвигаются на каждом такте игры
        moveSpaceObjects();
        check();
        Bullet bullet = enemyFleet.fire(this);
        // если выстрел произошел - возвращаем пулю в список
        if (bullet != null) {
            enemyBullets.add(bullet);
        }
        setScore(score);
        drawScene();
    }

    // отрисовка эл-тов
    private void drawScene() {
        drawField();
        enemyFleet.draw(this);
        playerShip.draw(this);
        for (Bullet bullet : enemyBullets) {
            bullet.draw(this);
        }
        for (Bullet bullet : playerBullets) {
            bullet.draw(this);
        }
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
        for (Bullet bullet : enemyBullets) {
            bullet.move();
        }
        playerShip.move();
        for (Bullet bullet : playerBullets) {
            bullet.move();
        }
    }

    // удаляет вражеские пули
    private void removeDeadBullets() {

        // создаем итератор
        Iterator<Bullet> bulletIterator = enemyBullets.iterator();
        // до тех пор, пока в списке есть элементы
        while (bulletIterator.hasNext()) {
            // получаем следующий элемент
            Bullet bulletNext = bulletIterator.next();
            // если пуля потрачена (нежива - попала в цель) или вылетела за пределы экрана
            if (!bulletNext.isAlive || bulletNext.y >= HEIGHT - 1) {
                bulletIterator.remove();
            }
        }

        playerBullets.removeIf(bullet -> !bullet.isAlive || (bullet.y + bullet.height) < 0);
    }

    // проверки
    private void check() {
        playerShip.verifyHit(enemyBullets);
        enemyFleet.verifyHit(playerBullets);
        enemyFleet.deleteHiddenShips();
        removeDeadBullets();
        // если пуля попала в игрока, перед остановкой игры нужно успеть показать анимацию взрыва
        if (!playerShip.isAlive) {
            stopGameWithDelay();
        }

        if (enemyFleet.getBottomBorder() >= playerShip.y) {
            playerShip.kill();
        }
        if (enemyFleet.getShipsCount() == 0) {
            playerShip.win();
            stopGameWithDelay();
        }

        score += enemyFleet.verifyHit(playerBullets);
    }

    // останавливает игру и выводить соответствующее сообщение на экран
    private void stopGame(boolean isWin) {
        isGameStopped = true;
        stopTurnTimer();
        if (isWin) {
            showMessageDialog(Color.BLACK, "Ты выиграл!", Color.GREEN, 75);
        } else {
            showMessageDialog(Color.BLACK, "Game Over", Color.RED, 75);
        }
    }

    private void stopGameWithDelay() {
        animationsCount++;
        if (animationsCount >= 10) {
            stopGame(playerShip.isAlive);
        }
    }

    // считывает команды игрока (нажатия клавиш)
    @Override
    public void onKeyPress(Key key) {
        if (key == Key.SPACE && isGameStopped) {
            createGame();
        }
        if (key == Key.LEFT) {
            playerShip.setDirection(Direction.LEFT);
        }
        if (key == Key.RIGHT) {
            playerShip.setDirection(Direction.RIGHT);
        }

        if (key == Key.SPACE) {
            Bullet bullet = playerShip.fire();
            if (bullet != null && playerBullets.size() < PLAYER_BULLETS_MAX) {
                playerBullets.add(bullet);
            }
        }
    }

    // вызывается при отпускании клавиш
    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.LEFT && playerShip.getDirection() == Direction.LEFT) {
            playerShip.setDirection(Direction.UP);
        }
        if (key == Key.RIGHT && playerShip.getDirection() == Direction.RIGHT) {
            playerShip.setDirection(Direction.UP);
        }
    }

    @Override
    public void setCellValueEx(int x, int y, Color cellColor, String value) {
        // если параметры метода x или y находятся внутри поля
        if (x < WIDTH && x > 0 && y > 0 && y < HEIGHT) {
            super.setCellValueEx(x, y, cellColor, value);
        }
    }
}
