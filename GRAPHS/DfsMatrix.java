
import java.util.Scanner;
import java.util.Arrays;

class dfs {
    

    private int v;
    private int adj[][];
    boolean visited[];

    public dfs(int v){
        this.v=v;
        adj= new int[v][v];
        visited=new boolean[v];
        Arrays.fill(visited,false);
    }
  public void abfs(int start){
    visited[start] =true;
    System.out.println(start + " ");
    for(int i =0;i<v;i++)
    {
        if(adj[start][i]==1&& !visited[i])
        {
            abfs(i);
        }
    }

   
  }





    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         System.out.println("enter the numof vertex");
         int v =sc.nextInt();

         dfs graph = new dfs(v);

         System.out.println("Enter the Adjacency matix("+v+"X"+v+"):");
         for(int i=0;i<v;i++)
         {
            for(int j=0;j<v;j++){
                graph.adj[i][j]=sc.nextInt();
            }
         }
         System.out.println("Enter the Starting vertex of dfs");
         int start = sc.nextInt();
         System.out.print("dfs traversal starting from vertex"+start+":");
         graph.abfs(start);
         sc.close();
    }
}
