package com.didiglobal.sds.client.test;

import com.didiglobal.sds.client.bean.SdsStrategy;
import com.didiglobal.sds.client.service.SdsStrategyService;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 访问量降级测试
 * <p>
 * Created by yizhenqiang on 2016/4/24.
 */
public class TimeoutDowngradeTest extends AbstractDowngradeTest {

    @Test
    public void test() {

        executor();

        System.out.println("所有线程运行结束");

    }

    @Override
    protected void initStrategy() {
        ConcurrentHashMap<String, SdsStrategy> strategyMap = new ConcurrentHashMap<>();

        SdsStrategy strategy = new SdsStrategy();
        strategy.setPoint(getPoint());
        strategy.setTimeoutThreshold(800L);
        strategy.setTimeoutCountThreshold(100L);
        strategy.setDowngradeRate(100);

        strategyMap.put(getPoint(), strategy);

        SdsStrategyService.getInstance().reset(strategyMap);
    }

    @Override
    protected long getExecutorTimes() {
        return 1;
    }

    @Override
    protected String getPoint() {
        return "testTimeoutPoint";
    }

    @Override
    protected int getThreadNum() {
        return 10;
    }

    @Override
    protected long getTakeTime() {
        return 1000;
    }
}
