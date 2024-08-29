package dev.leoduarte.springwebapp.utils.jsonschema2pojo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

class JsonSchema2PojoGeneratorTest {

    JsonSchema2PojoGenerator generator = new JsonSchema2PojoGenerator();

    @Test
    @Disabled("Manual usage only")
    void generate() throws MalformedURLException {
        URL jsonInputUrl = new URL("file:/home/leonardoduarte/Git/spring-web-app/src/main/resources/exampleInputForGeneratingJavaClasses.json");
        File outputClassDirectory = new File("/home/leonardoduarte/Git/spring-web-app/src/main/java/dev/leoduarte/springwebapp/jsonschema2pojogenerator");
        String packageName = "dev.leoduarte.springwebapp.datasource1.domain.generated";
        String javaClassName = "Person";

        generator.convertJson2JavaClass(jsonInputUrl, outputClassDirectory, packageName, javaClassName);
    }
}
