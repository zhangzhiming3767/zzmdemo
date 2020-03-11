package com.example.zzmdemo.nothingtodowithproject.javaBaseTest;


import com.example.zzmdemo.dto.Link;
import com.example.zzmdemo.dto.Node;

import java.io.IOException;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/3/11 21:21
 */
public class DoublyLinkList<T> {
    private Link<T> frist;
    private Link<T> last;
    //初始化首尾指针
    public DoublyLinkList(){
        frist = null;
        last = null;
    }

    public boolean isEmpty(){
        return frist == null;
    }
    //在头部新增
    public void addFrist(T value){
        Link<T> newLink= new Link(value);
        // 如果链表为空
        if(isEmpty()){
            //last -> newLink
            last = newLink;
        }else {
            // frist.pre -> newLink
            frist.pre = newLink;
        }
        // newLink -> frist
        newLink.next = frist;
        // frist -> newLink
        frist = newLink;
    }

    public void addLast(T value){
        Link<T> newLink= new Link(value);
        // 如果链表为空
        if(isEmpty()){
            // 表头指针直接指向新节点
            frist = newLink;
        }else {
            //last指向的节点指向新节点
            last.next = newLink;
            //新节点的前驱指向last指针
            newLink.pre = last;
        }
        // last指向新节点
        last = newLink;
    }

    //在key之前插入一个value
    public boolean addBefore(T key,T value){

        Link<T> cur = frist;
        if(frist.next.val == key){
            addFrist(value);
            return true;
        }else {
            //循环，找到这个key  TODO 这里写的有问题，待调整
            while (cur.next.val != key) {
                cur = cur.next;
                if(cur == null){
                    return false;
                }
            }
            //TODO 这一步操作没看懂，debug一下看看
            Link<T> newLink= new Link(value);
            newLink.next = cur.next;
            cur.next.pre = newLink;
            newLink.pre = cur;
            cur.next = newLink;
            return true;
        }
    }
    //在key之后插入一个value
    public void addAfter(T key,T value)throws RuntimeException{
        Link<T> cur = frist;
        //经过循环，cur指针指向指定节点
        while(cur.val!=key){
            cur = cur.next;
            // 找不到该节点
            if(cur == null){
                throw new RuntimeException("Node is not exists");
            }
        }
        Link<T> newLink = new Link<>(value);
        // 如果当前结点是尾节点
        if (cur == last){
            // 新节点指向null
            newLink.next = null;
            // last指针指向新节点
            last =newLink;
        }else {
            //新节点next指针，指向当前结点的next
            newLink.next = cur.next;
            //当前结点的前驱指向新节点
            cur.next.pre = newLink;
        }
        //当前结点的前驱指向当前结点
        newLink.pre = cur;
        //当前结点的后继指向新节点
        cur.next = newLink;
    }
    //删除第一个
    public void deleteFrist(){
        if(frist.next == null){
            last = null;
        }else {
            frist.next.pre = null;
        }
        frist = frist.next;
    }
    //删除最后一个
    public void deleteLast(T key){
        if(frist.next == null){
            frist = null;
        }else {
            last.pre.next = null;
        }
        last = last.pre;
    }
    //删除key
    public void deleteKey(T key)throws RuntimeException{
        Link<T> cur = frist;
        while(cur.val!= key){
            cur = cur.next;
            //不存在该节点
            if(cur == null){
                throw new RuntimeException("Node is not exists");
            }
        }
        // 如果frist指向的节点
        if(cur == frist){
            //frist指针后移
            frist = cur.next;
        }else {
            //前面节点的后继指向当前节点的后一个节点
            cur.pre.next = cur.next;
        }
        // 如果当前节点是尾节点
        if(cur == last){
            // 尾节点的前驱前移
            last = cur.pre;
        }else {
            //后面节点的前驱指向当前节点的前一个节点
            cur.next.pre = cur.pre;
        }
    }
    //TODO 待研究作用
    public T queryPre(T value)throws IOException,RuntimeException{
        Link<T> cur = frist;
        if(frist.val == value){
            throw new RuntimeException("Not find "+value+"pre");
        }
        while(cur.next.val!=value){
            cur = cur.next;
            if(cur.next == null){
                throw new RuntimeException(value +"pre is not exeist!");
            }
        }

        return cur.val;
    }
    //TODO 待研究作用
    public void displayForward(){
        Link<T> cur = frist;
        while(cur!=null){
            cur.displayCurrentNode();
            cur = cur.next;
        }
        System.out.println();

    }
    //TODO 待研究作用
    public void displayBackward(){
        Link<T> cur = last;
        while(cur!=null){
            cur.displayCurrentNode();
            cur = cur.pre;
        }
        System.out.println();
    }


    public static void main(String[] args) throws Exception{
        // 自己测试代码
        //TODO 以上每个方法调一遍，看看效果
        DoublyLinkList<Integer> d = new DoublyLinkList<Integer>();
        d.addFrist(1);
        d.addLast(99);
        d.addBefore(1,0);

//        d.addFrist(5);
//        d.addFrist(2);
//        d.addFrist(3);
//        d.addLast(6);
//        d.addFrist(4);
//        d.addFrist(5);
//        d.addLast(7);
//        d.displayForward();
//
//        System.out.println(d.queryPre(4));
//        System.out.println(d.queryPre(0));
    }


}
