package org.hjjang.example.db2.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.hjjang.example.config.SecondDBMapper;
import org.hjjang.example.db1.domain.NpPushAdmApp;
import org.hjjang.example.db2.domain.NpPushServer;
import org.springframework.stereotype.Repository;

@Repository
@SecondDBMapper
public interface NpPushServerMapper {
    NpPushServer selectServer(String hostNm);
}
