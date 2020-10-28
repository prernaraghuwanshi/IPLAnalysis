package com.bl.iplanalyser;

public class IPLAnalyserException extends Throwable {
    enum ExceptionType {
        IPL_FILE_PROBLEM, HEADER_DELIMETER_PROBLEM, FILE_TYPE_PROBLEM,NO_DATA;
    }

    ExceptionType type;

    public IPLAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public IPLAnalyserException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }
}
