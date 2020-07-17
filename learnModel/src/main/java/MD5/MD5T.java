package MD5;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 11:15 2020/7/17
 * @ Modified By：
 * @Version: 1.0.0
 */
public class MD5T {
    public static void main(String[] args) {
        String value = "123456";
        try {
            //加密对象，指定加密方式
            MessageDigest md5 = MessageDigest.getInstance("md5");
            //准备要加密的数据
            byte[] b = value.getBytes();
            //加密
            byte[] digest = md5.digest(b);
            //十六进制的字符
            char[] chars = new char[] { '0', '1', '2', '3', '4', '5',
                    '6', '7' , '8', '9', 'A', 'B', 'C', 'D', 'E','F' };
            StringBuffer stringBuffer = new StringBuffer();
            //处理成十六进制的字符串(通常)
            for (byte bb: digest){
                stringBuffer.append(chars[(bb >> 4) & 15]);
                stringBuffer.append(chars[bb & 15]);
            }
            //打印加密后的字符串
            System.out.println(stringBuffer);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        System.out.println("DigestUtils.md5Hex(value.getBytes)>>>" + DigestUtils.md5Hex(value.getBytes()));
        System.out.println("DigestUtils.md5Hex(value)>>>" + DigestUtils.md5Hex(value));
        System.out.println("DigestUtils.getMd5Digest()>>>" + DigestUtils.getMd5Digest());

    }
}
