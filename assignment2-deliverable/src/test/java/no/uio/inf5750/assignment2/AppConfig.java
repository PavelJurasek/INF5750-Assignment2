package no.uio.inf5750.assignment2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pjurasek on 11.09.16.
 */
@Configuration
@ComponentScan(basePackages = {"no.uio.inf5750.assignment2.dao.hibernate", "no.uio.inf5750.assignment2.service.impl"})
public class AppConfig {
}
