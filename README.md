springboot 使用Jackson来进行json的处理
## 我们在处理日期的时候在日期字段上使用@JsonFormat
```java
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
```
## 设置时区
如果我们需要使用特定的时区，我们可以设置@JsonFormat的timezone属性：
```java
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Chongqing")
    private LocalDateTime lastUpdate;
```
虽然@JsonFormat本身很强大，但对格式和时区进行硬编码可能会让我们陷入困境。
如果我们要为应用程序中的所有日期配置默认格式，则更灵活的方法是在application.properties中配置它：
```properties
# 日期配置默认格式
spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
# 指定特定的时区
spring.jackson.time-zone=Asia/Chongqing
```
这种设置默认格式存在缺陷。但是它不适用于Java 8日期类型，如  LocalDate 和  LocalDateTime
 - 我们只能使用它来格式化java.util.Date或  java.util.Calendar类型的字段 。
## 解决方案：自定义Jackson的ObjectMapper
如果我们想使用Java 8日期类型并设置默认日期格式，那么我们需要查看创建一个Jackson2ObjectMapperBuilderCustomizer的Bean
```java
@Configuration
public class ContactAppConfig {

    private static final String dateFormat = "yyyy-MM-dd";

    private static final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";

    @Bean
    @ConditionalOnProperty(value = "spring.jackson.date-format", matchIfMissing = true, havingValue = "none")
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return new Jackson2ObjectMapperBuilderCustomizer() {
            @Override
            public void customize(Jackson2ObjectMapperBuilder builder) {
                builder.simpleDateFormat(dateTimeFormat);
                builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)));
                builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
            }
        };
    }

}
```

