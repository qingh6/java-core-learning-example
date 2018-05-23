package org.javacore.ioio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * lqh
 */
public class FileOutputStreamTest {

    public static void main(String[] args) throws Exception{
        String file = "C:/stream.txt";
        String charset = "UTF-8";
        // 写字符换转成字节流
        FileOutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, charset);
        try {
            writer.write("这是要保存的中文字符rrrr");
        } finally {
            writer.close();
        }
        // 读取字节转换成字符
        FileInputStream inputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(inputStream, charset);
        StringBuffer buffer = new StringBuffer();
        char[] buf = new char[64];
        int count = 0;
        try {
            while ((count = reader.read(buf)) != -1) {
                buffer.append(buffer, 0, count);
            }
        } finally {
            reader.close();
        }
    }
}
