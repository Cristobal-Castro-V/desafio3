package desafio.devoptopus.desafio3.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:discount.properties")
public class PropertiesConfig {

}
