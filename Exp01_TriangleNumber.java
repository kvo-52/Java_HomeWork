import java.util.Scanner;

public class Exp01_TriangleNumber {
    public static void main(String[] args) {
        Scanner Scanner =new Scanner(System.in);
        System.out.print("Введите число: ");
        int number=Scanner.nextInt();
        Scanner.close();
        printNumber(number);
    }

    // Print rezult
    public static void printNumber(int number){
        System.out.println ("Треугольное число = "+Triangle(number)+ "\n" );
    }

    // metod triangle number
    public static int Triangle(int num){
        if (num==1){
            return 1;
        }
        return Triangle(num-1)+num;
    }
}
