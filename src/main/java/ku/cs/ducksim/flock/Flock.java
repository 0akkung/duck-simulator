package ku.cs.ducksim.flock;

import ku.cs.ducksim.decorators.AlphaDuck;

import java.util.ArrayList;
import java.util.Iterator;

public class Flock implements Quackable {
    private ArrayList<Quackable> quackers = new ArrayList<>();

    public void add(Quackable quacker) {
        if (quackers.isEmpty()) {
            quacker = new AlphaDuck(quacker);
        }
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        Iterator<Quackable> iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = iterator.next();
            quacker.quack();
        }
    }
}
