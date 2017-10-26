package br.com.welisson.calculoDeHoras.restapi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.http.HttpStatus;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MvcException {

    public abstract HttpStatus value();
}
