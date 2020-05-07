import java.util.Scanner;

public class Hrosc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextInt();

        int i = 0;
        int skatla = 0;
        while(!sc.nextLine().equals("Bingo!")){
            System.out.println(skatla);
            if(i%2 != 0)skatla++;
            i++;
        }
    }
}