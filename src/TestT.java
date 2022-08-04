import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestT extends Car{
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);

        List<Integer> sub = integers.subList(0,3);
        System.out.println(sub);
    }
}
