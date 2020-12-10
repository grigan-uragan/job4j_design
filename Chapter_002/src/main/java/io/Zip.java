package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    private List<File> packageList(ArgZip argZip) throws IOException {
        SearchFile searchFile = new SearchFile(path -> !path.toString().endsWith(argZip.exclude()));
        Files.walkFileTree(Path.of(argZip.directory()), searchFile);
        return searchFile.getFiles();
    }

    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {

                sources.forEach(file -> {
                   try (BufferedInputStream in =
                                new BufferedInputStream(new FileInputStream(file))) {
                       zip.putNextEntry(new ZipEntry(file.getPath()));
                       zip.write(in.readAllBytes());
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
                });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip =
                     new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArgZip argZip = new ArgZip(args);
        Zip zip = new Zip();
        try {
            zip.packFiles(zip.packageList(argZip), new File(argZip.output()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
