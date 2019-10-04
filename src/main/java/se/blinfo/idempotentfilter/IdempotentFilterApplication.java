package se.blinfo.idempotentfilter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import se.blinfo.idempotentfilter.dao.RequestDao;
import se.blinfo.idempotentfilter.domain.Request;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootApplication
@Slf4j
public class IdempotentFilterApplication {

	@Autowired
	RequestDao dao;

	public static void main(String[] args) {
		SpringApplication.run(IdempotentFilterApplication.class, args);
	}
//
//	@Bean
//	CommandLineRunner commandLineRunner(@Qualifier("redisTemplate") RedisTemplate template) {
//		return args -> {
//			log.info("saving request");
//			Request request = new Request("1","foo","bar", LocalDateTime.now(),null);
//			template.opsForList().leftPush("123456",request);
//		};
//	}

}
