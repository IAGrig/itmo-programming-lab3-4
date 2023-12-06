package cargo;

import interfaces.Colorful;
import interfaces.Movable;

public abstract class Cargo implements Movable, Colorful {
    private int weight;
    private String color;

    public Cargo(String color) {
        weight = (int) (5 + Math.random() * 80);
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void describeColor() {
        System.out.println(this + " имеет цвет " + color);
    }
}
