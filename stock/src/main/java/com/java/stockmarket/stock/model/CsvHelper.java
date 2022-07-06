package com.java.stockmarket.stock.model;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsvHelper {

    public static String TYPE = "text/csv";

    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    private static double parseStringToDouble(String value) {
        return value == null || value.isEmpty() ? 0.0 : Double.parseDouble(value);
    }

    private static int parseStringToInteger(String value) {
        return value == null || value.isEmpty() ? 0 : Integer.parseInt(value);
    }

    private static long parseStringToLong(String value) {
        return value == null || value.isEmpty() ? 0 : Long.parseLong(value);
    }

    public static List<Stock> csvToStocks(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                CSVParser csvParser = new CSVParser(fileReader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            List<Stock> stockDtoList = new ArrayList<Stock>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
                Date res = df.parse(csvRecord.get("date"));

                Stock newStock = new Stock(
                        parseStringToInteger(csvRecord.get("quarter")),
                        csvRecord.get("stock"),
                        res,
                        csvRecord.get("open"),
                        csvRecord.get("high"),
                        csvRecord.get("low"),
                        csvRecord.get("close"),
                        parseStringToLong(csvRecord.get("volume")),
                        parseStringToDouble(csvRecord.get("percent_change_price")),
                        parseStringToDouble(csvRecord.get("percent_change_volume_over_last_wk")),
                        parseStringToLong(csvRecord.get("previous_weeks_volume")),
                        csvRecord.get("next_weeks_open"),
                        csvRecord.get("next_weeks_close"),
                        parseStringToDouble(csvRecord.get("percent_change_next_weeks_price")),
                        parseStringToInteger(csvRecord.get("days_to_next_dividend")),
                        parseStringToDouble(csvRecord.get("percent_return_next_dividend"))
                );
                stockDtoList.add(newStock);
            }
            return stockDtoList;
        } catch (Exception e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}