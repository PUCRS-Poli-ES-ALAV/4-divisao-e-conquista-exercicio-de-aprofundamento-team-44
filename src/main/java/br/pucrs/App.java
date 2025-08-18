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
    }

    /*
     * Assinatura: int[] mergeSort(int[] vet)
     * 
     * Casos base:
     * se arr tem 1 elemento ou menos
     * retorna arr;
     * 
     * se não
     * adiciona primeira metade de L em vet;
     * adiciona a segunda metade de L em vet;
     * bubble sort vet
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
        }
        else{ //separa vet em 2
            int vet2[] = null;
            for(int i = 0; i<=vet.length/2; i++){
                vet2[i] = vet[i];
            }
            int vet3[] = null;
            int j = 0;
            for(int i = vet.length; i>vet.length/2; i--){
                vet3[j] = vet[i];
                j++;
            }
            vet2 = mergeSort(vet2); //primeira metade
            vet3 = mergeSort(vet3); //segunda metade
            for(int i = 0; i <= vet.length; i++){
            }

        }

        return null;
    }

    //sup pro mergeSort
    public static int[] merge(int[] v1, int[] v2){
        
        
        return null;
    }
}
