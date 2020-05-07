import java.util.Arrays;
import java.util.Scanner;

public class LCMSeznami {
    static int primes[] = new int[10000000];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        int seznam[] = new int[N];


        int sqrt = (int)Math.ceil(Math.sqrt(primes.length));
        // naredi tabelo fakotorjev
        for(int i=2; i<sqrt; i++){
            for(int j=i; j<primes.length; j+=i){
                if(primes[j] == 0)primes[j] = i;
            }
        }

        for(int i=0; i<N; i++){
            seznam[i] = sc.nextInt();
        }

        for(int i=0; i<Q; i++){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;

            System.out.println(nLCM(seznam, a, b));
        }

        sc.close();
        //System.out.println(nLCM(new int[] { 6, 13, 34, 25 }, 0, 3));
        //System.out.println(isLCM(new int[] { 6, 13, 34, 25 }));


    }

    /*public static void primes(int n){
        int i = n;
        while(primes[i] != 0){
            System.out.println(primes[i]);
            i /= primes[i];
        }
    }*/

    /*public static boolean isLCM(int[] S){
        int factors[] = new int[10000000];

        for(int j=0; j<S.length; j++){
            int i = S[j];
            while(primes[i] != 0){
                if(factors[primes[i]] != S[j] && factors[primes[i]] != 0){ // skupni faktor!
                    return false;
                }
                factors[primes[i]] = S[j];
                i /= primes[i];
            }
        }

        return true;
    }*/

    public static int nLCM(int[] S, int a, int b){ // a <= b
        int sum = 0;
        for(int start = a; start<=b; start++){
            int factors[] = new int[10000000];
            for(int end = start; end<=b; end++){
                //int myFactors[] = new int[10000000];
                boolean ok = true;
                // poišči fakotorje S[end]
                int i = S[end];
                while(primes[i] != 0){
                    if(factors[primes[i]] != S[end] && factors[primes[i]] != 0){
                        ok = false;
                    }
                    factors[primes[i]] = S[end];
                    //myFactors[primes[i]]++;
                    i /= primes[i];
                }

                if(ok){
                    sum++;
                    //System.out.print("*");
                }
                else{
                    break;
                }
                //System.out.println(Arrays.toString(Arrays.copyOfRange(S, start, end+1)));
            }
        }

        return sum;
    }
}