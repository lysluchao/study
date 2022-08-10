package com.lc.lucene.util;

import lombok.extern.log4j.Log4j;

import java.io.File;

/**
 * @Description: 文件工具类
 * @Auther: LuChao
 * @Date: 2022/8/9 14:05
 * @Version: v1.0
 */
@Log4j
public class FileUtil {
    public static final String RESOURCES_PATH = System.getProperty("user.dir") + "src\\main\\resources";

    public static boolean deleteFile(File file) {
        //判断文件不为null或文件目录存在
        if (file == null || !file.exists()) {
            log.error("文件删除失败, 请检查文件路径是否正确");
            return false;
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
}
