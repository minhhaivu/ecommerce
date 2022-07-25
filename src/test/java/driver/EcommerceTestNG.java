package driver;

import org.testng.TestNG;
import org.testng.collections.Lists;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.List;

public class EcommerceTestNG extends TestNG {
    public EcommerceTestNG() {
        super();
    }

    @Override
    public void run() {
        String mySuitePath = "D:\\00. Personal\\03. Material\\Selenium\\Workspace\\git\\ecommerce\\mytestng.xml";
        List<String> mySuites = Lists.newArrayList();
        mySuites.add(0, mySuitePath);
        setTestSuites(mySuites);
        super.run();
    }

    public void run(String filteredTest){
        initializeSuitesAndJarFile();
        filterTest(filteredTest);
        super.run();
    }

    public void filterTest(String name) {
        List<XmlSuite> resultSuite = Lists.newArrayList();
        for (XmlSuite suite : m_suites
        ) {
            List<XmlTest> filteredTest = Lists.newArrayList();
            for (XmlTest test : suite.getTests()
            ) {
                if (test.getName().equals(name)) {
                    filteredTest.add(test);
                }
            }
            suite.setTests(filteredTest);
            resultSuite.add(suite);
        }
        m_suites=resultSuite;
    }

    private void filterClass(String name) {
        List<XmlSuite> result = Lists.newArrayList();
        for (XmlSuite suite : m_suites
        ) {
            for (XmlTest test : suite.getTests()
            ) {

            }
        }

    }
}
