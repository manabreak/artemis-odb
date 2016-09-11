package com.artemis.generator.model.type;

import java.lang.reflect.Type;

/**
  * @author Daan van Yperen
 */
public class ParameterDescriptor {
    public Type type;
    public String name;

    public ParameterDescriptor(Type type, String name) {
        this.type = type;
        this.name = name;
    }
}