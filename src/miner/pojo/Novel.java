package miner.pojo;

import java.util.ArrayList;
import java.util.List;

public class Novel {
    private String title;
    private List<Character> characterList;
    private final List<String> paragraphs;

    //构造函数
    public Novel(String title, List<Character> characterList, List<String> paragraphs) {
        this.characterList = new ArrayList<>(characterList);
        this.paragraphs = new ArrayList<>(paragraphs);
        this.title = title;
    }
    //重命名
    public void setTitle(String title) {
        this.title = title;
    }
    //重新选择角色
    public void setCharacterList(List<Character> characterList) {
        this.characterList = characterList;
    }
    public String getTitle() {
        return title;
    }
    //new防止外部修改内部状态
    public List<String> getParagraphs() {
        return new ArrayList<>(paragraphs);
    }
    public List<Character> getCharacterList() {
        return new ArrayList<>(characterList);
    }

}
