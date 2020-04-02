package org.wso2.transport.tcp_custom;

import java.net.*;
import java.io.*;

import org.apache.axis2.transport.base.threads.WorkerPool;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TCPClient implements Runnable{

    private static final Log log = LogFactory.getLog(TCPClient.class);
    private Socket socket;
    private TCPEndpoint endpoint;
    private WorkerPool workerPool;

    public TCPClient(TCPEndpoint endpoint,WorkerPool workerPool){
        this.endpoint=endpoint;
        this.workerPool=workerPool;

    }
    public void run(){
        if (socket != null) {
            workerPool.execute(new TCPWorker(endpoint, socket));
        }
    }

    public void startSocket() throws IOException {
        this.socket = new Socket(endpoint.getHost(),endpoint.getPort());
        new Thread(this).start();
        log.info("TCP client started on port : " + endpoint.getPort());
    }

    public void closeSocket() throws IOException {
        log.info("TCP client stopping......");
        socket.close();
        socket=null;
        log.info("TCP client stopped");
    }
}