
package com.irfaan.learningspringoreilly.json;

import com.alipay.tracer.biz.util.ToStringUtil;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: Greeting.java, v 0.1 2021‐12‐17 12.59 Ahmad Irfaan Hibatullah Exp $$
 */

public class Greeting {

    private String message;

    public Greeting(String message) {
        this.message = message;
    }

    /**
     * Getter method for property message.
     *
     * @return property value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter method for property message.
     *
     * @param message value to be assigned to property message
     */

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ToStringUtil.reflectionToLogStringByFields(this);
    }
}