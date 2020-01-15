package com.demo.resources;

import com.demo.api.Saying;
import com.demo.modules.HelloWorldModule;
import com.demo.service.HelloWorldService;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
  private final AtomicLong counter;



  @Inject
  public HelloWorldResource() {
    this.counter = new AtomicLong();
  }

  @GET
  @Path("/say")
  public Saying sayHelloWithServiceInjected () {

    Injector injector = Guice.createInjector(new HelloWorldModule());

    /*
     * Now that we've got the injector, we can build objects.
     */
    HelloWorldService helloService = injector.getInstance(HelloWorldService.class);

    return new Saying(this.counter.incrementAndGet(), helloService.sayHello());

  }




}