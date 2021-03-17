package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.*;

// родительский класс всех объектов
public class GameObject {

    // координаты положения на игровом поле
    public double x;
    public double y;

    // кроме формы объекта, матрица содержит порядковый номер цвета
    public int[][] matrix;

    // габаритные размеры объекта
    public int width;
    public int height;

    public GameObject(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // устанавливает значения
    public void setMatrix(int[][] array) {
        matrix = array;
        width = matrix[0].length;
        height = matrix.length;
    }

    // отображает игровой объект на экране
    public void draw(Game game) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                // для каждой ячейки матрицы matrix вызываем метод setCellValueEx
                game.setCellValueEx( (int) (x + i), (int) (y + j), Color.values()[matrix[j][i]], "");
            }
        }
    }

}
