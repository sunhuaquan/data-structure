package com.sun.util;

/**
 * @author sunhuaquan
 * @Title: UF
 * @ProjectName data-structure
 * @Description: TODO
 * @date 2018/11/1721:47
 */
public interface UF {

    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
