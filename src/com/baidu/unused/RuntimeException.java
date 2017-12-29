package com.baidu.unused;

/**
 * Created by baidu on 17/5/9.
 */
public class RuntimeException {
    public static void main(String[] ags) {
        try {
            throw new java.lang.NullPointerException("wwx");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
