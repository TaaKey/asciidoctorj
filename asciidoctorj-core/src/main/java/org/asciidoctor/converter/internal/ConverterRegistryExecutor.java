package org.asciidoctor.converter.internal;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.converter.spi.ConverterRegistry;

import java.util.ServiceLoader;

public class ConverterRegistryExecutor {

    private static ServiceLoader<ConverterRegistry> converterRegistryServiceLoader = ServiceLoader
            .load(ConverterRegistry.class);

    private Asciidoctor asciidoctor;

    public ConverterRegistryExecutor(Asciidoctor asciidoctor) {
        this.asciidoctor = asciidoctor;
    }

    public void registerAllConverters() {
        for (ConverterRegistry converterRegistry : converterRegistryServiceLoader) {
            converterRegistry.register(asciidoctor);
        }
    }
}
