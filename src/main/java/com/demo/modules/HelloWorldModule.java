package com.demo.modules;

import com.demo.service.HelloWorldService;
import com.demo.service.HelloWorldServiceImpl;
import com.google.inject.AbstractModule;

public class HelloWorldModule extends AbstractModule {

  protected void configure() {
    bind(HelloWorldService.class).to(HelloWorldServiceImpl.class);
  }

}
