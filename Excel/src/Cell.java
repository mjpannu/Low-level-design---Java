import java.util.ArrayList;
import java.util.List;

public class Cell {

    private Object value;
    private String formula;
    private List<CellAddress> dependencies;

    public Cell(Object value){
        this.value = value;
        this.formula = "";
        this.dependencies = new ArrayList<>();
    }

    public Cell(String formula){
        this.value = null;
        this.formula = formula;
        this.dependencies = new ArrayList<>();
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public List<CellAddress> getDependencies() {
        return dependencies;
    }

    public void addDependencies(CellAddress dependency){
        dependencies.add(dependency);
    }
}

