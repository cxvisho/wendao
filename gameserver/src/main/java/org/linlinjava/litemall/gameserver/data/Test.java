package org.linlinjava.litemall.gameserver.data;

import java.io.PrintStream;

public class Test {
    public static void main(String[] args) {
        String arr = "多闻道人";
        byte[] sb = arr.getBytes();

        System.out.println(bytesToHexString(sb));
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if ((src == null) || (src.length <= 0)) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\Test.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */