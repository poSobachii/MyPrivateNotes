package JavaBasics.a5_Arrays_and_Collections.a53_Lists;

import JavaBasics.a5_Arrays_and_Collections.Plane;

import java.util.Comparator;

public class PlaneComparator implements Comparator<Plane> {

    @Override
    public int compare(Plane plane1, Plane plane2) {
        if(plane1.getAge() > plane2.getAge()) {
            return 1;
        } else if (plane1.getAge() < plane2.getAge()) {
            return -1;
        }
        return 0;
    }
}
