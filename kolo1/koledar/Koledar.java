import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Koledar {
    public static void main(String[] args) {
        new Koledar();
    }
    
    Koledar(){
        Scanner sc = new Scanner(System.in);
        
        int W = sc.nextInt();
        int H = sc.nextInt();
        int N = sc.nextInt();
    
        LinkedList<LinkedList<Pair>> liki = new LinkedList<>();
    
        for(int i=0; i<N; i++){
            LinkedList<Pair> lik = new LinkedList<>();
            int k = sc.nextInt();
            for(int j=0; j<k; j++){
                lik.add(new Pair(sc.nextInt(), sc.nextInt()));
            }
            liki.add(lik);
        }

        int Q = sc.nextInt();
        for(int i=0; i<Q; i++){
            int h = sc.nextInt();
            LinkedList<LinkedList<Pair>> likiNaMeji = najdiLike(liki, h);
            LinkedList<LinkedList<Pair>> likiNadMejo = najdiLikeNadMejo(liki, h);

            for(LinkedList lik : likiNaMeji){
                //System.out.println("Lik "+lik);
                //System.out.println("P: "+ploscina(lik));
            }

            //System.out.println( (ploscinaLikovNaMeji(likiNaMeji, h) + ploscinaLikov(likiNadMejo, h)) );
            //System.out.println( (W*(H-h)) );
            System.out.println( (ploscinaLikovNaMeji(likiNaMeji, h) + ploscinaLikov(likiNadMejo, h))/(W*(H-h)) );

        }
    
    
        sc.close();
        
    }

    private double ploscinaLikov(LinkedList<LinkedList<Pair>> likiNadMejo, int h) {
        double PLOSCINA = 0;
        for(LinkedList<Pair> lik : likiNadMejo){
            PLOSCINA += Math.abs(ploscina(lik));
        }

        return PLOSCINA;
    }

    private LinkedList<LinkedList<Pair>> najdiLikeNadMejo(LinkedList<LinkedList<Pair>> liki, int h) {
        LinkedList<LinkedList<Pair>> likiNadMejo = new LinkedList<>();
        for(LinkedList<Pair> lik : liki ){
            //System.out.println("Lik "+ lik);
            boolean nadMejo = true;
            for(Pair tocka : lik){
                //System.out.println(meja + " : " + tocka);
                if(tocka.y < h){
                    nadMejo = false;
                    break;
                }
            }
            if(nadMejo)likiNadMejo.add(lik);
        }
        return likiNadMejo;
    }

    private double ploscinaLikovNaMeji(LinkedList<LinkedList<Pair>> likiNaMeji, int h) {
        double PLOSCINA = 0;
        for(LinkedList<Pair> lik : likiNaMeji){
            //System.out.println();
            //System.out.println("Lik "+lik);
            double P = 0;
            LinkedList<Pair> del = new LinkedList<>();
            boolean vPreostanku = false;
            boolean presecisce = false;

            int I = 0;
            // poisci tocko v odrezanem delu
            for(int i=0; i<lik.size(); i++){
                if(lik.get(i).y < h){
                    I = i;
                    break;
                }
            }
            
            //System.out.println("Zacetnan tocka " + lik.get(I));

            for(int i=0; i<lik.size(); i++){
                Pair A = lik.get((I+i)%lik.size());
                Pair B = lik.get((I+i+1)%lik.size());
                //System.out.println(A + "->" + B);
                double k = (double)(A.y - B.y) / (double)(A.x - B.x); // k = 0 če je stranica vzporedna za rezom
                double xPrescisce = (double)(h-A.y+k*A.x)/k;
                if(k == 0)xPrescisce = Double.POSITIVE_INFINITY;
                if(A.x == B.x && h < Math.max(A.y, B.y) && h > Math.min(A.y, B.y))xPrescisce = A.x;
                // če je premica med točkama prerezana
                if(xPrescisce <= Math.max(A.x, B.x) && xPrescisce >= Math.min(A.x, B.x)){
                    Pair zadnjePresecisce = new Pair(xPrescisce, h);
                    del.add(zadnjePresecisce);
                    //System.out.println("Najdeno presecisce: " + zadnjePresecisce);
                    if(presecisce){ // izracunaj ploscino
                        //System.out.println("Del: " + del);
                        if(vPreostanku)P += ploscina(del);
                        //System.out.println("Dodan del. Nov P = "+P);
                    }
                    del = new LinkedList<>();
                    del.add(zadnjePresecisce);
                    presecisce = true;
                    vPreostanku = B.y >= h;
                    del.add(B);
                }
                else{
                    del.add(B);
                }
            }

            PLOSCINA += Math.abs(P);
        }

        return PLOSCINA;
    }

    public static double ploscina(LinkedList<Pair> tocke){ 
        double area = 0.0; 
        int j = tocke.size() - 1; 
        for (int i = 0; i < tocke.size(); i++) 
        { 
            area += (tocke.get(j).x + tocke.get(i).x) * (tocke.get(j).y - tocke.get(i).y); 
            j = i;
        } 
      
        return (area / 2.0); 
        //return Math.abs(area / 2.0); 
    } 

    private LinkedList<LinkedList<Pair>> najdiLike(LinkedList<LinkedList<Pair>> liki, int meja) {
        LinkedList<LinkedList<Pair>> likiNaMeji = new LinkedList<>();
        for(LinkedList<Pair> lik : liki ){
            //System.out.println("Lik "+ lik);
            boolean nadMejo = false;
            boolean podMejo = false;
            for(Pair tocka : lik){
                //System.out.println(meja + " : " + tocka);
                if(tocka.y < meja)podMejo = true;
                if(tocka.y > meja)nadMejo = true;
                if(nadMejo && podMejo){
                    likiNaMeji.add(lik);
                    break;
                }
            }
        }
        return likiNaMeji;
    }

    class Pair {
        public double x, y;
        Pair(double x, double y){
            this.x = x;
            this.y = y;
        }

        public String toString(){
            return "["+x+", "+y+"]";
        }
    }
}