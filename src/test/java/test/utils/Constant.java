package test.utils;

// 参数化--常量提取
public class Constant {
    // 服务地址
    public static final String BASE_URL = "http://8.129.91.152:8765";
    // 登录地址
    public static final String LOGIN_URL = BASE_URL + "/Index/login.html";
    // 首页地址
    public static final String INDEX_URL = BASE_URL + "/Index/index.html";
    // 正确的手机号和密码
    public static final String CORRECT_PHONE = "13323234545";
    public static final String CORRECT_PASSWORD = "lemon123456";
    // 浏览器类型
    public static final String BROWSER_TYPE = "chrome";
    // 用户名
    public static final String NICK_NAME = "自动化测试帐号1";
    // 显式等待超时时间
    public static final int WAIT_TIMEOUT = 8;

    public static final String BACKSTAGE_LOGIN_URL = BASE_URL + "/Admin/Index/login.html";
    public static final String BACKSTAGE_CORRECT_USERNAME= "lemon7";
    public static final String BACKSTAGE_CORRECT_CORRECT_PASSWORD = "lemonbest";
    public static final String VERIFICATION_CODE = "hapi";

}
