package org.hjjang.example.db1.mapper;

import org.hjjang.example.config.FirstDBMapper;
import org.hjjang.example.db1.domain.NpPushAdmApp;
import org.springframework.stereotype.Repository;

@Repository
@FirstDBMapper
public interface NpPushAdmAppMapper {
    NpPushAdmApp selectAppById(String id);
}
