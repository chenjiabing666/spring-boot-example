package com.slfx.cglib.asm;

import org.objectweb.asm.ClassReader;

import java.io.IOException;


public class ClassPrinterTest {
    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader("com.slfx.cglib.mapper.Dao");
        ClassPrinter cp = new ClassPrinter();
        cr.accept(cp, 0);
    }
}
