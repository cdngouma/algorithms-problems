public class InsertionSort{
    // Function to sort array using insertion sort
    private static int[] sort(int[] arr){
        
        for(int i=1; i<arr.length; i++){
            for(int j=i; j>0; j--){
                // Move elements of arr[0..j-1], that are
                // greater than key, to one position ahead
                // of their current position
                if(arr[j] < arr[j-1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                else{
                    // exit loop if a previous number is less than current
                    break;
                }
            }
        }
        
        return arr;
    }
    
    int[] generateArr(int N){
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = (int)Math.floor(Math.random() * 100);
        }
        return arr;
    }
    
    // A utility function to print array of size N
    void printArr(int[] arr){
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    // Driver method
    public static void main(String []args){
        InsertionSort o = new InsertionSort();
        int arr[] = o.generateArr(10);
        o.sort(arr);
        System.out.println("sorted Arr: ");
        o.printArr(arr);
        int[] res = sort(arr);
    }
}