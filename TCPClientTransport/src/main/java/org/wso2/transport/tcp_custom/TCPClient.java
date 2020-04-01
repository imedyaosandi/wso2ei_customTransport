package org.wso2.transport.tcp_custom;

import java.net.*;
import java.io.*;

import org.apache.axis2.transport.base.threads.WorkerPool;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TCPClient implements Runnable{

    private static final Log log = LogFactory.getLog(TCPClient.class);
    // initialize class variables
    private Socket socket;
    private TCPEndpoint endpoint;
    private WorkerPool workerPool;
    private String address;
    private int port;
    int count = 0;

    // constructor
    public TCPClient(String addr, int port,TCPEndpoint endpoint,WorkerPool workerPool){
        log.info("Inside client");
        this.address=addr;
        this.port=port;
        this.endpoint=endpoint;
        this.workerPool=workerPool;

    }
    public void run(){
        if (socket != null) {
            //start tcpworker to process messages
            workerPool.execute(new TCPWorker(endpoint, socket));
        }
    }

    public void startSocket() throws IOException {
        log.info("Inside startSocket");
        // establish a connection
        this.socket = new Socket(address,port);
        log.info("Socket" + socket);
//        this.run();
        new Thread(this).start();
        log.info("TCP client started on port : " + endpoint.getPort());
    }

//    public void receiveFromServer() throws Exception {
//        log.info("Inside receiveFromServer");
//        char delimiter = 0x10;
//        InputStream inFromServer = socket.getInputStream();
//        //read from server
//        int next = inFromServer.read();
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        while (next > -1) {
//            if (delimiter != next) {
//                bos.write(next);
//            }
//            next = inFromServer.read();
//            if (delimiter == next) {
//                log.info("TCP client reading from server : " + new String(bos.toByteArray()));
//                //System.out.println(new String(bos.toByteArray()));
////                count++;
////                if (count == 1 || count == 2) {
////                    break;
////                }
//                bos = new ByteArrayOutputStream();
//            }
//        }
//
////        if (count == 2) {
////            close();
////        }
//    }

    public void closeSocket() throws IOException {
        log.info("TCP client stopping......");
        socket.close();
        socket=null;
        log.info("TCP client stopped");
    }
}