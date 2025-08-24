package clases;

import comportamental.EventNotifier;
import creacional.EventFactory;
import creacional.TheatreEventFactory;

import estructural.TicketDecorator;

import java.util.List;

public class TicketEnVivo {
    public static void main(String[] args) {
        EventFactory eventFactory = new TheatreEventFactory();
        Event event = eventFactory.createEvent();
        System.out.println("Evento creado: " + event.getEventDetails());

        Show show = new Show();
        event.addShow(show);

        Selection platea = new Selection();
        for (int i = 0; i < 5; i++) {
            platea.addSeat(new Seat());
        }
        show.addSection(platea);

        Customer customer = new Customer("cliente@email.com");
        EventNotifier eventNotifier = new EventNotifier();
        eventNotifier.addObserver(customer);

        List<Seat> selectedSeats = platea.getAvailableSeats().subList(0, 2);

        ReservationService reservationService = new ReservationService();
        Reservation reservation = reservationService.reserveSeats(customer, selectedSeats);

        double bebidaPrice = PriceConstants.DEFAULT_BEVERAGE_PRICE;
        double parkingPrice = PriceConstants.DEFAULT_PARKING_PRICE;

        PricePolicy pricePolicy = r -> r.getSeats().size() * PriceConstants.BASE_PRICE_PER_SEAT;

        PaymentProcessor paymentProcessor = amount -> {
            System.out.println("Procesando pago por $" + amount + "...");
            return new PaymentResult(true);
        };

        RefundStrategy refundStrategy = new StandardRefundStrategy();

        
        TicketService ticketService = new TicketService(paymentProcessor, pricePolicy, refundStrategy);
        Ticket baseTicket = ticketService.purchase(reservation);

        if (baseTicket != null) {
            TicketInterface decoratedTicket = new ExtrasDecorator(baseTicket, bebidaPrice, parkingPrice);


            System.out.println("\n--- Ticket Final ---");
            System.out.println(decoratedTicket.getETicket());
            System.out.println("Precio total: $" + decoratedTicket.getPrice());

            eventNotifier.notifyObservers(event.getType().toString(),
                    "Su compra ha sido confirmada. Detalles en su email.");

            SupportTicket supportTicket = new SupportTicket(IssueType.PAYMENT, customer);
            System.out.println("\nEstado inicial del ticket de soporte: " + supportTicket.getStatus());
            supportTicket.escalate();
            System.out.println("Estado después de escalar: " + supportTicket.getStatus());
            supportTicket.close();
            System.out.println("Estado final: " + supportTicket.getStatus());

            // 14) Reembolso (Strategy)
            System.out.println("\nIntentando reembolso...");
            boolean refundResult = ticketService.refund(baseTicket); // reembolso sobre el ticket base
            System.out.println("Resultado del reembolso: " + (refundResult ? "Éxito" : "Fallido"));
        } else {
            System.out.println("Error en la compra. No se generó ticket.");
        }
    }


    static class ExtrasDecorator extends TicketDecorator {
        private final double bebidaPrice;
        private final double parkingPrice;

        public ExtrasDecorator(TicketInterface decoratedTicket, double bebidaPrice, double parkingPrice) {
            super(decoratedTicket);
            this.bebidaPrice = bebidaPrice;
            this.parkingPrice = parkingPrice;
        }

        @Override
        public double getPrice() {
            return super.getPrice() + bebidaPrice + parkingPrice;
        }

        @Override
        public String getETicket() {
            return super.getETicket()
                    + "\nIncluye: Bebida (+$" + bebidaPrice + ")"
                    + "\nIncluye: Estacionamiento (+$" + parkingPrice + ")";
        }
    }
}
