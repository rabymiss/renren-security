package com.example.servlet.repository;

import com.example.servlet.entity.JobMessage;

public interface JobRepository {
    public  long deleteby(JobMessage jobMessage);
    public int save(JobMessage jobMessage);
    public long update(JobMessage jobMessage);
}
