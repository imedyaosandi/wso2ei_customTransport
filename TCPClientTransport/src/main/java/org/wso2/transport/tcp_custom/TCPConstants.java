package org.wso2.transport.tcp_custom;

public class TCPConstants {
    public static final String PARAM_PORT = "transport.clienttcp.port";
    public static final String PARAM_HOST = "transport.clienttcp.hostname";
    public static final String PARAM_BACKLOG = "transport.clienttcp.backlog";
    public static final String PARAM_CONTENT_TYPE = "transport.clienttcp.contentType";
    public static final String PARAM_RECORD_DELIMITER = "transport.clienttcp.recordDelimiter";
    public static final String PARAM_RECORD_DELIMITER_TYPE = "transport.clienttcp.recordDelimiterType";
    public static final String PARAM_RECORD_LENGTH = "transport.clienttcp.recordLength";
    public static final String PARAM_RESPONSE_CLIENT = "transport.clienttcp.responseClient";
    public static final String PARAM_RESPONSE_INPUT_TYPE = "transport.clienttcp.inputType";
    public static final String BINARY_INPUT_TYPE = "binary";
    public static final String STRING_INPUT_TYPE = "string";
    public static final String STRING_DELIMITER_TYPE = "string";
    public static final String BYTE_DELIMITER_TYPE = "byte";
    public static final String CHARACTER_DELIMITER_TYPE = "character";
    public static final int TCP_DEFAULT_BACKLOG = 50;
    public static final String TCP_DEFAULT_CONTENT_TYPE = "text/xml";
    public static final String TCP_OUTPUT_SOCKET = "transport.clienttcp.outputSocket";
}
