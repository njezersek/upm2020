import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Map.Entry;

public class infrastruktura {
    public static HashMap<String, HashSet<String>> mesta = new HashMap<>();
    public static LinkedList<String> dodanePovezave = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while(sc.hasNextLine()){
            String line = sc.nextLine();

            //System.out.println(line);

            String[] l = line.split(" ");
            String a = l[0];
            String b = l[1];

            dodaj(a, b);

        }

        for(Entry<String, HashSet<String>> m : mesta.entrySet()){
            System.out.print(m.getKey() + ": ");
            for(String p : m.getValue()){
                System.out.print(p + " ");
            }
            System.out.println();
        }

        // do the BFS
        HashSet<String> preverjena = new HashSet<>();
        for(Entry<String, HashSet<String>> m : mesta.entrySet()){
            String mesto = m.getKey();
            if(preverjena.contains(mesto))continue;

            HashSet<String> komponenta = BFS(mesta, mesto);
            for(String s : komponenta){
                preverjena.add(s);
            }

            // dodaj novo povezao
            for(Entry<String, HashSet<String>> n : mesta.entrySet()){
                if(!preverjena.contains(n.getKey())){
                    dodaj(n.getKey(), mesto);
                    dodanePovezave.add(n.getKey() + " " + mesto);
                    break;
                }
            }
        }
        System.out.println("---");
        for(String p : dodanePovezave){
            System.out.println(p);
        }
        
        
        sc.close();
    }
    
    public static HashSet<String> BFS(HashMap<String, HashSet<String>> mesta, String start){
        HashSet<String> obiskana = new HashSet<>();
        Queue<String> Q = new LinkedList<>();
        obiskana.add(start);
        Q.add(start);

        while(!Q.isEmpty()){
            String mesto = Q.remove();
            for(String sosed : mesta.get(mesto)){
                if(!obiskana.contains(sosed)){
                    obiskana.add(sosed);
                    Q.add(sosed);
                }
            }
        }

        return obiskana;
    }

    public static void dodaj(String a, String b){
        HashSet<String> A = mesta.getOrDefault(a, new HashSet<>());
        A.add(b);
        mesta.put(a, A);
        HashSet<String> B = mesta.getOrDefault(b, new HashSet<>());
        B.add(a);
        mesta.put(b, B);
    }
}