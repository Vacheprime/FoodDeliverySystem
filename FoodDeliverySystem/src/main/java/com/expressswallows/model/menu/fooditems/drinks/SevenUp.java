package com.expressswallows.model.menu.fooditems.drinks;

/**
 * SevenUp class represents the Seven Up drink.
 */
public class SevenUp extends Drink {
    private static final int sugarContent = 25;

    /**
     * All argument constructor for a new seven up
     * @param size the size of the seven up.
     */
    public SevenUp(Drink.Size size) {
        super(size.getCookTime(), size.getPrice());
    }

    /**
     * Prepare the seven up.
     */
    @Override
    public void prepare() {
        this.setSugarContent(sugarContent);
    }
}
