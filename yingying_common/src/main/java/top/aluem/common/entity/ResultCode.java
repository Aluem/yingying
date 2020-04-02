package top.aluem.common.entity;

/**
 * 公共的返回码
 *  返回码：
 *      成功：10000
 *      失败：10001
 *      未登录：10002
 *      未授权：10003
 *      抛出异常：99999
 */
public enum ResultCode {

    SUCCESS(10000,true,"操作成功"),
    FAIL(10001,false,"操作失败"),
    UNAUTHENTICATED(10002,false,"您还没登陆"),
    UNAUTHORISE(10003,false,"权限不足"),
    SERVER_ERROR(99999,false,"抱歉，系统繁忙，请稍后重试");

    //提供构造参数，化简返回数据
    int code;
    boolean success;
    String message;

    ResultCode(int code, boolean success, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }

    public boolean success() {
        return success;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }
}
