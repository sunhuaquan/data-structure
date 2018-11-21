package com.sun.util;

/**
 * @author sunhuaquan
 * @Title: Tree
 * @ProjectName data-structure
 * @Description: 树接口
 * @date 2018/11/2023:23
 */
public interface Tree<E> {

    /**
     * 获取树的元素个数
     *
     * @return
     */
    int size();

    /**
     * 判断树是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 向数中添加元素
     *
     * @param e
     */
    void add(E e);

    /**
     * 是否包含元素e
     *
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 获取最大元素
     *
     * @return
     */
    E max();

    /**
     * 获取最小元素
     *
     * @return
     */
    E min();

    /**
     * 删除元素e
     *
     * @param e
     */
    void remove(E e);

    /**
     * 树的中序遍历
     *
     * @return
     */
    List<E> inOrder();


}
