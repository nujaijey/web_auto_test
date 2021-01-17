package test.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import test.utils.Constant;

/**
 *  IRetryAnalyzer：方法retry实现对失败的测试用例多次执行
 *  TestngRetry：失败用例重试
 *  1、局部重试配置
 *  （1）实现IRetryAnalyzer接口，重写retry方法，条件判断返回true执行重试机制
 *  （2）测试方法@Test注解添加retryAnalyzer属性，值为TestngRetry.class
 *  2、全局重试配置
 *  （1）实现IRetryAnalyzer接口，重写retry方法，条件判断返回true执行重试机制
 *  （2）实现IAnnotationTransformer接口，重写transform方法，对@Test注解中的retryAnalyzer属性进行判断并设置
 *  （3）在TestNG.xml添加监听器配置
 */

public class TestngRetry implements IRetryAnalyzer {
    // log4j日志对象
    private Logger logger = LoggerFactory.getLogger(TestngRetry.class);
    // 当前重试次数
    public static int currentTimes = 1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (currentTimes <= Constant.MAX_RETRY_TIMES){
            logger.info("执行第【" + currentTimes + "】次重试机制");
            currentTimes++;
            // 返回为true时，TestNG在执行用例失败时检测到这个状态，就会执行重试机制
            return  true;
        }
        // 默认返回false，表示不执行重试机制
        return false;
    }
}
