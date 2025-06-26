package co.com.bancolombia.api;

import co.com.bancolombia.api.dto.mapper.StatusResponseMapper;
import co.com.bancolombia.usecase.checkstatus.CheckStatusUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final CheckStatusUseCase checkStatusUseCase;

    public Mono<ServerResponse> getHealthCheck(ServerRequest serverRequest) {
        return
                Mono.fromCallable(checkStatusUseCase::checkStatus)
                        .flatMap(status -> ServerResponse.ok()
                                .bodyValue(StatusResponseMapper.buildResponseOK(status)))
                        .onErrorResume(error -> ServerResponse.status(500)
                                .bodyValue(StatusResponseMapper.buildResponseError(error.getMessage())));
    }
}
