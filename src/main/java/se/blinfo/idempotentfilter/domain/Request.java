package se.blinfo.idempotentfilter.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author jel
 */
@Data
@RedisHash()
@AllArgsConstructor
public class Request implements Serializable {
    @Id
    private String id;
    private String clientId;
    private String idempotentKey;
    private LocalDateTime locked;
    private byte[] response;
}
