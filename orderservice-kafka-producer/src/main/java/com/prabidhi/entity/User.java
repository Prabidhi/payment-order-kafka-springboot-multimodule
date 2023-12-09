package com.prabidhi.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="user1")
public class User implements Serializable {

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
