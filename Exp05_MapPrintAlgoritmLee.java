import java.util.Random;
import java.util.Scanner;

public class Exp05_MapPrintAlgoritmLee {
    public static void main(String[] args) {
        System.out.println("Задайте размер поля");
        int col = questionForUser("Введите длину: ") + 2;
        int row = questionForUser("Введите ширину: ") + 2;

        int[][] battlefield = new int[row][col];
        generationMap(battlefield, col, row);
        addWall(battlefield, col, row);
        printMap(battlefield, col, row);
        

    }

    public static void generationMap(int[][] array, int col, int row) {
        
        int minRow = 0, maxRow = row - 1, minCol = 0, maxCol = col - 1;
        int count = 0;
        int max = (row - 2) * (col - 2);

        for (int i = minCol; i <= maxCol; i++) {
            array[minRow][i] = -9;
        }
        minRow = minRow + 1;
        for (int i = minRow; i <= maxRow; i++) {
            array[i][maxCol] = -9;
        }
        maxCol = maxCol - 1;
        for (int i = maxCol; i >= minCol; i--) {
            array[maxRow][i] = -9;
        }
        maxRow = maxRow - 1;
        for (int i = maxRow; i >= minRow; i--) {
            array[i][minCol] = -9;
        }
        minCol = minCol + 1;

        while (count < max) {
            for (int i = minCol; i <= maxCol; i++) {
                array[minRow][i] = 0;
                count++;
            }
            minRow = minRow + 1;
            for (int i = minRow; i <= maxRow; i++) {
                array[i][maxCol] = 0;
                count++;
            }
            maxCol = maxCol - 1;
            for (int i = maxCol; i >= minCol; i--) {
                array[maxRow][i] = 0;
                count++;
            }
            maxRow = maxRow - 1;
            for (int i = maxRow; i >= minRow; i--) {
                array[i][minCol] = 0;
                count++;
            }
            minCol = minCol + 1;
        }
    }

    public static void printMap(int[][] array, int col, int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%4d ", array[i][j]);
            }
            System.out.println("");
        }
    }

    public static void addWall(int[][] array, int col, int row) {
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            int randCol = r.nextInt(col);
            int randRow = r.nextInt(row);
            array[randCol][randRow] = -1;
        }
    }

    public static int questionForUser(String text) {
        int i;
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
