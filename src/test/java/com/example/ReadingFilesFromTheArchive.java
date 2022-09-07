package com.example;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.example.domain.Squad;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static java.nio.charset.StandardCharsets.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ReadingFilesFromTheArchive {

    ClassLoader classLoader = ReadingFilesFromTheArchive.class.getClassLoader();

    @Test
    void pdfReadingFileFromTheArchiveTest() throws Exception {
        ZipFile zipFile = new ZipFile("C:\\Users\\zdor2\\IdeaProjects\\HW_9.WorkingWithFiles\\src\\test\\resources\\CryptoProPDF_UserGuide.zip");
        Enumeration<? extends ZipEntry> entries = zipFile.entries();

        while (entries.hasMoreElements()){
            ZipEntry entry = entries.nextElement();
            InputStream stream = zipFile.getInputStream(entry);
            PDF pdf = new PDF(stream);
            assertThat(pdf.numberOfPages).isEqualTo(25);
        }
    }

    @Test
    void csvReadingFileFromTheArchiveTest() throws Exception {
        ZipFile zipFile = new ZipFile("C:\\Users\\zdor2\\IdeaProjects\\HW_9.WorkingWithFiles\\src\\test\\resources\\Sample_import.zip");
        Enumeration<? extends ZipEntry> entries = zipFile.entries();

        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            InputStream stream = zipFile.getInputStream(entry);
            CSVReader csvReader = new CSVReader(new InputStreamReader(stream, UTF_8));
            List<String[]> csv = csvReader.readAll();
            assertThat(csv).contains(
                    new String[] {"1;Куриный бульон по-бургундски;"},
                    new String[] {"2;Вафли из печеньев слоеные с тестом;"},
                    new String[] {"3;Суп;"},
                    new String[] {"4;Вареник;"}
            );
        }
    }

    @Test
    void xlsReadingFileTheArchiveTest() throws Exception {
        ZipFile zipFile = new ZipFile("C:\\Users\\zdor2\\IdeaProjects\\HW_9.WorkingWithFiles\\src\\test\\resources\\laboratorii_1.zip");
        Enumeration<? extends ZipEntry> entries = zipFile.entries();

        while (entries.hasMoreElements()){
            ZipEntry entry = entries.nextElement();
            InputStream stream = zipFile.getInputStream(entry);
            XLS xls = new XLS(stream);
            assertThat(
                    xls.excel.getSheetAt(0)
                            .getRow(2)
                            .getCell(2)
                            .getStringCellValue()
            ).isEqualTo("Наименование юр.лица");
        }
    }


    @Test
    void pdfReadingFileFromTheArchiveTest2() throws Exception {
        ZipFile zipFile = new ZipFile("C:\\Users\\zdor2\\IdeaProjects\\HW_9.WorkingWithFiles\\src\\test\\resources\\CryptoProPDF_UserGuide.zip");
        Enumeration<? extends ZipEntry> entries = zipFile.entries();

        while (entries.hasMoreElements()){
            ZipEntry entry = entries.nextElement();
            InputStream stream = zipFile.getInputStream(entry);
            PDF pdf = new PDF(stream);
            assertThat(pdf.text).contains("АННОТАЦИЯ");
        }
    }
}
