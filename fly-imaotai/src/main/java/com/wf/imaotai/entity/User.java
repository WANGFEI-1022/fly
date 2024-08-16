package com.wf.imaotai.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable{
    private Long id;
    private String name;
    private String password;
    private Long mobile;
    private String email;
    private Date createTime;
}
