package comparator.example;

import comparator.Comparator;
import comparator.Difference;

import java.util.List;

public class TestComparison {

    public static void main(String[] args) {
        Person p1 = new Person("Eduardo", "Guerra", 39, 110);
        Person p2 = new Person("Eduardo", "Guerra", 43, 120);

        List<Difference> diffs = Comparator.compare(p1,p2);
        System.out.println(Comparator.compare(p1,p2));
    }
}
