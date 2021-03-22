package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

// корабль игрока
public class PlayerShip extends Ship {

    public PlayerShip() {
        // отображаем корабль внизу экрана по центру
        super(SpaceInvadersGame.WIDTH / 2.0, SpaceInvadersGame.HEIGHT - ShapeMatrix.PLAYER.length - 1);
        // задаем внешний вид корабля
        setStaticView(ShapeMatrix.PLAYER);
    }
}
