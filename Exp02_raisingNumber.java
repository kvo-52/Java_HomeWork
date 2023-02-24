import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

//1.metod inputData
//2.metod raising- возведения числа
//3.metod read in file -"readFile"
//4.metod write for file - "writeMyFile "
//5.main

public class Exp02_raisingNumber {
    public static void main(String[] args) throws Exception {
        Integer a = getDataForUser("Введите число а: ");
        Integer b = getDataForUser("Введите число b: ");
        System.out.println("Число " + a + " в степени " + b + " = " + raising(a, b));
        String pathInput = "input.txt";
        String pathOutput = "output.txt";
        String saveStr = String.format("a %d\nb %d", a, b);
        writeFile(saveStr, pathInput);
        System.out.printf("\nДанные записаны в файл %s\n", pathInput);

        inputData(pathInput);
        int[] argAB = readFile(pathInput, "a", "b"); //  получаем массив с переменными а и b
        int newA = argAB[0];
        int newB = argAB[1];

        if (a ==0 && b == 0) {
            saveStr = "не определено";
        }
        else {
            Double intResult = raising(newA, newB);
            saveStr = String.valueOf(intResult);
        }
        writeFile(saveStr, pathOutput);
        System.out.printf("\nРезультат записан в файл %s\n", pathOutput);
        inputData(pathOutput);

    }

    //чтение файла
    public static int[] readFile(String fileName, String a, String b) throws Exception {
        Scanner scan = new Scanner(new File(fileName));
        int[] intArr = new int[2];
        int index = 0;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] strArr = line.split(" ");
            if (a.equalsIgnoreCase(strArr[0])) {
                intArr[0] = Integer.parseInt(strArr[1]);
            } else if (b.equalsIgnoreCase(strArr[0])) {
                intArr[1] = Integer.parseInt(strArr[1]);
            }
            index++;
        }
        scan.close();
        return intArr;
    }

    // Чтение из файла и вывод в терминал
    public static void inputData(String text) throws Exception {
        File f = new File(text);
        Scanner scan = new Scanner(f);
        while (scan.hasNextLine()) {
            String msg = scan.nextLine();
            System.out.println(msg);
        }
    }

    // запись в файл
    public static void writeFile(String data, String path) {
        try (FileWriter wfile = new FileWriter(path, false)) {
            wfile.write(data);
            wfile.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

// Получение данных от пользователя
public static int getDataForUser(String text) {
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
