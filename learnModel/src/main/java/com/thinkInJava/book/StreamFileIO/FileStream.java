package com.thinkInJava.book.StreamFileIO;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
@Slf4j
public class FileStream {

    public static void main(String[] args) {
        FileStream fileStream = new FileStream();
//        fileStream.getFileInputStream();
//        fileStream.fileStreamB();
        fileStream.createDir();
    }

    /**
     * 会乱码
     */
    public void  getFileInputStream() {
        {
            try {
                byte bWrite[] = {11, 21, 98,99, 3, 40, 5};
                OutputStream os = new FileOutputStream("D:/test1219.txt");
                for (int x = 0; x < bWrite.length; x++) {
                    os.write(bWrite[x]);
                }
                os.close();
                InputStream is = new FileInputStream("D:/test1219.txt");
                int size = is.available();
                for (int i = 0; i < size; i++) {
                    System.out.println((char) is.read() + " ");
                }
                is.close();
            } catch (IOException e) {
                log.info(e.getMessage(),e);
            }
        }
    }

    public void fileStreamB(){

        try {
            File f = new File("D:/a1.txt");
            //构建FIle OutPut Stream对象，文件不存在会自动新建
            FileOutputStream fop = new FileOutputStream(f);

            //构建outputStreamWriter对象，参数可以指定编码，默认为操作系统默认编码，windows上是gbk
            OutputStreamWriter writer = new OutputStreamWriter(fop,"UTF-8");

            //写入到缓冲区
            writer.append("中文输入");

            //换行
            writer.append("\r\n");

            //刷新缓冲区，写入到文件，如果厦门已经没有写入的内容，直接close也会写入
            writer.append("English");

            //关闭写入流，同时会把缓冲区内容写入文件
            writer.close();

            //关闭输出流，释放系统资源
            fop.close();

            //构建FileInputStream对象
            FileInputStream fip = new FileInputStream(f);

            //构建InputStreamReader对象，编码与写入相同
            InputStreamReader reader = new InputStreamReader(fip, "UTF-8");

            StringBuffer sb = new StringBuffer();
            while (reader.ready()){
                sb.append((char) reader.read());
            }
            log.info(sb.toString());
            //关闭读取流
            reader.close();

            //关闭输入流，释放系统资源
            fip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建目录
     * mkdirs()可以建立多级文件夹， mkdir()只会建立一级的文件夹，
     */

    public void createDir(){
        String dirName = "D:/createDir/p1/s1";
        File d = new File(dirName);
        boolean flag =d.mkdirs();
        log.info("flag:" + flag);
    }
}
