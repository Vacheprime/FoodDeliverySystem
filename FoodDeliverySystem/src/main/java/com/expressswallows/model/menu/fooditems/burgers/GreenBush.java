package com.expressswallows.model.menu.fooditems.burgers;

/**
 * GreenBush class is used to represent a Green Bush burger.
 */
public class GreenBush extends Burger {
    private static final int spiciness = 5;
    private static final int cookTime = 7;
    private static final double price = 19.99;

    /**
     * All argument constructor for a new Green Bush burger.
     * @param sauce the burger sauce.
     */
    public GreenBush(BurgerSauce sauce) {
        super(cookTime, price, sauce);
    }

    /**
     * Prepare the Green Bush.
     */
    @Override
    public void prepare() {
        this.setSpiciness(spiciness);
    }
}
