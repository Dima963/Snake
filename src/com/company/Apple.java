package com.company;

public class Apple {

    Main main;

    public  int posX;
    public int posY;

    public  Apple(int startX, int startY){
        posX = startX;
        posY = startY;
    }



    public void setRandomPosition() {
        posX = (int) (Math.random() * main.Width);
        posY = (int) (Math.random() * main.Height);
    }
}
