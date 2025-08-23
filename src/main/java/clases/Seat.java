/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manue
 */
public class Seat {
    private boolean available = true;

    public boolean isAvailable() {
        return available;
    }

    public void reserve() {
        available = false;
    }

    public void release() {
        available = true;
    }
}