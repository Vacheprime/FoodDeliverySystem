package com.expressswallows.model.menu.fooditems.drinks;

/**
 * Coke class represents the Coke drink.
 */
public class Coke extends Drink {
    private static final int sugarContent = 30;

    /**
     * All argument constructor for a new coke.
     * @param size the size of the coke.
     */
    public Coke(Drink.Size size) {
        super(size.getCookTime(), size.getPrice(), size);
        this.prepare();
    }

    @Override
    public String getDatabaseType() {
        return "DRINK:COKE:"+getSize();
    }

    /**
     * Prepare the Coke.
     */
    @Override
    public void prepare() {
        this.setSugarContent(sugarContent);
    }

    @Override
    public String toString() {
        return super.toString();
    }
  
    
}
