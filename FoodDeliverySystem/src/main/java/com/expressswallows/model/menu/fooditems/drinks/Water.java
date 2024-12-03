package com.expressswallows.model.menu.fooditems.drinks;

/**
 * Water class is used to represent water as a drink.
 */
public class Water extends Drink {
    private static final int sugarContent = 0;

    /**
     * All argument constructor for a water drink.
     * @param size the size of the drink.
     */
    public Water(Drink.Size size) {
        super(size.getCookTime(), size.getPrice());
    }

    /**
     * Prepare the water.
     */
    @Override
    public void prepare() {
        this.setSugarContent(sugarContent);
    }
}