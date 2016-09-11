package com.artemis.generator.strategy.e;

import com.artemis.generator.common.IterativeModelStrategy;
import com.artemis.generator.model.type.TypeModel;
import com.artemis.generator.model.artemis.ComponentDescriptor;
import com.artemis.generator.model.type.MethodDescriptor;
import com.artemis.generator.util.MethodBuilder;

/**
 * Generate direct accessor for each component.
 *
 * @author Daan van Yperen
 */
public class DirectAccessorStrategy extends IterativeModelStrategy {

    @Override
    protected void apply(ComponentDescriptor component, TypeModel model) {
        model.add(createGetComponentMethod(component));
    }

    /**
     * T _componentName() -> return instance of entity Component E::_componentName()
     */
    private MethodDescriptor createGetComponentMethod(ComponentDescriptor component) {
        return
                new MethodBuilder(component.getComponentType(), "_"+component.getMethodPrefix())
                        .mapper("return ", component, ".get(entityId)")
                        .build();
    }
}