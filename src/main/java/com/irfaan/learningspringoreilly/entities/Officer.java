package com.irfaan.learningspringoreilly.entities;

import com.alipay.tracer.biz.util.ToStringUtil;

import javax.persistence.*;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: Officer.java, v 0.1 2021‐12‐20 11.57 Ahmad Irfaan Hibatullah Exp $$
 */
@Entity
@Table(name = "officers")
public class Officer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    private Rank rank;

    private String firstName;
    private String lastName;

    public Officer() {
    }

    public Officer(Rank rank, String firstName, String lastName) {
        this.rank = rank;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Officer(Integer id, Rank rank, String firstName, String lastName) {
        this.id = id;
        this.rank = rank;
        this.firstName = firstName;
        this.lastName = lastName;
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
     * Getter method for property rank.
     *
     * @return property value of rank
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Setter method for property rank.
     *
     * @param rank value to be assigned to property rank
     */

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    /**
     * Getter method for property firstName.
     *
     * @return property value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter method for property firstName.
     *
     * @param firstName value to be assigned to property firstName
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter method for property lastName.
     *
     * @return property value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter method for property lastName.
     *
     * @param lastName value to be assigned to property lastName
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return ToStringUtil.reflectionToLogStringByFields(this);
    }

}