package co.com.bancolombia.api;

import co.com.bancolombia.api.dto.Response;
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
//private  final UseCase useCase;
//private  final UseCase2 useCase2;

    private final CheckStatusUseCase checkStatusUseCase;

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        return
                Mono.fromCallable(checkStatusUseCase::checkStatus)
                        .flatMap(status -> ServerResponse.ok()
                                .bodyValue(StatusResponseMapper.buildResponse(status)));

    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // useCase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}
