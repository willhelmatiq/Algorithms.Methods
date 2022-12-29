package org.example.greedyAlgorithms;

import java.util.*;
import java.util.stream.Collectors;

/**
 * task description on https://stepik.org/lesson/13239/step/5?unit=3425
 */

public class HuffmanCoding {

    public static void main(String[] args) {
        encode();
    }
    static void encode() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.isEmpty()){
            return;
        }
        Map<Character, Long> frequencyMap = s.chars().mapToObj(a -> (char)a)
                .collect(Collectors.groupingBy(character -> character, Collectors.counting()));
        List<Node> nodeList = new ArrayList<>();
        frequencyMap.forEach((character, aLong) -> nodeList.add(new Node(character, Math.toIntExact(aLong))));
        List<Node> sortedNodeList = new ArrayList<>(nodeList.stream().sorted(Node::compareTo).toList());
        Node root = new Node('\n', 0);
        while (!sortedNodeList.isEmpty()) {
            Node right = sortedNodeList.get(sortedNodeList.size() - 1);
            sortedNodeList.remove(sortedNodeList.size() - 1);
            if(sortedNodeList.isEmpty()){
                root = right;
            } else {
                Node left = sortedNodeList.get(sortedNodeList.size() - 1);
                Node intermediateNode = new Node((char)127, left.frequency + right.frequency);
                intermediateNode.setLeft(left);
                intermediateNode.setRight(right);
                sortedNodeList.remove(sortedNodeList.size() - 1);
                if (sortedNodeList.isEmpty()){
                    root = intermediateNode;
                } else {
                    int i = 0;
                    while (i < sortedNodeList.size()){
                        if(intermediateNode.compareTo(sortedNodeList.get(i)) <= 0){
                            sortedNodeList.add(i, intermediateNode);
                            break;
                        }
                        i++;
                    }
                    if (i == sortedNodeList.size()) {
                        sortedNodeList.add(i, intermediateNode);
                    }
                }
            }

        }

        Map<Character, String> dict = new HashMap<>();
        makeDictFromTree(root, dict, new StringBuilder(), 0);
        Map<Character, String> dictSorted = dict.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1,v2)->v1, LinkedHashMap::new));

        StringBuilder result = new StringBuilder();
        s.chars().mapToObj(a -> (char)a).forEach(character -> result.append(dict.get(character)));

        System.out.println(dict.size() + " " + result.toString().length());
        dictSorted.entrySet().forEach( entry ->
                System.out.println(entry.getKey() + ": " + entry.getValue()));
        System.out.println(result.toString());

    }

    static void makeDictFromTree(Node root, Map<Character, String> dict, StringBuilder code, int depth) {
        if (root.getLeft() == null && root.getRight() == null){
            if (code.isEmpty()){
                code.append('0');
            }
            dict.put(root.getA(), code.toString());
        } else {
            depth++;
            if (root.getLeft() != null) {
                code.append('0');
                makeDictFromTree(root.getLeft(), dict, code, depth);
            }
            if (root.getRight() != null) {
                code.delete(depth-1, code.length());
                code.append('1');
                makeDictFromTree(root.getRight(), dict, code, depth);
            }
        }
    }

    static class Node implements Comparable<Node>{
        private Node left;
        private Node right;
        private char a;
        private int frequency;
        Node(char a, int frequency){
            this.a = a;
            this.frequency = frequency;
        }
        public Node getLeft(){
            return left;
        }

        public Node getRight(){
            return right;
        }

        public char getA(){
            return a;
        }

        public int getFrequency(){
            return frequency;
        }

        public void setLeft(Node node) {
            this.left = node;
        }

        public void setRight(Node node){
            this.right = node;
        }

        public void setA(char a ){
            this.a = a;
        }

        public void setFrequency(int frequency){
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Node o) {
            if (this.frequency < o.frequency) {
                return 1;
            } else if (this.frequency > o.frequency) {
                return -1;
            } else {
                return Character.compare(this.a, o.a);
            }
        }
    }
}
