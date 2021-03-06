package com.ezsyncxz.efficiency.entity;

import com.ezsyncxz.efficiency.rsync.Rsync;
import com.sun.corba.se.impl.orbutil.concurrent.Sync;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName FileFragment
 * @Description TODO
 * @Author chenwj
 * @Date 2020/2/26 14:01
 * @Version 1.0
 **/

@Getter
@Setter
@NoArgsConstructor
public class FileFragment {

    /**
     * 数据片段
     */
    private byte[] body;

    /**
     * 目标路径
     */
    private String tarPath;

    /**
     * 文件名
     */
    private String filename;

    /**
     * 是否需要解压，默认为否
     */
    private boolean needCompress = false;

    /**
     * 偏移量
     */
    private int off;

    /**
     * 文件大小
     */
    private long length;

    /**
     * 开始传输的时间戳
     */
    private long startTime;

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public boolean isNeedCompress() {
        return needCompress;
    }

    public void setNeedCompress(boolean needCompress) {
        this.needCompress = needCompress;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public int getOff() {
        return off;
    }

    public void setOff(int off) {
        this.off = off;
    }

    public String getTarPath() {
        return tarPath;
    }

    public void setTarPath(String tarPath) {
        this.tarPath = tarPath;
    }

    private FileFragment(Builder builder) {

        setBody(builder.body);
        setTarPath(builder.tarPath);
        setFilename(builder.filename);
        setNeedCompress(builder.needCompress);
        setOff(builder.off);
        setLength(builder.length);
        setStartTime(builder.startTime);
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private byte[] body;
        private String tarPath;
        private String filename;
        private boolean needCompress;
        private int off;
        private long length;
        private long startTime;

        private Builder() {
        }

        public Builder body(byte[] val) {
            body = val;
            return this;
        }

        public Builder tarPath(String val) {
            tarPath = val;
            return this;
        }

        public Builder filename(String val) {
            filename = val;
            return this;
        }

        public Builder needCompress(boolean val) {
            needCompress = val;
            return this;
        }

        public Builder off(int val) {
            off = val;
            return this;
        }

        public Builder length(long val) {
            length = val;
            return this;
        }

        public Builder startTime(long val) {
            startTime = val;
            return this;
        }

        public FileFragment build() {
            return new FileFragment(this);
        }
    }

    public static void main(String[] args) {
        String b1024 = "abcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefgh";
        String c1024 = "bcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefgha";

        int i = Rsync.adler32(b1024.getBytes());
        int i1 = Rsync.nextAdler32(i, (byte)'a', (byte)'a');
        int i2 = Rsync.adler32(c1024.getBytes());
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);

    }
}
