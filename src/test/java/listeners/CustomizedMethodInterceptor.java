package listeners;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomizedMethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<IMethodInstance> result = new ArrayList<IMethodInstance>();
        for (IMethodInstance m : methods) {
            Set<String> groups = new HashSet<String>();
            for (String group : m.getMethod().getGroups()) {
                groups.add(group);
            }
            if (groups.contains("High")) {
                result.add(0, m);
            }
            else {
                result.add(m);
            }
        }
        return result;
    }
}
