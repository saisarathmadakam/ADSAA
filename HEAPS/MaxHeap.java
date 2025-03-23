import java.util.*;

public class MaxHeap {
   
    
        int arr[];
        int maxsize,heapsize;
        MaxHeap(int maxsize)
        {
            this.maxsize=maxsize;
            heapsize=0;
            arr = new int[maxsize];
    
        }
    
    
        

    void insertkey(int x)
    {
        if(heapsize==maxsize)
        {
            System.out.println("heapsize is full");
            return;
        }
        int i =heapsize;
        arr[i]=x;
        heapsize++;
         while(i!=0&& arr[parent(i)]<arr[i])
         {
            int temp = arr[i];
            arr[i]=arr[parent(i)];
            arr[parent(i)]=temp;
            i=parent(i);
         }
    }
    
  int currentsize(){
    return heapsize;
  }
  int  maxele()
  {
      return arr[0]; 
  }
int parent(int i)
{
    return (i-1)/2;
}
int lchild(int i)
{
    return 2*i+1; 

}
int rchild(int i)
{
    return 2*i+2;
}

  void hepify(int i)
  {
    int l = lchild(i);
    int r = rchild(i);
    int largest=i;
    if(l<heapsize && arr[l]>arr[i])
    {
        largest=l;
    }
    if(r<heapsize && arr[r]>arr[largest])
    {
        largest=r;
    }
    if(largest!=i)
    {
        int temp = arr[i];
        arr[i]=arr[largest];
        arr[largest]=temp;

        hepify(largest);

    }

  }

  void removeMax()
  {
    if(heapsize<=0)
    {
        System.out.println("heap is empty");
    }
    else if(heapsize==1)
    {
        heapsize--;
    }
    else {
        arr[0]=arr[heapsize-1];
        heapsize--;
        hepify(0);
    }
  

    }
    public static void main(String[] args)
    { 
        
        MaxHeap h = new MaxHeap(15);

        


        int element []= {23,43,535,554,544};
        for(int e:element)
        h.insertkey(e);


        System.out.println("current size of the heap " + h.currentsize());
        System.out.println(" maximum element of the heap "+h .maxele());
        h.removeMax();
        System.out.println("current size of the heap " + h.currentsize());
        System.out.println(" maximum element of the heap "+h .maxele());

    }
}
