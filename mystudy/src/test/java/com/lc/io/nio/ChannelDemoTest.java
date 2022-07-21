package com.lc.io.nio;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

class ChannelDemoTest {
    @Test
    void copy() throws IOException {
        FileInputStream fileInputStream=new FileInputStream("data.txt");
        FileOutputStream fileOutputStream=new FileOutputStream("dataCopy.txt");

        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

        FileChannel fileInputStreamChannel = fileInputStream.getChannel();
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();

        int readCount = 0;
        while (readCount>=0) {
            try {
                byteBuffer.clear();
                readCount=fileInputStreamChannel.read(byteBuffer);
                byteBuffer.flip();
                fileOutputStreamChannel.write(byteBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        fileInputStream.close();
        fileOutputStream.close();

    }

    @Test
    public void read() throws FileNotFoundException {
        FileInputStream fileInputStream=new FileInputStream("data.txt");
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        try {
            channel.read(byteBuffer);
            byteBuffer.flip();
            System.out.println(new String(byteBuffer.array(),0,byteBuffer.remaining()));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                channel.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void write() throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("data.txt");
        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("123456".getBytes(StandardCharsets.UTF_8));

        byteBuffer.flip();
        try {
            channel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                channel.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}