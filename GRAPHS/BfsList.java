import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Arrays;

public class bfslist {
    
  private int v;
  private LinkedList<Integer>[] adj;

  public bfslist(int v){
    this.v=v;
    adj= new LinkedList[v];

    for(int i =0;i<v;i++){
        adj[i]=new LinkedList<>();
    }
  }


  public void addEdge(int src,int dest)
  {
    adj[src].add(dest);
    adj[dest].add(src);
  }
  

  public void bfsa(int start)
  {
    boolean[] visited = new boolean[v];
    Arrays.fill(visited,false);

    visited[start]=true;

    Queue<Integer>queue = new LinkedList<>();
    queue.add(start);

    while (!queue.isEmpty()) 
    {
        int vis = queue.poll();
        System.out.print(vis + " ");

        for(int nei:adj[vis])
        {   if(!visited[nei]){
            queue.add(nei);
            visited[nei]=true;
        }
        
    }
}

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter the  number of vertices : ");
    int v = sc.nextInt();
    
    bfslist graph = new bfslist(v);

    System.out.println("Enter the number of edges:");
    int e = sc.nextInt();

    System.out.println("Enter the edgs(Source to destination):");
    for(int i=0;i<e;i++)
    {
        int src = sc.nextInt();
        int dest = sc.nextInt();
        graph.addEdge(src,dest);
    }

    System.out.println("ENTER THE STARTING VERTEX of bfs:");
    int start = sc.nextInt();
    System.out.println("bfs traversal starting from vertex"+ start + ":");
    graph.bfsa(start);
    sc.close();

  }

}
