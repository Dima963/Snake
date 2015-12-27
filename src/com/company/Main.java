package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main extends JPanel implements ActionListener{

    public static final int SCALE = 32;
    public static final int Width = 20;
    public static final int Height = 20;


    public  Main(){

        t.start();
        addKeyListener(new keyboard());
        setFocusable(true);
    }

    Snake s = new Snake(10, 10, 10, 10);


    Apple a =  new Apple((int)(Math.random()*Width), (int) (Math.random()*Height));
    Timer t = new Timer(1000/5, this);

    public void paint(Graphics graphics) {
        graphics.setColor(color(15, 50, 15));
        graphics.fillRect(0, 0, SCALE * Width, SCALE * Height);
        graphics.setColor(color(255, 216,0));


        for(int i = 0; i <SCALE * Height; i+=SCALE ) {
            graphics.drawLine(i, 0, i, SCALE * Height);
            for(int j = 0; j< SCALE * Width; j+=SCALE ) {
                graphics.drawLine(0, j,SCALE * Width, j );
            }
        }

        for(int d = 0; d< s.length; d++){
            graphics.setColor(color(200, 150, 0));
graphics.fillRect(s.snakeX[d]*SCALE+1,s.snakeY[d]*SCALE+1,SCALE- 1, SCALE- 1  );

        }

        graphics.setColor(color(255,0, 0));
        graphics.fillRect(a.posX*SCALE + 1, a.posY*SCALE+1, SCALE-1,SCALE-1);
    }

    public Color color(int red, int green, int blue)
    {
        return new Color(red, green, blue);
    }

    public static void main(String[] args) {

        JFrame frame= new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(SCALE * Width+ 7, SCALE * Height+30);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(new Main());



    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
       s.move();
        if((s.snakeX[0] == a.posX) & (s.snakeY[0] == a.posY)){

            a.setRandomPosition();
            s.length++;

        }
        for(int k = 1; k < s.length; k++) {
            if ((s.snakeX[k] == a.posX) & (s.snakeY[k] == a.posY)) {
                a.setRandomPosition();

            }
        }
        repaint();

    }

    private class  keyboard extends KeyAdapter{

        public void keyPressed(KeyEvent keyE){

            int key = keyE.getKeyCode();
            if((key == KeyEvent.VK_RIGHT)& s.direction != 2) s.direction = 0;

            if((key == KeyEvent.VK_DOWN)& s.direction != 3) s.direction = 1;
            if((key == KeyEvent.VK_LEFT)& s.direction != 0) s.direction = 2;
            if((key == KeyEvent.VK_UP)& s.direction != 1) s.direction = 3;
        }

    }


}
