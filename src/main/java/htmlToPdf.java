import java.io.FileOutputStream;
import java.io.OutputStream;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

public class htmlToPdf
{
    public static void main(String[] args) throws Exception {
        try (OutputStream os = new FileOutputStream("/Users/Eric Young/Documents/Java1/StockCalculator/pdf/out.pdf")) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
//            builder.withUri("file:///Users/Eric Young/Documents/pdf/in.htm");
            builder.withUri("file:html/test.html");
            builder.toStream(os);
            builder.run();
        }
    }
}