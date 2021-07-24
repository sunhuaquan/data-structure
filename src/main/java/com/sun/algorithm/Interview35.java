package com.sun.algorithm;

import com.sun.util.ComplexListNode;

import java.util.HashMap;
import java.util.Map;


public class Interview35 {

    public static void main(String[] args) {


        ComplexListNode<String> complexListNode = new ComplexListNode("A");


    }

    public static  ComplexListNode<String> cloneNodes(ComplexListNode<String> complexListNode) {

        Map<ComplexListNode<String>,ComplexListNode<String>> map=new HashMap<>();

        ComplexListNode<String> copyHead=new ComplexListNode<>("");
        ComplexListNode<String> node=complexListNode;
        ComplexListNode<String> copyNode=copyHead;
        while (node!=null){
            String val = node.getVal();
            ComplexListNode<String> c=new ComplexListNode<>(val);
            copyNode.setNext(c);
            copyNode=c;
            map.put(node,c);
        }
        return copyHead.getNext();

    }


}
