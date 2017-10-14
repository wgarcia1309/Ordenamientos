package ordenamientos;

import static java.lang.Math.random;

public class Ordenamientos {

    public static void main(String[] args) {
        int v[] =new int[10000];
        for (int i = 0; i < 10000; i++) {
            v[i] = (int) (random() * 10000);
            if ((int) (random() * 2) + 1 == 2) {
                v[i] = -v[i];
            }
        }
        System.out.println("shell sort has taken " + shell_sort(v) + " milliseconds");
        System.out.println("select sort has taken " + select_sort(v) + " milliseconds");
        System.out.println("insert sort has taken " + insert_sort(v) + " milliseconds");
        System.out.println("burbble sort has taken "+ Bubble_sort(v) +" milliseconds");
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
        return time_end - time_start;
    }
}
