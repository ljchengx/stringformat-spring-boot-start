> 手写sping-boot-starter思路

1、组件的基本实现

这里使用一个对象转换的简单方法来演示。

首先定义一个接口

```java
/**
 * @author ljchengx
 * @date 2021/5/18 11:02
 */
public interface FormatProcessor {

    /**
     * 类型转换
     *
     * @param obj: 参数
     */
    <T> String format(T obj);
}
```

初始化两个类来实现

```java
public class JsonFormatProcessor implements FormatProcessor{

    public <T> String format(T obj) {
        return JSON.toJSONString(obj);
    }
}
```

```java
public class StringFormatProcessor implements FormatProcessor{

    public <T> String format(T obj) {
        return obj.toString();
    }
}
```

pom.xml文件如下：

```xml
    <dependencies>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.76</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
            <version>2.4.5</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <version>2.4.5</version>
            <optional>true</optional>
        </dependency>
    </dependencies>
```

2、创建一个类给用户调用

```java
public class FormatTemPlate {

    private FormatProcessor formatProcessor;

    public FormatTemPlate(FormatProcessor formatProcessor) {
        this.formatProcessor = formatProcessor;
    }

    public <T> String doFormat(T obj) {

        return "Execute format" + "Execute format" + "Obj format result: " + formatProcessor.format(obj) + "\n";
    }
}
```

3、创建配置项

```java
@Configuration
public class FormatAutoConfiguration {

    @Bean
    @Primary //设置为默认
    @ConditionalOnMissingClass("com.alibaba.fastjson.JSON") //当没有fastjson时注入时
    public FormatProcessor stringFormat() {
        return new StringFormatProcessor();
    }


    @Bean
    @ConditionalOnClass(name = "com.alibaba.fastjson.JSON")//当存在fastjson时注入JsonFormat
    public FormatProcessor jsonFormat() {
        return new JsonFormatProcessor();
    }

}
```

```java
@Configuration
@Import(FormatAutoConfiguration.class) 
public class AutoConfiguration {

    @Bean
    // 由于import了Format这Bean的配置类，spring就有据可依的能找到相应bean作为入参
    // 这里还会根据具体Condition判断注入哪个bean
    public FormatTemPlate autoConfiguration(FormatProcessor formatProcessor,FormatProperties formatProperties) {
        return new FormatTemPlate(formatProcessor,formatProperties);
    }

}
```

4、创建 spring.factories 

```
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
org.ljchengx.config.FormatAutoConfiguration,\
org.ljchengx.config.AutoConfiguration
```

 ![image-20210518142902540](https://cdn.jsdelivr.net/gh/ljchengx/PicGo/img/image-20210518142902540.png)

5、外部项目调用

```java
@Autowired
FormatTemPlate formatTemPlate;
```

