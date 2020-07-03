package org.hjjang.example.db2;

import org.hjjang.example.db1.NpPushAdmAppRepository;
import org.hjjang.example.db1.domain.NpPushAdmApp;
import org.hjjang.example.db1.mapper.NpPushAdmAppMapper;
import org.hjjang.example.db2.domain.NpPushServer;
import org.hjjang.example.db2.mapper.NpPushServerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NpPushServerRepositoryTest {

    @Autowired
    NpPushServerMapper npPushServerMapper;

    @Test
    public void test_Repository(){
        String id = "TEST1";
        System.out.println(npPushServerMapper);
        NpPushServer npPushServer = npPushServerMapper.selectServer(id);
        System.out.println(npPushServer);
        assertEquals("TEST1",npPushServer.getHostNm());

    }
}