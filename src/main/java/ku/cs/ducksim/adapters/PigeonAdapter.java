package ku.cs.ducksim.adapters;

import ku.cs.ducksim.flock.Pigeon;
import ku.cs.ducksim.flock.Quackable;

public class PigeonAdapter implements Quackable {
    private Pigeon pigeon;

    public PigeonAdapter(Pigeon pigeon) {
        this.pigeon = pigeon;
    }

    @Override
    public void quack() {
        pigeon.coo();
        pigeon.coo();
    }
}
