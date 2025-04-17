package core.composition;
// Interface A
interface Engine {
    void start();
}

// Interface B
interface Transmission {
    void changeGear();
}

// Class implementing both interfaces
class Car implements Engine, Transmission {
    private Engine engine;
    private Transmission transmission;

    public Car(Engine engine, Transmission transmission) {
        this.engine = engine;
        this.transmission = transmission;
    }

    @Override
    public void start() {
        engine.start();
    }

    @Override
    public void changeGear() {
        transmission.changeGear();
    }
}

// Concrete implementation of Engine
class PetrolEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Petrol engine started.");
    }
}

// Concrete implementation of Transmission
class ManualTransmission implements Transmission {
    @Override
    public void changeGear() {
        System.out.println("Manual transmission gear changed.");
    }
}

// Main class to test the functionality
public class Main {
    public static void main(String[] args) {
        Engine engine = new PetrolEngine();
        Transmission transmission = new ManualTransmission();
        Car car = new Car(engine, transmission);

        car.start();
        car.changeGear();
    }
}
