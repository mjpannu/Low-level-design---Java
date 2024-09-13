package file;

import cache.LRUcache;

import java.util.List;

public class FileSystem {

    private final Directory root;
    private final LRUcache cache;

    public FileSystem(int cacheSize ) {
        root = new Directory("root");
        cache = new LRUcache(2);
    }

    public Directory getRoot(){
        return root;
    }

    public boolean insertFile(String filename, int size, String parentDirectoryName){
        Directory parent = findDirectory(root, parentDirectoryName);
        if(parent != null) {
            File newFile = new File(filename, size);
            parent.addNode(newFile);
            cache.accessFile(newFile);
            return true;
        }
        return false;
    }

    public List<File> getRecenFiles(){
        return cache.getRecentFiles();
    }

    private Directory findDirectory(Directory current, String name){
        if(current.name.equals(name)){
            return current;
        }
        for(FileNode child : current.getchildren()){
            if(child instanceof Directory){
                Directory result = findDirectory((Directory)child, name);
                if(result != null){
                    return result;
                }
            }
        }
        return null;
    }
}
