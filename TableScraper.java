package Selenium.Project1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TableScraper {
    public static void main(String[] args) {
        String url = "http://the-internet.herokuapp.com/challenging_dom";

        try {
            Document document = Jsoup.connect(url).get();

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

            // Print the table to the console
            for (List<String> rowData : tableData) {
                for (String cellData : rowData) {
                    System.out.print(cellData + "\t");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

