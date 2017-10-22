package ordenamientos;

import java.math.BigInteger;
import java.util.Random;

public class Ordenamientos {
    public static BigInteger o[] =new BigInteger[2000];
    public static int c;
    public static void main(String[] args) {
        BigInteger v[]=new BigInteger[2000];
        for (int i = 0; i < 2000; i++) {
            o[i] = create(new BigInteger("10000000000000"),new BigInteger("999999999999999"),new Random());
            v[i]=new BigInteger(o[i].toString());
        }
        System.out.print("\033[31mArreglo Desordenado:\n");
        show(o);
        System.out.println("\033[31mBurbble-Sort \n\033[34mTiempo:\033[30m"+ Bubble_sort(v) +" nanosegundos\n\033[34mIteraciones: \033[30m"+c);/*
        System.out.print("Arreglo Ordenado:");*/
        restart(v);
        System.out.println("\033[31mInsert-Sort  \n\033[34mTiempo:\033[30m" + insert_sort(v) + " nanosegundos\n\033[34mIteraciones: \033[30m"+c);/*
        System.out.print("Arreglo Ordenado:");*/
        restart(v);
        System.out.println("\033[31mSelect-Sort  \n\033[34mTiempo:\033[30m" + select_sort(v) + " nanosegundos\n\033[34mIteraciones: \033[30m"+c);/*
        System.out.print("Arreglo Ordenado:");*/
        restart(v);
        System.out.println("\033[31mShell-Sort   \n\033[34mTiempo:\033[30m" + shell_sort(v) + " nanosegundos\n\033[34mIteraciones: \033[30m"+c);/*
        System.out.print("Arreglo Ordenado:");*/
        restart(v);
        System.out.println("\033[31mRadix-Sort   \n\033[34mTiempo:\033[30m"+ radix_sort(v) +" nanosegundos\n\033[34mIteraciones: \033[30m"+c);/*
        System.out.print("Arreglo Ordenado:");*/
        restart(v);
        System.out.println("\033[31mHeap-Sort    \n\033[34mTiempo:\033[30m"+ heapsort(v) +" nanosegundos\n\033[34mIteraciones: \033[30m"+c);/*
        System.out.print("Arreglo Ordenado:");*/
        restart(v);
        System.out.println("\033[31mMerge-Sort   \n\033[34mTiempo:\033[30m"+ merge_sort(v) +" nanosegundos\n\033[34mIteraciones: \033[30m"+c);/*
        System.out.print("Arreglo Ordenado:");*/
        restart(v);
        System.out.println("\033[31mQuick-Sort   \n\033[34mTiempo:\033[30m"+ merge_sort(v) +" nanosegundos\n\033[34mIteraciones: \033[30m"+c);/*
        System.out.print("Arreglo Ordenado:");*/
    }
    public static BigInteger create(BigInteger mn,BigInteger mx,Random rnd){
     BigInteger r;
     do{
         r=new BigInteger(50,rnd);
     }while(r.compareTo(mx)>0 || r.compareTo(mn)<0);
     return r;
    }
    public static void show(BigInteger v[]){
        int n=v.length;
        for (int i = 0; i < n; i++) {
            System.out.print(v[i]+" ");
        }
        System.out.println("");
    }
    public static void restart(BigInteger v[]){
        int n=v.length;
        for (int i = 0; i < n; i++) {
            v[i]=new BigInteger(o[i].toString());
        }
    }
    //Start Bubble
    public static long Bubble_sort(BigInteger v[]) {
        long time_start, time_end;
        c=0;
        int n=v.length;
        time_start =System.nanoTime();
        for (int i = 0; i < n-1; i++) {
            for (int j = 1; j < n - i-1; j++) {
                //if (v[j - 1] > v[j])
                if (v[j - 1].compareTo(v[j])>0) {  
                    /*temp = v[j-1];
                    v[j-1] = v[j];
                    v[j] = temp;
                    */
                    BigInteger temp =new BigInteger(v[j - 1].toString());
                    v[j - 1] =new BigInteger(v[j].toString());
                    v[j] = new BigInteger(temp.toString());
                }
                c++;
            }
            c++;
        }
        time_end = System.nanoTime();
        return (time_end - time_start);
    }
    //End Bubble
    //Start Insert
    public static long insert_sort(BigInteger v[]) {
        long time_start, time_end;c=0;
        time_start = System.nanoTime();
        int n = v.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                //if (v[j] < v[j - 1]) {
                if(v[j].compareTo(v[j-1])<0){
                    /*
                    temp = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = temp;*/
                    BigInteger temp =new BigInteger(v[j].toString());
                    v[j] =new BigInteger(v[j-1].toString());
                    v[j-1] = new BigInteger(temp.toString());
                }
                c++;
            }
            c++;
        }
        time_end = System.nanoTime();
        return (time_end - time_start);
    }
    //End Insert  
    //Start Select
    public static long select_sort(BigInteger v[]) {
        long time_start, time_end;c=0;
        time_start = System.nanoTime();
        int n = v.length, menor;
        for (int i = 0; i < n; i++) {
            menor = i;
            for (int j = i + 1; j < n; j++) {
                //if (v[j] < v[menor])
                if (v[j].compareTo(v[menor])<0 ){
                    menor = j;
                }
                c++;
            }
            if (menor != i) {
                /*temp = v[i];
                v[i] = v[menor];
                v[menor] = temp;
                */
                BigInteger temp =new BigInteger(v[i].toString());
                v[i] =new BigInteger(v[menor].toString());
                v[menor] = new BigInteger(temp.toString());
            }
            c++;
        }
        time_end = System.nanoTime();
        return (time_end - time_start);
    }
    //End Select
    //Start Shell
    public static long shell_sort(BigInteger v[]) {
        long time_start, time_end;c=0;
        time_start = System.nanoTime();
        int n = v.length, inc = n / 2;
        while (inc > 0) {
            for (int i = inc; i < n; i++) {
                int j = i - inc;
                while (j >= 0) {
                    int k = j + inc;
                    //if (v[j] > v[k]) {
                    if(v[j].compareTo(v[k])>0){
                        /*
                        BigInteger t = v[j];
                        v[j] = v[k];
                        v[k] = t;*/
                        BigInteger temp =new BigInteger(v[j].toString());
                        v[j] =new BigInteger(v[k].toString());
                        v[k] = new BigInteger(temp.toString());
                    } else {
                        j = 0;
                    }
                    j = j - inc;
                    c++;
                }
                c++;
            }
            inc = inc / 2;
            c++;
        }
        time_end = System.nanoTime();
        return (time_end - time_start);
    }
    //End Shell
    //Start Radix
    public static long radix_sort(BigInteger v[]){
        long time_start, time_end;c=0;
        time_start = System.nanoTime();
        int n=v.length;
        BigInteger m;
        m=getmax(v);
        BigInteger exp=BigInteger.ONE;
        for (; m.divide(exp).compareTo(BigInteger.ZERO)>0; exp=exp.multiply(BigInteger.TEN)) {
            countSort(v, n, exp);
            c++;
        }
        time_end = System.nanoTime();
        return (time_end - time_start);
    }
    static void countSort(BigInteger arr[], int n, BigInteger exp) {
        BigInteger output[] = new BigInteger[n]; // output array
        int i;
        BigInteger count[] = new BigInteger[10];
        for (i = 0; i < 10; i++) {
            count[i]=BigInteger.ZERO;
            c++;
        }
        for (i = 0; i < n; i++){
            //count[ (arr[i]/exp)%10 ]++;
            int x=Integer.parseInt((arr[i].divide(exp).mod(BigInteger.TEN)).toString());
            count[x]=count[x].add(BigInteger.ONE);
            c++;
        }
        for (i = 1; i < 10; i++){
            //count[i] += count[i - 1];
            count[i] =count[i].add(count[i - 1]);
            c++;
        }
        for (i = n - 1; i>= 0; i--){
            //output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            int x= Integer.parseInt((arr[i].divide(exp)).mod(BigInteger.TEN).toString());
            int x1=Integer.parseInt(count[x].subtract(BigInteger.ONE).toString());
            output[x1] = new BigInteger(arr[i].toString());
            //count[ (arr[i]/exp)%10 ]--;
            count[x]=count[x].subtract(BigInteger.ONE);
            c++;
        }
         // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++){
            //arr[i] = output[i];
             arr[i]= new BigInteger(output[i].toString());
             c++;
        }
    }
    public static BigInteger getmax(BigInteger v[]){
        int d=v.length;
        BigInteger m=new BigInteger(v[0].toString());
        for (int i = 1; i < d; i++) {
            if(v[i].compareTo(m)>0)m=new BigInteger(v[i].toString());
            c++;
        }
        return m;
    }
    //End Radix
    //Start Merge
    public static long merge_sort(BigInteger v[]){
        long time_start, time_end;c=0;
        time_start = System.nanoTime();
        sortM(v,0, v.length-1);
        time_end = System.nanoTime();
        return (time_end - time_start);
    }
    public static void sortM(BigInteger arr[], int l, int r){
        if (l < r){
            // Find the middle point
            int m = (l+r)/2;
            // Sort first and second halves
            sortM(arr, l, m);
            sortM(arr , m+1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);
            c++;
        }
    }
    public static void merge(BigInteger arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
        // Create temp arrays 
        BigInteger L[] = new BigInteger [n1];
        BigInteger R[] = new BigInteger [n2];
        //Copy data to temp arrays
        for (int i=0; i<n1; ++i)
            L[i] = new BigInteger(arr[l + i].toString());
        for (int j=0; j<n2; ++j)
            R[j] = new BigInteger(arr[m + 1+ j].toString());
        // Merge the temp arrays 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2){
            //if (L[i] <= R[j])
            if (L[i].compareTo(R[j])<=0){
                arr[k] = new BigInteger(L[i].toString());
                i++;
            }else{
                arr[k] = new BigInteger(R[j].toString());
                j++;
            }
            k++;
        }
 
        // Copy remaining elements of L[] if any 
        while (i < n1){
            //arr[k] = L[i];
            arr[k] = new BigInteger(L[i].toString());
            i++;
            k++;
        }
          while (j < n2){
            arr[k] = new BigInteger(R[j].toString());
            j++;
            k++;
        }
    }
    //End Merge
    //Start Heap
    public static long heapsort(BigInteger v[]){
        long time_start, time_end;c=0;
        time_start = System.nanoTime();
        sortH(v);
        time_end = System.nanoTime();
        return (time_end - time_start);
    }
    public static void sortH(BigInteger arr[]){
    int n = arr.length;
    // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--){
            heapify(arr, n, i);
            c++;
        }
            
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--){
            // Move current root to end
            BigInteger temp = arr[0];
            arr[0] = new BigInteger(arr[i].toString());
            arr[i] = new BigInteger(temp.toString());
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
            c++;
        }
    }
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heapify(BigInteger arr[], int n, int i){
        int largest = i;// Initialize largest as root
        int l = 2*i + 1;// left = 2*i + 1
        int r = 2*i + 2;// right = 2*i + 2
        // If left child is larger than root
        if (l < n && arr[l].compareTo(arr[largest])>0)
            largest = l;
        // If right child is larger than largest so far
         if (r < n && arr[r].compareTo(arr[largest])>0)
            largest = r;
        // If largest is not root
         if (largest != i){
            BigInteger swap = new BigInteger(arr[i].toString());
            arr[i] = new BigInteger(arr[largest].toString());
            arr[largest] = new BigInteger(swap.toString());
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    //End Heap
    //Start Quick
    public static long quick_sort(BigInteger v[]){
        long time_start, time_end;c=0;
        time_start = System.nanoTime();
        sortQ(v,0,v.length-1);
        time_end = System.nanoTime();
        return (time_end - time_start);
    }
    static int partition(BigInteger arr[], int left, int right){
    int i = left, j = right;
    BigInteger pivot = new BigInteger(arr[(left + right)/ 2].toString());
        while (i <= j){
            while(arr[i].compareTo(pivot)<0){
                c++;
                i++;
            }
            while(arr[j].compareTo(pivot)>0){
                c++;
                j--;
            }
            if(i <= j) {
                BigInteger tmp = new BigInteger(arr[i].toString());
                arr[i] = new BigInteger(arr[j].toString());
                arr[j] = new BigInteger(tmp.toString());
                i++;
                j--;
            }
            c++;
        }
        return i;
    }
    static void sortQ(BigInteger arr[], int left, int right) {
          int index = partition(arr, left, right);
          if(left < index - 1)
              sortQ(arr, left, index - 1);
          if(index < right)
            sortQ(arr, index, right);
    }
   //End Quick
}
