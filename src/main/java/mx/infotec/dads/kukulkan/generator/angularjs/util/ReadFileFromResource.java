package mx.infotec.dads.kukulkan.generator.angularjs.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.infotec.dads.kukulkan.metamodel.util.FileUtil;

public class ReadFileFromResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadFileFromResource.class);

    private ReadFileFromResource() {

    }

    public static void test(String[] args) throws IOException {
        System.out.println(ReadFileFromResource.saveFile(
                "templates/archetypes/angularjs-spring-mongo/src/main/webapp/content/images/logo-jhipster.png",
                Paths.get("/home/daniel/bot/logo-jhipster.png")));
    }

    public static boolean saveFile(String templatePath, Path to) {
        LOGGER.info("saveFile to: {}", to.toString());
        System.out.println("template: " + "templates/" + templatePath);
        try {
            ClassLoader classLoader = ReadFileFromResource.class.getClassLoader();
            File file = new File(classLoader.getResource("templates/" + templatePath).getFile());
            Path from = file.toPath();
            FileUtil.copy(from, to);
        } catch (IOException e) {
            System.out.println("template not found: " + templatePath);
            return false;
        }
        return true;
    }

}