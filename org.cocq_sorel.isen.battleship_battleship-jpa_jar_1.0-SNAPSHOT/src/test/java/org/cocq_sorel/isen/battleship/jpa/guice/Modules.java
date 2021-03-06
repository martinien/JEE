package org.cocq_sorel.isen.battleship.jpa.guice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.inject.Module;

@Inherited
@Retention ( RetentionPolicy.RUNTIME )
@Target ( {ElementType.TYPE , ElementType.METHOD} )
public @interface Modules {
    Class<? extends Module>[] value();
}
