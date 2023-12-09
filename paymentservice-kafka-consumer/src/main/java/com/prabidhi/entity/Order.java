package com.prabidhi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name="order1")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Order implements Serializable {
    //@Serial
    private static final long serialVersionUID = -4551323276601557391L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double orderAmount;
    private String status;
    private int userId;

    public static long getSerialVersionUID(){
        return serialVersionUID;
    }
}
