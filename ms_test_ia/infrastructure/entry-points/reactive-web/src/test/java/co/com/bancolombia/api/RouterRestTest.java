package co.com.bancolombia.api;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.mockito.Mockito.when;import static org.mockito.ArgumentMatchers.any;
import static org.springframework.http.MediaType.APPLICATION_JSON;


@ContextConfiguration(classes = {RouterRest.class, Handler.class})
@WebFluxTest
class RouterRestTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockitoBean
    private Handler handler;

    @Test
    void testRouterFunction() {
        var responseResult= ServerResponse.ok().build();

        when(handler.getHealthCheck(any())).thenReturn(responseResult);

        var responseGetHealth = webTestClient.get().uri("/api/checkStatus").accept(APPLICATION_JSON).exchange();
        responseGetHealth.expectStatus().isOk();

    }

}
