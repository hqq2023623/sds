package com.didiglobal.sds.web.test.dao;
import java.util.Date;
import java.util.List;

import com.didiglobal.sds.web.dao.HeartbeatDao;
import com.didiglobal.sds.web.dao.bean.HeartbeatDO;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeartbeatDaoTest {

    @Autowired
    private HeartbeatDao heartbeatDao;

    @Test
    public void addHeartbeatTest() {
        List<HeartbeatDO> dataList = Lists.newArrayList();
        HeartbeatDO heartbeatDO = new HeartbeatDO();
        heartbeatDO.setAppGroupName("黑马");
        heartbeatDO.setAppName("bh-order");
        heartbeatDO.setPoint("testPoint");
        heartbeatDO.setDowngradeNum(123L);
        heartbeatDO.setVisitNum(1000000L);
        heartbeatDO.setExceptionNum(234L);
        heartbeatDO.setTimeoutNum(1233L);
        heartbeatDO.setMaxConcurrentNum(12);
        heartbeatDO.setAppIp("127.0.0.1");
        heartbeatDO.setStatisticsCycleTime(new Date());
        dataList.add(heartbeatDO);

        heartbeatDO = new HeartbeatDO();
        heartbeatDO.setAppGroupName("黑马");
        heartbeatDO.setAppName("bh-order");
        heartbeatDO.setPoint("testPoint1");
        heartbeatDO.setDowngradeNum(123L);
        heartbeatDO.setVisitNum(1000000L);
        heartbeatDO.setExceptionNum(234L);
        heartbeatDO.setTimeoutNum(1233L);
        heartbeatDO.setMaxConcurrentNum(12);
        heartbeatDO.setAppIp("127.0.0.1");
        heartbeatDO.setStatisticsCycleTime(new Date());
        dataList.add(heartbeatDO);

        Assert.assertEquals(2, heartbeatDao.addHeartbeat(dataList));
    }

    @Test
    public void queryHeartbeatListTest() {
        System.out.println(heartbeatDao.queryHeartbeatList("黑马", "bh-order", "testPoint",
                new Date(System.currentTimeMillis() - 10000000), new Date()));
    }
}
