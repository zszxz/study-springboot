package com.zszxz.entity;

import java.time.LocalDateTime;

/**
 * @Author lsc
 * <p> 测试实体 </p>
 */
public class TestVo  {

    /** 测试名称**/
    //@Ignore
    private String testName;

    /** 测试年龄 **/
    private Long testAge;

    /** 测试时间 **/
    private LocalDateTime testTime;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Long getTestAge() {
        return testAge;
    }

    public void setTestAge(Long testAge) {
        this.testAge = testAge;
    }

    public LocalDateTime getTestTime() {
        return testTime;
    }

    public void setTestTime(LocalDateTime testTime) {
        this.testTime = testTime;
    }
}
