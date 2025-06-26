package co.com.bancolombia.api.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResponseTest {

    @Test
    void testResponseGetterAndSetter() {
        Response.SystemStatusRS systemStatus = new Response.SystemStatusRS("OK", "Service is running");
        Response.MetaWrapper meta = new Response.MetaWrapper("200", "2023-10-01 12:00:00");
        Response response = new Response(systemStatus, meta);

        assertEquals("OK", response.getData().getStatus());
        assertEquals("Service is running", response.getData().getMessage());
        assertEquals("200", response.getMeta().getCode());
        assertEquals("2023-10-01 12:00:00", response.getMeta().getRequestDateTime());

    }

    @Test
    void testResponseBuilder() {
        Response.SystemStatusRS systemStatus = Response.SystemStatusRS.builder()
                .status("OK")
                .message("Service is running")
                .build();
        Response.MetaWrapper meta = Response.MetaWrapper.builder()
                .code("200")
                .requestDateTime("2023-10-01 12:00:00")
                .build();
        Response response = Response.builder()
                .data(systemStatus)
                .meta(meta)
                .build();

        assertEquals("OK", response.getData().getStatus());
        assertEquals("Service is running", response.getData().getMessage());
        assertEquals("200", response.getMeta().getCode());
        assertEquals("2023-10-01 12:00:00", response.getMeta().getRequestDateTime());
    }
}
