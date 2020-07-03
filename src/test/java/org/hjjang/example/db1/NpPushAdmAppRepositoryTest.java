package org.hjjang.example.db1;

import org.hjjang.example.db1.NpPushAdmAppRepository;
import org.hjjang.example.db1.domain.NpPushAdmApp;
import org.hjjang.example.db1.mapper.NpPushAdmAppMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NpPushAdmAppRepositoryTest {

    @Autowired
    NpPushAdmAppRepository repository;

    @Autowired
    NpPushAdmAppMapper npPushAdmAppMapper;

    @Test
    public void test_Repository(){
        String id = "0001";
        NpPushAdmApp npPushAdmApp = npPushAdmAppMapper.selectAppById(id);
        System.out.println(npPushAdmApp);
        assertEquals("0001",npPushAdmApp.getAppId());
    }
}