package org.hjjang.example.db2;

import lombok.RequiredArgsConstructor;
import org.hjjang.example.db2.domain.NpPushServer;
import org.hjjang.example.db2.mapper.NpPushServerMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NpPushServerRepository {

    private final NpPushServerMapper npPushServerMapper;

    public NpPushServer getNpPushServer(String id){
        NpPushServer npPushServer = npPushServerMapper.selectServer(id);
        return npPushServer;
    }
}
