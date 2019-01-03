package mx.infotec.dads.kukulkan.generator.util;

import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.BASE_64_SECRET_LENGTH;

import java.security.SecureRandom;
import java.util.Base64;

public class GeneratorUtils {

    private GeneratorUtils() {
    }

    public static String getBase64Secret(int length) {
        SecureRandom random = new SecureRandom();
        byte[] randomBytes = new byte[length];
        random.nextBytes(randomBytes);
        return Base64.getEncoder().encodeToString(randomBytes).substring(0, BASE_64_SECRET_LENGTH);
    }

}
