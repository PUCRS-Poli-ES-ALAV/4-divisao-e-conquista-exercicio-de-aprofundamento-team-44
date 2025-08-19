package br.pucrs;
import java.util.ArrayList;

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
        for(int i = 0; i<vetres.length; i++){
            if(i==vetres.length-1){
                System.out.print(vetres[i]);
            }
            else
            System.out.print(vetres[i]+",");
        }
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
    public static int[] mergeSort(int[] vet){
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

    public static long maxVal1(long A[], int init, int end){
        return 0;
    }
}
