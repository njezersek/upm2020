package kolo1.ponaredki;

import java.util.Scanner;

public class Ponaredki {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int orig = sc.nextInt();
            int fake = sc.nextInt();
            if(p(1, 0, orig, fake)){
                System.out.println("DA");
            }else{
                System.out.println("NE");
            }
        }

        sc.close();
    }

    public static boolean p(int orig, int fake, int targetOrig, int targetFake){
        if(orig == targetOrig && fake == targetFake)return true;
        if(orig > targetOrig || fake > targetFake)return false;
        boolean ok = false;
        if(p(orig+1, fake+1, targetOrig, targetFake))ok = true;
        if(fake > 0)if(p(orig, fake+2, targetOrig, targetFake))ok = true;
        return ok;
    }
}