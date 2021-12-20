
package com.irfaan.learningspringoreilly.json;

import com.alipay.tracer.biz.util.ToStringUtil;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: Astronauts.java, v 0.1 2021‐12‐17 13.55 Ahmad Irfaan Hibatullah Exp $$
 */
public class Astronauts {

    private String name;
    private String craft;

    /**
     * Getter method for property name.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property name.
     *
     * @param name value to be assigned to property name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property craft.
     *
     * @return property value of craft
     */
    public String getCraft() {
        return craft;
    }

    /**
     * Setter method for property craft.
     *
     * @param craft value to be assigned to property craft
     */

    public void setCraft(String craft) {
        this.craft = craft;
    }

    @Override
    public String toString() {
        return ToStringUtil.reflectionToLogStringByFields(this);
    }
}