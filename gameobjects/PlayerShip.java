package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.List;

// корабль игрока
public class PlayerShip extends Ship {

    // направление движения
    private Direction direction = Direction.UP;

    public void setDirection(Direction newDirection) {
        if (newDirection != Direction.DOWN) {
            this.direction = newDirection;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public PlayerShip() {
        // отображаем корабль внизу экрана по центру
        super(SpaceInvadersGame.WIDTH / 2.0, SpaceInvadersGame.HEIGHT - ShapeMatrix.PLAYER.length - 1);
        // задаем внешний вид корабля
        setStaticView(ShapeMatrix.PLAYER);
    }

    // проверяет попали ли вражеские пули в корабль игрока
    public void verifyHit(List<Bullet> bullets) {
        if (!bullets.isEmpty()) {
            if (this.isAlive) {
                for (Bullet bullet : bullets) {
                    // проверяем "жива" ли пуля и пересечение игрока с этой пулей
                    if (bullet.isAlive && isCollision(bullet)) {
                        kill();
                        bullet.kill();
                    }
                }
            }
        }
    }

    @Override
    public void kill() {
        if (this.isAlive) {
            isAlive = false;
            setAnimatedView(ShapeMatrix.KILL_PLAYER_ANIMATION_FIRST, ShapeMatrix.KILL_PLAYER_ANIMATION_SECOND,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_THIRD, ShapeMatrix.DEAD_PLAYER);
        }
    }

    public void move() {
        if (isAlive) {
            if (direction == Direction.LEFT) {
                x--;
            }
            if (direction == Direction.RIGHT) {
                x++;
            }
            if (x < 0) {
                x = 0;
            }
            if ((x + this.width) > SpaceInvadersGame.WIDTH) {
                x = SpaceInvadersGame.WIDTH - width;
            }
        }
    }

    // создает пули
    @Override
    public Bullet fire() {
        if (!isAlive) {
            return null;
        }
        return new Bullet(x + 2, y - ShapeMatrix.BULLET.length, Direction.UP);
    }
}
