package api;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
//import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

public class FetchAndExport {
    public static void main(String[] args) {
        String url = "https://data.sfgov.org/resource/p4e4-a5a7.json";

        try {
            // Create an HttpClient to send an HTTP GET request
            HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = httpClient.execute(httpGet);

            // Check if the response code is 200 (OK)
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                String html = EntityUtils.toString(entity);

                // fetch the HTML content with Jsoup
                Document document = Jsoup.parse(html);

                // Locate the table element you want to scrape (you may need to adjust this)
                Element table = document.select("table").first();

                // Initialize a list to store table rows
                List<List<String>> tableData = new ArrayList<>();

                // Iterate through the rows of the table
                Elements rows = table.select("tr");
                for (Element row : rows) {
                    Elements cells = row.select("td");
                    List<String> rowData = new ArrayList<>();
                    for (Element cell : cells) {
                        rowData.add(cell.text());
                    }
                    tableData.add(rowData);
                }

                // Export data to a CSV file
                writeToCSV(tableData, "table_data.csv");
                System.out.println("Data exported to table_data.csv");
            } else {
                System.out.println("HTTP GET request failed with status code: " + response.getStatusLine().getStatusCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToCSV(List<List<String>> data, String filePath) {
        try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(filePath), CSVFormat.DEFAULT)) {
            for (List<String> row : data) {
                csvPrinter.printRecord(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
//    public void currentTimestamp {
//            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yy-HH-mm-ss");
//            String formattedDate = sdf.format(new Date());
//            System.out.println(formattedDate);
//        }
    
  
}

