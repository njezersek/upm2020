import java.util.Scanner;

public class enakiNizi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for(int t = 0; t < T; t++){
            String a = sc.nextLine();
            String b = sc.nextLine();

            if(primerjaj(a, b))System.out.println("enaka");
            else System.out.println("razlicna");
        }

        sc.close();
    }

    public static boolean primerjaj(String a, String b){
        //System.out.println(a + ", " + b);
        if(a.equals(b)){
            return true;
        }
        if(a.length() <=1 || b.length()<=1)return false;

        int interval = a.length()/3;

        String a1 = a.substring(0, interval);
        String a2 = a.substring(interval, interval*2);
        String a3 = a.substring(interval*2, interval*3);

        String b1 = b.substring(0, interval);
        String b2 = b.substring(interval, interval*2);
        String b3 = b.substring(interval*2, interval*3);

        if(primerjaj(a1, b1) && primerjaj(a2, b2) &&  primerjaj(a3, b3))return true;
        if(primerjaj(a1, b1) && primerjaj(a2, b3) &&  primerjaj(a3, b2))return true;
        if(primerjaj(a1, b2) && primerjaj(a2, b1) &&  primerjaj(a3, b3))return true;
        if(primerjaj(a1, b2) && primerjaj(a2, b3) &&  primerjaj(a3, b1))return true;
        if(primerjaj(a1, b3) && primerjaj(a2, b1) &&  primerjaj(a3, b2))return true;
        if(primerjaj(a1, b3) && primerjaj(a2, b2) &&  primerjaj(a3, b1))return true;

        return false;
    }
}
/*
aaabbbaaa bbbbbbaab aaaaabaaa
bbbaaaaaa aaaaaaaba bbbbbbbaa

aaa bbb aaa bbb bbb aab aaa aab aaa
bbb aaa aaa aaa aaa aba bbb bbb baa
*/