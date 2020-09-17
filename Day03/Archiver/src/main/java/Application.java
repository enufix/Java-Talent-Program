import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Application {

    private static final String sevenZip = "7z";
    private static final String zip = "zip";


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the compression algorithm that you want, 7z or zip: ");
        String compressionType = sc.nextLine();

        File directory = new File("files");

        if(compressionType.equals(sevenZip)){

            SevenZipArchiver sevenZipArchiver = new SevenZipArchiver();
            File sevenZipArchive = new File("archive.7z");
            sevenZipArchiver.archive(directory, sevenZipArchive);
            System.out.println("7-Zip file has been created.");

        }else if(compressionType.equals(zip)){

            ZipArchiver zipArchiver = new ZipArchiver();
            File zipArchive = new File("archive.zip");
            zipArchiver.archive(directory,zipArchive);
            System.out.println("Zip file has been created. ");
        }


    }
}
