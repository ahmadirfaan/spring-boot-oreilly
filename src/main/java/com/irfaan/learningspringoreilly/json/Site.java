
package com.irfaan.learningspringoreilly.json;

import com.alipay.tracer.biz.util.ToStringUtil;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: Site.java, v 0.1 2021‐12‐17 15.22 Ahmad Irfaan Hibatullah Exp $$
 */
public class Site {

    private Integer id;
    private final String address;
    private final double latitude;
    private final double longitude;

    public Site(String address, double latitude, double longitude) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Getter method for property id.
     *
     * @return property value of id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter method for property id.
     *
     * @param id value to be assigned to property id
     */

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter method for property address.
     *
     * @return property value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Getter method for property latitude.
     *
     * @return property value of latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Getter method for property longitude.
     *
     * @return property value of longitude
     */
    public double getLongitude() {
        return longitude;
    }



    @Override
    public String toString() {
        return ToStringUtil.reflectionToLogStringByFields(this);
    }
}