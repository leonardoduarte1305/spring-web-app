package dev.leoduarte.springwebapp.utils.jsonschema2pojo;

import com.sun.codemodel.JCodeModel;
import lombok.SneakyThrows;
import org.jsonschema2pojo.Annotator;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.net.URL;

public class JsonSchema2PojoGenerator {

    @SneakyThrows
    public void convertJson2JavaClass(
            URL inputJsonUrl,
            File outputJavaClassDirectory,
            String packageName,
            String javaClassName) {
        JCodeModel jCodeModel = new JCodeModel();

        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() {
                return true;
            }

            @Override
            public SourceType getSourceType() {
                return SourceType.JSON;
            }
        };

        SchemaStore schemaStore = new SchemaStore();
        Annotator jackson2Annotator = new Jackson2Annotator(config);
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        RuleFactory ruleFactory = new RuleFactory(config, jackson2Annotator, schemaStore);

        SchemaMapper schemaMapper = new SchemaMapper(ruleFactory, schemaGenerator);

        schemaMapper.generate(jCodeModel, javaClassName, packageName, inputJsonUrl);
        jCodeModel.build(outputJavaClassDirectory);
    }

}
