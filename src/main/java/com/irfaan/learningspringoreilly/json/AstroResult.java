package com.irfaan.learningspringoreilly.json;

import com.alipay.tracer.biz.util.ToStringUtil;

import java.util.List;

public class AstroResult {
    private Integer number;
    private String message;
    private List<Astronauts> people;

    /**
     * Getter method for property number.
     *
     * @return property value of number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * Setter method for property number.
     *
     * @param number value to be assigned to property number
     */

    public void setNumber(Integer number) {
        this.number = number;
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

    /**
     * Getter method for property people.
     *
     * @return property value of people
     */
    public List<Astronauts> getPeople() {
        return people;
    }

    /**
     * Setter method for property people.
     *
     * @param people value to be assigned to property people
     */

    public void setPeople(List<Astronauts> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return ToStringUtil.reflectionToLogStringByFields(this);
    }
}