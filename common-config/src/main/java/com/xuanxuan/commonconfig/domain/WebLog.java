package com.xuanxuan.commonconfig.domain;


import java.util.Objects;

public class WebLog {

    private String description;
    private String username;
    private Long startTime;
    private Integer spendTime;
    private String basePath;
    private String uri;
    private String url;
    private String method;
    private String ip;
    private Object parameter;
    private Object result;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Integer getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Integer spendTime) {
        this.spendTime = spendTime;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Object getParameter() {
        return parameter;
    }

    public void setParameter(Object parameter) {
        this.parameter = parameter;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebLog webLog = (WebLog) o;
        return Objects.equals(description, webLog.description) &&
                Objects.equals(username, webLog.username) &&
                Objects.equals(startTime, webLog.startTime) &&
                Objects.equals(spendTime, webLog.spendTime) &&
                Objects.equals(uri, webLog.uri) &&
                Objects.equals(url, webLog.url) &&
                Objects.equals(method, webLog.method) &&
                Objects.equals(ip, webLog.ip) &&
                Objects.equals(parameter, webLog.parameter) &&
                Objects.equals(result, webLog.result) &&
                Objects.equals(basePath, webLog.basePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, username, startTime, spendTime, uri, url, method, ip, parameter, result, basePath);
    }
}
