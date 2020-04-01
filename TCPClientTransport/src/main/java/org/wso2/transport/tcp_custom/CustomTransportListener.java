package org.wso2.transport.tcp_custom;

import org.apache.axis2.AxisFault;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.transport.base.AbstractTransportListener;
import org.apache.axis2.transport.base.AbstractTransportListenerEx;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class CustomTransportListener extends AbstractTransportListenerEx<TCPEndpoint> {
    private static final Log log = LogFactory.getLog(CustomTransportListener.class);

    private Map<TCPEndpoint, TCPClient> serverTable = new ConcurrentHashMap<TCPEndpoint, TCPClient>();
    public String address=null;
    public int port=0;


    protected void doInit() throws AxisFault {

    }

    protected TCPEndpoint createEndpoint() {

        return new TCPEndpoint();
    }



    protected void startEndpoint(TCPEndpoint endpoint) throws AxisFault {
        log.info("address : " + endpoint.getHost()+" <<----------->>   port : "+endpoint.getPort());
        address=endpoint.getHost();
        port=endpoint.getPort();
        try {
            TCPClient client = new TCPClient(address, port,endpoint,workerPool);
            log.info("client object : " + client);
            serverTable.put(endpoint, client);
            client.startSocket();
            //client.receiveFromServer();
        } catch (IOException e) {
            handleException("Error while starting the TCP endpoint", e);
        }
    }

    protected void stopEndpoint(TCPEndpoint endpoint) {
        try {
            TCPClient client = serverTable.get(endpoint);
            if (client != null) {
                client.closeSocket();
            }
        } catch (IOException e) {
            log.error("Error while stopping the TCP endpoint", e);
        } finally {
            serverTable.remove(endpoint);
        }
    }

    }

