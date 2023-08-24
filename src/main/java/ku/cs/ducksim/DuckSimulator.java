package ku.cs.ducksim;

import ku.cs.ducksim.adapters.*;
import ku.cs.ducksim.decorators.QuackCounter;
import ku.cs.ducksim.factories.*;
import ku.cs.ducksim.flock.*;

public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory();
        AbstractDuckFactory countingEchoedDuckFactory = new CountingEchoedDuckFactory();

        System.out.println("\n================= Duck Simulator ===================");
        simulator.simulate(duckFactory);
        System.out.println("\n======== Duck Simulator with Quack Counter ========");
        simulator.simulate(countingDuckFactory);
        System.out.println("\n==== Duck Simulator with Echoed Quack Counter ====");
        simulator.simulate(countingEchoedDuckFactory);
        System.out.println("\n===================================================");
    }

    private void simulate(AbstractDuckFactory duckFactory) {
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose()); // No decoration
        Quackable pigeon = new PigeonAdapter(new Pigeon()); // No decoration

        System.out.println("\nDuck Simulator With Composite - Flocks");

        Flock flockOfDucks = new Flock();

        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);
        flockOfDucks.add(pigeon);

        Flock flockOfMallards = new Flock();

        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour = duckFactory.createMallardDuck();

        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);

        flockOfDucks.add(flockOfMallards);

        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        simulate(flockOfDucks);

        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
        simulate(flockOfMallards);

        System.out.println("\nThe ducks quacked " +
                QuackCounter.getQuacks() + " times");
        QuackCounter.resetQuacks();
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }

}
