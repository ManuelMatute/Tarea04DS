/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manue
 */
import java.time.LocalDateTime;

public class SupportTicket {
    private IssueType issueType;
    private TicketState state;
    private LocalDateTime createdAt;
    private Customer customer;

    public SupportTicket(IssueType issueType, Customer customer) {
        this.issueType = issueType;
        this.customer = customer;
        this.state = new OpenState();
        this.createdAt = LocalDateTime.now();
    }

     public void escalate() {
        this.state = new EscalatedState();
        this.state.handle(this);
    }



    public void close() {
        this.state = new ClosedState();
        this.state.handle(this);
    }


    public IssueType getIssueType() {
        return issueType;
    }

    public TicketStatus getStatus() {
        return state.getStatus();
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Customer getCustomer() {
        return customer;
    }
}
