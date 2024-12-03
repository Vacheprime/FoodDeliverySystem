package com.expressswallows.model.menu.fooditems.hotdogs;

import com.expressswallows.model.menu.fooditems.Food;
import com.expressswallows.utils.Utils;
import java.util.Objects;

/**
 * Hotdog class is used to represent all menu items that are hot dogs
 */
public abstract class Hotdog extends Food {
    private HotdogBun bun;
    private int spiciness;

    /**
     * HotdogBun enum is used to represent all bun types.
     */
    public enum HotdogBun {
        SOGGY(0),
        WHITE(0.99);

        // Store the price of a bun type
        private final double price;

        /**
         * Constructor for a bun type.
         * @param price the price of the bun.
         */
        HotdogBun(double price) {
            this.price = price;
        }

        /**
         * Getter for the price of the bun type.
         * @return the price of the bun type.
         */
        public double getPrice() {
            return price;
        }
    }

    /**
     * All argument constructor for a new hotdog.
     * @param cookTime the cook time of the wiener.
     * @param price the price of the wiener.
     * @param bun the bun type of the wiener.
     */
    public Hotdog(int cookTime, double price, HotdogBun bun) {
        super(cookTime, price);
        if (bun == null) {
            throw new IllegalArgumentException("The bun argument cannot be null.");
        }
        this.bun = bun;
    }

    /**
     * Getter for the hotdog bun.
     * @return the bun type.
     */
    public HotdogBun getBun() {
        return bun;
    }

    /**
     * Setter for the hotdog bun.
     * @param bun the new hotdog bun.
     */
    public void setBun(HotdogBun bun) {
        if (bun == null) {
            throw new IllegalArgumentException("The bun argument cannot be null.");
        }
        this.bun = bun;
    }

    /**
     * Getter for the spiciness level.
     * @return the spiciness level.
     */
    public int getSpiciness() {
        return spiciness;
    }

    /**
     * Setter for the spiciness level.
     * @param spiciness the spiciness level.
     */
    public void setSpiciness(int spiciness) {
        if (!Utils.validateSpicinessLevel(spiciness)) {
            throw new IllegalArgumentException("The spiciness level must be between 0 and 10.");
        }
        this.spiciness = spiciness;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Hotdog hotdog)) return false;
        if (!super.equals(o)) return false;
        return spiciness == hotdog.spiciness && bun == hotdog.bun;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bun, spiciness);
    }

    @Override
    public String toString() {
        return "Hotdog{" +
                "bun=" + bun +
                ", spiciness=" + spiciness +
                '}';
    }
}
