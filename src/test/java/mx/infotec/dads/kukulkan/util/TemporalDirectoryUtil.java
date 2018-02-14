package mx.infotec.dads.kukulkan.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author erik.valdivieso
 */
public final class TemporalDirectoryUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemporalDirectoryUtil.class);

    private static final String TEMPORAL_PATH = buildTemporalPath();

    private static String buildTemporalPath() {
        String tempDir;

        try {
            Path p = Files.createTempDirectory("refactoring");
            tempDir = p.toString();
        } catch (IOException ex) {
            LOGGER.error("Can't create temporal file, create alter directory", ex);

            String systemTempDir = System.getProperty("java.io.tmpdir");
            
            if (systemTempDir == null) {
                LOGGER.error("Can't retrieve system property 'java.io.tmpdir', use current directory instead");
                systemTempDir = "";
            } else {
                systemTempDir += File.separatorChar;
            }
            
            tempDir = systemTempDir + "refactoring";
        }

        LOGGER.debug("Temporal dir: {}", tempDir);
        (new File(tempDir)).deleteOnExit();
        return tempDir;
    }

    public static String getTemporalPath() {
        return TEMPORAL_PATH;
    }

    public static void deleteTemporalDir() {
        LOGGER.debug("Delete temporal dir: {}", TEMPORAL_PATH);
        delete(new File(TEMPORAL_PATH));
    }

    private static void delete(File dir) {
        if (dir != null && dir.exists()) {
            if (dir.isDirectory()) {
                for (File file : dir.listFiles()) {
                    delete(file);
                }
            }
            
            if(!dir.delete()) {
                LOGGER.warn("Can't delete {} file", dir.getAbsoluteFile());
            }
        }
    }

}
