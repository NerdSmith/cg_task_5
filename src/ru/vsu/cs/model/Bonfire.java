package ru.vsu.cs.model;

import ru.vsu.cs.utils2d.ColorPalette;
import ru.vsu.cs.utils2d.RndUtils;

public class Bonfire {
    private final int fireWidth;
    private final int fireHeight;
    private int numberOfChunks;

    private int[] fireTempArray;
    private int maxTemp = ColorPalette.colorPalette.length - 1;

    private float keepingFireRate = 0.1f; // from 0 to 1
    private float decayRateMultiplier = 1.3f; // from 1 to 3

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
        int decay = (int) Math.floor(Math.random() * decayRateMultiplier);
        int belowChunkFireIntensity = fireTempArray[belowChunkIndex];
        int newIntegrity = belowChunkFireIntensity - decay + (int) Math.round(Math.random() * keepingFireRate); // decay rate can be modified by this magic nb: 0.0 - default decay / 1.0 - keeping fire
        int newFireIntensity = Math.max(Math.min(newIntegrity, maxTemp), 0); // add intensity to next generations
        int windChunk = Math.max(from - decay + RndUtils.getRandomNumber(-1, 1), 0); // curr wind rate
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

    public void setKeepingFireRate(float keepingFireRate) {
        this.keepingFireRate = keepingFireRate;
    }

    public void setDecayRateMultiplier(float decayRateMultiplier) {
        this.decayRateMultiplier = decayRateMultiplier;
    }
}
