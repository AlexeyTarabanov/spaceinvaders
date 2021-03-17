package com.javarush.games.spaceinvaders.gameobjects;

// родительский класс всех объектов
public class GameObject {

    // координаты положения на игровом поле
    public double x;
    public double y;

    public GameObject(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
