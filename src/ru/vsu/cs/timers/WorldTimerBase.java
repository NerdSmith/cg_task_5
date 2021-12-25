package ru.vsu.cs.timers;

import ru.vsu.cs.model.World;

public interface WorldTimerBase {
    void start();

    void stop();

    void setPeriod(int delay);
}
