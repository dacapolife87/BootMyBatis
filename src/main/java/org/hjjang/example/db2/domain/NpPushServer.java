package org.hjjang.example.db2.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("npPushServer")
public class NpPushServer {

    private String hostNm;
    private String hostTpCd;
    private String monUrl;
    private String useFlag;
    private int linkerNum;
    private String updDate;

    public NpPushServer() {
    }

    public NpPushServer(String hostNm, String hostTpCd, String monUrl, String useFlag, int linkerNum, String updDate) {
        this.hostNm = hostNm;
        this.hostTpCd = hostTpCd;
        this.monUrl = monUrl;
        this.useFlag = useFlag;
        this.linkerNum = linkerNum;
        this.updDate = updDate;
    }
}
