package com.dev.shorty.repository;

import com.dev.shorty.model.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByShortKey(String shortKey);

    Optional<Url> findByOriginalUrl(String originalUrl);
}
