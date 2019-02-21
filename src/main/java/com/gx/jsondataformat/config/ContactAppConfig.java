package com.gx.jsondataformat.config;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

/**
 * 如果我们想使用Java 8日期类型并设置默认日期格式，那么我们需要查看创建一个Jackson2ObjectMapperBuilderCustomizer的Bean
 * 虽然这种方法可能看起来有点麻烦，但它的优点在于它适用于Java 8和遗留日期类型
 */
@Configuration
public class ContactAppConfig {

    private static final String dateFormat = "yyyy-MM-dd";

    private static final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";

    @Bean
    @ConditionalOnProperty(value = "spring.jackson.date-format", matchIfMissing = true, havingValue = "none")
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> {
            builder.simpleDateFormat(dateTimeFormat);
            builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)));
            builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
        };
    }

}
