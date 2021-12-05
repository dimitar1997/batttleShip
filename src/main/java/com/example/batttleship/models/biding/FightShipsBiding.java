package com.example.batttleship.models.biding;

import com.example.batttleship.models.entity.Ship;

public class FightShipsBiding {
  private  Ship c;
  private  Ship a;

    public FightShipsBiding() {
    }

    public Ship getC() {
        return c;
    }

    public FightShipsBiding setC(Ship c) {
        this.c = c;
        return this;
    }

    public Ship getA() {
        return a;
    }

    public FightShipsBiding setA(Ship a) {
        this.a = a;
        return this;
    }
}
