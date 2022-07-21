package com.lc.io.nio;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

class BufferDemoTest {

    @Test
    public void bufferDemo(){
        ByteBuffer allocate = ByteBuffer.allocate(10);
        print(allocate);
        allocate.put("nihaoa".getBytes(StandardCharsets.UTF_8));
        print(allocate);

        allocate.flip();
        print(allocate);

        byte[] b1=new byte[2];
        allocate.get(b1);
        System.out.println(new String(b1, StandardCharsets.UTF_8));
        print(allocate);

        //使用reset方法可以返回mark时的值
        allocate.mark();

        byte[] b2=new byte[2];
        allocate.get(b2);
        System.out.println(new String(b2, StandardCharsets.UTF_8));
        print(allocate);

        allocate.reset();
        print(allocate);

    }

    private void print(ByteBuffer allocate) {
        System.out.println("-----------");
        System.out.println(allocate.position());
        System.out.println(allocate.limit());
        System.out.println(allocate.capacity());
    }


}