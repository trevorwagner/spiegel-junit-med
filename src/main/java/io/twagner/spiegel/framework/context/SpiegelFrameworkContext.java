package io.twagner.spiegel.framework.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"io.twagner.spiegel.framework"})
public class SpiegelFrameworkContext {
}
