package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.http.MediaType;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.getProjectionConfiguration().addProjection(DepartmentProjection.class);
    
    config.getProjectionConfiguration().addProjection(EmployeeProjection1.class);

    config.getProjectionConfiguration().addProjection(EmployeeProjection2.class);
    
    //
    config.setDefaultMediaType(MediaType.APPLICATION_JSON);
    config.useHalAsDefaultJsonMediaType(false);
    //
  }
}