package com.expressswallows.model.restaurant;

import com.expressswallows.model.restaurant.users.Client;
import java.util.Objects;

/**
 * Payment class is used to represent payments made by clients.
 * @author shahi
 */
public class Payment {
    private final double paymentAmount;
    private final String paymentMethod;
    private final Client payedBy;

    /**
     * All argument constructor for a client's Payment.
     * 
     * @param paymentAmount the payment amount.
     * @param paymentMethod the payment method.
     * @param client the client that made the payment.
     */
    public Payment(double paymentAmount, String paymentMethod, Client payedBy) {
        // Validate the arguments
        if (paymentMethod == null || payedBy == null) {
            throw new IllegalArgumentException("The paymentMethod and payedBy arguments cannot be null.");
        }
        if (paymentAmount <= 0) {
            throw new IllegalArgumentException("The payment amount must be greater than zero.");
        }
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
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
     * Getter for the payment method.
     * @return the payment method.
     */
    public String getPaymentMethod() {
        return paymentMethod;
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
        int hash = 5;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.paymentAmount) ^ (Double.doubleToLongBits(this.paymentAmount) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.paymentMethod);
        hash = 17 * hash + Objects.hashCode(this.payedBy);
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
        if (!Objects.equals(this.paymentMethod, other.paymentMethod)) {
            return false;
        }
        return Objects.equals(this.payedBy, other.payedBy);
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentAmount=" + paymentAmount + ", paymentMethod=" + paymentMethod + ", payedBy=" + payedBy + '}';
    }
}
