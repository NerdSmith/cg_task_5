package ru.vsu.cs.model;

import ru.vsu.cs.utils2d.ColorPalette;

public class Bonfire {
    private final int fireWidth;
    private final int fireHeight;
//    private int chunkSize = 4;
    private int numberOfChunks;

    private int[] fireTempArray;
    private int maxTemp = ColorPalette.colorPalette.length - 1;

    public Bonfire(int fireWidth, int fireHeight) {
        this.fireWidth = fireWidth;
        this.fireHeight = fireHeight;

        this.numberOfChunks = fireWidth * fireHeight;
        this.fireTempArray = new int[numberOfChunks];

        createFireSource();
    }

    private void createFireSource() {
        for (int col = 0; col < fireWidth; col++) {
            int currChunk = numberOfChunks - fireWidth + col;
            fireTempArray[currChunk] = maxTemp;
        }
    }

    public void calculateFirePropagation() {
        for (int column = 0; column < fireWidth; column++) {
            for (int row = 0; row < fireHeight; row++) {
                updateFireIntensityPerPixel(row * fireWidth + column);
            }
        }
    }

    private void updateFireIntensityPerPixel(int from) {
        int belowChunkIndex = from + fireWidth;

        if (belowChunkIndex >= numberOfChunks) {
            return;
        }
        int decay = (int) Math.floor(Math.random() * 2);
        int belowChunkFireIntensity = fireTempArray[belowChunkIndex];
        int newIntegrity = belowChunkFireIntensity - decay + (int) Math.round(Math.random() * 0.7); // decay rate can be modified by this magic nb: 0.0 - default decay / 1.0 - keeping fire
        int newFireIntensity = Math.max(Math.min(newIntegrity, maxTemp), 0); // add intensity to next generations
        int windChunk = Math.max(from - decay , 0); // curr wind rate
        fireTempArray[windChunk] = newFireIntensity;
    }

    public void resetFire() {
        for (int i = 0; i < numberOfChunks; i++) {
			fireTempArray[i] = 0;
		}
        createFireSource();
    }

    public int getFireWidth() {
        return fireWidth;
    }

    public int getFireHeight() {
        return fireHeight;
    }

    public int[] getFireTempArray() {
        return fireTempArray;
    }
}
