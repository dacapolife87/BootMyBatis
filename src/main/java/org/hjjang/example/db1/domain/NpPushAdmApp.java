package org.hjjang.example.db1.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("npPushAdmApp")
public class NpPushAdmApp {

    private String appId;
    private String userId;
    private String cretDtm;
    private String mdfyDtm;

    public NpPushAdmApp(){};

    public NpPushAdmApp(String appId, String userId, String cretDtm, String mdfyDtm) {
        this.appId = appId;
        this.userId = userId;
        this.cretDtm = cretDtm;
        this.mdfyDtm = mdfyDtm;
    }
}
