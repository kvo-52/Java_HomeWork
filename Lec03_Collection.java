//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Lec03_Collection
 */


public class Lec03_Collection {

    public static void main(String[] args) {
        //ArrayList<Integer>list1=new ArrayList<>();

        int day = 29;
        int month = 9;
        int year = 1990;
        Integer[] date = { day, month, year };
        List <Integer> d = Arrays.asList(date);
        System.out.println(d);
    }
}