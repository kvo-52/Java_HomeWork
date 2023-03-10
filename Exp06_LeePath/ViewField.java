package Exp06_LeePath;

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class ViewField extends JComponent{
    public static int[] horizon = {16,16}; // Размерность поля
    private static int ratio = 24; // Размерность ячейки

    private static int wW = ratio * (horizon[1] + 2); // Ширина окна
    private static int hW = ratio * (horizon[0] + 2); // Высота окна
    
    public static CreateField f = new CreateField(horizon[0], horizon[1]); // Создание(генерация) лабиринта
    public static AlgoritmLee f2 = new AlgoritmLee(f.getMapSize()); // Волновой алгоритм
    
    private static Color exit = new Color(0, 0, 255, 200); // Выход
    private static Color way = new Color(0, 255, 0, 150); // Путь
    private static Color wall = new Color(0, 0, 0, 200); // Стена
    private static Color cat = new Color(240, 120, 0, 200); // Начало

    private static int fontSize = ratio >> 1; // Размер шрифта
    private static Font monoFont = new Font("Monospaced", Font.BOLD, fontSize); // Шрифт

    
    public void paintComponent(Graphics ender) {
        
        super.paintComponent(ender);
        FontMetrics fstr = ender.getFontMetrics(); // Размер строки

        // Поле - белое
        ender.setColor(Color.WHITE);
        ender.fillRect(0, 0, getWidth(), getHeight());

        // Рамка вокруг активного поля
        int t = ratio >> 3; // Толщина линии
        ender.setColor(Color.BLACK);
        ender.fillRect((ratio-t), (ratio-t), (horizon[1]*ratio + 2*t), (horizon[0]*ratio + 2*t));
        ender.setColor(Color.WHITE);
        ender.fillRect(ratio, ratio, (horizon[1]*ratio), (horizon[0]*ratio));

        // Отрисовка стен на поле
        ender.setColor(wall);
        for (int i = 0; i < horizon[0]; i ++) {
            for (int j = 0; j < horizon[1]; j ++) {
                if (f.getMap()[i][j] == -1) {
                    int x = (i+1) * ratio;
                    int y = (j+1) * ratio;
                    ender.fillRect(y, x, ratio, ratio);
                }
            }
        }

        // Отрисовка пути на поле
        ender.setColor(way);
        for (int i = 0; i < horizon[0]; i ++) {
            for (int j = 0; j < horizon[1]; j ++) {
                if (f2.getPath()[i][j] == 1) {
                    int x = (i+1) * ratio;
                    int y = (j+1) * ratio;
                    ender.fillRect(y, x, ratio, ratio);
                }
            }
        }

        // Отрисовка котейки (начало)
        ender.setColor(cat);
        ender.fillRect(((f.getPoints()[1]+1) * ratio), ((f.getPoints()[0]+1) * ratio), ratio, ratio);
        // Отрисовка выхода (конец)
        ender.setColor(exit);
        ender.fillRect(((f.getPoints()[3]+1) * ratio), ((f.getPoints()[2]+1) * ratio), ratio, ratio);

        // Нанесение возможных ходов
        ender.setColor(Color.BLACK);
        ender.setFont(monoFont);
        for (int i = 0; i < horizon[0]; i ++) {
            for (int j = 0; j < horizon[1]; j ++) {
                if (f2.getMapLi()[i][j] != -1) {
                    String ff = String.format("%d", f2.getMapLi()[i][j]);
                    int w = fstr.stringWidth(ff);
                    int h = fstr.getAscent() >> 2;
                    int x = (i+1) * ratio + fontSize + h;
                    int y = (j+1) * ratio + fontSize - w;
                    ender.drawString(String.format("%d", f2.getMapLi()[i][j]), y, x);
                }
            }
        }
    }
    
    // Размер окна
    public Dimension getPreferredSize() {
        return new Dimension(wW, hW);
    }
    // Минимальный размер окна
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
}
