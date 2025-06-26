package co.com.bancolombia.api.dto.mapper;

import co.com.bancolombia.api.dto.Response;
import co.com.bancolombia.model.systemstatus.SystemStatus;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StatusResponseMapperTest {


    @Test
    void testToSystemStatusRS() throws Exception {
        var infoSystem = new SystemStatus("OK", "All good");
        Method method = StatusResponseMapper.class.getDeclaredMethod("toSystemStatusRS", SystemStatus.class);
        method.setAccessible(true);
        var result = method.invoke(null, infoSystem);
        assertNotNull(result);
        assertEquals("OK", ((Response.SystemStatusRS) result).getStatus());
    }

    @Test
    void testToMetaWrapper() throws Exception {
        Method method = StatusResponseMapper.class.getDeclaredMethod("toMetaWrapper", String.class);
        method.setAccessible(true);
        var result = method.invoke(null, "200");
        assertNotNull(result);
        assertEquals("200", ((Response.MetaWrapper) result).getCode());
    }

    @Test
    void testConvertLocalDateTimetoString() throws Exception {
        Method method = StatusResponseMapper.class.getDeclaredMethod("convertLocalDateTimetoString");
        method.setAccessible(true);
        var result = method.invoke(StatusResponseMapper.class);
        assertNotNull(result);
        assertTrue(result.toString().matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}"));
    }
}
