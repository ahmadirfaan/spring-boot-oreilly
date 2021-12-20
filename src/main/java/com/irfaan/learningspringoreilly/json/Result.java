
package com.irfaan.learningspringoreilly.json;

import com.alipay.tracer.biz.util.ToStringUtil;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: Result.java, v 0.1 2021‐12‐17 15.14 Ahmad Irfaan Hibatullah Exp $$
 */
public class Result {

    public String formattedAddress;
    public Geometry geometry;

    /**
     * Getter method for property formattedAddress.
     *
     * @return property value of formattedAddress
     */
    public String getFormattedAddress() {
        return formattedAddress;
    }

    /**
     * Setter method for property formattedAddress.
     *
     * @param formattedAddress value to be assigned to property formattedAddress
     */

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    /**
     * Getter method for property geometry.
     *
     * @return property value of geometry
     */
    public Geometry getGeometry() {
        return geometry;
    }

    /**
     * Setter method for property geometry.
     *
     * @param geometry value to be assigned to property geometry
     */

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @Override
    public String toString() {
        return ToStringUtil.reflectionToLogStringByFields(this);
    }
}