
package com.irfaan.learningspringoreilly.json;

import com.alipay.tracer.biz.util.ToStringUtil;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: Location.java, v 0.1 2021‐12‐17 15.09 Ahmad Irfaan Hibatullah Exp $$
 */
public class Location {

    private double lat;
    private double lng;

    /**
     * Getter method for property lat.
     *
     * @return property value of lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * Setter method for property lat.
     *
     * @param lat value to be assigned to property lat
     */

    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * Getter method for property lng.
     *
     * @return property value of lng
     */
    public double getLng() {
        return lng;
    }

    /**
     * Setter method for property lng.
     *
     * @param lng value to be assigned to property lng
     */

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return ToStringUtil.reflectionToLogStringByFields(this);
    }
}