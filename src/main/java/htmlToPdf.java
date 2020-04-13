import java.io.FileOutputStream;
import java.io.OutputStream;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

public class htmlToPdf
{
    public static void main(String[] args) throws Exception {
        try (OutputStream os = new FileOutputStream("/Users/Eric Young/Documents/pdf/out.pdf")) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withUri("file:///Users/Eric Young/Documents/pdf/in.htm");
            builder.toStream(os);
            builder.run();
        }
    }
}