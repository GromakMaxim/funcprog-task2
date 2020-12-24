package org.example;

public class PieceOfLand {
    private final int width;
    private final int length;
    private final int pricePerSquareMeter;

    public PieceOfLand(int width, int length, int pricePerSquareMeter) {
        this.width = width;
        this.length = length;
        this.pricePerSquareMeter = pricePerSquareMeter;
    }

    public int getPricePerSquareMeter() {
        return pricePerSquareMeter;
    }

    @Override
    public String toString() {
        return "width=" + width + " length=" + length + " price " + pricePerSquareMeter + "\n";
    }
}
