package vn.iotstar.webcourse.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "[User]")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String userName;
    private String fullName;
    @Column(name = "password")
    private String passWord;
    private String avatar;
    private int roleid;
    private String phone;
    private Date createdDate;

    public User() {

    }
    
}