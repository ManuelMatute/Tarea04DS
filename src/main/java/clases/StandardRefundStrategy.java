/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manue
 */
public class StandardRefundStrategy implements RefundStrategy{
   @Override
    public boolean processRefund(Ticket ticket) {
        System.out.println("Procesando reembolso estandar por $" + ticket.getPrice());
        return true;
    }
}
