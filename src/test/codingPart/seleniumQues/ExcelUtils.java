package codingPart.seleniumQues;

import org.testng.annotations.Test;

public class ExcelUtils {

    public void readFromExcel() {
//        FileInputStream fs = null;
//        WorkbookDocument workbook = null;
//        try {
//            // Path of the excel file
//            fs = new FileInputStream("C:\\Automation\\InterviewQuestions\\src\\test\\codingPart\\seleniumQues\\TestData.xlsx");
//
//            // Creating a workbook
//            workbook = new XSSFWorkbook(fs);
//            XSSFSheet sheet = workbook.getSheetAt(0);
//            Row row = sheet.getRow(0);
//            System.out.println("Row: " + row);
//
//            Cell cell = row.getCell(0);
//            System.out.println("Cell: " + cell);
//
//        } catch (IOException e) {
//            System.out.println("Exception occurred while reading file " + e);
//        } finally {
//            try {
//                if (workbook != null) {
//                    workbook.close();
//                }
//                if (fs != null) {
//                    fs.close();
//                }
//            } catch (IOException e) {
//                System.out.println("Exception occurred while closing resources " + e);
//            }
//        }
    }

    @Test
    public void ty() {
        ExcelUtils e = new ExcelUtils();
        e.readFromExcel();

        String[] str = new String[]{"A", "B"};

        String s = null;
        System.out.println(s.toLowerCase());
//        ArrayList list;
//
//        for(int i=0;i<str.length;i++){
//            list.add(str[i]);
//        }
    }
}
