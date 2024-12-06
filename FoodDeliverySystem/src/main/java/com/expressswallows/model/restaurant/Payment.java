package com.expressswallows.model.restaurant;

import com.expressswallows.model.restaurant.users.Client;
import java.util.Objects;

/**
 * Payment class is used to represent payments made by clients.
 * @author shahi
 */
public class Payment {
    private final double paymentAmount;
    private final Client payedBy;

    /**
     * All argument constructor for a client's Payment.
     * @param paymentAmount the payment amount.
     * @param payedBy the client that made the payment.
     */
    public Payment(double paymentAmount, Client payedBy) {
        // Validate the arguments
        if (paymentAmount <= 0) {
            throw new IllegalArgumentException("The payment amount must be greater than zero.");
        }
        this.paymentAmount = paymentAmount;
        this.payedBy = payedBy;
    }

    /**
     * Getter for the payment amount.
     * @return the payment amount.
     */
    public double getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * Getter for the client who made the payment.
     * @return the client who made the payment.
     */
    public Client getPayedBy() {
        return payedBy;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.paymentAmount) ^ (Double.doubleToLongBits(this.paymentAmount) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.payedBy);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Payment other = (Payment) obj;
        if (Double.doubleToLongBits(this.paymentAmount) != Double.doubleToLongBits(other.paymentAmount)) {
            return false;
        }
        return Objects.equals(this.payedBy, other.payedBy);
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentAmount=" + paymentAmount + ", payedBy=" + payedBy + '}';
    }
    
    
}
