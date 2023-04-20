package net.ubn.td.todolist;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * @author CSLin
 * @date 2023/4/17 3:35 PM
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60*60)
public class RedisSessionConfig {
    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("JSESSIONID");
        serializer.setCookiePath("/");
        serializer.setUseBase64Encoding(false);
        //域名的正则表达式。^.?\\.(\\w\\.[a-z]+)$ 是个通用写法。
        // 如果正则表达式不匹配，则不会设置任何域。如果正则表达式匹配，则第一个分组将用作域。
        // 例如：https://child.mydomain.com的请求会将域设置为mydomain.com。
        // http:// localhost:8080 /或https://192.168.1.100:8080/的请求将不对域名进行处理。
        // 因此，在切换域名时，不需要再做任何修改。
//        serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$");
        serializer.setDomainName("ubn.tc");

        return serializer;
    }
}
