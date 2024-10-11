    package com.example.main.domain.file.domain;

    import org.springframework.boot.context.properties.ConfigurationProperties;

    @ConfigurationProperties(prefix = "default.profile")
    public record ImageProperties(String ImageUrl) {
    }
