package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

    public static ExtentReports extent;

    public static ExtentReports getReport() {

        if (extent == null) {

            String timeStamp =
            new java.text.SimpleDateFormat("yyyyMMdd_HHmmss")
            .format(new java.util.Date());

            // History report
            ExtentSparkReporter historySpark =
            new ExtentSparkReporter(
            "reports/amazon-report_" + timeStamp + ".html");

            // Latest report for Jenkins
            ExtentSparkReporter latestSpark =
            		new ExtentSparkReporter("reports/AmazonReport.html");


            extent = new ExtentReports();

            extent.attachReporter(historySpark, latestSpark);

            extent.setSystemInfo("Project", "Amazon POM Framework");

            extent.setSystemInfo("Tester", "QA Automation");
        }
        //jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj

        return extent;
    }
}