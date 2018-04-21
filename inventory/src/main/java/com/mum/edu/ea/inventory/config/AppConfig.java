package com.mum.edu.ea.inventory.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MessagingConfiguration.class, MessagingListnerConfiguration.class})
public class AppConfig {
}
