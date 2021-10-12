package com.netup;

import java.io.*;

public class StreamUtils {
    /**
     * 功能：酱输入流转为byte【】，可以吧文件内容读到byte【】中去
     * @version 1.8
     * @return**/
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int len;
        while ((len=is.read(b))!=-1){
            bos.write(b,0,len);//把读取到的数据写入到dos中
        }
        byte[] array =bos.toByteArray();//然后将dos转成字节数组
        bos.close();
        return array;
    }

    /**
     * @version 1.8
     *功能：可以把一个输入流的数据直接转换成字符串
     **/
    public static String streamToString(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line=reader.readLine()) != null){
            builder.append(line+"\r\n");
        }
        return builder.toString();
    }
}
