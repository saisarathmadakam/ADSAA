import java.util.LinkedList;
import java.util.*;

public class dfslist {
    private  int v;
    private LinkedList<Integer>[]adj;

    public dfslist(int v){
        this.v=v;
        adj = new LinkedList[v];

        for(int i =0;i<v;i++)
        {
            adj[i]= new LinkedList<>();
        }

    }
   public void addEdge(int src ,int desc)
   {
    adj[src].add(desc);
    adj[desc].add(src);
   }
  
    public  void dfs(int start)
    {
        boolean [] visited = new boolean[v];
        Arrays.fill(visited,false);

        Stack<Integer>stack = new Stack<>();
        stack.push(start);
        visited[start]=true;

        while(!stack.isEmpty())
        {
            int vis = stack.pop();
            System.out.println( vis + " ");
            for(int nei :adj[vis])
            if(!visited[nei])
            {
              stack.push(nei);
              visited[nei]=true;
                
            }
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        System.out.println("enter the number of vertices");
        int v =sc.nextInt();
        dfslist graph = new dfslist(v);
        
        System.out.println("enter the number of edges ");
        int e =sc.nextInt();

        for(int i=0;i<e;i++)
        {
            int src =sc.nextInt();
            int desc = sc.nextInt();
            graph.addEdge(src,desc);

        }
        System.out.println("enter the source vertex");
        int start = sc.nextInt();
        System.out.println("bfs list is starting vertex from"+start+":");
        graph.dfs(start);


      }
}
