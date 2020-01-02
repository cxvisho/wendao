package org.linlinjava.litemall.gameserver.data;

import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;
import java.util.List;

public class GameWriteTool {
    public static final Charset DEFAULT_CHARSET = Charset.forName("GBK");
    public static final int INT = 4;

    public static final boolean writeArraySize(ByteBuf buff, List<?> list) {
        try {
            buff.writeByte(list.size());
            return true;
        } catch (NullPointerException e) {
            buff.writeByte(0);
        }
        return false;
    }

    public static final void writeInt(ByteBuf buff, Integer value) {
        if (value == null) {
            value = Integer.valueOf(0);
        }
        buff.writeInt(value.intValue());
    }

    public static final void writeString(ByteBuf buff, String value) {
        if (value == null) {
            buff.writeByte(0);
            return;
        }
        byte[] bytes = value.getBytes(DEFAULT_CHARSET);

        buff.writeByte(bytes.length);
        buff.writeBytes(bytes);
    }

    public static final void writeString2(ByteBuf buff, String value) {
        if (value == null) {
            buff.writeShort(0);
            return;
        }
        byte[] bytes = value.getBytes(DEFAULT_CHARSET);

        buff.writeShort(bytes.length);
        buff.writeBytes(bytes);
    }

    public static final void writeLong(ByteBuf buff, Long value) {
        if (value == null) {
            value = Long.valueOf(0L);
        }
        buff.writeLong(value.longValue());
    }

    public static final void writeShort(ByteBuf buff, Integer value) {
        if (value == null) {
            value = Integer.valueOf(0);
        }
        buff.writeShort(value.intValue());
    }

    public static final void writeByte(ByteBuf buff, Integer value) {
        if (value == null) {
            value = Integer.valueOf(0);
        }
        buff.writeByte(value.intValue());
    }

    public static final void writeBoolean(ByteBuf buff, boolean value) {
        if (value) {
            buff.writeByte(1);
        } else {
            buff.writeByte(0);
        }
    }

    public static final void writeZero(ByteBuf buff, Integer length) {
        buff.writeZero(length.intValue());
    }

    public static final byte[] toArray(ByteBuf buff) {
        byte[] b = new byte[buff.readableBytes()];
        buff.readBytes(b);
        return b;
    }


    public static void writeBytes(ByteBuf writeBuf, byte[] bytes) {
        writeBuf.writeBytes(bytes);
    }

    public static void writeLenBuffer2(ByteBuf writeBuf, byte[] bytes) {
        writeBuf.writeShort(bytes.length);
        writeBuf.writeBytes(bytes);
    }
}


/* Location:              C:\Users\Administrator\Desktop\gameserver-0.1.0.jar!\org\linlinjava\litemall\gameserver\data\GameWriteTool.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */