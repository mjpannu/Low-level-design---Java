import file.Directory;
import file.File;
import file.FileSystem;


public class Main {
    public static void main(String[] args) {


        FileSystem fs = new FileSystem(2);
        Directory root = fs.getRoot();
        Directory docs = new Directory("docs");
        Directory music = new Directory("music");
        root.addNode(docs);
        root.addNode(music);

        boolean fileInserted =  fs.insertFile("song1.mp3", 10, "music");
        System.out.println("File insertion success:"  + fileInserted);

        fileInserted =  fs.insertFile("resume.pdf", 50, "invalid-dir");
        System.out.println("File insertion success:"  + fileInserted);

        fileInserted =  fs.insertFile("resume.pdf", 50, "docs");
        System.out.println("File insertion success:"  + fileInserted);

        fileInserted =  fs.insertFile("song2.mp3", 10, "music");
        System.out.println("File insertion success:"  + fileInserted);

        for(File file : fs.getRecenFiles()){
            System.out.println(file.getName());
        }

    }
}