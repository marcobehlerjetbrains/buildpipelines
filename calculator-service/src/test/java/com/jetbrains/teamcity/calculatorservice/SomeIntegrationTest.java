package com.jetbrains.teamcity.calculatorservice;


import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeIntegrationTest {

    //language=TEXT
    private String hello = "/usr/bin/java -XX:TieredStopAtLevel=1 -noverify -Dspring.output.ansi.enabled=always -javaagent:C:\\Users\\screencasts\\AppData\\Local\\JetBrains\\Toolbox\\apps\\IDEA-U\\ch-0\\212.4746.92\\lib\\idea_rt.jar=56933:C:\\Users\\screencasts\\AppData\\Local\\JetBrains\\Toolbox\\apps\\IDEA-U\\ch-0\\212.4746.92\\bin -Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true -Dfile.encoding=UTF-8 -classpath C:\\dev\\buildpipelines\\calculator-service\\target\\classes;C:\\Users\\screencasts\\.m2\\repository\\org\\springframework\\boot\\spring-boot-starter-thymeleaf\\2.5.2\\spring-boot-starter-thymeleaf-2.5.2.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\springframework\\boot\\spring-boot-starter\\2.5.2\\spring-boot-starter-2.5.2.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\springframework\\boot\\spring-boot\\2.5.2\\spring-boot-2.5.2.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\springframework\\boot\\spring-boot-autoconfigure\\2.5.2\\spring-boot-autoconfigure-2.5.2.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\springframework\\boot\\spring-boot-starter-logging\\2.5.2\\spring-boot-starter-logging-2.5.2.jar;C:\\Users\\screencasts\\.m2\\repository\\ch\\qos\\logback\\logback-classic\\1.2.3\\logback-classic-1.2.3.jar;C:\\Users\\screencasts\\.m2\\repository\\ch\\qos\\logback\\logback-core\\1.2.3\\logback-core-1.2.3.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\apache\\logging\\log4j\\log4j-to-slf4j\\2.14.1\\log4j-to-slf4j-2.14.1.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\apache\\logging\\log4j\\log4j-api\\2.14.1\\log4j-api-2.14.1.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\slf4j\\jul-to-slf4j\\1.7.31\\jul-to-slf4j-1.7.31.jar;C:\\Users\\screencasts\\.m2\\repository\\jakarta\\annotation\\jakarta.annotation-api\\1.3.5\\jakarta.annotation-api-1.3.5.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\yaml\\snakeyaml\\1.28\\snakeyaml-1.28.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\thymeleaf\\thymeleaf-spring5\\3.0.12.RELEASE\\thymeleaf-spring5-3.0.12.RELEASE.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\thymeleaf\\thymeleaf\\3.0.12.RELEASE\\thymeleaf-3.0.12.RELEASE.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\attoparser\\attoparser\\2.0.5.RELEASE\\attoparser-2.0.5.RELEASE.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\unbescape\\unbescape\\1.1.6.RELEASE\\unbescape-1.1.6.RELEASE.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\slf4j\\slf4j-api\\1.7.31\\slf4j-api-1.7.31.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\thymeleaf\\extras\\thymeleaf-extras-java8time\\3.0.4.RELEASE\\thymeleaf-extras-java8time-3.0.4.RELEASE.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\springframework\\boot\\spring-boot-starter-web\\2.5.2\\spring-boot-starter-web-2.5.2.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\springframework\\boot\\spring-boot-starter-json\\2.5.2\\spring-boot-starter-json-2.5.2.jar;C:\\Users\\screencasts\\.m2\\repository\\com\\fasterxml\\jackson\\core\\jackson-databind\\2.12.3\\jackson-databind-2.12.3.jar;C:\\Users\\screencasts\\.m2\\repository\\com\\fasterxml\\jackson\\core\\jackson-annotations\\2.12.3\\jackson-annotations-2.12.3.jar;C:\\Users\\screencasts\\.m2\\repository\\com\\fasterxml\\jackson\\core\\jackson-core\\2.12.3\\jackson-core-2.12.3.jar;C:\\Users\\screencasts\\.m2\\repository\\com\\fasterxml\\jackson\\datatype\\jackson-datatype-jdk8\\2.12.3\\jackson-datatype-jdk8-2.12.3.jar;C:\\Users\\screencasts\\.m2\\repository\\com\\fasterxml\\jackson\\datatype\\jackson-datatype-jsr310\\2.12.3\\jackson-datatype-jsr310-2.12.3.jar;C:\\Users\\screencasts\\.m2\\repository\\com\\fasterxml\\jackson\\module\\jackson-module-parameter-names\\2.12.3\\jackson-module-parameter-names-2.12.3.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\springframework\\boot\\spring-boot-starter-tomcat\\2.5.2\\spring-boot-starter-tomcat-2.5.2.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\apache\\tomcat\\embed\\tomcat-embed-core\\9.0.48\\tomcat-embed-core-9.0.48.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\apache\\tomcat\\embed\\tomcat-embed-el\\9.0.48\\tomcat-embed-el-9.0.48.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\apache\\tomcat\\embed\\tomcat-embed-websocket\\9.0.48\\tomcat-embed-websocket-9.0.48.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\springframework\\spring-web\\5.3.8\\spring-web-5.3.8.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\springframework\\spring-beans\\5.3.8\\spring-beans-5.3.8.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\springframework\\spring-webmvc\\5.3.8\\spring-webmvc-5.3.8.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\springframework\\spring-aop\\5.3.8\\spring-aop-5.3.8.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\springframework\\spring-context\\5.3.8\\spring-context-5.3.8.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\springframework\\spring-expression\\5.3.8\\spring-expression-5.3.8.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\springframework\\spring-core\\5.3.8\\spring-core-5.3.8.jar;C:\\Users\\screencasts\\.m2\\repository\\org\\springframework\\spring-jcl\\5.3.8\\spring-jcl-5.3.8.jar com.jetbrains.teamcity.calculatorservice.CalculatorServiceApplication\n" +
            "OpenJDK 64-Bit Server VM warning: Options -Xverify:none and -noverify were deprecated in JDK 13 and will likely be removed in a future release.\n" +
            "\n" +
            "___________                   _________ .__  __          \n" +
            "\\__    ___/___ _____    _____ \\_   ___ \\|__|/  |_ ___.__.\n" +
            "  |    |_/ __ \\\\__  \\  /     \\/    \\  \\/|  \\   __<   |  |\n" +
            "  |    |\\  ___/ / __ \\|  Y Y  \\     \\___|  ||  |  \\___  |\n" +
            "  |____| \\___  >____  /__|_|  /\\______  /__||__|  / ____|\n" +
            "             \\/     \\/      \\/        \\/          \\/     \n" +
            "__________               __           ._.\n" +
            "\\______   \\ ____   ____ |  | __  _____| |\n" +
            " |       _//  _ \\_/ ___\\|  |/ / /  ___/ |\n" +
            " |    |   (  <_> )  \\___|    <  \\___ \\ \\|\n" +
            " |____|_  /\\____/ \\___  >__|_ \\/____  >__\n" +
            "        \\/            \\/     \\/     \\/ \\/" +
            "\n" +
            "2021-08-02 17:05:14.238  INFO 19352 --- [           main] c.j.t.c.CalculatorServiceApplication     : Starting CalculatorServiceApplication using Java 16.0.1 on DESKTOP-ROTQJ0L with PID 19352 (C:\\dev\\buildpipelines\\calculator-service\\target\\classes started by screencasts in C:\\dev\\buildpipelines)\n" +
            "2021-08-02 17:05:14.239  INFO 19352 --- [           main] c.j.t.c.CalculatorServiceApplication     : No active profile set, falling back to default profiles: default\n" +
            "2021-08-02 17:05:14.943  INFO 19352 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)\n" +
            "2021-08-02 17:05:14.954  INFO 19352 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]\n" +
            "2021-08-02 17:05:14.955  INFO 19352 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.48]\n" +
            "2021-08-02 17:05:15.016  INFO 19352 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext\n" +
            "2021-08-02 17:05:15.016  INFO 19352 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 739 ms\n" +
            "2021-08-02 17:05:15.251  WARN 19352 --- [           main] ion$DefaultTemplateResolverConfiguration : Cannot find template location: classpath:/templates/ (please add some templates or check your Thymeleaf configuration)\n" +
            "2021-08-02 17:05:15.324  INFO 19352 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''\n" +
            "2021-08-02 17:05:15.333  INFO 19352 --- [           main] c.j.t.c.CalculatorServiceApplication     : Started CalculatorServiceApplication in 1.397 seconds (JVM running for 1.947)\n";

    @Test
    public void anIntegrationTest() throws InterruptedException, IOException {
        Path path = Paths.get("./artifacts");
        Files.createDirectories(path);

        Path subfolder = path.resolve("subfolder");
        Files.createDirectories(subfolder);
        Files.write(subfolder.resolve("test.txt"), "test".getBytes());

        try (InputStream is = SomeIntegrationTest.class.getResourceAsStream("/sample-mp4-file.mp4")) {
            Files.copy(is, path.resolve("selenium_chrome_recording.mp4"));
        }
        Files.write(path.resolve("application.log"), hello.getBytes());
        Thread.sleep(1000);
        assertEquals(1,1);

        System.out.println("test");
        System.out.println("test2");
        System.out.println("test3");
        System.out.println("test4");
    }
}
