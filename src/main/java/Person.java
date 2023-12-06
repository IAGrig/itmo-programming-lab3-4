import enums.Gender;
import exceptions.NoClothesException;
import interfaces.Colorful;
import interfaces.Movable;
import interfaces.Moving;
import interfaces.Speakable;
import time.Timer;

public class Person implements Speakable, Moving, Movable {
    private final String name;
    private final Gender gender;
    private final int force;
    private final int weight;
    private int energy;
    private String clothing;

    public Person(String name, Gender gender, int energy, int force, int weight, String clothing) {
        this.name = name;
        this.gender = gender;
        this.energy = energy;
        this.force = force;
        this.weight = weight;
        this.clothing = clothing;
    }

    public void say(String phrase) {
        System.out.println(this + " говорит " + phrase);
    }

    public void go(int distance, int speed) {
        int energyCost = (int) (speed * Math.log(speed));
        while (distance > 0) {
            if (energy >= energyCost) {
                System.out.printf("%s проходит %d метров%n", this, speed);
                energy -= energyCost;
            } else {
                System.out.println(this + " устал");
                rest();
            }
        }
    }

    public void rest() {
        int restoredEnergy = (int) (10 + Math.random() * 40);
        System.out.printf("%s отдыхает и восстанавливает %d%n", this, restoredEnergy);
        energy += restoredEnergy;
    }

    public void move(Movable object) {
        int energyCost = (int) (object.getWeight() * Math.log10(object.getWeight()));
        if (energy >= energyCost) {
            energy -= energyCost;
            System.out.println(this + " двигает " + object);
            int timeCost = (int) (object.getWeight() / Math.log10(object.getWeight()));
            Timer.takes(timeCost);
            return;
        }
        System.out.println(this + " устал");
        rest();
        move(object);
    }

    public void move(Movable object, int distance) {
        final int distanceParts = 2;
        int distancePart = distance / distanceParts;
        int energyCost = (int) (distancePart * object.getWeight() * Math.log(object.getWeight())) / 1000;
        for (int i = 0; i < distanceParts; i++) {
            if (energy >= energyCost) {
                System.out.printf("%s несёт %s %d метров%n", this, object, distancePart);
                energy -= energyCost;
                int timeCost = (int) (distance / 2 * (1 + Math.random()) / 6 * Math.log10(1 + object.getWeight()));
                Timer.takes(timeCost);
            } else {
                rest();
            }
        }
    }

    public void changeColor(Colorful colorful, String color) {
        System.out.println(this + " красит " + colorful + " в цвет " + color);
        colorful.setColor(color);
    }

    public void undress() throws NoClothesException {
        if (clothing.isEmpty()) throw new NoClothesException("Нечего снимать");
        System.out.println(this + " снимает с себя " + clothing);
        clothing = "";
    }

    public void undress(Person person) throws NoClothesException {
        if (person.clothing.isEmpty()) throw new NoClothesException("Нечего снимать");
        System.out.println(this + " снимает " + person.getClothing() + " с " + person);
        person.clothing = "";
    }

    public void dress(String clothing) {
        System.out.println(this + " надевает " + clothing);
        this.clothing = clothing;
    }

    public void dress(Person person, String clothing) {
        System.out.println(this + " одевает " + clothing + "на" + person);
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getEnergy() {
        return energy;
    }

    public int getForce() {
        return force;
    }

    public int getWeight() {
        return weight;
    }

    public String getClothing() {
        return clothing;
    }
}
