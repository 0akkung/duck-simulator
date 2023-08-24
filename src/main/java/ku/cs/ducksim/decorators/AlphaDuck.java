package ku.cs.ducksim.decorators;

import ku.cs.ducksim.flock.Quackable;

public class AlphaDuck implements Quackable {
    private Quackable alpha;

    public AlphaDuck(Quackable alpha) {
        this.alpha = alpha;
    }

    @Override
    public void quack() {
        System.out.println("-- Alpha --");
        alpha.quack();
        alpha.quack();
        alpha.quack();
        System.out.println("-----------");
    }
}
