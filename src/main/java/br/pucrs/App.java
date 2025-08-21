package br.pucrs;
import java.util.ArrayList;
import java.lang.Math;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int[] vetor = {1,67,4,13};
        int[] vetor2 = {1,2,3,4};
        int[] res = merge(vetor, vetor2);

        System.out.println("Teste do merge():");
        for(int i = 0; i<res.length; i++){
            if(i==res.length-1){
                System.out.print(res[i]);
            }
            else
            System.out.print(res[i]+",");
        }
        System.out.println();
        int[] vetres = {1,67,4,13,8,25,12,2,3,4,44};
        vetres = mergeSort(vetres);
        System.out.println("Teste do mergeSort():");
        for(int i = 0; i<vetres.length; i++){
            if(i==vetres.length-1){
                System.out.print(vetres[i]);
            }
            else
            System.out.print(vetres[i]+",");
        }

        long[] l = {20847,0,6,2023,6,704,2};
        System.out.println("\nTeste do maxVal1(): "+maxVal1(l, l.length));
    }

    /*
     * Assinatura: int[] mergeSort(int[] vet)
     * 
     * Casos base:
     * se vet tem 1 elemento ou menos
     * retorna vet;
     * 
     * se vet tem 2 elementos
     * if(primeiro > segundo)
     * troca eles de lugar
     * return vet;
     * 
     * se não
     * vet1 = mergeSort(primeira metade de vet);
     * vet2 = mergeSort(segunda metade de vet);
     * vet = vet1 + vet2;
     * bubble sort de vet;
     * retorna vet;
     * 
     */
    public static int[] mergeSort(int[] vet){//testar e colocar os tempos na tabela
        if(vet.length <= 1)
        return vet;

        if(vet.length == 2){
            if(vet[0] > vet[1]){
                int t = vet[0];
                vet[0] = vet[1];
                vet[1] = t;
            }
            return vet;
        }
        else{ //separa vet em 2
            int vet2[] = new int[vet.length/2];
            for(int i = 0; i<vet.length/2; i++){
                vet2[i] = vet[i];
            }
            int vet3[] = new int[vet.length/2 + vet.length%2];
            int j = 0;
            for(int i = vet.length/2; i<vet.length; i++){
                vet3[j] = vet[i];
                j++;
            }
            vet2 = mergeSort(vet2); //primeira metade
            vet3 = mergeSort(vet3); //segunda metade
            vet = merge(vet2, vet3); //junta os dois organizando
            return vet;
        }
    }

    //sup pro mergeSort
    public static int[] merge(int[] v1, int[] v2){
        int tam = v1.length + v2.length;
        int[] merged = new int[tam];
        int i = 0;
        //junta os dois vetores no merged
        for(int j = 0; j < v1.length; j++){
            merged[i] = v1[j];
            i++;
        }
        for(int j = 0; j < v2.length; j++){
            merged[i] = v2[j];
            i++;
        }
        //bubble sort
        for(int j = merged.length-1; j>=0; j--){
            for(int k = 0; k<j; k++){
                if(merged[k] > merged[k+1]){
                    int t = merged[k];
                    merged[k] = merged[k+1];
                    merged[k+1] = t;
                }
            }
        }
        return merged;
    }

    //testar e colocar os tempos na tabela
    public static long maxVal1(long vet[], int n) { 
       long max = vet[0];
       for (int i = 1; i < n; i++) {  
           if( vet[i] > max ) 
              max = vet[i];
       }
       return max;
    }

    //testar e colocar os tempos na tabela
    public static long maxVal2(long A[], int init, int end) {  
       if (end - init <= 1)
           return max(A[init], A[end]);  
       else {
             int m = (init + end)/2;
             long v1 = maxVal2(A,init,m);   
             long v2 = maxVal2(A,m+1,end);  
             return max(v1,v2);
            }
    }
    //sup para o maxVal2
    public static long max(long a, long b){
        if(a > b)
        return a;

        return b;
    }

    public static long multiply(long x, long y, int n){
        if(n == 1)
        return x * y;

        int m = (n+1)/2;
        long pow = (long)Math.pow(2, m);
        long a = x / pow;
        long b = x % pow;
        long c = y / pow;
        long d = y % pow;
        long e = multiply(a, c, n-m); //n-m por ter passado +1
        long f = multiply(b, d, n-m);
        long g = multiply(b, c, n-m);
        long h = multiply(a, d, n-m);
        return 2^(2*m)*e + 2^m*(g + h) + f;
    }
}
