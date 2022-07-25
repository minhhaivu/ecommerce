package listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

@Listeners
public class CustomizedAnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        CustomAttribute[] customAttributes = annotation.getAttributes();
        for (CustomAttribute customAtt: customAttributes
             ) {
            if (customAtt.name().equals("ID")) {
                System.out.println("Test Case " + Arrays.toString(customAtt.values())
                        +": " + annotation.getDescription());
            }
            if (customAtt.name().equals("businessValue")) {
                System.out.println("Business Value: " + Arrays.toString(customAtt.values()));
            }
        }

    }

}
