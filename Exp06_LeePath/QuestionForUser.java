package Exp06_LeePath;

import java.util.Scanner;

public class QuestionForUser{
    private static String text;

    public static int questionForUser(String text) {
        QuestionForUser.text = text;
        int i=Integer.parseInt(text);
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print(text);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                if (i > 2) {
                    break;
                } else {
                    System.out.println("Нужно число больше 2");
                }
            } else {
                System.out.println("Вы ввели не целое число");
            }
        }
        return i;
}
}