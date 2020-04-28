package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;

import com.example.zzmdemo.dto.HeroNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 * 单项链表
 *
 * @author zhangzhiming
 * @since 2020/4/24 19:39
 */
public class SingleLinkList {


    public static void main(String[] args) {
        HeroNode temp = null;
        for (int i = 0; i < 3; i++) {
            HeroNode heroNode = new HeroNode();
            heroNode.setId(i + "");
            heroNode.setNo(i);
            heroNode.setNickName("第" + i + "个节点");
            //尾插法
            temp = addNodeHead(temp, heroNode);
        }

        System.out.println("");
    }

    /**
     * 暂存
     */
    public void temporary(){
        HeroNode temp = null;
        for (int i = 0; i < 3; i++) {
            HeroNode heroNode = new HeroNode();
            heroNode.setId(i + "");
            heroNode.setNo(i);
            heroNode.setNickName("第" + i + "个节点");
            //尾插法
            temp = addNodeTail(temp, heroNode);
        }
        //链表循环
        temp = cycle(temp);
        //链表反转
        temp = reverse(temp);
        HeroNode heroNode = new HeroNode();
        heroNode.setId("2");
        heroNode.setNo(2);
        heroNode.setNickName("第" + 2 + "个节点，这是被覆盖的值");
        //在指定节点插入
        temp = addByOrder(temp, heroNode, true);
        heroNode.setNickName("第" + 2 + "个节点，这是被更新的值");
        //更新指定节点的值
        temp = updateByNo(temp, heroNode);
        //删除指定节点
        temp = delete(temp, 2);
        //查找指定节点
        temp = queryByNo(temp, 1);
    }


    /**
     * 判断链表有没有循环
     * @param temp 原数据
     * @return true 有
     */
    public  static Boolean judgeCycle(HeroNode temp){

        return true;
    }

    /**
     * 头插法
     * @param temp 原数据
     * @param heroNode 新数据
     * @return 结果
     */
    public static HeroNode addNodeHead(HeroNode temp, HeroNode heroNode) {
        if(temp==null){
            return heroNode;
        }
        if(heroNode==null){
            throw new RuntimeException("待插入的节点不能为空");
        }
        heroNode.next=temp;
        return heroNode;
    }

    /**
     * 添加新节点 尾插法
     * 原理：不考虑顺序时，先找到最后一个节点，根据next指向下一个node
     *
     * @param temp     原数据
     * @param heroNode 新数据
     */
    public static HeroNode addNodeTail(HeroNode temp, HeroNode heroNode) {
        if (temp == null) {
            return heroNode;
        }
        HeroNode result = temp;
        //遍历链表，找到最后
        while (result.next != null) {
            result = result.next;
        }
        //当退出while循环时，已经找到链表的在最后，用这个节点的next指向新的节点
        result.next = heroNode;
        return temp;
    }
    /**
     * 将链表收尾相连，循环
     * @param result 原数据
     * @return 新数据
     */
    public static HeroNode cycle(HeroNode result) {
        if(result==null){
            throw new RuntimeException("链表不能为空");
        }
        HeroNode temp=result;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=result;
        return result;
    }

    /**
     * 链表反转
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     *
     * @param result 原链表
     * @return 反转后的链表
     */
    public static HeroNode reverse(HeroNode result) {
        if (result == null) {
            throw new RuntimeException("链表不能为空");
        }
        List<HeroNode> list = new ArrayList<>();
        list.add(result);
        while (result.next != null) {
            list.add(result.next);
            result = result.next;
        }
        HeroNode temp = list.get(list.size() - 1);
        HeroNode newResult = temp;
        if (list.size() > 1) {
            for (int i = list.size() - 2; i >= 0; i--) {
                newResult.next = list.get(i);
                if (i == 0) {
                    newResult.next.next = null;
                }else {
                    newResult = newResult.next;
                }
            }
        }
        return temp;
    }

    /**
     * 插入英雄的方式，将节点插入指定位置
     *
     * @param result   原链表
     * @param heroNode 待插入节点
     * @param cover    节点已有数据时，是否覆盖,true 覆盖
     * @return HeroNode
     */
    public static HeroNode addByOrder(HeroNode result, HeroNode heroNode, boolean cover) {
        HeroNode temp = result;
        if (temp == null) {
            if (heroNode == null) {
                throw new RuntimeException("原链表和插入节点 不能同时为空");
            } else {
                return heroNode;
            }
        }
        if (temp.no > heroNode.no) {
            heroNode.next = temp;
            return heroNode;
            //第一位
        } else if (temp.no == heroNode.no) {
            if (cover) {
                temp.nickName = heroNode.nickName;
                return heroNode;
            } else {
                throw new RuntimeException("该节点已有数据");
            }
        }
        boolean flag = false;
        //找出临时变量为插入位置的前一个节点
        //标志是否已经存在要添加的节点
        //2.遍历
        while (temp.next != null) {
            if (temp.next.no > heroNode.no) {
                HeroNode next = temp.next;
                temp.next = heroNode;
                heroNode.next = next;
                flag = true;
                break;
            } else if (temp.next.no == heroNode.no) {
                if (cover) {
                    temp.next.nickName = heroNode.nickName;
                    flag = true;
                    break;
                } else {
                    throw new RuntimeException("该节点已有数据");
                }
            } else {
                temp = temp.next;
            }
        }
        if (!flag) {
            temp.next = heroNode;
        }
        return result;
    }

    /**
     * @param result   原链表
     * @param heroNode 待更新的节点
     * @return HeroNode
     */
    public static HeroNode updateByNo(HeroNode result, HeroNode heroNode) {
        HeroNode temp = result;
        if (temp == null) {
            throw new RuntimeException("链表为空");
        }
        if (heroNode.no == temp.no) {
            temp.nickName = heroNode.nickName;
            return result;
        }
        boolean flag = true;
        while (temp.next != null) {
            if (heroNode.no == temp.next.no) {
                temp.next.nickName = heroNode.nickName;
                flag = false;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            throw new RuntimeException("没有找到编号为" + heroNode.no + "的数据");
        }
        return result;
    }

    /**
     * @param result
     * @param no
     * @return
     */
    public static HeroNode delete(HeroNode result, int no) {
        HeroNode temp = result;
        boolean flag = true;
        if (temp == null) {
            throw new RuntimeException("链表为空");
        }
        if (temp.no == no) {
            return temp.next;
        }
        while (temp.next != null) {
            if (temp.next.no == no) {
                temp.next = temp.next.next;
                flag = false;
                break;//找到删除节点的前一个节点
            }
            temp = temp.next;
        }
        if (flag) {
            throw new RuntimeException("链表为空");
        }
        return result;
    }

    /**
     * @param result
     * @param no
     * @return
     */
    public static HeroNode queryByNo(HeroNode result, int no) {
        HeroNode temp = result;
        if (temp == null) {
            throw new RuntimeException("链表为空");
        }
        if (temp.no == no) {
            return temp;
        }
        while (temp.next != null) {
            if (temp.next.no == no) {
                return temp.next;
            }
            temp = temp.next;
        }
        throw new RuntimeException("没有找到编号为" + no + "的数据");
    }


}
