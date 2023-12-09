package com.prabidhi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name="user1")
@Getter
@Setter
public class User implements Serializable {

    //@Serial
    private static final long serialVersionUID = -4551323276601557391L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double balance;


    public static long getSerialVersionUID(){
        return serialVersionUID;
    }

}
