package ru.vsu.cs.timers;

import ru.vsu.cs.model.World;

public class WorldTimer extends AbstractWorldTimer {
    public WorldTimer(World world, int period) {
        super(world, period);
    }

    @Override
    void worldAction(World w) {
        actualWorld.update();
    }

    @Override
    public void start() {
        super.start();
    }
}
