import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Excel {

    private final Map<CellAddress, Cell> cells;
    private final Map<CellAddress, List<CellAddress>> dependencyGraph;

    public Excel(){
        cells  = new HashMap<>();
        dependencyGraph = new HashMap<>();
    }
// Get and evaluate are connected
    public Object getCellValue(int row, int col){
        CellAddress address = new CellAddress(row, col);
        Cell cell = cells.get(address);
        if(cell == null) return null;

        if(cell.getFormula() != null){
            return evaluateFormula(cell.getFormula(), cell.getDependencies());
        }
        return cell.getValue();
    }

    public Object evaluateFormula(String formula, List<CellAddress> dependencies){
        double sum = 0;
        for(CellAddress address : dependencies){
            Object value = getCellValue(address.getRow(), address.getCol());
            if(value instanceof Number) {
                sum += ((Number) value).doubleValue();
            }
        }
        return sum;
    }

    public void setCellValue(int row, int col, Object value){
        CellAddress address = new CellAddress(row, col);
        cells.put(address, new Cell(value));
        recalculateDependencies(address);
    }

    public void recalculateDependencies(CellAddress address){
        if(dependencyGraph.containsKey(address)){
            for(CellAddress dependent : dependencyGraph.get(address)){
                Cell dependentCell = cells.get(dependent);
                if(dependentCell != null && dependentCell.getFormula() != null){
                    dependentCell.setValue(evaluateFormula(dependentCell.getFormula(), dependentCell.getDependencies()));
                    recalculateDependencies(dependent);
                }
            }
        }
    }

    public void setFormula(int row, int col, String formula, List<CellAddress> dependencies) {
        CellAddress address = new CellAddress(row, col);
        Cell cell = new Cell(formula);
        cells.put(address, cell);

        for(CellAddress dep : dependencies){
            dependencyGraph.computeIfAbsent(dep, k-> new ArrayList<>()).add(address);
            cell.addDependencies(dep);
        }
        recalculateDependencies(address);
    }

    public void printSpreadSheet(int rows, int cols){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                Object value = getCellValue(i, j);
                System.out.print((value == null ? "null" : value)+"\t");
            }
            System.out.println();
        }
    }

}
