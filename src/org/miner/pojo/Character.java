package org.miner.pojo;

import java.util.HashSet;
import java.util.Set;

//记录角色名字及其别名
public class Character {
    //名字
    private final String characterName;
    //别名
    private Set<String> aliases;

    //无别名情况下的构造函数
    public Character(String characterName){
        //初始化容器
        this.aliases = new HashSet<>();
        //赋值
        this.characterName = characterName;
    }
    //有别名情况下的构造函数
    public Character(String characterName, Set<String> aliases){
        //初始化容器
        this.aliases = new HashSet<>();
        //赋值
        this.characterName = characterName;
        //初始化并深拷贝，防止外部修改影响内部
        this.aliases = new HashSet<>(aliases);
    }
    //返回所有名字和别名的集合，重新new一个，防止外部修改内部状态
    public Set<String> getNameAndAliases(){
        HashSet<String> nameAndAliases = new HashSet<>(aliases);
        nameAndAliases.add(this.characterName);
        return nameAndAliases;
    }
}
