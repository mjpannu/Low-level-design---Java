package file;

public class File extends FileNode{

    private int size;
    public File(String name, int size){
        super(name);
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}
