```text
对mybatis配置文件的优化
<!--引⼊外部配置⽂件-->
<properties resource="db.properties">
<!--可以给实体类起别名-->
<typeAliases>
<typeAlias type="com.pn.entity.User" alias="User"/>
</typeAliases>
<!--每⼀个Mapper.XML都需要在Mybatis核⼼配置⽂件中注册！-->
<mappers> <mapper resource="com/pn/dao/UserMapper.xml"/>
</mappers>

```
```java
#将等级为DEBUG的日志信息输出到console和file这两个目的地，console和file的定义在下面的代码
        log4j.rootLogger=DEBUG,console,file

        #控制台输出的相关设置
        log4j.appender.console = org.apache.log4j.ConsoleAppender
        log4j.appender.console.Target = System.out
        log4j.appender.console.Threshold=DEBUG
        log4j.appender.console.layout = org.apache.log4j.PatternLayout
        log4j.appender.console.layout.ConversionPattern=[%c]-%m%n

        #文件输出的相关设置
        log4j.appender.file = org.apache.log4j.RollingFileAppender
        log4j.appender.file.File=./log/pn.log
        log4j.appender.file.MaxFileSize=10mb
        log4j.appender.file.Threshold=DEBUG
        log4j.appender.file.layout=org.apache.log4j.PatternLayout
        log4j.appender.file.layout.ConversionPattern=[%p][%d{yy-MM-dd}][%c]%m%n

        #日志输出级别
        log4j.logger.org.mybatis=DEBUG
        log4j.logger.java.sql=DEBUG
        log4j.logger.java.sql.Statement=DEBUG
        log4j.logger.java.sql.ResultSet=DEBUG
        log4j.logger.java.sql.PreparedStatement=DEBUG
```
**关于@Param() 注解**
基本类型的参数或者String类型，需要加上
引⽤类型不需要加
如果只有⼀个基本类型的话，可以忽略，但是建议⼤家都加上！
我们在SQL中引⽤的就是我们这⾥的 @Param() 中设定的属性名

**lombok插件**
在实体类上加注解

**resultMap的使用在注解 annotation配置文件下**

```java
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
<!--
-引入外部配置文件
--> <properties resource="db.properties"/>
    <settings>
        <!--  默认日志输出 -->
        <setting name="logImpl" value="STDOUT_LOGGING"/>
        <!--        <setting name="logImpl" value="LOG4J"/>-->
<!-- 数据库字段名驼峰转换-->
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>
<!-- 设置返回类型的别名-->
    <typeAliases>
<!--        <package name="com.pn.entity"/>-->
        <typeAlias type="com.pn.entity.User" alias="user"/>

    </typeAliases>



    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
         <dataSource type="POOLED">
        <property name="driver" value="${driver}"/>
             <property name="url" value="${url}"/>
        <property name="username" value="${username}"/>
        <property name="password" value="${password}"/>
    </dataSource>
</environment>
</environments>
<mappers>
    <mapper class="com.pn.dao.userMapper"/>



</mappers>

</configuration>
```

```java
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.pn.dao.userMapper">
<!--   同一Mapper 方法下适用二级缓存-->
<!--    如果只有一个cache标签实体类要序列化-->
<!--    <cache-->
<!--            eviction="FIFO" size="512" readOnly="true" flushInterval="60000"/>-->
<!--   <cache/>-->
<!-- 添加ehcache依赖-->
    <cache type="org.mybatis.caches.ehcache.EhcacheCache">

    </cache>
    <select id="queryUserById"  resultType="user">

           select * from mybatis.user where id= #{id}
    </select>
    <update id="updateUser" parameterType="user" >
        update mybatis.user set name= #{name},pwd= #{pwd} where id = #{id}
    </update>
</mapper>
```