package Poker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class text {
    public static void main(String[] args) {
        File file = new File("d:/text.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            //读取读取文件内容并打印
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
