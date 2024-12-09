package com.expressswallows.model.menu.fooditems.burgers;

/**
 * SkinnyPity class is used to represent the Skinny Pity burger.
 */
public class SkinnyPity extends Burger {
    private static final int spiciness = 0;
    private static final int cookTime = 5;
    private static final double price = 7.99;

    /**
     * All argument constructor for a new Skinny Pity burger.
     * @param sauce the burger sauce.
     */
    public SkinnyPity(BurgerSauce sauce) {
        super(cookTime, price, sauce);
        this.prepare();
    }

    @Override
    public String getDatabaseType() {
        return "BURGER:SKINNYPITY";
    }

    /**
     * Prepare the Skinny Pity.
     */
    @Override
    public void prepare() {
        this.setSpiciness(spiciness);
    }

    @Override
    public String toString() {
        return "Skinny Pity " + super.toString(); 
    }
    
    
    
}
