package com.lnsoft;

import com.lnsoft.lambada.TestLambada;
import com.lnsoft.po.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChrLambadaApplicationTests {

    @Autowired
    private TestLambada testLambada;

    @Test
    public void contextLoads() {

        List<Integer> ids = new ArrayList<>();
        ids.add(1);ids.add(4);ids.add(5);//
        ids.add(8);ids.add(12);ids.add(14);
        ids.add(15);ids.add(16);ids.add(17);ids.add(20);

//        List<UserInfo> userInfoList = testLambada.getUserInfoById(ids);
//        List<UserInfo> userInfoList = testLambada.getUserInfo(
        List<UserInfo> userInfoList = testLambada.getUserInfoByStream(
                u -> u.getName().contains("n") && u.getId() == 8,
                ids
        );
        for (UserInfo userInfo : userInfoList) {
            System.out.println("\t" + userInfo.getName());
        }
    }

}
