
package com.irfaan.learningspringoreilly.json;

import com.alipay.tracer.biz.util.ToStringUtil;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: Geometry.java, v 0.1 2021‐12‐17 15.10 Ahmad Irfaan Hibatullah Exp $$
 */
public class Geometry {

    private Location location;

    /**
     * Getter method for property location.
     *
     * @return property value of location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Setter method for property location.
     *
     * @param location value to be assigned to property location
     */

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return ToStringUtil.reflectionToLogStringByFields(this);
    }
}