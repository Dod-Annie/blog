package com.dodannie.blog.pojo;

/**
 * @author Dod_Annie
 * @description
 * @date 2020/5/30 21:39
 */

import com.dodannie.blog.excel.annotation.Excel;
import lombok.Data;
import java.io.Serializable;

@Data
public class Log implements Serializable {

    private static final long serialVersionUID = 762815810554536396L;

    /**
     * 日志id
     */
    @Excel(name = "编号")
    private Integer logId;

    /**
     * 请求路径
     */
    @Excel(name = "请求地址", autoSize = true)
    private String logUrl;

    /**
     * 参数
     */
    private String logParams;

    /**
     * 访问状态，1正常0异常
     */
    @Excel(name = "访问状态，1正常0异常")
    private Integer logStatus;

    /**
     * 异常信息
     */
    @Excel(name = "异常信息")
    private String logMessage;

    /**
     * 请求方式，get、post等
     */
    @Excel(name = "请求方式")
    private String logMethod;

    /**
     * 响应时间
     */
    @Excel(name = "响应时间（毫秒）")
    private Long logTime;

    /**
     * 返回值
     */
    private String logResult;

    /**
     * 请求ip
     */
    @Excel(name = "请求ip", autoSize = true)
    private String logIp;

    /**
     * 创建时间
     */
    @Excel(name = "创建时间", autoSize = true)
    private String createdTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    public String getLogParams() {
        return logParams;
    }

    public void setLogParams(String logParams) {
        this.logParams = logParams;
    }

    public Integer getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(Integer logStatus) {
        this.logStatus = logStatus;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public String getLogMethod() {
        return logMethod;
    }

    public void setLogMethod(String logMethod) {
        this.logMethod = logMethod;
    }

    public Long getLogTime() {
        return logTime;
    }

    public void setLogTime(Long logTime) {
        this.logTime = logTime;
    }

    public String getLogResult() {
        return logResult;
    }

    public void setLogResult(String logResult) {
        this.logResult = logResult;
    }

    public String getLogIp() {
        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
