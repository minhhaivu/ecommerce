package test;

import driver.EcommerceTestNG;

public class RunDefaultSuiteTest {
    public static void main(String[] args) {
        System.out.println("EcommerceTestNG always run default suite: mytestng.xml");
        EcommerceTestNG testNG = new EcommerceTestNG();
        testNG.run();
    }
}
