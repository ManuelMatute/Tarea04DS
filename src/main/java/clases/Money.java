/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.math.BigDecimal;
import java.util.Currency;

/**
 *
 * @author Joseph
 */
public class Money {
    private BigDecimal amount;
    private Currency currency;

    @Override
    public String toString() {
        return "Money{" + "amount=" + amount + ", currency=" + currency + '}';
    }
    
  
}
