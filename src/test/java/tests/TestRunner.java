package tests;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(DistributedTSPTest.class);
        for(Failure failure : result.getFailures())
        {
            System.out.println("Failed: " + failure.toString());
        }
        System.out.println("Failed count: "+ result.getFailureCount());
    }
}
