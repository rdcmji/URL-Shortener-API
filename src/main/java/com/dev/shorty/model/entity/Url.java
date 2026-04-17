package com.dev.shorty.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "url")
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    @Column(nullable = false, length = 2048)
    private String originalUrl;

    @Column(nullable = false, unique = true, length = 20)
    private String shortKey;

    @Column(nullable = false)
    private  Long clickCount;

    @Builder
    public Url(String originalUrl, String shortKey){
        this.originalUrl = originalUrl;
        this.shortKey = shortKey;
        this.clickCount = 0L; //생성시 조회수는 0
    }

    //조회수 증가 비즈니스 로직
    public void increaseClickCount(){
        this.clickCount++;
    }
}
