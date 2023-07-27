package edu.skypro.homework.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InfoService {
    private final ServerProperties serverProperties;

    public Integer getPort() {
        return serverProperties.getPort();
    }

}
