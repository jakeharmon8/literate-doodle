package com.literdood.math;

public class Vector {
    public float x, y;

    public Vector(float x, float y) {
        this.x = x; this.y = y;
    }

    public float magnitude() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public Vector unit() {
        return new Vector(x/magnitude(), y/magnitude());
    }

    public Vector multiply(float val) {
        return new Vector(x * val, y * val);
    }
}
