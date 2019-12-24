package com.joyner.gp_learning;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()



    {

        TestCopy testCopy = new TestCopy();
        ArrayList<TestCopy> a = new ArrayList();
        a.add(testCopy);



        ArrayList<TestCopy> dd = (ArrayList<TestCopy> )a.clone();
        System.out.println(a + "===" + dd);
        testCopy.change = 88;
        System.out.println(a + "===" + dd);

    }
}
