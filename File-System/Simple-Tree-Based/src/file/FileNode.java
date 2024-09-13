package file;

public abstract class FileNode {

    protected String name;
    protected Directory parent;

    public FileNode(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public abstract int getSize();
}
