package ru.vsu.cs.timers;

import ru.vsu.cs.model.World;

public interface WorldTimer {
    void start();

    void stop();

    void setPeriod(int delay);
}
