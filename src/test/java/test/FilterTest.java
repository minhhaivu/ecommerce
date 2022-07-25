package test;

import driver.EcommerceTestNG;
import org.testng.collections.Lists;

import java.util.List;

public class FilterTest {
  public static void main (String[] args) {
      EcommerceTestNG ecommerceTestNG = new EcommerceTestNG();
      String mySuitePath = "D:\\00. Personal\\03. Material\\Selenium\\Workspace\\git\\ecommerce\\mytestng.xml";
      List<String> mySuites = Lists.newArrayList();
      mySuites.add(0, mySuitePath);
      ecommerceTestNG.setTestSuites(mySuites);
      ecommerceTestNG.run("SmokeTest");
    }
}
