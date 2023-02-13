import java.util.Scanner;

public class TriangleNumber {
    public static void main(String[] args) {
        Scanner Scanner =new Scanner(System.in);
        System.out.print("Введите число: ");
        int number=Scanner.nextInt();
        Scanner.close();
        System.out.println ("Треугольное число = "+Triangle(number)+ "\n" );
    }
    public static int Triangle(int num){
        if (num==1){
            return 1;
        }
        return Triangle(num-1)+num;
    }
}
