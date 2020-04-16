import java.util.Arrays;
import java.util.Scanner;

public class mesta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        //System.out.println("T="+T);
        
        for(int t = 0; t < T; t++){
            int N = sc.nextInt();
            //System.out.println("N"+t+"="+N);
            int sum = 0;
            for(int n = 0; n<N-1; n++){
                int K = sc.nextInt();
                //System.out.println("K"+t+","+n+"="+K);
                int min = Integer.MAX_VALUE;
                for(int k=0; k<K; k++){
                    int dd = sc.nextInt();
                    if(dd < min)min = dd;
                }
                sum += min;
            }
            System.out.println(sum);
        }

        sc.close();
    }
}