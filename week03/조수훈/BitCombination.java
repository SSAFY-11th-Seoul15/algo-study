package week03.조수훈;
import java.util.*;
import java.io.*;
public class BitCombination {
    

    static int[] p = {1,2,3,4,5};


    public static void BitCombi(int start, int r, int v){
        if(r==3){
            for(int i =0; i< 5; i++){
                if( (v & (1<<i)) !=0){
                    System.out.print(p[i]+" ");
                }
 
            }
            System.out.println();
            return;
        }

        for(int i =start; i< 5; i++){
            if( (v & (1<<i)) == 0 ){
                BitCombi(start+1, r+1, v|(1<<i));
            }
        }


    }

    public static void main(String[] args) {
        
        BitCombi(0, 0, 0);



    }
}
