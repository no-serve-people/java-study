package com.tracenull.j20200908;

/**
 * https://www.runoob.com/java/java-generics.html
 */
public class GenericMethodTest {
    // 泛型方法 printArray
    public static <E> void printArray(E[] inputArray) {
        // 输出数组元素
        for (E e : inputArray) {
            System.out.printf("%s ", e);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        System.out.println("整形数组元素为：");
        printArray(intArray);
        System.out.println("\n双精度型数组元素为:");
        printArray(doubleArray); // 传递一个双精度型数组
        System.out.println("\n字符型数组元素为:");
        printArray(charArray); // 传递一个字符型数组
    }
}
