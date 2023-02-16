import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//1.metod input data
//2.metod raisingNumber - возведения числа
//3.metod read in file -"readFile"
//4.metod write for file - " "
//5.main

public class Exp02_raisingNumber {
    public static void main(String[] args) {
        
    }

    public static int[] readFile() throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file); 
        String line = scan.nextLine(); 
        int[] intArray = new int[2];
        String[] stringArray = line.split(" "); 
        if(stringArray[0] == "a"){
            intArray[0] = Integer.parseInt(stringArray[1]); 
            stringArray = scan.nextLine().split(" "); 
            intArray[1] = Integer.parseInt(stringArray[1]); 
        }
        else {
            intArray[1] = Integer.parseInt(stringArray[1]);
            stringArray = scan.nextLine().split(" ");
            intArray[0] = Integer.parseInt(stringArray[1]);
        }
        return intArray;
    }    
}
