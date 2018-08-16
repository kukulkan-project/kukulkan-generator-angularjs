/*
 *  
 * The MIT License (MIT)
 * Copyright (c) 2018 Roberto Villarejo Martínez
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package mx.infotec.dads.kukulkan.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

public class ChecksumUtils {

    /**
     * Computes a Map with file names as keys and checksum as values for files
     * in given pathname and sub-directories
     * 
     * @param pathname
     *            A string representation for path
     * @return a Map
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static Map<String, String> computeHashesMap(Path path) throws NoSuchAlgorithmException, IOException {
        Map<String, String> hashesMap = new HashMap<>();
        MessageDigest md = MessageDigest.getInstance("MD5");

        Files.walk(path).filter(filePath -> !filePath.toFile().isDirectory() && !filePath.toString().contains(".git")
                && !filePath.toString().contains(".kukulkan.json")).forEach(filePath -> {
                    try {
                        String hash = getFileChecksum(md, filePath.toFile());
                        // hashesMap.put(filePath.toString().replaceFirst(path.toString(),
                        // ""), hash);
                        Path relativeFilePath = path.relativize(filePath);
                        hashesMap.put(relativeFilePath.toString(), hash);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                });

        return hashesMap;
    }

    /**
     * Computes the checksum for file using the digest
     * 
     * @param digest
     * @param file
     * @return the checksum
     * @throws IOException
     */
    public static String getFileChecksum(MessageDigest digest, File file) throws IOException {

        try (InputStream is = Files.newInputStream(file.toPath());
                DigestInputStream dis = new DigestInputStream(is, digest);) {
            while (dis.read() != -1)
                ;
            dis.close();
            return DatatypeConverter.printHexBinary(digest.digest());
        }
    }

}
