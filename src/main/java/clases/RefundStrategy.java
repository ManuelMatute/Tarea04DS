/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clases;

/**
 *
 * @author Joseph
 * Interfaz para el patrón Strategy que define el comportamiento de reembolso
 */
public interface RefundStrategy {
    boolean processRefund(Ticket ticket);
}
