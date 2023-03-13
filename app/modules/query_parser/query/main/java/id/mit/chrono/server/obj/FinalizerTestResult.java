package id.mit.chrono.server.obj;

public class FinalizerTestResult{

    public String testType;
    public String testDescription;
    public String testValue;
    public String testResult;

    public FinalizerTestResult(String testType, String testDescription, String testValue, String testResult) {
        this.testType = testType;
        this.testDescription = testDescription;
        this.testValue = testValue;
        this.testResult = testResult;
    }

    public String getTestType() {
        return testType;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public String getTestValue() {
        return testValue;
    }

    public String getTestResult() {
        return testResult;
    }
}
