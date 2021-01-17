package test.listener;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 *  TestListenerAdapter：ITestListener适配器，存储所有运行的测试用例结果
 *  TestResultListener：监听用例的结果（成功/失败/跳过）
 *  解决TestNG的dataProvider与重启机制冲突问题
 *  （1）TestResultListener继承TestListenerAdapter类，重写onTestSuccess和onTestFailure方法
 *  （2）把当前重试次数currentTimes置为1
 */

public class TestResultListener extends TestListenerAdapter {
    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        // dataProvider与重启机制冲突问题解决方法
        // 1、在用例执行成功/失败后，把当前重试次数currentTimes置为1
        // 2、testNG升级到7.0.0
        TestngRetry.currentTimes = 1;
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        TestngRetry.currentTimes = 1;
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
    }
}
