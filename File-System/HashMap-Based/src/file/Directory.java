package file;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Directory extends FileNode{

    private Map<String, FileNode> children;
    public Directory(String name){
        super(name);
        this.children = new HashMap<String, FileNode>();
    }

    public void addNode(FileNode node){
        node.parent = this;
        children.put(node.getName(), node);
    }

    public Map<String, FileNode> getchildren(){
        return children;
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for(FileNode node: children.values()){
            totalSize += node.getSize();
        }
        return totalSize;
    }
}
