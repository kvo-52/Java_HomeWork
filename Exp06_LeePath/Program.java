package Exp06_LeePath;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Program {
    public static void main(String[] args) {
      
        CreateField f = new CreateField(10, 10);
        f.generationWall(); // Генерация стен
        f.generationPoints(); // Генерация старт/финиш
        AlgoritmLee f2=new AlgoritmLee(f.getMapSize());
        f2.algoritmWave(f.getPoints(), f.getMap()); // Волновой алгоритм
        f2.searchPath(f.getPoints()); // Поиск пути

        JFrame window = new JFrame("SeachFieldCat");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().add(window, new ViewField(), 0);
        window.pack();
        window.setVisible(true);
    }
}
