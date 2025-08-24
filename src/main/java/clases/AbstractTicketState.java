/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

public abstract class AbstractTicketState implements TicketState {

    @Override
    public void handle(SupportTicket ticket) {
        System.out.println("Estado del ticket: " + getStatus());
    }
}
