package week03.조수훈;
import java.util.*;
import java.io.*;
public class Main14238 {
    
    static int [] count;
    static int [] count2;
    static String [] chol;
    static String [] chol2;
    static boolean flag =false;
    static boolean flag2 = false;
 
    private static void recursive(int r,int N){
   

        //종료 조건
        if(r== N+2){
            for(int i =2;i< chol.length;i++){
                System.out.print(chol[i]);
            }
            flag = true;
            return;
        }

        if(!chol[r-2].equals("C") && !chol[r-1].equals("C") && count[2]!=0){
            chol[r] ="C";
            count[2] -=1;
            recursive(r+1,N);
        }
        if(!chol[r-1].equals("B") && count[1]!=0){
            chol[r] ="B";
            count[1] -=1;
            recursive(r+1,N);
        }
        if(count[0]!=0){
            chol[r] ="A";
            count[0] -=1;
            recursive(r+1,N);
        }



    }
    private static void recursive2(int r,int N){
     

        //종료 조건
        if(r== N+2){
            for(int i =2;i< chol2.length;i++){
                System.out.print(chol2[i]);
            }
            flag2= true;
            return;
        }
        if(!chol2[r-1].equals("B") && count2[1]!=0){
            chol2[r] ="B";
            count2[1] -=1;
            recursive2(r+1,N);
        }
        if(!chol2[r-2].equals("C") && !chol2[r-1].equals("C") && count2[2]!=0){
            chol2[r] ="C";
            count2[2] -=1;
            recursive2(r+1,N);
        }
       
        if(count2[0]!=0){
            chol2[r] ="A";
            count2[0] -=1;
            recursive2(r+1,N);
        }



    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split("");
        count = new int[3];
        count2 = new int[3];
        chol = new String[str.length+2];
        chol2 = new String[str.length+2];
        chol[0] = "0";
        chol[1]= "0";
        chol2[0] = "0";
        chol2[1]= "0";
        for(String s: str){
            if(s.equals("A")){
                count[0]+=1;
                count2[0]+=1;
            }else if( s.equals("B")){
                count[1]+=1;
                count2[1]+=1;
            }else if (s.equals("C")){
                count[2]+=1;
                count2[2]+=1;
            }
        }
        
        recursive2(2,str.length);
        if(flag2==false){
            recursive(2, str.length);
        }
        if( flag ==false && flag2==false){
            System.out.println(-1);
        }
        // System.out.println(Arrays.toString(chol));



    }
}
