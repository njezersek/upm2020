import java.util.Arrays;
import java.util.Scanner;

public class mesta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for(int t = 0; t < T; t++){
            int N = sc.nextInt();
            sc.nextLine();
            int sum = 0;
            for(int n = 0; n<N-1; n++){
                String line = sc.nextLine();
                String[] dolzine = line.split(" ");
                int min = Integer.MAX_VALUE;
                for(String d : dolzine){
                    int dd = Integer.parseInt(d);
                    if(dd < min)min = dd;
                }
                sum += min;
            }
            System.out.println(sum);
        }

        sc.close();
    }
}