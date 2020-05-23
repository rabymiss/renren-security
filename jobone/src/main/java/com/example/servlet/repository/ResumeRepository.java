package com.example.servlet.repository;

import com.example.servlet.entity.JobMessage;
import com.example.servlet.entity.PersonResume;
import com.example.servlet.entity.Resume;
import com.example.servlet.entity.ResumeEntity;

import java.util.List;

public interface ResumeRepository {

  public int save(Resume resume);
  public List<Resume> findAllby(Resume resume);
  public long deletebyuuid(Resume resume);

  public int savep(PersonResume personResume);
  public List<PersonResume> findAllbyp(PersonResume personResume);
  public long deletebdp(PersonResume personResume);
  public Long updatep(PersonResume personResume);
}
