package com.mycodes.splitwise.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends BaseModel{
private String name;
private String phoneNumber;
private String password;

}
