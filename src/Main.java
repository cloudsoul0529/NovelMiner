import miner.SetNovel;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("请选择小说文件：");
        String novelFilePath = SetNovel.chooseFile();
        List<String> novelLines = new ArrayList<>(SetNovel.readByLine(novelFilePath));
    }
}