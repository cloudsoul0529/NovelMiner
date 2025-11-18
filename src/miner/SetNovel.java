package miner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

//获取小说相关数据的工具类
public final class SetNovel {
    //静态函数，直接通过类名调用
    //选择文件
    public static String chooseFile() {
            JFileChooser chooser = new JFileChooser();
            //过滤文件，只显示.txt文件
            FileNameExtensionFilter filter =
                    new FileNameExtensionFilter("Text File", "txt");
            chooser.setFileFilter(filter);
            //打开对话框，并用result接收点击结果（打开/取消/错误）
            int result = chooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                return file.getAbsolutePath();
            }
            return null;
    }
    //按行读入文本
    public static List<String> readByLine(String filePath) {
        List<String> lines = new ArrayList<>();
        //try-with-resources方式，简洁安全，不需要finally代码块
        //指定编码方式，防止乱码
        try(FileReader fr = new FileReader(filePath, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(fr);) {
            String line;
            while((line = br.readLine()) != null) {
                //清理字符串首尾空白字符,防止影响段落的划分
                lines.add(line.trim());
            }
        }catch (Exception e) {
            //打印异常堆栈信息
            e.printStackTrace();
        }
        return lines;
    }
    //划分段落
    public static List<String> splitIntoParagraphs(List<String> lines) {
        List<String> paragraphs = new ArrayList<String>();
        StringBuffer current = new StringBuffer();
        for (String line : lines) {
            //遇到空行，段落结束
            if (line.isEmpty()) {
                //防止连续多行空行
                if (!current.isEmpty()) {
                    paragraphs.add(current.toString().trim());
                    current.setLength(0);
                }
            }else {
                //添加空格，防止单词相连
                current.append(line).append(" ");
            }
        }
        //处理最后一段
        if (!current.isEmpty()) {
            paragraphs.add(current.toString());
        }
        return paragraphs;
    }
}
