package com.varunu28.redisluademo;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/lua")
public class DemoController {

    private static final String COUNTER_KEY = "demo_counter";

    @Value("${flash.sale.id}")
    private String flashSaleId;

    private final StringRedisTemplate redisTemplate;
    private final RedisScript<Long> flashSaleScript;

    public DemoController(StringRedisTemplate redisTemplate, RedisScript<Long> flashSaleScript) {
        this.redisTemplate = redisTemplate;
        this.flashSaleScript = flashSaleScript;
    }

    @PostMapping
    public ResponseEntity<String> lua(@RequestBody LuaPersistDto request) {
        String memberId = String.format("%s|%s|%d", request.userId(), flashSaleId, request.count());
        String sortedSetKey = "flash_sale:" + flashSaleId;

        Long counter = redisTemplate.execute(
                flashSaleScript,
                List.of(COUNTER_KEY, sortedSetKey, String.valueOf(request.count)),
                memberId
        );
        if (counter == -1) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("order already exists");
        }
        if (counter == -2) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("count exceeded");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("order persisted successfully");
    }

    public record LuaPersistDto(String userId, int count) {}
}
