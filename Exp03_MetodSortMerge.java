import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

// 1. Метод создания массива
// 2. Метод сортировки слиянием
// 3. Печать результата

public class Exp03_MetodSortMerge {
    public static void main(String[] args) throws IOException{
        System.out.println("Сортировка методом слияния.");
        ArrayList<Integer> array1 = createArray();
        System.out.println("Исходный список:");
        System.out.println(array1);
        
        ArrayList<Integer> array2 = new ArrayList<>();
        array2 = mergeSort(array1);
        System.out.println("Отсортированный список:");
        System.out.println(array2);
    }


public static ArrayList<Integer> createArray() {
    Random randomArray= new Random();
    int size=randomArray.nextInt(10,20);
    ArrayList <Integer> myArray= new ArrayList<> (size);
    for (int i=0; i<size; i++){
        myArray.add(i, (randomArray.nextInt(30)));
    }
    return myArray;
}


public static ArrayList<Integer> mergeSort(ArrayList<Integer> array) {
    int size = array.size();
    if (size > 1) {
        int size_a = size >> 1;
        int size_b = size - size_a;

        ArrayList<Integer> arr_a = new ArrayList<Integer>(size_a);
        ArrayList<Integer> arr_b = new ArrayList<Integer>(size_b);

        for (int i = 0; i < size; i ++) {
            if(i < size_a) { arr_a.add(i, array.get(i));}
            else { arr_b.add((i-size_a), array.get(i));}
        }

        arr_a = mergeSort(arr_a);
        arr_b = mergeSort(arr_b);

        int a = 0;
        int b = 0;

        array.removeAll(array);

        while ((a < size_a) && (b < size_b)) {
            if ((arr_a.get(a)) < (arr_b.get(b))) {
                array.add(arr_a.get(a));
                a ++;
            }
            else {
                array.add(arr_b.get(b));
                b ++;
            }
        }

        if (a == size_a){
            for (; b < size_b; b ++ ) { array.add(arr_b.get(b));}
        }
        else {
            for (; a < size_a; a ++ ) { array.add(arr_a.get(a));}
        }
    }
    return array;
}

    }


    
    