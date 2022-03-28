package ru.filippov.SecuritySpringBoot.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;



    public Role(){

    }

    public Role(String name){
        this.name = name;
    }
    public Role(long id, String name) {
        this(name);
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getNameHtml() {
        return name + " ";
    }


    @Override
    public String getAuthority() {
        return name;
    }
}
