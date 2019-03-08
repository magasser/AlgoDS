package serie02.exercise01;

import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println(loop(sc.nextLong()));
        }
    }

    public static long loop(long i) {
        if(i == 1) {
            return 1;
        }

        return i * loop(i-1);
    }
}
