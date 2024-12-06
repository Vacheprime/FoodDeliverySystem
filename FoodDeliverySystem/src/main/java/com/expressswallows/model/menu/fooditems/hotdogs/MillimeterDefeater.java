package com.expressswallows.model.menu.fooditems.hotdogs;

/**
 * MillimeterDefeater class is used to represent the Millimeter Defeater hotdog.
 */
public class MillimeterDefeater extends Hotdog {
    private static final int spiciness = 10;
    private static final int cookTime = 3;
    private static final double price = 3.99;

    /**
     * All argument constructor for a new millimeter defeater.
     * @param bun the bun type.
     */
    public MillimeterDefeater(HotdogBun bun) {
        super(cookTime, price, bun);
    }

    /**
     * Prepare the MillimeterDefeater.
     */
    @Override
    public void prepare() {
        this.setSpiciness(spiciness);
    }
}
