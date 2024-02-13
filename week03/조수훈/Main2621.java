package week03.조수훈;
import java.util.*;
import java.io.*;


public class Main2621 {

    static HashMap<String, Integer> cardsAlphs = new HashMap<>();
    static HashMap<Integer, Integer> cardsNums = new HashMap<>();
    static int v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            if (cardsAlphs.containsKey(a)) {
                cardsAlphs.put(a, cardsAlphs.get(a) + 1);
            } else {
                cardsAlphs.put(a, 1);
            }
            if (cardsNums.containsKey(b)) {
                cardsNums.put(b, cardsNums.get(b) + 1);
            } else {
                cardsNums.put(b, 1);
            }

        }
        int point = 0;
        ArrayList<Integer> sortedNums = new ArrayList<>(cardsNums.keySet());
        Collections.sort(sortedNums);
        boolean flag = true;
        if(sortedNums.size() !=5) flag = false;
        for (int i = 0; i < sortedNums.size() - 1; i++) {
            if (sortedNums.get(i + 1) - sortedNums.get(i) != 1) {
                flag = false;
                break;
            }
        }

        // 5개의 카드가 색이 같으면서 숫자가 연속적일때
        if (cardsAlphs.containsValue(5) && flag == true) {
            int max = Collections.max(cardsNums.keySet());
            point += max + 900;
        }
        // 4개의 숫자가 같을때
        else if (cardsNums.containsValue(4)) {
            for (int num : cardsNums.keySet()) { 
                if (cardsNums.get(num) == 4) {
                    point += num + 800;
                    break;
                } 
            }
        }
        //3개의 같은숫자, 나머지 2장 같은 숫자
        else if(cardsNums.containsValue(3) && cardsNums.containsValue(2)){
            for (int num : cardsNums.keySet()) { 
                if (cardsNums.get(num) == 3) {
                    point += num *10;
                } 
                else if (cardsNums.get(num) == 2) {
                    point += num + 700;
                } 
            }
        }


        // 5 장 같은 색일때
        else if (cardsAlphs.containsValue(5)) {
            int max = Collections.max(cardsNums.keySet());
            point += max + 600;
        }
        // 숫자가 연속적일때
        else if (flag == true) {
            int max = Collections.max(cardsNums.keySet());
            point += max + 500;
        }

        // 3장의 숫자가 같을떄
        else if( cardsNums.containsValue(3)){
            for (int num : cardsNums.keySet()) { 
                if (cardsNums.get(num) == 3) {
                    point += num + 400;
                    break;
                }
            }
        }
        // 2장의 숫자가 같고, 다른 2장의 숫자가 같을떄
        else if( cardsNums.containsValue(2) && cardsNums.keySet().size()==3){
            int temp = 0 ;
            for (int num : cardsNums.keySet()) { 
                if (cardsNums.get(num) == 2 && temp == 0 ) {
                    temp = num;
                }
                else if(cardsNums.get(num) == 2){
                    if(num > temp){
                        point += 10 * num;
                        point += temp + 300;
                    }else{
                        point += 10 * temp;
                        point += num + 300;
                    }
                    break;
                }
            }




        }

        // 2장의 숫자가 같을때
        else if (cardsNums.containsValue(2)) {
            for (int num : cardsNums.keySet()) { 
                if (cardsNums.get(num) == 2) {
                    point += num + 200;
                    break;
                }
                
            }
        } 
        else {
            int max = Collections.max(cardsNums.keySet());
            point += max + 100;
        }

        System.out.println(point);
        return;
    }
}
