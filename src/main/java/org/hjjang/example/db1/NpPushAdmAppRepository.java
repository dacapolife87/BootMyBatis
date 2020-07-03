package org.hjjang.example.db1;

import lombok.RequiredArgsConstructor;
import org.hjjang.example.db1.domain.NpPushAdmApp;
import org.hjjang.example.db1.mapper.NpPushAdmAppMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NpPushAdmAppRepository {

    private final NpPushAdmAppMapper npPushAdmAppMapper;

    public NpPushAdmApp getNpPushAdmApp(String id){
        NpPushAdmApp npPushAdmApp = npPushAdmAppMapper.selectAppById(id);
        return npPushAdmApp;
    }
}
