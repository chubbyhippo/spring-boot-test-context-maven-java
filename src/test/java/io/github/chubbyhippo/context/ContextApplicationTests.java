package io.github.chubbyhippo.context;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ContextApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("should print all bean definitions from context")
    void shouldPrintAllBeanDefinitionsFromContext() {
        Arrays.stream(context.getBeanDefinitionNames())
                .toList()
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("should have security config bean")
    void shouldHaveSecurityConfigBean() {
        assertThat(context.getBean("securityConfig")).isNotNull();
    }

}
