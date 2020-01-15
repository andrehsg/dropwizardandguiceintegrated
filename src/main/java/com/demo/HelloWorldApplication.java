package com.demo;

import com.demo.api.Saying;
import com.demo.health.TemplateHealthCheck;
import com.demo.modules.HelloWorldModule;
import com.demo.resources.HelloWorldResource;
import com.demo.service.HelloWorldService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {



    public static void main(final String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(final Bootstrap<HelloWorldConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final HelloWorldConfiguration configuration,
                    final Environment environment) {

        //Google Guice
        /*
         * Guice.createInjector() takes your Modules, and returns a new Injector
         * instance. Most applications will call this method exactly once, in their
         * main() method.
         */
        Injector injector = Guice.createInjector(new HelloWorldModule());

        /*
         * Now that we've got the injector, we can build objects.
         */
        HelloWorldService helloService = injector.getInstance(HelloWorldService.class);

        final HelloWorldResource resource = new HelloWorldResource();
        environment.jersey().register(resource);




    }

}
