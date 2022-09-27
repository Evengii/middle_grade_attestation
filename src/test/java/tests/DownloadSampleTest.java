package tests;

import configs.Config;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DigitalDownloadsPage;
import java.io.File;
import java.io.IOException;
import static com.codeborne.selenide.Selenide.open;

/*
    1. Download file
        Assert it downloaded and appeared in default folder
    2. Delete directory with the file

 */

public class DownloadSampleTest extends BaseTest{
    DigitalDownloadsPage digitalDownloadsPage = new DigitalDownloadsPage();

    @Test
    public void downloadSample() throws IOException {
        open(Config.getDigitalDownloads());
        digitalDownloadsPage.openItemPage("Picture of Music 2");

        File report = digitalDownloadsPage.getDownloadBtn().download();
        Assert.assertTrue(report.exists(), "File is not downloaded");
        FileUtils.deleteDirectory(new File(report.getParent()));
        System.out.println(report.getParent());
        Assert.assertFalse(report.exists(), "File still exist");
    }
}
