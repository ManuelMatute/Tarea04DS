/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reservation {

    private final List<Seat> seats = new ArrayList<>();
    private final List<Option> options = new ArrayList<>();
    private boolean confirmed = false;

   
    public void reserveSeats(List<Seat> seatsToReserve) {
        if (seatsToReserve == null || seatsToReserve.isEmpty()) {
            throw new IllegalArgumentException("La lista de asientos no puede estar vacía o ser null");
        }
        for (Seat seat : seatsToReserve) {
            if (seat == null) throw new IllegalArgumentException("La lista contiene asientos null");
            if (!seat.isAvailable()) throw new IllegalStateException("Asiento no disponible");
            if (seats.contains(seat)) throw new IllegalArgumentException("Asiento ya está reservado");
        }
        for (Seat seat : seatsToReserve) {
            seats.add(seat);
            seat.reserve();
        }
    }

    public void addSeat(Seat seat) {
        if (seat == null) throw new IllegalArgumentException("seat no puede ser null");
        if (!seat.isAvailable()) throw new IllegalStateException("Asiento no disponible");
        if (seats.contains(seat)) throw new IllegalArgumentException("Asiento ya está reservado");
        seats.add(seat);
        seat.reserve();
    }

    public void removeSeat(Seat seat) {
        if (seat == null) return;
        if (seats.remove(seat)) {
            seat.release();
        }
    }

    public void cancelAndReleaseAllSeats() {
        for (Seat seat : seats) {
            seat.release();
        }
        seats.clear();
        confirmed = false;
    }

    public void addOption(Option option) {
        if (option == null) throw new IllegalArgumentException("option no puede ser null");
        options.add(option);
    }

    public List<Seat> getSeats() {
        return Collections.unmodifiableList(seats);
    }

    public List<Option> getOptions() {
        return Collections.unmodifiableList(options);
    }

    public void confirm() {
        confirmed = true;
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}
