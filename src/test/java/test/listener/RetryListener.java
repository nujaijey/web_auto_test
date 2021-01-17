package test.listener;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.IAnnotation;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 *  IAnnotationTransformer：动态修改@Test注解的属性
 *  RetryListener：@Test注解没有配置retryAnalyzer时加上
 *  iTestAnnotation：当前用例的@Test注解
 *  全局重试配置
 *  （1）实现IRetryAnalyzer接口，重写retry方法，条件判断返回true执行重试机制
 *  （2）实现IAnnotationTransformer接口，重写transform方法，对@Test注解中的retryAnalyzer属性进行判断并设置
 *  （3）在TestNG.xml添加监听器配置
 */
public class RetryListener implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        // 得到@Test注解对应的属性retryAnalyzer对象
        IRetryAnalyzer iRetryAnalyzer = iTestAnnotation.getRetryAnalyzer();
        // 判断retryAnalyzer对象是否为null-->为null表示retryAnalyzer没有配置
        if (iRetryAnalyzer == null){
            // @Test注解加上retryAnalyzer配置
            iTestAnnotation.setRetryAnalyzer(TestngRetry.class);
        }

    }
}
