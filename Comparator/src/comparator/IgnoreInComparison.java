package comparator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Must be runtime, otherwise we loose the information during reflection
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreInComparison {
}
