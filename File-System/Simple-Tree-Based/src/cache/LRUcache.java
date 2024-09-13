package cache;

import file.File;
import file.FileNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;

public class LRUcache {

    private final int capacity;
    private final Map<String, File> cache;
    private final LinkedList<File> list;

    public LRUcache(int capacity){
        this.capacity =  capacity;
        cache = new HashMap<>();
        list = new LinkedList<File>();
    }

    public void accessFile(File file){
        if(cache.containsKey(file.getName())){
            list.remove(file);
        } else {
            if(cache.size() >= capacity){
                String oldest = list.removeLast().getName();
                cache.remove(oldest);

            }
        }
        list.addFirst(file);
        cache.put(file.getName(), file);
    }

    public List<File> getRecentFiles(){
        return list;
    }

}
