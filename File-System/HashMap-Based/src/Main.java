import file.Directory;
import file.File;
import file.FileSystem;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println(Thread.activeCount());
        System.out.println(Runtime.getRuntime().availableProcessors());

        // Initialize FileSystem with a cache size of 3
//        FileSystem fileSystem = new FileSystem(3);
//
//        // Add directories
//        fileSystem.addDirectory("docs", "root");
//        fileSystem.addDirectory("images", "root");
//
//        // Insert files
//        fileSystem.insertFile("file1.txt", 100, "docs");
//        fileSystem.insertFile("file2.txt", 200, "docs");
//        fileSystem.insertFile("image1.png", 300, "images");
//
//        // Retrieve and display file details
//        File file1 = fileSystem.getFile("file1.txt");
//        File file2 = fileSystem.getFile("file2.txt");
//        File image1 = fileSystem.getFile("image1.png");
//
//        System.out.println("File1: " + (file1 != null ? file1.getName() + ", Size: " + file1.getSize() : "Not found"));
//        System.out.println("File2: " + (file2 != null ? file2.getName() + ", Size: " + file2.getSize() : "Not found"));
//        System.out.println("Image1: " + (image1 != null ? image1.getName() + ", Size: " + image1.getSize() : "Not found"));
//
//        // Access files to update recent cache
//        fileSystem.getFile("file1.txt"); // This should update recent files cache
//        fileSystem.getFile("image1.png"); // This should update recent files cache
//
//        // Display top recent files
//        List<File> recentFiles = fileSystem.getRecenFiles();
//        System.out.println("Top Recent Files:");
//        for (File file : recentFiles) {
//            System.out.println(file.getName() + ", Size: " + file.getSize());
//        }
    }
}
