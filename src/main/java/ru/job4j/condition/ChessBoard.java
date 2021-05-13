package ru.job4j.condition;

public class ChessBoard {
    public static int way(int x1, int y1, int x2, int y2) {
        int rsl = 0;
        if (x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0) {
            if (x1 - x2 == y1 - y2 || x1 + x2 == y1 + y2) {
                rsl = Math.abs(x2 - x1);
                rsl = rsl == 0 && rsl < 8 ? Math.abs(y2 - y1) : rsl;
            }
        }
        return rsl;
    }
}