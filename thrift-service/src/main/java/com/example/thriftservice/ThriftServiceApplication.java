package com.example.thriftservice;

import com.example.thriftapi.HelloService;
import com.example.thriftservice.service.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ThriftServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThriftServiceApplication.class, args);
        TProcessor tprocessor = new HelloService.Processor<>(new HelloServiceImpl());
        try {
            ServerThread serverThread = new ServerThread(tprocessor, 9898);
            serverThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static class ServerThread extends Thread {
        private TServer server;

        ServerThread(TProcessor tprocessor, int port) throws Exception {
            TServerSocket serverTransport = new TServerSocket(port);
            TServer.Args tArgs = new TServer.Args(serverTransport);
            tArgs.processor(tprocessor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            server = new TSimpleServer(tArgs);
        }

        @Override
        public void run() {
            try {
                //启动服务
                server.serve();
            } catch (Exception e) {
                log.error("thrift server.serve() throws an exception.", e);
            }
        }

        public void stopServer() {
            log.info("stopping thrift server...");
            server.stop();
        }
    }
}
