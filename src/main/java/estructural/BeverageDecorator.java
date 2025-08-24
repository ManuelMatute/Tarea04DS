/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructural;

import clases.TicketInterface;

public class BeverageDecorator extends SurchargeDecorator {
    public BeverageDecorator(TicketInterface decoratedTicket, double beveragePrice) {
        super(decoratedTicket, "Bebida", beveragePrice);
    }
}
