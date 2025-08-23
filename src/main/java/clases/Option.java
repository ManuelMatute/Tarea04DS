/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Joseph
 * Clase que representa una opción adicional que puede ser añadida a una reserva
 * (como bebidas, estacionamiento, etc.)
 */
public class Option {
    private String name;
    private Money money;

    public Option(String name, Money money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return money;
    }

    @Override
    public String toString() {
        return name + money;
    }
}
