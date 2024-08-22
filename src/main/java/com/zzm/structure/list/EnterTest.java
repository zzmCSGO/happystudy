package com.zzm.structure.list;

/**
 * @Author:zzm
 * @Date:2024/8/20 21:27
 * ArrayList和ListedList集合性能测试对比
 */
public class EnterTest {
    public static void main( String[] args )
    {

//        ArrayListTest.addFromHeaderTest(100000);
//        LinkedListTest.addFromHeaderTest(100000);


//        ArrayListTest.addFromMidTest(10000);
//        LinkedListTest.addFromMidTest(10000);

        ArrayListTest.addFromTailTest(10000000);
        LinkedListTest.addFromTailTest(10000000);

//        ArrayListTest.deleteFromHeaderTest(100000);
//        LinkedListTest.deleteFromHeaderTest(100000);

//        ArrayListTest.deleteFromMidTest(100000);
//        LinkedListTest.deleteFromMidTest(100000);

//        ArrayListTest.deleteFromTailTest(1000000);
//        LinkedListTest.deleteFromTailTest(1000000);
//
//        ArrayListTest.getByForTest(10000);
//        LinkedListTest.getByForTest(10000);
//
//        ArrayListTest.getByIteratorTest(100000);
//        LinkedListTest.getByIteratorTest(100000);
    }
}
