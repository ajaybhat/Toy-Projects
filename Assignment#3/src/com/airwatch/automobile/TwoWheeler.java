package com.airwatch.automobile;

/**
 * Created by ABhat on 12 Aug 2014 - 12/08/14.
 */
public abstract class TwoWheeler implements Automobile {
    @Override
    public int getNumOffWheels() {
        return 2;
    }
}
