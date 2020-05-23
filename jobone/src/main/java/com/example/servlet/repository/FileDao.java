package com.example.servlet.repository;


import com.example.servlet.entity.File2;

public interface FileDao {
    public int save(File2 file2);
    public File2 findimg(File2 file2);
}
