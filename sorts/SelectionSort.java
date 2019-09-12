public class SelectionSort {
    
    public void sort(int[] arr) {
        
        for(int pos=0; pos<arr.length; pos++) {
            // find min in unsorted array
            int minIndex = findMinimumIndex(arr, pos);
            // swap smallest value in unsorted array with
            // leftmost element in unsorted array
            int temp = arr[pos];
            arr[pos] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    
    private int findMinimumIndex(int[] arr, int start) {
        int index = start;
        int min = arr[index];
        for(int i=start; i<arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }
    
    public int[] generateNumbers(int N) {
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = (int)Math.floor(Math.random()*100);
        }
        return arr;
    }
    
    public void print(int[] arr) {
        for(int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
    
	public static void main(String[] args) {
		SelectionSort o = new SelectionSort();
		int[] arr = o.generateNumbers(10);
		o.sort(arr);
		o.print(arr);
	}
}
