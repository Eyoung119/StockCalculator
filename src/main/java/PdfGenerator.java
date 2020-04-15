import java.io.FileOutputStream;
import java.io.OutputStream;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

public class PdfGenerator
{
    public static void main(String[] args) throws Exception {
       PdfGenerator pdfGen = new PdfGenerator();
       pdfGen.run();
    }

    private void run() {
        readJSON jsonRead = new readJSON();
        jsonRead.jsonReader();
    }
}