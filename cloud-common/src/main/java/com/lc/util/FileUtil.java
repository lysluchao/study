package com.lc.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * @Description: 文件工具类
 * @Auther: LuChao
 * @Date: 2022/8/9 14:05
 * @Version: v1.0
 */
public class FileUtil {

    public static final String RESOURCES_PATH = System.getProperty("user.dir") + "src\\main\\resources";

    public static boolean deleteFile(File file) throws IOException {
        //判断文件不为null或文件目录存在
        if (file == null || !file.exists()) {
            throw new IOException("文件删除失败, 请检查文件路径是否正确");
        }
        //取得这个目录下的所有子文件对象
        File[] files = file.listFiles();
        //遍历该目录下的文件对象
        assert files != null;
        for (File f : files) {
            //打印文件名
            String name = file.getName();
            System.out.println(name);
            //判断子目录是否存在子目录,如果是文件则删除
            if (f.isDirectory()) {
                deleteFile(f);
            } else {
                return f.delete();
            }
        }
        //删除空文件夹 for循环已经把上一层节点的目录清空。
        return file.delete();
    }

    /**
     * Delete the files specified by names in absolute file path.
     *
     * @param absolutePath    Where deleted files stored.
     * @param deleteFileNames file's names
     * @return true if successfully delete specified files
     */
    public static boolean deleteFilesInDir(String absolutePath, String... deleteFileNames) throws FileNotFoundException {
        File baseDir = new File(absolutePath);
        if (!baseDir.exists()) {
            throw new FileNotFoundException("File not found in " + absolutePath);
        }

        File[] files = baseDir.listFiles();

        if (files == null) {
            return false;
        }
        boolean deleteResult = false;

        for (File file : files) {
            String fileName = file.getName();
            if (file.isFile()) {
                for (String deleteFileName : deleteFileNames) {
                    if (deleteFileName.equals(fileName)) {
                        deleteResult = file.delete();
                    }
                }
            } else if (file.isDirectory()) {
                deleteFilesInDir(absolutePath + File.separator + fileName, deleteFileNames);
            }
        }
        return deleteResult;
    }
}

