
package com.irfaan.learningspringoreilly.json;

import com.alipay.tracer.biz.util.ToStringUtil;

import java.util.List;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: Response.java, v 0.1 2021‐12‐17 15.16 Ahmad Irfaan Hibatullah Exp $$
 */
public class Response {

    private List<Result> results;
    private String status;

    /**
     * Getter method for property results.
     *
     * @return property value of results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     * Setter method for property results.
     *
     * @param results value to be assigned to property results
     */

    public void setResults(List<Result> results) {
        this.results = results;
    }

    /**
     * Getter method for property status.
     *
     * @return property value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter method for property status.
     *
     * @param status value to be assigned to property status
     */

    public void setStatus(String status) {
        this.status = status;
    }

    public Location getLocation() {
        return results.get(0).getGeometry().getLocation();
    }

    public String getFormattedAddress() {
        return results.get(0).getFormattedAddress();
    }

    @Override
    public String toString() {
        return ToStringUtil.reflectionToLogStringByFields(this);
    }
}