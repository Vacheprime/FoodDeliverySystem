/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.expressswallows.model.menu.fooditems;

import java.util.Objects;

/**
 * Fries class represents the fries item.
 * @author shahi
 */
public class Fries extends Food {
    private FriesSize size;
    
    /**
     * FriesSize enum is used to represent the available portion sizes for fries.
     */
    public enum FriesSize {
        SMALL,
        MEDIUM,
        LARGE
    }

    /**
     * All argument constructor for a fries food item.
     * 
     * @param size the size of the fries.
     */
    public Fries(FriesSize size) {
        if (size == null) {
            throw new IllegalArgumentException("The fries size cannot be null.");
        }
        this.size = size;
    }

    /**
     * Getter for the size of the fries.
     * @return the size of the fries.
     */
    public FriesSize getSize() {
        return size;
    }

    /**
     * Prepare the Fries based on the size chosen.
     */
    @Override
    public void prepare() {
        switch (size) {
            case SMALL -> {
                setCookTime(2);
                setPrice(2.99);
            }
            case MEDIUM -> {
                setCookTime(3);
                setPrice(3.49);
            }
            case LARGE -> {
                setCookTime(4);
                setPrice(4.99);
            }
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.size);
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
        final Fries other = (Fries) obj;
        return this.size == other.size;
    }

    @Override
    public String toString() {
        return "Fries{" + "size=" + size + '}';
    }
}
