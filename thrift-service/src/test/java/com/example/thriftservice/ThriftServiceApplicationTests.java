package com.example.thriftservice;

import com.example.thriftapi.HelloService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ThriftServiceApplicationTests {

    //@Resource
    //HelloService.Iface helloService;
    //
    //@Test
    //public void contextLoads() {
    //    try {
    //        System.out.println(helloService.greet("world"));
    //    } catch (TException e) {
    //        e.printStackTrace();
    //    }
    //}
    //
    //@Test
    //public void testRemote() {
    //    try (TTransport transport = new TSocket("localhost", 9898, 30000)) {
    //        TProtocol protocol = new TBinaryProtocol(transport);
    //        HelloService.Client helloService = new HelloService.Client(protocol);
    //        transport.open();
    //        log.info("远程调用服务...{}", helloService.greet("Remote"));
    //    } catch (TException e) {
    //        log.error("远程调用异常.", e);
    //    }
    //}

}
