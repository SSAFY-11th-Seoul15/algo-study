// 4*4 * 8 * 8
// insert 4* 4*8*8 * 8 * 30
// search 4*4*8*8*8*300000

package week02.조수훈;

import java.util.*;
import java.io.*;
public class Main9202_2 {
    
  
    static char[][] graph;
    static Trie trie;
    static int [] dx = {0,1,1,1,0,-1,-1,-1};
    static int [] dy = {1,1,0,-1,-1,-1,0,1};
    static boolean [][] visited;
   static StringBuilder sb = new StringBuilder();
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
        public boolean search(String str){
            TrieNode node = this.rootNode;
          
            for(int i =0; i< str.length(); i++){
                node = node.childNodes.get(str.charAt(i));
                if(node == null){
                   return false;
                }
            }
            return true;

        }

    }

    public static void BackTrack(int r , int x, int y, Set<String> stringSet){
        if(r == 8){
            stringSet.add(sb.toString());
            return;
        }

        for(int i =0;i < 8; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(nx >= 4|| nx<0 || ny>=4 || ny<0){
                continue;
            }
            if(visited[nx][ny] == false && trie.search(sb.toString())){
                visited[nx][ny] = true;
                sb.append(graph[nx][ny]);
                BackTrack(r+1, nx, ny, stringSet);
                sb.deleteCharAt(sb.length()-1);
                visited[nx][ny] = false;
            }
        }

    }

    private static void setPrint(Set<String> stringSet) {
        List<String> list = new ArrayList<>(stringSet);
        Collections.sort(list);
        String longestStr = "";
        int score = 0;
 
        for (String s : list) {
            if (s.length() > longestStr.length()) {
                longestStr = s;
            }
            score += getScore(s.length());
        }
 
        sb.append(score).append(" ").append(longestStr).append(" ").append(list.size()).append("\n");
    }

    private static int getScore(int maxLen) {
        int score = 0;
        if (maxLen <= 2) score = 0;
        else if (maxLen <= 4) score = 1;
        else if (maxLen == 5) score = 2;
        else if (maxLen == 6) score = 3;
        else if (maxLen == 7) score = 5;
        else if (maxLen == 8) score = 11;
 
        return score;
    }
    public static void main(String[] args) throws Exception{
      
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(br.readLine());
        trie = new Trie();
        for(int i =0; i < w; i++){
            trie.insert(br.readLine());
        }
        br.readLine();
        int b = Integer.parseInt(br.readLine());
        for(int T =0;T < b; T++){
            Set<String> stringSet = new HashSet<>();
            sb = new StringBuilder();
        	graph = new char[4][4];
            for(int i =0; i<4; i++){
                String t  = br.readLine();
                for(int j =0; j<4; j++){
                    graph[i][j] = t.charAt(j);
                }
            }
            br.readLine();
            for(int i =0; i< 4; i++){
                for(int j =0; j< 4; j++){
                    visited = new boolean[4][4];
                    sb.append(graph[i][j]);
                    visited[i][j] = true;
                    BackTrack(1, i, j,stringSet);
                    sb.deleteCharAt(sb.length()-1);
                    visited[i][j] = false;
                }
            }
            setPrint(stringSet);
 
            if (b != 0) br.readLine();


        }

    
        System.out.println(sb.toString());
    
    }


}
