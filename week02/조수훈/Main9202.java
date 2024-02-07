// 4*4 * 8 * 8
// insert 4* 4*8*8 * 8 * 30
// search 4*4*8*8*8*300000

package week02.조수훈;

import java.util.*;
import java.io.*;
public class Main9202 {
    
    static String [] words;
    static char[][] graph;
    static Trie trie;
    static int [] dx = {0,1,1,1,0,-1,-1,-1};
    static int [] dy = {1,1,0,-1,-1,-1,0,1};
    static boolean [][] visited;
    static StringBuilder sb;
    

    public static class TrieNode{
        public Map<Character, TrieNode> childNodes = new HashMap<>();
        boolean isLastC;
    }
    public static class Trie{
        public TrieNode rootNode;
        Trie(){
            rootNode = new TrieNode();
        }
        public void insert(String str){
            TrieNode node = this.rootNode;
            for(int i =0; i< str.length(); i++){
                node =node.childNodes.computeIfAbsent(str.charAt(i), c-> new TrieNode());
            }
            node.isLastC = true;
        }
        public int search(String str){
            TrieNode node = this.rootNode;
            int k=0;
            for(int i =0; i< str.length(); i++){
                node = node.childNodes.getOrDefault(str.charAt(i), null);
                if(node == null){
                   break;
                }
                k+=1;
                System.out.println(str.charAt(i)+" "+ k);
            }
            return k;

        }

    }

    public static void BackTrack(int r , int x, int y){
        if(r == 8){
            trie.insert(sb.toString());
   
            return;
        }

        for(int i =0;i < 8; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(nx >= 4|| nx<0 || ny>=4 || ny<0){
                continue;
            }
            if(visited[nx][ny] == false){
                visited[nx][ny] = true;
                sb.append(graph[nx][ny]);
                BackTrack(r+1, nx, ny);
                sb.deleteCharAt(sb.length()-1);
                visited[nx][ny] = false;
            }
        }

    }
    public static void main(String[] args) throws Exception{
      
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(br.readLine());
        words = new String[w];
        for(int i =0; i < w; i++){
            words[i] = br.readLine();
        }
        br.readLine();
        int b = Integer.parseInt(br.readLine());
     
        for(int T =0;T < b; T++){
            sb = new StringBuilder();
        	graph = new char[4][4];
            for(int i =0; i<4; i++){
                String t  = br.readLine();
                for(int j =0; j<4; j++){
                    graph[i][j] = t.charAt(j);
                }
            }
            br.readLine();
            trie = new Trie();
        
            for(int i =0; i< 4; i++){
                for(int j =0; j< 4; j++){
                    visited = new boolean[4][4];
                    sb.append(graph[i][j]);
                    visited[i][j] = true;
                    BackTrack(1, i, j);
                    sb.deleteCharAt(sb.length()-1);
                    visited[i][j] = false;
                }
            }
            int sum =0;
            int count = 0;
            int max_k = 0;
            List<String> lw = new ArrayList<>();
            for(int i =0; i< words.length;i++){
                int k =trie.search(words[i]);
                if(words[i].length()==k){
                    count+=1;
                    lw.add(words[i]);
                    max_k = Math.max(k, max_k);
                }
                if(k==3 || k==4){
                    sum +=1;
                }
                else if(k==5){
                    sum+=2;
                }
                else if(k==6){
                    sum+=3;
                }
                else if(k==7){
                    sum+=5;
                }
                else if(k==8){
                    sum+=11;
                }

            }

            List<String> last = new ArrayList<>();
            for(int i=0;i< lw.size();i++){
                String t = lw.get(i);
                if(t.length()==max_k){
                    last.add(t);
                }
            }
            Collections.sort(last);
            System.out.println(sum+" "+last.get(0)+" "+count);
            


        }

    
    
    
    }


}
