package RocketComponents;

import enums.ItemState;
import interfaces.Colorful;
import time.Timer;

public abstract class RocketComponent implements Colorful {
    private ItemState state;
    private String color;

    public RocketComponent() {
        if (Math.random() > 0.5) {
            state = ItemState.CORRECT;
        } else {
            state = ItemState.BROKEN;
        }
        color = "Металлический";
    }

    public boolean checkState() {
        System.out.println(this + " " + state);
        return state == ItemState.CORRECT;
    }

    public void fix() {
        if (state == ItemState.CORRECT) {
            System.out.println(this + " уже починено");
            return;
        }
        int hours = (int) (Math.random() * 10);
        int minutes = (int) (Math.random() * 60);
        int seconds = (int) (Math.random() * 60);
        System.out.println("Идёт починка " + this);
        Timer.takes(hours, minutes, seconds);
        if (Math.random() > 0.2) state = ItemState.CORRECT;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void describeColor() {
        System.out.println(this + " имеет цвет " + color);
    }
}
