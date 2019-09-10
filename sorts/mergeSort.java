public class MergeSort{
    
    private void merge(int[] arr, int start, int mid, int end){
        int[] temp = new int[end-start+1];
        int left = start;
        int right = mid+1;
        int k = 0;
        
        while(left <= mid && right <= end){
            if(arr[left] < arr[right]){
                temp[k] = arr[left];
                left++;
            }
            else{
                temp[k] = arr[right];
                right++;
            }
            k++;
        }
        
        while(left <= mid){
            temp[k] = arr[left];
            left++;
            k++;
        }
        
        while(right <= end){
            temp[k] = arr[right];
            right++;
            k++;
        }
        
        for(left = start; left <= end; left++){
            arr[left] = temp[left-start];
        }
    }
    
    private void sort(int[] arr, int start, int end){
        if(start >= end) return;
        
        int mid = (start + end )/ 2;
        sort(arr, start, mid);
        sort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }

    public static void main(String []args){
        MergeSort o = new MergeSort();
        int[] arr = o.generateNumbers(30);
    //    o.print(arr);
        o.sort(arr, 0, arr.length-1);
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