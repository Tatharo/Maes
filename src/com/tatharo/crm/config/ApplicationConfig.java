package com.tatharo.crm.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;

import com.tatharo.crm.service.UserService;

public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<>();
        classes.add(UserService.class);
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        MOXyJsonProvider moxyJsonProvider = new MOXyJsonProvider();
        moxyJsonProvider.setWrapperAsArrayName(false);
        moxyJsonProvider.setAttributePrefix("@");
        moxyJsonProvider.setFormattedOutput(true);
        moxyJsonProvider.setIncludeRoot(false);
        moxyJsonProvider.setMarshalEmptyCollections(false);
        moxyJsonProvider.setValueWrapper("$");
        moxyJsonProvider.setNamespaceSeparator(':');

        HashSet<Object> singletons = new HashSet<>();
        singletons.add(moxyJsonProvider);
        return singletons;
    }

}
