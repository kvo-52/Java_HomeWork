import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

//1.metod input data
//2.metod raisingNumber - возведения числа
//3.metod read in file -"readFile"
//4.metod write for file - "writeMyFile "
//5.main

public class Exp02_raisingNumber {
    public static void main(String[] args) {
        
        
    }

    //чтение файла
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

    // запись в файл
    public void writeMyFile(int a, int b) {

        try (FileWriter fw = new FileWriter("output.txt", false)) {
            if (a == 0 && b == 0) {
                fw.write("не определено");
                fw.close();
            } else {
                fw.write(String.format("а = %d, b = %d, ответ: %f", a, b, Math.pow(a, b)));
                fw.close();
            }
        }

        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
// Получение данных от пользователя
public static int getNumberUser(String text) {
    int i;
    while (true) {
        Scanner sc = new Scanner(System.in);
        System.out.print(text);
        if (sc.hasNextInt()) {
            i = sc.nextInt();
            break;
        } else {
            System.out.println("Вы ввели не целое число");
        }
    }
    return i;
}

// Возведение в степень
public static double raising(int number, int degree) {
    double result = 1;
    if (degree > 0) {
        for (int i = 1; i <= degree; i++) {
            result *= number;
        }
        return result;
    } else if (degree < 0) {
        for (int i = -1; i > degree; i--) {
            result *= number;
        }
        result = 1 / (result * number);
        return result;
    } else {
        return 1;
    }
}


    
}
