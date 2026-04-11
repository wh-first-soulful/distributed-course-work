> docker-compose up -d --build
> time="2026-04-11T17:54:18+08:00" level=warning msg="D:\code\trae\_projects\lightmall\docker-compose.yml: the attribute `version` is obsolete, it will be ignored, please remove it to avoid potential confusion"
> \#1 \[internal] load local bake definitions
> \#1 reading from stdin 2.29kB 0.0s done
> \#1 DONE 0.0s

\#2 \[order internal] load build definition from Dockerfile.order
\#2 transferring dockerfile: 249B 0.0s done
\#2 DONE 0.0s

\#3 \[gateway internal] load build definition from Dockerfile.gateway
\#3 transferring dockerfile: 261B done
\#3 DONE 0.0s

\#4 \[goods internal] load build definition from Dockerfile.goods
\#4 transferring dockerfile: 249B 0.0s done
\#4 DONE 0.0s

\#5 \[stock internal] load build definition from Dockerfile.stock
\#5 transferring dockerfile: 249B done
\#5 DONE 0.0s

\#6 \[user internal] load build definition from Dockerfile.user
\#6 transferring dockerfile: 243B done
\#6 DONE 0.0s

\#7 \[user internal] load metadata for docker.io/library/openjdk:11-jre-slim
\#7 DONE 5.0s

\#8 \[user internal] load .dockerignore
\#8 transferring context: 2B done
\#8 DONE 0.0s

\#9 \[user internal] load build context
\#9 transferring context: 154B done
\#9 DONE 0.0s

\#10 \[goods 1/3] FROM docker.io/library/openjdk:11-jre-slim\@sha256:93af7df2308c5141a751c4830e6b6c5717db102b3b31f012ea29d842dc4f2b02
\#10 resolve docker.io/library/openjdk:11-jre-slim\@sha256:93af7df2308c5141a751c4830e6b6c5717db102b3b31f012ea29d842dc4f2b02 0.0s done
\#10 DONE 0.0s

\#11 \[user 2/3] WORKDIR /app
\#11 CACHED

\#12 \[user 3/3] COPY lightmall-user/target/lightmall-user-1.0.0-SNAPSHOT.jar /app/lightmall-user.jar
\#12 CACHED

\#13 \[user] exporting to image
\#13 exporting layers done
\#13 exporting manifest sha256:069a377cc8c3ea4672892f4c0094fd1a67f579d821582ebfbbc37a04419179dc done
\#13 exporting config sha256:209fca1ff7024df327a9847fea38be15265d298e7060125a09dfee4ffdbeba3c done
\#13 exporting attestation manifest sha256:c8bbe2b4b49bc527a709700ccf261def06551123778a78c9c6364ba07b310756 0.0s done
\#13 exporting manifest list sha256:52e877f8a2c309cab23bd452b78bf60a2cd3e10870d55d4f84faea535ce1a08d 0.0s done
\#13 naming to docker.io/library/lightmall-user:latest
\#13 naming to docker.io/library/lightmall-user:latest done
\#13 unpacking to docker.io/library/lightmall-user:latest done
\#13 DONE 0.1s

\#14 \[goods internal] load build context
\#14 ...

\#15 \[user] resolving provenance for metadata file
\#15 DONE 0.0s

\#14 \[goods internal] load build context
\#14 transferring context: 16.22MB 5.1s
\#14 ...

\#16 \[gateway internal] load build context
\#16 ...

\#14 \[goods internal] load build context
\#14 transferring context: 32.09MB 10.1s
\#14 ...

\#17 \[order internal] load build context
\#17 ...

\#18 \[stock internal] load build context
\#18 ...

\#14 \[goods internal] load build context
\#14 ...

\#16 \[gateway internal] load build context
\#16 transferring context: 39.88MB 12.7s done
\#16 DONE 12.7s

\#11 \[gateway 2/3] WORKDIR /app
\#11 CACHED

\#19 \[gateway 3/3] COPY lightmall-gateway/target/lightmall-gateway-1.0.0-SNAPSHOT.jar /app/lightmall-gateway.jar
\#19 CACHED

\#14 \[goods internal] load build context
\#14 ...

\#20 \[gateway] exporting to image
\#20 exporting layers done
\#20 exporting manifest sha256:85f9c616c389b9d8069584f51aa821c70b58fe7f6a81b4afec960f97fbe33419 done
\#20 exporting config sha256:23adda46dbea4df9ffc3956cfa3bbf54ba4875f0f91ac6988da80a22e0bd9bd4 done
\#20 exporting attestation manifest sha256:9d769993c3f3659eb57b8e78c508ede24c813cfa5414d2356cc8d553afc444fe 0.0s done
\#20 exporting manifest list sha256:ed5f5f547a9899101f714076aed9ce7c624b122c12d1776448c4f496dac17d03 0.0s done
\#20 naming to docker.io/library/lightmall-gateway:latest done
\#20 unpacking to docker.io/library/lightmall-gateway:latest done
\#20 DONE 0.1s

\#14 \[goods internal] load build context
\#14 ...

\#21 \[gateway] resolving provenance for metadata file
\#21 DONE 0.1s

\#14 \[goods internal] load build context
\#14 ...

\#17 \[order internal] load build context
\#17 transferring context: 50.35MB 14.7s done
\#17 DONE 14.8s

\#11 \[order 2/3] WORKDIR /app
\#11 CACHED

\#22 \[order 3/3] COPY lightmall-order/target/lightmall-order-1.0.0-SNAPSHOT.jar /app/lightmall-order.jar
\#22 CACHED

\#14 \[goods internal] load build context
\#14 transferring context: 50.36MB 14.9s done
\#14 DONE 14.9s

\#23 \[order] exporting to image
\#23 exporting layers done
\#23 exporting manifest sha256:6c87fdb10310a13a2c99396d824345d687d41817a3aabbde7b046022c030f15e done
\#23 exporting config sha256:dde10a82de8021ae700dec7f52c76a619bc1dba1ba30615b5b166a4b68e6c4ca done
\#23 exporting attestation manifest sha256:777b7ac32e707738f4acb3eaca224b3afa42d32ca0460b42034fafb07c81c333 0.0s done
\#23 exporting manifest list sha256:76ae66257d9b6725961a523e9b58af3f1286f8e3869dd20a090b32d73dc70591 0.0s done
\#23 naming to docker.io/library/lightmall-order:latest done
\#23 unpacking to docker.io/library/lightmall-order:latest done
\#23 DONE 0.1s

\#18 \[stock internal] load build context
\#18 transferring context: 50.35MB 14.9s done
\#18 DONE 14.9s

\#24 \[stock 3/3] COPY lightmall-stock/target/lightmall-stock-1.0.0-SNAPSHOT.jar /app/lightmall-stock.jar
\#24 CACHED

\#11 \[goods 2/3] WORKDIR /app
\#11 CACHED

\#25 \[goods 3/3] COPY lightmall-goods/target/lightmall-goods-1.0.0-SNAPSHOT.jar /app/lightmall-goods.jar
\#25 CACHED

\#26 \[goods] exporting to image
\#26 exporting layers done
\#26 ...

\#27 \[order] resolving provenance for metadata file
\#27 DONE 0.0s

\#26 \[goods] exporting to image
\#26 exporting manifest sha256:df78f162c598a450f548f6bd7a0c9bbb8d7a99e0466f18bfd484511232ea1c9a done
\#26 exporting config sha256:8cdf05a07a1bf5e5fdaaea0d7c3d4ca247c645021927c9b8201a94bc22e363e4 done
\#26 exporting attestation manifest sha256:c30144be9d40a126ddd625f313b195c47884e9dd592f74935ff8ebc998adc0e7 0.0s done
\#26 exporting manifest list sha256:eb2e5da2506dd7c537c7a2886ef7df771c8de414c9a5f737f6819d1bd2a4afd9 0.0s done
\#26 naming to docker.io/library/lightmall-goods:latest done
\#26 unpacking to docker.io/library/lightmall-goods:latest
\#26 unpacking to docker.io/library/lightmall-goods:latest done
\#26 DONE 0.1s

\#28 \[stock] exporting to image
\#28 exporting layers done
\#28 exporting manifest sha256:27bd65bb24f425e498edd8b69e41256df9bb25dcb790586e0c841304009afd1a done
\#28 exporting config sha256:fc05a2e8cf4cc756462cf355a14b90ba8be9337457965f8d9f14aa89a3a6e82d done
\#28 exporting attestation manifest sha256:f5322d00a21bfc13b1e7d8de7f668a2f6e73d85430865b78975e1627ec818b51 0.0s done
\#28 exporting manifest list sha256:644abd1729a0b76d1c606e291cf15f2b205db49e0af6efb8c244d81b35d2e1cf 0.0s done
\#28 naming to docker.io/library/lightmall-stock:latest done
\#28 unpacking to docker.io/library/lightmall-stock:latest done
\#28 DONE 0.1s

\#29 \[goods] resolving provenance for metadata file
\#29 DONE 0.0s

\#30 \[stock] resolving provenance for metadata file
\#30 DONE 0.0s
\[+] up 14/14
✔ Image lightmall-stock Built 21.4s
✔ Image lightmall-user Built 21.4s
✔ Image lightmall-goods Built 21.4s
✔ Image lightmall-gateway Built 21.4s
✔ Image lightmall-order Built 21.4s
✔ Network lightmall\_lightmall-network Created 0.0s
✔ Container lightmall-mysql Started 0.6s
✔ Container lightmall-redis Started 0.6s
✔ Container lightmall-gateway Started 0.9s
✔ Container lightmall-stock Started 0.8s
✔ Container lightmall-order Started 0.9s
✔ Container lightmall-goods Started 0.9s
✔ Container lightmall-user Started 0.8s
✔ Container lightmall-nginx Started 1.2s
PS D:\code\trae\_projects\lightmall> docker inspect -f '{{.Name}}: {{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' $(docker ps -q | Select-String lightmall)
docker: 'docker inspect' requires at least 1 argument

Usage: docker inspect \[OPTIONS] NAME|ID \[NAME|ID...]

See 'docker inspect --help' for more information
PS D:\code\trae\_projects\lightmall> Invoke-WebRequest -Uri <http://localhost:9082/api/goods/1> -UseBasicParsing

StatusCode : 200
StatusDescription :
Content : {"code":500,"message":"nested exception is org.apache.ibatis.exceptions.PersistenceException: \n###
Error querying database. Cause: org.springframework.jdbc.CannotGetJdbcConnectionException: Failed
t...
RawContent : HTTP/1.1 200
Transfer-Encoding: chunked
Keep-Alive: timeout=60
Connection: keep-alive
Content-Type: application/json
Date: Sat, 11 Apr 2026 09:56:24 GMT

```
                {"code":500,"message":"nested exceptio...
```

Forms :
Headers : {\[Transfer-Encoding, chunked], \[Keep-Alive, timeout=60], \[Connection, keep-alive], \[Content-Type, a
pplication/json]...}
Images : {}
InputFields : {}
Links : {}
ParsedHtml :
RawContentLength : 770

PS D:\code\trae\_projects\lightmall> docker logs lightmall-goods

. \_\_\_\_ \_ \_\_ \_ \_
/\ / *'* \_\_ \_ *(*) \_\_ \_\_ \_ \ \ \ \
( ( )\_\_ | '\_ | '*| | '* / *\` | \ \ \\* *\
\\/ \_\_)| |*)| | | | | || (| | ) ) ) )
' |***| .\_\_|*****| ||*| |*\_*, | / / / /
\=========|*|==============|***/=/*/*/*/
:: Spring Boot :: (v2.7.15)

2026-04-11 09:54:42.261 INFO 1 --- \[ main] com.lightmall.goods.GoodsApplication : Starting GoodsApplication using Java 11.0.16 on ff319b521a95 with PID 1 (/app/lightmall-goods.jar started by root in /app)
2026-04-11 09:54:42.264 INFO 1 --- \[ main] com.lightmall.goods.GoodsApplication : No active profile set, falling back to 1 default profile: "default"
2026-04-11 09:54:44.114 INFO 1 --- \[ main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode
2026-04-11 09:54:44.118 INFO 1 --- \[ main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data Redis repositories in DEFAULT mode.
2026-04-11 09:54:44.159 INFO 1 --- \[ main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 13 ms. Found 0 Redis repository interfaces.
2026-04-11 09:54:45.201 INFO 1 --- \[ main] o.s.b.w\.embedded.tomcat.TomcatWebServer : Tomcat initialized with port(s): 9082 (http)
2026-04-11 09:54:45.218 INFO 1 --- \[ main] o.apache.catalina.core.StandardService : Starting service \[Tomcat]
2026-04-11 09:54:45.219 INFO 1 --- \[ main] org.apache.catalina.core.StandardEngine : Starting Servlet engine: \[Apache Tomcat/9.0.79]
2026-04-11 09:54:45.344 INFO 1 --- \[ main] o.a.c.c.C.\[Tomcat].\[localhost].\[/] : Initializing Spring embedded WebApplicationContext
2026-04-11 09:54:45.345 INFO 1 --- \[ main] w\.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2942 ms
\_ \_ |\_ \_ *|*. \_\_\_ \_ | \_
\| | |/|*)(*| | |*\ |*)||*|*\
/ |
3.5.3
2026-04-11 09:54:48.955 INFO 1 --- \[ main] o.s.b.w\.embedded.tomcat.TomcatWebServer : Tomcat started on port(s): 9082 (http) with context path ''
2026-04-11 09:54:49.591 INFO 1 --- \[ main] com.lightmall.goods.GoodsApplication : Started GoodsApplication in 8.308 seconds (JVM running for 9.001)
2026-04-11 09:56:23.338 INFO 1 --- \[nio-9082-exec-1] o.a.c.c.C.\[Tomcat].\[localhost].\[/] : Initializing Spring DispatcherServlet 'dispatcherServlet'
2026-04-11 09:56:23.339 INFO 1 --- \[nio-9082-exec-1] o.s.web.servlet.DispatcherServlet : Initializing Servlet 'dispatcherServlet'
2026-04-11 09:56:23.340 INFO 1 --- \[nio-9082-exec-1] o.s.web.servlet.DispatcherServlet : Completed initialization in 1 ms
Bloom filter check for key goods:id:1: false
Cache check for key goods:id:1: miss
Double cache check for key goods:id:1: miss
Querying database for goods id: 1
2026-04-11 09:56:23.632 INFO 1 --- \[nio-9082-exec-1] com.zaxxer.hikari.HikariDataSource : HikariPool-1 - Starting...
2026-04-11 09:56:24.838 ERROR 1 --- \[nio-9082-exec-1] com.zaxxer.hikari.pool.HikariPool : HikariPool-1 - Exception during pool initialization.

java.sql.SQLException: Access denied for user 'root'@'172.18.0.6' (using password: YES)
at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:130) \~\[mysql-connector-j-8.0.33.jar!/:8.0.33]
at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122) \~\[mysql-connector-j-8.0.33.jar!/:8.0.33]
at com.mysql.cj.jdbc.ConnectionImpl.createNewIO(ConnectionImpl.java:825) \~\[mysql-connector-j-8.0.33.jar!/:8.0.33]
at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:446) \~\[mysql-connector-j-8.0.33.jar!/:8.0.33]
at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:239) \~\[mysql-connector-j-8.0.33.jar!/:8.0.33]
at com.mysql.cj.jdbc.NonRegisteringDriver.connect(NonRegisteringDriver.java:188) \~\[mysql-connector-j-8.0.33.jar!/:8.0.33]
at com.zaxxer.hikari.util.DriverDataSource.getConnection(DriverDataSource.java:138) \~\[HikariCP-4.0.3.jar!/:na]
at com.zaxxer.hikari.pool.PoolBase.newConnection(PoolBase.java:364) \~\[HikariCP-4.0.3.jar!/:na]
at com.zaxxer.hikari.pool.PoolBase.newPoolEntry(PoolBase.java:206) \~\[HikariCP-4.0.3.jar!/:na]
at com.zaxxer.hikari.pool.HikariPool.createPoolEntry(HikariPool.java:476) \~\[HikariCP-4.0.3.jar!/:na]
at com.zaxxer.hikari.pool.HikariPool.checkFailFast(HikariPool.java:561) \~\[HikariCP-4.0.3.jar!/:na]
at com.zaxxer.hikari.pool.HikariPool.<init>(HikariPool.java:115) \~\[HikariCP-4.0.3.jar!/:na]
at com.zaxxer.hikari.HikariDataSource.getConnection(HikariDataSource.java:112) \~\[HikariCP-4.0.3.jar!/:na]
at org.springframework.jdbc.datasource.DataSourceUtils.fetchConnection(DataSourceUtils.java:160) \~\[spring-jdbc-5.3.29.jar!/:5.3.29]
at org.springframework.jdbc.datasource.DataSourceUtils.doGetConnection(DataSourceUtils.java:118) \~\[spring-jdbc-5.3.29.jar!/:5.3.29]
at org.springframework.jdbc.datasource.DataSourceUtils.getConnection(DataSourceUtils.java:81) \~\[spring-jdbc-5.3.29.jar!/:5.3.29]
at org.mybatis.spring.transaction.SpringManagedTransaction.openConnection(SpringManagedTransaction.java:80) \~\[mybatis-spring-2.0.7.jar!/:2.0.7]
at org.mybatis.spring.transaction.SpringManagedTransaction.getConnection(SpringManagedTransaction.java:67) \~\[mybatis-spring-2.0.7.jar!/:2.0.7]
at org.apache.ibatis.executor.BaseExecutor.getConnection(BaseExecutor.java:337) \~\[mybatis-3.5.10.jar!/:3.5.10]
at org.apache.ibatis.executor.SimpleExecutor.prepareStatement(SimpleExecutor.java:86) \~\[mybatis-3.5.10.jar!/:3.5.10]
at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:62) \~\[mybatis-3.5.10.jar!/:3.5.10]
at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:325) \~\[mybatis-3.5.10.jar!/:3.5.10]
at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156) \~\[mybatis-3.5.10.jar!/:3.5.10]
at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109) \~\[mybatis-3.5.10.jar!/:3.5.10]
at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:89) \~\[mybatis-3.5.10.jar!/:3.5.10]
at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:151) \~\[mybatis-3.5.10.jar!/:3.5.10]
at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:145) \~\[mybatis-3.5.10.jar!/:3.5.10]
at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:140) \~\[mybatis-3.5.10.jar!/:3.5.10]
at org.apache.ibatis.session.defaults.DefaultSqlSession.selectOne(DefaultSqlSession.java:76) \~\[mybatis-3.5.10.jar!/:3.5.10]
at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) \~\[na:na]
at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(Unknown Source) \~\[na:na]
at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source) \~\[na:na]
at java.base/java.lang.reflect.Method.invoke(Unknown Source) \~\[na:na]
at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:427) \~\[mybatis-spring-2.0.7.jar!/:2.0.7]
at com.sun.proxy.$Proxy82.selectOne(Unknown Source) \~\[na:na]
at org.mybatis.spring.SqlSessionTemplate.selectOne(SqlSessionTemplate.java:160) \~\[mybatis-spring-2.0.7.jar!/:2.0.7]
at com.baomidou.mybatisplus.core.override.MybatisMapperMethod.execute(MybatisMapperMethod.java:89) \~\[mybatis-plus-core-3.5.3.jar!/:3.5.3]
at com.baomidou.mybatisplus.core.override.MybatisMapperProxy$PlainMethodInvoker.invoke(MybatisMapperProxy.java:148) \~\[mybatis-plus-core-3.5.3.jar!/:3.5.3]
at com.baomidou.mybatisplus.core.override.MybatisMapperProxy.invoke(MybatisMapperProxy.java:89) \~\[mybatis-plus-core-3.5.3.jar!/:3.5.3]
at com.sun.proxy.$Proxy87.selectById(Unknown Source) \~\[na:na]
at com.baomidou.mybatisplus.extension.service.IService.getById(IService.java:292) \~\[mybatis-plus-extension-3.5.3.jar!/:3.5.3]
at com.lightmall.goods.service.impl.GoodsServiceImpl.getGoodsById(GoodsServiceImpl.java:64) \~\[classes!/:na]
at com.lightmall.goods.service.impl.GoodsServiceImpl$$FastClassBySpringCGLIB$$4c8d6eeb.invoke(<generated>) \~\[classes!/:na]
at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218) \~\[spring-core-5.3.29.jar!/:5.3.29]
at org.springframework.aop.framework.CglibAopProxy.invokeMethod(CglibAopProxy.java:386) \~\[spring-aop-5.3.29.jar!/:5.3.29]
at org.springframework.aop.framework.CglibAopProxy.access$000(CglibAopProxy.java:85) \~\[spring-aop-5.3.29.jar!/:5.3.29]
at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:704) \~\[spring-aop-5.3.29.jar!/:5.3.29]
at com.lightmall.goods.service.impl.GoodsServiceImpl$$EnhancerBySpringCGLIB$$b4d5127b.getGoodsById(<generated>) \~\[classes!/:na]
at com.lightmall.goods.controller.GoodsController.getGoodsById(GoodsController.java:41) \~\[classes!/:na]
at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) \~\[na:na]
at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(Unknown Source) \~\[na:na]
at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source) \~\[na:na]
at java.base/java.lang.reflect.Method.invoke(Unknown Source) \~\[na:na]
at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205) \~\[spring-web-5.3.29.jar!/:5.3.29]
at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:150) \~\[spring-web-5.3.29.jar!/:5.3.29]
at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117) \~\[spring-webmvc-5.3.29.jar!/:5.3.29]
at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895) \~\[spring-webmvc-5.3.29.jar!/:5.3.29]
at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808) \~\[spring-webmvc-5.3.29.jar!/:5.3.29]
at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87) \~\[spring-webmvc-5.3.29.jar!/:5.3.29]
at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1072) \~\[spring-webmvc-5.3.29.jar!/:5.3.29]
at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:965) \~\[spring-webmvc-5.3.29.jar!/:5.3.29]
at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006) \~\[spring-webmvc-5.3.29.jar!/:5.3.29]
at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898) \~\[spring-webmvc-5.3.29.jar!/:5.3.29]
at javax.servlet.http.HttpServlet.service(HttpServlet.java:529) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883) \~\[spring-webmvc-5.3.29.jar!/:5.3.29]
at javax.servlet.http.HttpServlet.service(HttpServlet.java:623) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:209) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51) \~\[tomcat-embed-websocket-9.0.79.jar!/:na]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) \~\[spring-web-5.3.29.jar!/:5.3.29]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) \~\[spring-web-5.3.29.jar!/:5.3.29]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) \~\[spring-web-5.3.29.jar!/:5.3.29]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) \~\[spring-web-5.3.29.jar!/:5.3.29]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) \~\[spring-web-5.3.29.jar!/:5.3.29]
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) \~\[spring-web-5.3.29.jar!/:5.3.29]
at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:167) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:90) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:481) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:130) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:390) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:926) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1790) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) \~\[tomcat-embed-core-9.0.79.jar!/:na]
at java.base/java.lang.Thread.run(Unknown Source) \~\[na:na]

org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.exceptions.PersistenceException:

### Error querying database. Cause: org.springframework.jdbc.CannotGetJdbcConnectionException: Failed to obtain JDBC Connection; nested exception is java.sql.SQLException: Access denied for user 'root'@'172.18.0.6' (using password: YES)

### The error may exist in com/lightmall/goods/mapper/GoodsMapper.java (best guess)

### The error may involve com.lightmall.goods.mapper.GoodsMapper.selectById

### The error occurred while executing a query

### Cause: org.springframework.jdbc.CannotGetJdbcConnectionException: Failed to obtain JDBC Connection; nested exception is java.sql.SQLException: Access denied for user 'root'@'172.18.0.6' (using password: YES)

```
    at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:96)
    at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:441)
    at com.sun.proxy.$Proxy82.selectOne(Unknown Source)
    at org.mybatis.spring.SqlSessionTemplate.selectOne(SqlSessionTemplate.java:160)
    at com.baomidou.mybatisplus.core.override.MybatisMapperMethod.execute(MybatisMapperMethod.java:89)
    at com.baomidou.mybatisplus.core.override.MybatisMapperProxy$PlainMethodInvoker.invoke(MybatisMapperProxy.java:148)
    at com.baomidou.mybatisplus.core.override.MybatisMapperProxy.invoke(MybatisMapperProxy.java:89)
    at com.sun.proxy.$Proxy87.selectById(Unknown Source)
    at com.baomidou.mybatisplus.extension.service.IService.getById(IService.java:292)
    at com.lightmall.goods.service.impl.GoodsServiceImpl.getGoodsById(GoodsServiceImpl.java:64)
    at com.lightmall.goods.service.impl.GoodsServiceImpl$$FastClassBySpringCGLIB$$4c8d6eeb.invoke(<generated>)
    at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)
    at org.springframework.aop.framework.CglibAopProxy.invokeMethod(CglibAopProxy.java:386)
    at org.springframework.aop.framework.CglibAopProxy.access$000(CglibAopProxy.java:85)
    at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:704)
    at com.lightmall.goods.service.impl.GoodsServiceImpl$$EnhancerBySpringCGLIB$$b4d5127b.getGoodsById(<generated>)
    at com.lightmall.goods.controller.GoodsController.getGoodsById(GoodsController.java:41)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
    at java.base/java.lang.reflect.Method.invoke(Unknown Source)
    at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205)
    at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:150)
    at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117)
    at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895)
    at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)
    at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
    at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1072)
    at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:965)
    at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
    at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)
    at javax.servlet.http.HttpServlet.service(HttpServlet.java:529)
    at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
    at javax.servlet.http.HttpServlet.service(HttpServlet.java:623)
    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:209)
    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)
    at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)
    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178)
    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)
    at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)
    at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)
    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178)
    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)
    at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)
    at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)
    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178)
    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)
    at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
    at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)
    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178)
    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)
    at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:167)
    at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:90)
    at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:481)
    at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:130)
    at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93)
    at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)
    at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)
    at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:390)
    at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63)
    at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:926)
    at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1790)
    at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52)
    at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191)
    at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659)
    at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
    at java.base/java.lang.Thread.run(Unknown Source)
```

Caused by: org.apache.ibatis.exceptions.PersistenceException:

### Error querying database. Cause: org.springframework.jdbc.CannotGetJdbcConnectionException: Failed to obtain JDBC Connection; nested exception is java.sql.SQLException: Access denied for user 'root'@'172.18.0.6' (using password: YES)

### The error may exist in com/lightmall/goods/mapper/GoodsMapper.java (best guess)

### The error may involve com.lightmall.goods.mapper.GoodsMapper.selectById

### The error occurred while executing a query

### Cause: org.springframework.jdbc.CannotGetJdbcConnectionException: Failed to obtain JDBC Connection; nested exception is java.sql.SQLException: Access denied for user 'root'@'172.18.0.6' (using password: YES)

```
    at org.apache.ibatis.exceptions.ExceptionFactory.wrapException(ExceptionFactory.java:30)
    at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:153)
    at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:145)
    at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:140)
    at org.apache.ibatis.session.defaults.DefaultSqlSession.selectOne(DefaultSqlSession.java:76)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
    at java.base/java.lang.reflect.Method.invoke(Unknown Source)
    at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:427)
    ... 65 more
```

Caused by: org.springframework.jdbc.CannotGetJdbcConnectionException: Failed to obtain JDBC Connection; nested exception is java.sql.SQLException: Access denied for user 'root'@'172.18.0.6' (using password: YES)
at org.springframework.jdbc.datasource.DataSourceUtils.getConnection(DataSourceUtils.java:84)
at org.mybatis.spring.transaction.SpringManagedTransaction.openConnection(SpringManagedTransaction.java:80)
at org.mybatis.spring.transaction.SpringManagedTransaction.getConnection(SpringManagedTransaction.java:67)
at org.apache.ibatis.executor.BaseExecutor.getConnection(BaseExecutor.java:337)
at org.apache.ibatis.executor.SimpleExecutor.prepareStatement(SimpleExecutor.java:86)
at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:62)
at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:325)
at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:89)
at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:151)
... 73 more
Caused by: java.sql.SQLException: Access denied for user 'root'@'172.18.0.6' (using password: YES)
at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:130)
at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)
at com.mysql.cj.jdbc.ConnectionImpl.createNewIO(ConnectionImpl.java:825)
at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:446)
at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:239)
at com.mysql.cj.jdbc.NonRegisteringDriver.connect(NonRegisteringDriver.java:188)
at com.zaxxer.hikari.util.DriverDataSource.getConnection(DriverDataSource.java:138)
at com.zaxxer.hikari.pool.PoolBase.newConnection(PoolBase.java:364)
at com.zaxxer.hikari.pool.PoolBase.newPoolEntry(PoolBase.java:206)
at com.zaxxer.hikari.pool.HikariPool.createPoolEntry(HikariPool.java:476)
at com.zaxxer.hikari.pool.HikariPool.checkFailFast(HikariPool.java:561)
at com.zaxxer.hikari.pool.HikariPool.<init>(HikariPool.java:115)
at com.zaxxer.hikari.HikariDataSource.getConnection(HikariDataSource.java:112)
at org.springframework.jdbc.datasource.DataSourceUtils.fetchConnection(DataSourceUtils.java:160)
at org.springframework.jdbc.datasource.DataSourceUtils.doGetConnection(DataSourceUtils.java:118)
at org.springframework.jdbc.datasource.DataSourceUtils.getConnection(DataSourceUtils.java:81)
... 83 more
PS D:\code\trae\_projects\lightmall>
