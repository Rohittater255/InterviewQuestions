package codingPart.testngQues;

import org.testng.IAnnotationTransformer;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomListener implements IAnnotationTransformer, IReporter {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(Retry.class);
    }


    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        File outputDir = new File(outputDirectory);
        if (!outputDir.exists()) {
            outputDir.mkdirs(); // Create the directory if it doesn't exist
        }

        try (FileWriter writer = new FileWriter(outputDirectory + "/custom-report.html")) {
            writer.write("<html><head><title>TestNG Custom Report</title></head><body>");
            writer.write("<h1>TestNG Custom Report</h1>");
            for (ISuite suite : suites) {
                writer.write("<h2>Suite: " + suite.getName() + "</h2>");
                suite.getResults().forEach((testName, result) -> {
                    try {
                        writer.write("<h3>Test: " + testName + "</h3>");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    List<ITestResult> allResults = new ArrayList<>();
                    allResults.addAll(result.getTestContext().getPassedTests().getAllResults());
                    allResults.addAll(result.getTestContext().getFailedTests().getAllResults());

                    // Sort the results by start time
                    List<ITestResult> sortedResults = allResults.stream()
                            .sorted(Comparator.comparingLong(ITestResult::getStartMillis))
                            .collect(Collectors.toList());

                    for (ITestResult testResult : sortedResults) {
                        try {
                            String status = testResult.getStatus() == ITestResult.SUCCESS ? "Passed" : "Failed";
                            writer.write("<p>" + status + ": " + testResult.getName() + "</p>");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
            writer.write("</body></html>");
        } catch (IOException e) {
            System.err.println("Error writing report: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
