package NCA;
import java.util.*;
public class Main {
	    public class Graph{
	    	public ArrayList<Integer> endpoint;
	    	public Graph(){
	    		
	    		 endpoint = new ArrayList<Integer>();
	    		// System.out.print("******");
	    	}
	    }
	    public Graph[] head;
	    public boolean not_root_mark[];
	    public int root;// common_parent;
        public void create_graph(int u, int v){
        //	System.out.print(head[u].endpoint.size());
            head[u].endpoint.add(v); 
        //    System.out.println(v + " " + not_root_mark.length);
            not_root_mark[v] = true;
        }
        
        public int LCA(int parent, int A, int B){
        	if (parent == A || parent == B){
        		return parent;
        	}
        	if (head[parent].endpoint.size() == 0){
        		return -1;
        	}
        	boolean flagA = false, flagB = false;
        	int res;
        	for(Integer val : head[parent].endpoint){
        	    res = LCA(val, A, B);
        		if (res == A){
        			flagA = true;
        		}
        		if (res == B){
        			flagB = true;
        		}
        		if (res != A && res !=B && res != -1){
        			return res;
        		}
        	}
            if (flagA && flagB){
            	//common_parent = parent;
            	return parent;
            }
            else if (flagA){
            	return A;
            }
            else if(flagB){
            	return B;
            }
            else 
            	return -1;
        }
        
        public int find_root(int N){
        	for(int i = 1; i <= N; i++){
        		if (!not_root_mark[i]){
        			return i; 
        		}
        	}return -1;
        }
        public Main(){
        	Scanner in = new Scanner(System.in);
        	int Cases = in .nextInt();
        	while(Cases > 0){
        	int N = in.nextInt();
        	
        	head = new Graph[N + 5];
        	for (int i = 0; i < N + 1; i++){
        		head[i] = new Graph();
        	}
        	//System.out.print(head[1]);
        	not_root_mark = new boolean[N + 5];
        	for (int i = 0; i < N - 1; i ++ ){
        		int u = in.nextInt(), v = in.nextInt();
        		create_graph(u, v);
        	}
        	int A = in.nextInt();
        	int B = in.nextInt();
        	root = find_root(N);
        	//System.out.println(root);
        	
        	System.out.println(LCA(root, A, B));
        	Cases--;
        	}
        	in.close();
        }
        
        public static void main(String[] Args){
        	Main s = new Main();
            
        }
        
}
