package com.example.servlet.repository;

import com.example.servlet.entity.Officesend;

import java.util.List;

public interface OffiDao {

    public int save(Officesend officesend);
    public List<Officesend> findall();
    public List<Officesend>findoffiby(Officesend officesend);
    public long deleteby(Officesend officesend);
    public List<Officesend>findoffibycpnid(Officesend officesend);
}
