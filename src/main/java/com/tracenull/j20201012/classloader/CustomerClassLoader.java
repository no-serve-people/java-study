package com.tracenull.j20201012.classloader;

import java.io.*;

/**
 * https://mp.weixin.qq.com/s?__biz=MzAxNjQwOTU0Mg==&mid=2247484238&idx=1&sn=356504dc8b4d9c7e2fd1add25a34c6b5&chksm=9bf475e7ac83fcf18134ea60318c3c0a1609c6efb81d6b25972d7d64898756c19e9f76bb83a8&scene=178#rd
 */
public class CustomerClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String rootDir = "/Users/ixingjue/IdeaProjects/javastudy/src/main/java";

        byte[] classData = getClassData(rootDir, name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getClassData(String rootPath, String className) {
        String path = rootPath + File.separator + className.replace(".", File.separator) + ".class";

        try {
            InputStream ins = new FileInputStream(path);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;

            byte[] buffer = new byte[bufferSize];
            int byteNumRead = 0;
            while ((byteNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, byteNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void main(String[] args) {
        CustomerClassLoader loader = new CustomerClassLoader();
        try {
            // 传入class文件的全限定名
            Class<?> clazz = loader.loadClass("com.tracenull.j20201012.classloader.CustomerClassLoader");
            System.out.println(clazz.getClassLoader());

            System.out.println(clazz.newInstance().toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "I am CustomerObject";
    }
}
