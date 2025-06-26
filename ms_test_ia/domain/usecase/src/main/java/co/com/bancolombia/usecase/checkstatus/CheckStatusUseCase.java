package co.com.bancolombia.usecase.checkstatus;

import co.com.bancolombia.model.systemstatus.gateways.SystemStatusRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CheckStatusUseCase {


    public String checkStatus() {
        return "OK";
    }
}
