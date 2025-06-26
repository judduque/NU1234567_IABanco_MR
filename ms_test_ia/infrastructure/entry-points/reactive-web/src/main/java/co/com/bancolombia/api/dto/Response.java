package co.com.bancolombia.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Response {

    private SystemStatusRS systemStatus;

    private  MetaWrapper meta;
    @Getter
    @Setter
    @AllArgsConstructor
    @Builder(toBuilder = true)
    public static class SystemStatusRS {
        private String status;
        private String message;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @Builder(toBuilder = true)
    public static class MetaWrapper {
        private String code;
        private String message;
        private String requestDateTime;
    }
}
