package com.expressswallows.model.menu.fooditems.burgers;

/**
 * BigFatty class is used to represent a Big Fatty burger.
 */
public class BigFatty extends Burger {
    private static final int spiciness = 7;
    private static final int cookTime = 10;
    private static final double price = 14.99;

    /**
     * All argument constructor for a Big Fatty burger.
     * @param sauce the sauce of the burger
     */
    public BigFatty(BurgerSauce sauce) {
        super(cookTime, price, sauce);
    }

    /**
     * Prepare the BigFatty.
     */
    @Override
    public void prepare() {
        this.setSpiciness(spiciness);
    }
}
