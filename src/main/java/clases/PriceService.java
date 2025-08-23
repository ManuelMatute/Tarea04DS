/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manue
 */
import java.util.ArrayList;
import java.util.List;

public class PriceService {
    private List<PricePolicy> policies = new ArrayList<>();

    public void addPolicy(PricePolicy policy) {
        policies.add(policy);
    }

    public double getBestPrice(Reservation reservation) {
        double best = Double.MAX_VALUE;
        for (PricePolicy policy : policies) {
            double current = policy.calculatePrice(reservation);
            if (current < best) {
                best = current;
            }
        }
        return best;
    }
}