package com.javarush.games.spaceinvaders.gameobjects;

// будет хранить в себе общие свойства космических кораблей
public class Ship extends GameObject {

    public Ship(double x, double y) {
        super(x, y);
    }

    // устанавливает матрицу и задает анимацию
    public void setStaticView(int[][] viewFrame) {
        setMatrix(viewFrame);

    }
}
