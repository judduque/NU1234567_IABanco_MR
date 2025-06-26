package co.com.bancolombia.usecase.checkstatus;

import co.com.bancolombia.model.systemstatus.SystemStatus;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckStatusUseCase {

    private static final String UP_STATUS = "UP";
    private static final String UP_MESSAGE = "The system is running";

    public SystemStatus checkStatus() {
        return SystemStatus.builder()
                .status(UP_STATUS)
                .message(UP_MESSAGE)
                .build();
    }
}
