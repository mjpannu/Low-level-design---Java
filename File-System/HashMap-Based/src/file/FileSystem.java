package file;

import cache.LRUcache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystem {

    private final Directory root;
    private final LRUcache cache;
    private final Map<String, Directory> directoryMap;
    private final Map<String, File> fileMap;

    public FileSystem(int cacheSize ) {
        root = new Directory("root");
        cache = new LRUcache(cacheSize);
        directoryMap = new HashMap<>();
        directoryMap.put("root", root);
        fileMap =  new HashMap<>();
    }

    public Directory getRoot(){
        return root;
    }

    public boolean insertFile(String filename, int size, String parentDirectoryName){
        Directory parent = directoryMap.get(parentDirectoryName);
        if(parent != null) {
            File newFile = new File(filename, size);
            parent.addNode(newFile);
            fileMap.put(filename, newFile);
            cache.accessFile(newFile);
            return true;
        }
        return false;
    }

    public boolean addDirectory(String name, String parentDirectory){
        Directory parent = directoryMap.get(parentDirectory);
        if(parent == null) return false;
        Directory newDirectory = new Directory(name);
        parent.addNode(newDirectory);
        directoryMap.put(name, newDirectory);
        return true;
    }

    public File getFile (String filename){
        return fileMap.get(filename);
    }

    public List<File> getRecenFiles(){
        return cache.getRecentFiles();
    }

}
