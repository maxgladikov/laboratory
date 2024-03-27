package online.gladikov.laboratory.simple_web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.restart.RestartEndpoint;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestartService {

    private final RestartEndpoint restartEndpoint;

    public void restartApp() {
        restartEndpoint.restart();
    }
}