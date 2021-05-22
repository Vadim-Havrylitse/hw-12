import java.lang.annotation.*;

@Inherited
//@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Repeat {
    int value() default 1;
}
