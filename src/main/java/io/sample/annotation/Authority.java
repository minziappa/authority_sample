package io.sample.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Authority {

	public enum Priority {

		SUPER_ADMIN("1"), ADMIN("2"), SEMI_ADMIN("3"), SEME_USER("4"), USER("5");

        public String value;
        
        private Priority(String value) {
                this.value = value;
        }
	}

	Priority priority() default Priority.USER;
}