import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;
import nicebank.Money;

import java.util.Locale;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        //  Adding the money type to the project
        typeRegistry.defineParameterType(new ParameterType<>(
                "money",
                "\\d+\\.\\d+",
                Money.class,
                (String s) ->{
                    String[] split = s.split("\\.");
                    return new Money(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                }
        ));

    }
}
