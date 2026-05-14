//package base;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//public class ReportManager {
//
//    public static ExtentReports extent;
//
//    public static ExtentReports getReport() {
//
//        if (extent == null) {
//
//            ExtentSparkReporter spark = new ExtentSparkReporter("amazon-report.html");
//
//            extent = new ExtentReports();
//            extent.attachReporter(spark);
//
//            extent.setSystemInfo("Project", "Amazon Automation");
//            extent.setSystemInfo("Tester", "Preetham");
//            extent.setSystemInfo("Environment", "QA");
//        }
//
//        return extent;
//    }
//}

package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

    public static ExtentReports extent;

    public static ExtentReports getReport() {

        if (extent == null) {

            ExtentSparkReporter spark = new ExtentSparkReporter("amazon-report.html");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Project", "Amazon POM Framework");
            extent.setSystemInfo("Tester", "QA Automation");
        }

        return extent;
    }
}