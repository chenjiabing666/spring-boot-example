package com.slfx.cglib.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;


public class ClassChangeTest {
    public static void main(String[] args) throws IOException {
        ClassWriter cw = new ClassWriter(0);
        ClassReader cr = new ClassReader("com.slfx.TestI");
        cr.accept(cw, 0);
        byte[] b = cw.toByteArray(); //


        MyClassLoader classLoader=new MyClassLoader();
        Class loadedClass = classLoader.defineClass("com.slfx.TestI", b);
        System.out.println( loadedClass.getMethods()[0]);
    }
}
