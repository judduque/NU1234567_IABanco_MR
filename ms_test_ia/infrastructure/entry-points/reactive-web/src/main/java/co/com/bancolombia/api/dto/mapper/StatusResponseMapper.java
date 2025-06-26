package co.com.bancolombia.api.dto.mapper;

import co.com.bancolombia.api.dto.Response;
import co.com.bancolombia.model.systemstatus.SystemStatus;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class StatusResponseMapper {

    private static final String SUCCESS_CODE = "200";
    private  static final String ERROR_CODE = "500";
    private  static final String ERROR_STATUS = "ERROR";
    provate static final String DEFAULT_ERROR_MESSAGE = "An error occurred while processing the request";


    private static Response.SystemStatusRS toSystemStatusRS(SystemStatus infoSystem) {
        return Response.SystemStatusRS.builder()
                .status(infoSystem.getStatus())
                .message(infoSystem.getMessage())
                .build();
    }

    private static Response.MetaWrapper toMetaWrapper(String code) {
        return Response.MetaWrapper.builder()
                .code(code)
                .requestDateTime(convertLocalDateTimetoString())
                .build();
    }

    private String convertLocalDateTimetoString() {
        var localDateTime = LocalDateTime.now();
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }

    public static Response buildResponseOK(SystemStatus infoSystem) {
        return Response.builder()
                .data(toSystemStatusRS(infoSystem))
                .meta(toMetaWrapper(SUCCESS_CODE))
                .build();
    }

    public static Response buildResponseError() {
        return Response.builder()
                .data(Response.SystemStatusRS.builder()
                        .status(ERROR_STATUS)
                        .message(DEFAULT_ERROR_MESSAGE)
                        .build())
                .meta(toMetaWrapper(ERROR_CODE))
                .build();
    }
}
