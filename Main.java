import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main o = new Main();
        input i = new input();
        System.out.printf("%40s", "BANKING SYSTEM\n");
        int ch = 0;
        while (true) {
            i.menu();
            while (true) {
                try {
                    System.out.print("Enter your choice :");
                    ch = o.sc.nextInt();
                    if (ch >= 1 && ch <= 7)
                        break;
                    else
                        System.out.println("Enter Valid Input : ");
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input !!!!!\nEnter an Integer ");
                    o.sc.nextLine();
                }
            }
            o.sc.nextLine();
            switch (ch) {
                case 1:
                    i.case1();
                    break;
                case 2:
                    i.case2();
                    break;
                case 3:
                    i.case3();
                    break;
                case 4:
                    i.case4();
                    break;
                case 5:
                    i.case5();
                    break;
                case 6:
                    i.case6();
                    break;
                case 7:
                    i.case7();
                    System.exit(0);
            }
        }
    }
}
