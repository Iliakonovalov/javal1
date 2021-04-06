import java.util.Random;
import java.util.Scanner;

public class homeWork4 {
    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 3;

    public static final char DOT_EMPTY = '.';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true)
        {
            humanTurn();
            printMap();

            if(checkWin(DOT_X))
            {
                System.out.println("Победил человек!");
                break;
            }

            if(isMapFull())
            {
                System.out.println("Это ничья!");
                break;
            }

            aiTurn();
            printMap();

            if(checkWin(DOT_O))
            {
                System.out.println("Победил компьютер!");
                break;
            }

            if(isMapFull())
            {
                System.out.println("Это ничья!");
                break;
            }
        }

        System.out.println("Игра закончена!");
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void humanTurn()
    {

        Scanner scanner = new Scanner(System.in);
        int x;
        int y;

        do
        {
            System.out.println("Введите координаты в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));

        map[y][x] = DOT_X;

    }

    public static void aiTurn()
    {

        Random random = new Random();
        int x;
        int y;

        do
        {
            System.out.println("Введите координаты в формате X Y");
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));

        map[y][x] = DOT_O;

    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }

        if (map[y][x] == DOT_EMPTY) {
            return true;
        }

        return false;
    }

    public static boolean checkWin(char symb)
    {
        int end = map.length - DOTS_TO_WIN;

        for (int i = 0; i <= end; i++)
        {
            if (isDiagonalFilled(symb, i))
            {
                return true;
            }

            for (int j = 0; j <= end; j++)
            {
                boolean possWin = isLineFilled(symb, i, j);

                if (possWin)
                {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean isLineFilled(char symb, int rowOffset, int columnOffset)
    {
        for (int row = rowOffset; row < (DOTS_TO_WIN + rowOffset); row++)
        {
            int horizontal = 0;
            int vertical = 0;

            for (int column = columnOffset; column < (DOTS_TO_WIN + columnOffset); column++)
            {
                if (map[row][column] == symb)
                {
                    horizontal++;
                }
                else
                {
                    horizontal = 0;
                }
                if (map[column][row] == symb)
                {
                    vertical++;
                }
                else
                {
                    vertical = 0;
                }
            }

            if ((horizontal == DOTS_TO_WIN) || (vertical == DOTS_TO_WIN))
            {
                return true;
            }
        }
        return false;
    }

    static boolean isDiagonalFilled(char symb, int rowOffset)
    {
        int mainDiagonalCounter = 0;
        int sideDiagonalCounter = 0;

        final int subSquareLength = (DOTS_TO_WIN + rowOffset);

        for (int row = rowOffset; row < subSquareLength; row++)
        {
            if (map[row][row] == symb)
            {
                mainDiagonalCounter++;
            }
            else
            {
                mainDiagonalCounter = 0;
            }

            if (map[row][map.length - 1 - row] == symb)
            {
                sideDiagonalCounter++;
            }
            else
            {
                sideDiagonalCounter = 0;
            }
        }
        return (mainDiagonalCounter == DOTS_TO_WIN) || (sideDiagonalCounter == DOTS_TO_WIN);
    }

    public static boolean isMapFull()
    {
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                if(map[i][j] == DOT_EMPTY)
                {
                    return false;
                }
            }
        }

        return true;
    }

}
