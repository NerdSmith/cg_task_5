package ru.vsu.cs.utils2d;

import java.util.Random;

public class RndUtils {
    private static Random rnd = new Random();

    public static int getRandomNumber(int min, int max) {
        return (int) ((rnd.nextDouble() * (max - min)) + min);
    }
}
