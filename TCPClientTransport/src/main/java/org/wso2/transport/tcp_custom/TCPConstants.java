package org.wso2.transport.tcp_custom;

public class TCPConstants {
    public static final String PARAM_PORT = "transport.customtcp.port";
    public static final String PARAM_HOST = "transport.customtcp.hostname";
    public static final String PARAM_BACKLOG = "transport.customtcp.backlog";
    public static final String PARAM_CONTENT_TYPE = "transport.customtcp.contentType";
    public static final String PARAM_RECORD_DELIMITER = "transport.customtcp.recordDelimiter";
    public static final String PARAM_RECORD_DELIMITER_TYPE = "transport.customtcp.recordDelimiterType";
    public static final String PARAM_RECORD_LENGTH = "transport.customtcp.recordLength";
    public static final String PARAM_RESPONSE_CLIENT = "transport.customtcp.responseClient";
    public static final String PARAM_RESPONSE_INPUT_TYPE = "transport.customtcp.inputType";
    public static final String BINARY_INPUT_TYPE = "binary";
    public static final String STRING_INPUT_TYPE = "string";
    public static final String STRING_DELIMITER_TYPE = "string";
    public static final String BYTE_DELIMITER_TYPE = "byte";
    public static final String CHARACTER_DELIMITER_TYPE = "character";
    public static final int TCP_DEFAULT_BACKLOG = 50;
    public static final String TCP_DEFAULT_CONTENT_TYPE = "text/xml";
    public static final String TCP_OUTPUT_SOCKET = "transport.customtcp.outputSocket";
}
