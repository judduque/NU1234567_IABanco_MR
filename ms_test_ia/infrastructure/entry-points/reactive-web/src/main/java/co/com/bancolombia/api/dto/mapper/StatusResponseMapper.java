package co.com.bancolombia.api.dto.mapper;

import co.com.bancolombia.api.dto.Response;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class StatusResponseMapper {

    private static Response.SystemStatusRS toSystemStatusRS(String status, String message) {
        return Response.SystemStatusRS.builder()
                .status(status)
                .message(message)
                .build();
    }

    private static Response.MetaWrapper toMetaWrapper(String code, String message) {
        return Response.MetaWrapper.builder()
                .code(code)
                .message(message)
                .requestDateTime(convertLocalDateTimetoString())
                .build();
    }

    private String convertLocalDateTimetoString() {
        var localDateTime = LocalDateTime.now();
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }

    public static Response buildResponse(String status) {
        return Response.builder()
                .systemStatus(toSystemStatusRS("UP","Sistema OK"))
                .meta(toMetaWrapper("500", "excelente"))
                .build();
    }
}
