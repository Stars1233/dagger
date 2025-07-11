package test;

import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
final class DaggerSimpleComponent {
  private DaggerSimpleComponent() {
  }

  public static SimpleComponent.Builder builder() {
    return new Builder();
  }

  private static final class Builder implements SimpleComponent.Builder {
    private Object object;

    @Override
    public Builder object(Object object) {
      this.object = Preconditions.checkNotNull(object);
      return this;
    }

    @Override
    public SimpleComponent build() {
      Preconditions.checkBuilderRequirement(object, Object.class);
      return new SimpleComponentImpl(object);
    }
  }

  private static final class SimpleComponentImpl implements SimpleComponent {
    private final Object object;

    private final SimpleComponentImpl simpleComponentImpl = this;

    SimpleComponentImpl(Object objectParam) {
      this.object = objectParam;

    }

    @Override
    public Object object() {
      return object;
    }
  }
}
