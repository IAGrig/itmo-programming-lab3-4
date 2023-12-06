import RocketComponents.*;
import exceptions.MissingComponentException;
import interfaces.Colorful;
import interfaces.Movable;
import interfaces.Moving;

public class Rocket implements Moving, Colorful {
    private final Engine engine;
    private final Battery battery;
    private final Machinery machinery;
    private final Capsulation capsulation;
    private final Storage storage;
    private String color;

    public Rocket(String color) {
        engine = new Engine();
        battery = new Battery();
        machinery = new Machinery();
        capsulation = new Capsulation();
        storage = new Storage(800);
        this.color = color;
    }

    public boolean load(Movable object, Person... people) throws MissingComponentException {
        if (storage == null) throw new MissingComponentException("Отсутствует хранилище ракеты");
        int peopleSumForce = 0;
        StringBuilder peopleNames = new StringBuilder();
        for (Person person : people) {
            peopleSumForce += person.getForce();
            peopleNames.append(person.getName()).append(", ");
        }
        peopleNames = peopleNames.delete(peopleNames.length() - 2, peopleNames.length());
        if (peopleSumForce >= object.getWeight()) {
            System.out.println(peopleNames + " засовывают " + object + " в ракету");
            return storage.load(object);
        } else {
            System.out.println("Сил " + peopleNames + " недостаточно для загрузки " + object);
            return false;
        }
    }

    public void tryToFlight() {
        System.out.println("Попытка запуска ракеты. Проверка узлов и компонентов:");
        if (checkState()) {
            System.out.println("Ракета запущена");
            for (Movable cargo : storage.getCargoSlots()) {
                if (cargo != null) move(cargo);
            }
        } else {
            System.out.println("Обнаружена неисправность. Запуск ракеты невозможен");
        }

    }

    public void move(Movable object) {
        System.out.println("Ракета перевозит " + object);
    }

    public void move(Movable object, int distance) {
        long speed = 10;
        while (distance > 0) {
            System.out.printf("Ракета пролетает $d метров %n", speed);
            distance -= speed;
            speed *= 15;
        }
    }

    public boolean checkState() throws MissingComponentException {
        System.out.println("Запущена проверка состояния ракеты");
        if (engine == null || machinery == null || capsulation == null || battery == null || storage == null) {
            throw new MissingComponentException("Не хватает компонентов ракеты");
        }
        boolean resultState = true;
        if (!engine.checkState()) {
            engine.fix();
            resultState = false;
        }
        if (!machinery.checkState()) {
            machinery.fix();
            resultState = false;
        }
        if (!capsulation.checkState()) {
            capsulation.fix();
            resultState = false;
        }
        if (!battery.checkState()) {
            battery.fix();
            resultState = false;
        }
        if (!storage.checkState()) {
            storage.fix();
            resultState = false;
        }
        return resultState;
    }

    public void fix() {
        engine.fix();
        battery.fix();
        machinery.fix();
        capsulation.fix();
        storage.fix();
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void describeColor() {
        System.out.println(this + " имеет цвет " + color);
    }

    public String toString() {
        return "Космическая ракета";
    }
}
