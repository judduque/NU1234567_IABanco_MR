package co.com.bancolombia.api;

import co.com.bancolombia.model.systemstatus.SystemStatus;
import co.com.bancolombia.usecase.checkstatus.CheckStatusUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.reactive.function.server.MockServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class HandleTest {

    @InjectMocks
    private Handler handler;

    @Mock
    private CheckStatusUseCase checkStatusUseCase;

    @Test
    void testGetHealthCheckStatusOK() {
        var serverRequest = MockServerRequest.builder().build();

        when(checkStatusUseCase.checkStatus()).thenReturn(structureSystemRS());
        Mono<ServerResponse> result = handler.getHealthCheck(serverRequest);

        StepVerifier.create(result)
                .expectNextMatches(response ->{
                    assertThat(response.statusCode().is2xxSuccessful()).isTrue();
                    return true;
                })
                .verifyComplete();
    }

    @Test
    void testGetHealthCheckError() {
        var serverRequest = MockServerRequest.builder().build();

        when(checkStatusUseCase.checkStatus()).thenThrow(new RuntimeException("Service unavailable"));
        Mono<ServerResponse> result = handler.getHealthCheck(serverRequest);

        StepVerifier.create(result)
                .expectNextMatches(response ->{
                    assertThat(response.statusCode().is5xxServerError()).isTrue();
                    return true;
                })
                .verifyComplete();
    }

    private SystemStatus structureSystemRS () {
        return SystemStatus.builder()
                .status("OK")
                .message("Service is running")
                .build();
    }

}
