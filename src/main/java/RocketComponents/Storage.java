package RocketComponents;

import interfaces.Movable;

public class Storage extends RocketComponent {
    private final Movable[] cargoSlots;
    private int availableWeight;
    private int usedSlots;

    public Storage(int availableWeight) {
        super();
        this.availableWeight = availableWeight;
        this.cargoSlots = new Movable[1 + (int) (Math.random() * 10)];
        this.usedSlots = 0;
    }

    public boolean load(Movable cargo) {
        if (availableWeight >= cargo.getWeight() && usedSlots < cargoSlots.length) {
            availableWeight -= cargo.getWeight();
            cargoSlots[usedSlots] = cargo;
            usedSlots++;
            return true;
        }
        return false;
    }

    public Movable[] getCargoSlots() {
        return cargoSlots;
    }

    public String toString() {
        return "Ракетное хранилище на " + cargoSlots.length + " отсеков";
    }
}
