package week02.조수훈;

import java.util.*;



import java.io.*;
public class Trie {
    public static class trie{
        public TrieNode rootNode;
        public trie(){
            rootNode = new TrieNode();
        }

        public void insert(String word){
            TrieNode temp = rootNode;
            for(int i=0;i< word.length();i++){
                temp = temp.childsNode.computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            temp.isLast = true;
        }
        public boolean find(String word){
            TrieNode temp = rootNode;
            for(int i=0;i < word. length(); i++){
                temp = temp.childsNode.getOrDefault(word.charAt(i), null);
                if(temp == null){
                    return false;
                }
            }
            return true;



        }

    }


    public static class TrieNode{
        boolean isLast;
        HashMap<Character, TrieNode> childsNode = new HashMap<>();
    }
    

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        trie t = new trie();
        t.insert(word);
        System.out.println(t.find("hi"));



    }
}
