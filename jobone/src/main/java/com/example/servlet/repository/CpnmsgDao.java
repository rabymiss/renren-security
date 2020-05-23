package com.example.servlet.repository;

import com.example.servlet.entity.CpnMsgEn;

import java.util.List;

public interface CpnmsgDao {
    public int save(CpnMsgEn cpnMsgEn);
    public List<CpnMsgEn> findcpn(CpnMsgEn cpnMsgEn);
    public Long update(CpnMsgEn cpnMsgEn);

}
