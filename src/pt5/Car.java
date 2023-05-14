/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt5;

import java.awt.Rectangle;

/**
 *
 * @author kentl
 */
public class Car {
    private int x;      // x-coordinate of the car's position
    private int y;      // y-coordinate of the car's position
    private int width;  // width of the car
    private int height; // height of the car
    private int speed;  // speed of the car
    private static final int FRAME_WIDTH = 600;  // Width of the game frame
    
    public Car(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public void move() {
        x += speed;
        if (x > FRAME_WIDTH) {
            x = -width;  // Reset car position to the left side of the frame
        }
        if (x < -width) {
            x = FRAME_WIDTH;  // Reset car position to the right side of the frame
        }
    }
    
    public Rectangle getBounds() {
        // Return a rectangle representing the car's boundaries for collision detection
        return new Rectangle(x, y, width, height);
    }
}

