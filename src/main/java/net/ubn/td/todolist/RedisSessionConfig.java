package net.ubn.td.todolist;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author CSLin
 * @date 2023/4/17 3:35 PM
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60*60)
public class RedisSessionConfig {
}
