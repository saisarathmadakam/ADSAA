import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Arrays;

class bfs {
    

    private int v;
    private int adj[][];

    public bfs(int v){
        this.v=v;
        adj= new int[v][v];
    }
  public void abfs(int start){
    boolean[] visited = new  boolean[v];
    Arrays.fill(visited,false);

    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited[start]=true;

    while (!queue.isEmpty()) {
        
        int vis = queue.poll();
        System.out.println(vis + " ");

        for(int i =0;i<v; i++)
        {
            if(adj[vis][i]==1 && !visited[i])
            {
                queue.add(i);
                visited[i]=true;
            }
        }
        
    }
    
  }





    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         System.out.println("enter the numof vertex");
         int v =sc.nextInt();

         bfs graph = new bfs(v);

         System.out.println("Enter the Adjacency matix("+v+"X"+v+"):");
         for(int i=0;i<v;i++)
         {
            for(int j=0;j<v;j++){
                graph.adj[i][j]=sc.nextInt();
            }
         }
         System.out.println("Enter the Starting vertex of Bfs");
         int start = sc.nextInt();
         System.out.print("Bfs traversal starting from vertex"+start+":");
         graph.abfs(start);
         sc.close();
    }
}
