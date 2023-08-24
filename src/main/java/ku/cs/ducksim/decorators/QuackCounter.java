package ku.cs.ducksim.decorators;

import ku.cs.ducksim.flock.Quackable;

public class QuackCounter implements Quackable {
    private Quackable duck;
    private static int numberOfQuacks;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++;
    }

    public static int getQuacks() {
        return numberOfQuacks;
    }

    public static void resetQuacks() {
        numberOfQuacks = 0;
    }
}
