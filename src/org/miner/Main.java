package org.miner;

import org.miner.util.SetNovel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("请选择小说文件：");
        String novelFilePath = SetNovel.chooseFile();
        List<String> novelLines = new ArrayList<>(SetNovel.readByLine(novelFilePath));
    }
}