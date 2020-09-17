import net.lingala.zip4j.ZipFile;
import java.io.File;
import java.io.IOException;


public class ZipArchiver implements Archiver{

    public void archive(File directory, File archive) throws IOException {

        new ZipFile(archive).addFolder(directory);

    }
}
