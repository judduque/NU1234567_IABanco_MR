package co.com.bancolombia.usecase.checkstatus;

import co.com.bancolombia.model.systemstatus.SystemStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CheckStatusUseCaseTest {

    @InjectMocks
    private CheckStatusUseCase checkStatusUseCase;

    @Test
    void testCheckStatus() {
        SystemStatus result = checkStatusUseCase.checkStatus();
        assertNotNull(result);
        assertEquals("UP", result.getStatus());
        assertEquals("The system is running", result.getMessage());

    }
}
