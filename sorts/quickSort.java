public class QuickSort{
    
    private int partition(int[] arr, int start, int end){
        int b = 0;
        int temp;
        
        for(int k = 1; k <= end; k++){
            if(arr[k] <= arr[start]){
                b++;
                temp = arr[k];
                arr[k] = arr[b];
                arr[b] = temp;
            }
            
        }
        
        temp = arr[b];
        arr[b] = arr[start];
        arr[start] = temp;
        
        return b;
    }
    
    private void quickSort(int[] arr, int start, int end){
        if(start >= end) return;
        
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);
    }

    public static void main(String []args){
        QuickSort o = new QuickSort();
        int[] arr = o.generateNumbers(10);
        o.quickSort(arr, 0, arr.length-1);
        o.print(arr);
    }
    
    private int[] generateNumbers(int N){
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = (int)Math.floor(Math.random() * 100);
        }
        return arr;
    }
    
    private void print(int[] arr){
        for(int n : arr){
            System.out.print(n + " ");
        }
        System.out.println();
    }
}