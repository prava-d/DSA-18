import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MCCR {
        public static int MCCR(EdgeWeightedGraph G) {
            // TODO

            int total = 0;
            HashSet<Integer> h = new HashSet<>();
            ArrayList<Integer> a = new ArrayList<>();
            HashMap<Integer, Integer> p = new HashMap<>();
            IndexPQ i = new IndexPQ(G.numberOfV());
            Iterator<Integer> vertices = G.vertices.iterator();

            int first = vertices.next();
            i.insert(first, 0);
            p.put(first, -1);
            h.add(first);

            for (Iterator<Integer> temp = vertices; temp.hasNext(); ) {
                int j = temp.next();
                i.insert(j, Integer.MAX_VALUE);
                h.add(j);
            }

            while(!i.isEmpty()) {
                int k = i.delMin();
                h.remove(k);
                a.add(k);

                for (Edge e: G.edges(k)) {
                    int v = e.other(k);
                    if (h.contains(v) && e.weight() < (int) i.keys[v]) {
                        p.put(v, k);
                        i.changeKey(v, e.weight());
                    }
                }
            }

            for (int par:p.keySet()) {
                for (Edge e: G.edges(par)) {
                    if (e.other(par) == p.get(par)) {
                        total += e.weight();
                    }
                }
            }

            return total;
        }

    }

// large and small step expressions (review question 3)
// Gm * (vin - Vout) = ... inc to Vin at
// Iout = (V1 - V2)*gm
// Iout different for different steps
// tao*ydot + y = z, e^(-t/tao); y = 1 ( 1 - e^(t/tao))
