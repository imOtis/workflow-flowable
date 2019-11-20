# Flowable Workflow Doc
Spring Boot Integration Flowable & Flowable-Modeler,
### 整合Flowable
> 版本选择:Flowable的相关依赖版本均为`6.4.1`
#### 添加依赖
> 项目结构采用`SpringBoot`作为基础架构,因此,直接选择`flowable-spring-boot-starter`,该依赖具有完整的`API`
```xml
<!-- Flowable -->
<dependency>
    <groupId>org.flowable</groupId>
    <artifactId>flowable-spring-boot-starter</artifactId>
    <version>6.4.1</version>
</dependency>
```
> `Flowable`使用`SLF4J`作为内部日志框架。此处使用`log4j`作为`SLF4J` 的实现,
```xml
<!-- SLF4J -->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.21</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-log4j12</artifactId>
    <version>1.7.21</version>
</dependency>
```
> 在`resources`目录下新建`log4j.properties`文件,对log4j进行配置
```properties
log4j.rootLogger=DEBUG, CA
log4j.appender.CA=org.apache.log4j.ConsoleAppender
log4j.appender.CA.layout=org.apache.log4j.PatternLayout
log4j.appender.CA.layout.ConversionPattern= %d{hh:mm:ss,SSS} [%t] %-5p %c %x - %m%n
```
#### 配置Flowable
...

### 整合Flowable-Modeler

#### 预处理
> 下载[Flowable 6.4.1](),


* [Flowable Introduction Chinese_Simplified](https://tkjohn.github.io/flowable-userguide/#_introduction)


### Develop
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

### Application