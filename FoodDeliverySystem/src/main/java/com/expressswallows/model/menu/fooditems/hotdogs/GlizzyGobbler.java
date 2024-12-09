package com.expressswallows.model.menu.fooditems.hotdogs;

/**
 * GlizzyGobbler class is used to represent the Glizzy Gobbler hotdog.
 */
public class GlizzyGobbler extends Hotdog {
    private static final int spiciness = 3;
    private static final int cookTime = 5;
    private static final double price = 7.99;

    /**
     * All argument constructor for a new glizzy gobbler hotdog.
     * @param bun the bun type of the hotdog.
     */
    public GlizzyGobbler(HotdogBun bun) {
        super(cookTime, price, bun);
        this.prepare();
    }

    @Override
    public String getDatabaseType() {
        return "HOTDOG:GLIZZYGOBBLER";
    }

    /**
     * Prepare the GlizzyGobbler.
     */
    @Override
    public void prepare() {
        this.setSpiciness(spiciness);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
    
}
