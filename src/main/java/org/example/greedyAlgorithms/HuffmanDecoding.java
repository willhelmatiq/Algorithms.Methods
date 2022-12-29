package org.example.greedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * task description on https://stepik.org/lesson/13239/step/6?unit=3425
 */

public class HuffmanDecoding {

    public static void main(String[] args) {
        try {
            decode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void decode() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = bufferedReader.readLine();
        int n = Integer.parseInt(firstLine.split(" ")[0]);
        int codeLength = Integer.parseInt(firstLine.split(" ")[1]);

        Map<String, Character> dict = new HashMap<>();
        char symbol;
        String code;
        String tempString;
        for (int i = 0; i < n; i++) {
            tempString = bufferedReader.readLine();
            symbol = tempString.charAt(0);
            code = tempString.split(": ")[1];
            dict.put(code, symbol);
        }
        StringBuilder encodedRow = new StringBuilder();
        for (int i = 0; i < codeLength; i++){
            encodedRow.append((char)bufferedReader.read());
        }
        StringBuilder decodedRow = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < encodedRow.length(); i++){
            temp.append(encodedRow.charAt(i));
            if(dict.containsKey(temp.toString())){
                decodedRow.append(dict.get(temp.toString()));
                temp.delete(0, temp.length());
            }
        }
        System.out.print("\n");
        System.out.println(decodedRow);
    }
}
