package com.example.demo.junit;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * @Description:
 * 微服务 限流 熔断降级测试
 * @Author HeSuiJin
 * @Date 2021/4/16
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class SentinelJunit {


    /**
     * 限流
     * @throws InterruptedException
     */
    @Test
    public void sentinelFlowJunit() throws InterruptedException {
        while(true) {
            //每秒发20次请求
            for (int i = 0; i < 20; i++) {
                final int i1=i;
                new Thread(() ->{
                    System.out.println((new Date()+"---"+i1+"---"+
                            sendGetRequest("http://localhost:9991/sentinelFlow/test")));
                }).start();
            }
            Thread.sleep(1000);
        }

    }

    /**
     * 熔断降级
     * @throws InterruptedException
     */
    @Test
    public void sentinelDegradeJunit() throws InterruptedException {
        while(true) {
            //每秒发20次请求
            for (int i = 0; i < 20; i++) {
                final int i1=i;
                new Thread(() ->{
                    System.out.println((new Date()+"---"+i1+"---"+
                            sendGetRequest("http://localhost:9991/sentinelDegrade/test")));
                }).start();
            }
            Thread.sleep(1000);
        }

    }

    public  String sendGetRequest(String getUrl) {
        StringBuffer sb = new StringBuffer();
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            URL url = new URL(getUrl);
            URLConnection urlConnection = url.openConnection();
            urlConnection.setAllowUserInteraction(false);
            isr = new InputStreamReader(url.openStream());
            br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
