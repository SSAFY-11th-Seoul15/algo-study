package week03.조수훈;

import java.util.Arrays;

public class test {
    

    public static void main(String[] args) {
            int[][]arr = new int[5][5];
            int cnt = 0;
            for(int i =0;i < 5; i++){
                for(int j = 0; j< 5; j++){
                    arr[i][j] = cnt;
                    cnt +=1;
                }
            }
            System.out.println(Arrays.deepToString(arr));




        }




}
