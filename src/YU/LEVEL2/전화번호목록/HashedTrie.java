package kr.co.programmers.level2.lessons42577;

import java.util.HashMap;
import java.util.Iterator;

class HashedTrie {
    private static class TrieNode {
        private HashMap<Character, TrieNode> children;
        boolean isLeafNode;
        boolean isCompleteWord;

        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
        }

        public TrieNode getChild(char ch){
            return children.get(ch);
        }

        public TrieNode setChild(char ch){
            return children.put(ch, new TrieNode());
        }

        public boolean isLeafNode(){
            return isLeafNode;
        }

        public void setLeafNode(boolean isLeafNode){
            this.isLeafNode = isLeafNode;
        }

        public boolean isCompleteWord(){
            return isCompleteWord;
        }

        public void setCompleteWord(boolean isCompleteWord){
            this.isCompleteWord = isCompleteWord;
        }
    }

    public boolean insert(String str) {
        TrieNode head = root;
        for(char ch: str.toCharArray()){
            if(head.getChild(ch) == null){
                head.setChild(ch);
            }
            head = head.getChild(ch);
        }
        head.setCompleteWord(true);
        if(head.isLeafNode()){
            return false;
        }
        head.setLeafNode(true);
        return true;
    }

    public boolean searchPrefixWord(String str){
        TrieNode head = root;
        int index = 0;
        for(char ch: str.toCharArray()){
            head = head.getChild(ch);
            if(head == null){
                return false;
            }
            if(head.isCompleteWord() == true && index != str.length()-1){
                System.out.println(str);
                System.out.println("index: " + index);
                System.out.println("str.length() : " + str.length());
                return true;
            }
            index = index + 1;
        }
        return false;
    }

    public boolean searchCompleteWord(String str){
        TrieNode head = root;
        for(char ch: str.toCharArray()){
            head = head.getChild(ch);
            if(head == null){
                return false;
            }
        }
        return head.isLeafNode();
    }

    private TrieNode root;

    public HashedTrie() {
        root = new TrieNode();
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        HashedTrie trie = new HashedTrie();
        boolean result = true;
        for(int i = 0; i < phone_book.length; i++){
            trie.insert(phone_book[i]);
        }

        for(int i = 0; i < phone_book.length; i++){
            if(trie.searchPrefixWord(phone_book[i]) == true){ // prefix 존재
                result = false;
                System.out.println("Prefix가 존재하는 String : " + phone_book[i]);
                return result;
            } else {
                result = true;
            }
        }
        return result;
    }
}
