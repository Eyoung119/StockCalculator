import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.json.simple.JSONObject;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class textToHtml {
    public static void main(String[] args) throws IOException {
            textToHtml test = new textToHtml();
            test.createHtml();
            test.makePdf();

        }

        int counter = 0;

        private void createHtml() throws IOException {
        readJSON readData = new readJSON();
        List<Person> list = readData.jsonReader();

        for (Person person:list) {
            OutputStream outputStream = new FileOutputStream("htmlfiles/Person" + counter + "testfile.html");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

            outputStreamWriter.write("<!DOCTYPE html>");
            outputStreamWriter.write("<html><body>");

            outputStreamWriter.write(String.format("<h3>(%d) </h3>", person.getAccountNumber()));
            outputStreamWriter.write(String.format("<h3> %s </h3>", person.getFirstName()));
            outputStreamWriter.write(String.format("<h3> %s </h3>", person.getLastName()));
            outputStreamWriter.write(String.format("<h3> %s </h3>", person.getSsn()));
            outputStreamWriter.write(String.format("<h3> %s </h3>", person.getEmail()));
            outputStreamWriter.write(String.format("<h3> %s </h3>", person.getPhone()));

            outputStreamWriter.write("<table>");
            outputStreamWriter.write(String.format("<tr>"));

            outputStreamWriter.write(String.format("<th> %s </th>", "Type"));
            outputStreamWriter.write(String.format("<th> %s </th>", "Symbol"));
            outputStreamWriter.write(String.format("<th> %s </th>", "Shares"));
            outputStreamWriter.write(String.format("<th> %s </th>", "Price Per Share"));

            outputStreamWriter.write(String.format("</tr>"));
            for (Trades trade:person.getStockTrades()) {
                outputStreamWriter.write("<tr>");
                outputStreamWriter.write(String.format("<td> %s </td>", trade.getType()));
                outputStreamWriter.write(String.format("<td> %s </td>", trade.getSymbol()));
                outputStreamWriter.write(String.format("<td> (%d) </td>", trade.getShares()));
                outputStreamWriter.write(String.format("<td> %s </td>", trade.getPricePerShare()));
                outputStreamWriter.write("</tr>");

            }
            outputStreamWriter.write("</table>");

            outputStreamWriter.write("</body></html>");

            outputStreamWriter.close();
            counter += 1;
        }


        }
        private void makePdf() {
        File directory = new File("htmlfiles");
        File[] fileArray = directory.listFiles();

        for(File file:fileArray) {
            String path = file.getAbsolutePath();
            Path filepath = Path.of(path);
            counter += 1;
            try (OutputStream os = new FileOutputStream("pdf/" + counter + "out.pdf")) {
                PdfRendererBuilder builder = new PdfRendererBuilder();
                builder.useFastMode();
                builder.withUri(filepath.toUri().toString());
                builder.toStream(os);
                builder.run();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
