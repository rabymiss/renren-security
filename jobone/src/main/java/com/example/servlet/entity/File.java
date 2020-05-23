package com.example.servlet.entity;

import lombok.Data;

@Data
public class File<T> {

    private String filename;
   T Data;
}
