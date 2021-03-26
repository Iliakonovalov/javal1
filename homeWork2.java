public class homeWork2
{
    public static void main(String[] args)
    {
        boolean c = checkSum(10, 11);
        System.out.println(c);
        negOrPos1(3);
        boolean e = negOrPos2(-2);
        System.out.println(e);
        writeWord("Помогите, 5-е задание пугает меня", 3);
        boolean k = leapYear(2020);
        System.out.println(k);

    }

    public static boolean checkSum(int a, int b)
    {
        int sum = a + b;
        return sum > 10 && sum <= 20;
    }

    public static void negOrPos1(int a)
    {
        if (a >= 0)
        {
            System.out.println("Число положительное");
        } else
        {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean negOrPos2(int d)
    {
        return d < 0;
    }

    public static void writeWord(String string, int f)
    {
        int i;
        for (i = 0; i < f; i++)
        {
            System.out.println(string);
        }
    }

    public static boolean leapYear(int g)
    {
        return (g % 4 == 0 && g % 100 != 0) || g % 400 == 0;
    }


}
