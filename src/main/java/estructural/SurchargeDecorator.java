/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructural;

import clases.TicketInterface;

public class SurchargeDecorator extends TicketDecorator {

    private final String description;
    private final double amount;

    public SurchargeDecorator(TicketInterface decoratedTicket, String description, double amount) {
        super(decoratedTicket);
        if (description == null || description.isBlank())
            throw new IllegalArgumentException("description no puede ser vacía");
        if (amount < 0) throw new IllegalArgumentException("amount no puede ser negativo");
        this.description = description;
        this.amount = amount;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + amount;
    }

    @Override
    public String getETicket() {
        return super.getETicket() + "\nIncluye: " + description + " (+$" + amount + ")";
    }
}
