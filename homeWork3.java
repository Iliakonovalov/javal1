public class homeWork3
{
    public static void main(String[] args)
    {
        changeNumber();
        changeNumber2();
        doubleIfLess();
        cube();
        twoArgs(4, 5);
        whoIsWho();
        int[] leftRight = {1, 5, 3, 2, 3, 3, 1};
        boolean c = checkLeftRight(leftRight);
        System.out.println(c);
        int[] arr = {3, 6, 4, 2, 1};
        int n = 1;
        move(arr, n);




    }

    public static void changeNumber()
    {
        System.out.println("1 задание: ");
        int[] arr = {1, 1, 0, 0, 0, 1, 0};
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
            System.out.println("arr[" + i + "] = " + arr[i]);
        }

    }

    public static void changeNumber2()
    {
        System.out.println("2 задание: ");
        int[] hundred = new int[100];
        for(int i = 0; i < hundred.length; i++)
        {
            hundred[i] = i + 1;
            System.out.println("hundred[" + i + "] = " + hundred[i]);
        }
    }

    public static void doubleIfLess()
    {
        System.out.println("3 задание: ");
        int[] less = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for(int i = 0; i < less.length; i++)
        {
            if(less[i] < 6) {
                less[i] = less[i] * 2;
            }
            System.out.println("less [" + i + "] = " + less[i]);
        }
    }

    public static void cube()
    {
        System.out.println("4 задание: ");
        int[][] sqr = new int[3][3];
        for(int i = 0; i < sqr.length; i++)
        {
            sqr[i][i] = 1;

            for(int j = 0; j < sqr.length; j++)
            {
                if(i + j == sqr.length - 1)
                {
                    sqr[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < sqr.length; i++)
        {
            for(int j = 0; j < sqr.length; j++)
            {
                System.out.println("sqr[" + i + "][" + j + "] = " + sqr[i][j]);
            }
        }
    }

    public static int[] twoArgs(int len, int initialValue)
    {
        System.out.println("5 задание: ");
        int[] name = new int[len];
        for(int i = 0; i < name.length; i++)
        {
            name[i] = initialValue;
            System.out.println("name[" + i + "] = " + name[i]);
        }
        return name;
    }

    public static void whoIsWho()
    {
        System.out.println("6 задание: ");
        int[] find1 = {0, -3, -5, 7, -4};
        int a = 0;
        for(int i = 0; i < find1.length; i++)
        {
            if(find1[i] > a)
            {
                a = find1[i];
            }
        }
        System.out.println("Максимум = " + a);

        for(int i = 0; i < find1.length; i++)
        {
            if(find1[i] < a)
            {
                a = find1[i];
            }
        }
        System.out.println("Минимум = " + a);

    }

    public static boolean checkLeftRight(int[] leftRight)
    {
        System.out.println("7 задание: ");
        int left = 0;
        for (int i = 0; i < leftRight.length; i++)
        {
            left += leftRight[i];
            int right = 0;

            for(int j = i + 1; j < leftRight.length; j++)
            {
                right += leftRight[j];
            }

            if(left == right)
            {
                return true;
            }

        }
        return false;
    }

    public static void move(int[] arr, int n)
    {
        System.out.println("8 задание: ");
        if(posOrNegNum(n))
        {
            for(int i = 0; i < n; i++)
            {
                moveRight(arr);
            }
        } else
        {
            for(int i = 0; i > n; i--)
            {
                moveLeft(arr);
            }
        }

        for(int i = 0; i < arr.length; i++)
        {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }

    public static void moveRight(int[] arr)
    {
        int enValue = arr[0];
        arr[0] = arr[arr.length - 1];

        for(int i = 1; i < (arr.length - 1); i++)
        {
            arr[arr.length - i] = arr[arr.length - i - 1];
        }

        arr[1] = enValue;
    }

    public static void moveLeft(int[] arr)
    {
        int enValue = arr[arr.length - 1];
        arr[arr.length - 1] = arr[0];

        for(int i = 1; i < (arr.length - 1); i++)
        {
            arr[arr.length - i - 1] = arr[arr.length - i];
        }

        arr[arr.length - 2] = enValue;
    }

    public static boolean posOrNegNum(int n)
    {
        return n > 0;
    }
}
