package ku.cs.ducksim.adapters;

import ku.cs.ducksim.flock.Goose;
import ku.cs.ducksim.flock.Quackable;

public class GooseAdapter implements Quackable {
    private Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }
}
