import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Excel sheet = new Excel();

        sheet.setCellValue(0,0,10);
        sheet.setCellValue(0,1,20);

        List<CellAddress> dependencies = new ArrayList<>();
        dependencies.add(new CellAddress(0,0));
        dependencies.add(new CellAddress(0,1));

        sheet.setFormula(0,2, "A1+B1", dependencies);

        sheet.printSpreadSheet(1, 3);

        // Change value in A1, and C1 should update automatically
        sheet.setCellValue(0, 0, 15);
        sheet.printSpreadSheet(1, 3);

    }
}