package ordenamientos;

import static java.lang.Math.random;
import java.util.Arrays;

public class Ordenamientos {

    public static void main(String[] args) {
        int v[] =new int[20];
        for (int i = 0; i < 20; i++) {
            v[i] = (int) (random() * 100);
            if ((int) (random() * 2) + 1 == 2) {
                v[i] = -v[i];
            }
        }
        System.out.println("shell sort has taken " + shell_sort(v) + " milliseconds");
        System.out.println("select sort has taken " + select_sort(v) + " milliseconds");
        System.out.println("insert sort has taken " + insert_sort(v) + " milliseconds");
        System.out.println("burbble sort has taken "+ Bubble_sort(v) +" milliseconds");
        System.out.println("radix sort has taken "+ radix_sort(v) +" milliseconds");
    }
    public static void show(int v[]){
        int n=v.length;
        for (int i = 0; i < n-1; i++) {
            System.out.print(v[i]+" ");
        }
        System.out.println(v[n-1]);
    }
    public static long Bubble_sort(int v[]) {
        long time_start, time_end;
        int n=v.length;
        time_start = System.currentTimeMillis();
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (v[j - 1] > v[j]) {
                    temp = v[j - 1];
                    v[j - 1] = v[j];
                    v[j] = temp;
                }

            }
        }
        time_end = System.currentTimeMillis();
        show(v);
        return time_end - time_start;
    }

    public static long select_sort(int v[]) {
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        int n = v.length, menor;
        for (int i = 0; i < n; i++) {
            menor = i;
            for (int j = i + 1; j < n; j++) {
                if (v[j] < v[menor]) {
                    menor = j;
                }
            }
            if (menor != i) {
                int temp = v[i];
                v[i] = v[menor];
                v[menor] = temp;
            }
        }
        time_end = System.currentTimeMillis();
        show(v);
        return time_end - time_start;
    }

    public static long insert_sort(int v[]) {
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        int n = v.length;
        int temp;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (v[j] < v[j - 1]) {
                    temp = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = temp;
                }
            }
        }
        time_end = System.currentTimeMillis();
        show(v);
        return time_end - time_start;
    }

    public static long shell_sort(int v[]) {
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        int n = v.length, inc = n / 2;
        while (inc > 0) {
            for (int i = inc; i < n; i++) {
                int j = i - inc;
                while (j >= 0) {
                    int k = j + inc;
                    if (v[j] > v[k]) {
                        int t = v[j];
                        v[j] = v[k];
                        v[k] = t;
                    } else {
                        j = 0;
                    }
                    j = j - inc;
                }
            }
            inc = inc / 2;
        }
        time_end = System.currentTimeMillis();
        show(v);
        return time_end - time_start;
    }
    public static long heapsort(int v[]){
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        time_end = System.currentTimeMillis();
        return time_end - time_start;
    }
    public static long radix_sort(int v[]){
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        int m,n=v.length,absmn=getmin(v)*-1;
        for (int i = 0; i < n; i++) {
            v[i]+=absmn;
        }
        m=getmax(v);
        for (int exp = 1; m/exp > 0; exp*=10) {
            v=countSort(v, n, exp);
        }
        time_end = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            v[i]-=absmn;
        }
        show(v);
        return time_end - time_start;
    }
    static int[] countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (i = n - 1; i >= 0; i--){
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }/*
        for (i = 0; i < n; i++)
            arr[i] = output[i];*/
        return output;
    }
    public static int getmax(int v[]){
        int d=v.length,m=v[0];
        for (int i = 1; i < d; i++) {
            if(v[i]>m)m=v[i];
        }
        return m;
    }
    public static int getmin(int v[]){
        int mn=v[0],n=v.length;
        for (int i = 1; i < n; i++) {
            if(mn>v[i])mn=v[i];
        }
        return mn;
    }
    /*
    Bubble Sort-Ready
    Insert  Sort-Ready
    Select Sort-Ready
    Shell Sort-Ready
    Radix Sort-Ready
    Quick Sort
    Heap Sort
    Merge Sort
    */
    //merge http://www.geeksforgeeks.org/merge-sort/
    public static long mergesort(int v[]){
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        sort(v,0, v.length-1);
        time_end = System.currentTimeMillis();
        return time_end - time_start;
    }
    public static void merge(int arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
        // Create temp arrays 
        int L[] = new int [n1];
        int R[] = new int [n2];
        //Copy data to temp arrays
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
        // Merge the temp arrays 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2){
            if (L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        // Copy remaining elements of L[] if any 
        while (i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
    }
    // Main function that sorts arr[l..r] using merge()
    public static void sort(int arr[], int l, int r){
        if (l < r){
            // Find the middle point
            int m = (l+r)/2;
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    /*
    
    
    
    
    public static long quicksort(int v[]){
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        Qs(v,low,high){
            if(low<high){
                int pi=partition(v,low,high);
                qs(v,low,pi-1);
                qs(v,pi+1,high);
            }
        }
        time_end = System.currentTimeMillis();
        return time_end - time_start;
    }
     partition(vector,low, high){
         int pivot=arr[random dentro del rango],i=low-1
         for(int j=low;j<=hg-1;j++){
             
         }
         swap(a)
     }
        
    }*/
}
