//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.format.annotation.DateTimeFormat;

public class Daili implements Cloneable, Serializable {
    public static final Boolean IS_DELETED;
    public static final Boolean NOT_DELETED;
    private Integer id;
    private String account;
    private String passwd;
    private String code;
    private String token;
    @JsonDeserialize(
            using = LocalDateTimeDeserializer.class
    )
    @JsonSerialize(
            using = LocalDateTimeSerializer.class
    )
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private LocalDateTime addTime;
    @JsonDeserialize(
            using = LocalDateTimeDeserializer.class
    )
    @JsonSerialize(
            using = LocalDateTimeSerializer.class
    )
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private LocalDateTime updateTime;
    private Boolean deleted;
    private static final long serialVersionUID = 1L;

    public Daili() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswd() {
        return this.passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getAddTime() {
        return this.addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public LocalDateTime getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public void andLogicalDeleted(boolean deleted) {
        this.setDeleted(deleted ? Daili.Deleted.IS_DELETED.value() : Daili.Deleted.NOT_DELETED.value());
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(this.hashCode());
        sb.append(", IS_DELETED=").append(IS_DELETED);
        sb.append(", NOT_DELETED=").append(NOT_DELETED);
        sb.append(", id=").append(this.id);
        sb.append(", account=").append(this.account);
        sb.append(", passwd=").append(this.passwd);
        sb.append(", code=").append(this.code);
        sb.append(", token=").append(this.token);
        sb.append(", addTime=").append(this.addTime);
        sb.append(", updateTime=").append(this.updateTime);
        sb.append(", deleted=").append(this.deleted);
        sb.append("]");
        return sb.toString();
    }

    public boolean equals(Object that) {
        if (this == that) {
            return true;
        } else if (that == null) {
            return false;
        } else if (this.getClass() != that.getClass()) {
            return false;
        } else {
            boolean var10000;
            label97: {
                label89: {
                    Daili other = (Daili)that;
                    if (this.getId() == null) {
                        if (other.getId() != null) {
                            break label89;
                        }
                    } else if (!this.getId().equals(other.getId())) {
                        break label89;
                    }

                    if (this.getAccount() == null) {
                        if (other.getAccount() != null) {
                            break label89;
                        }
                    } else if (!this.getAccount().equals(other.getAccount())) {
                        break label89;
                    }

                    if (this.getPasswd() == null) {
                        if (other.getPasswd() != null) {
                            break label89;
                        }
                    } else if (!this.getPasswd().equals(other.getPasswd())) {
                        break label89;
                    }

                    if (this.getCode() == null) {
                        if (other.getCode() != null) {
                            break label89;
                        }
                    } else if (!this.getCode().equals(other.getCode())) {
                        break label89;
                    }

                    if (this.getToken() == null) {
                        if (other.getToken() != null) {
                            break label89;
                        }
                    } else if (!this.getToken().equals(other.getToken())) {
                        break label89;
                    }

                    if (this.getAddTime() == null) {
                        if (other.getAddTime() != null) {
                            break label89;
                        }
                    } else if (!this.getAddTime().equals(other.getAddTime())) {
                        break label89;
                    }

                    if (this.getUpdateTime() == null) {
                        if (other.getUpdateTime() != null) {
                            break label89;
                        }
                    } else if (!this.getUpdateTime().equals(other.getUpdateTime())) {
                        break label89;
                    }

                    if (this.getDeleted() == null) {
                        if (other.getDeleted() == null) {
                            break label97;
                        }
                    } else if (this.getDeleted().equals(other.getDeleted())) {
                        break label97;
                    }
                }

                var10000 = false;
                return var10000;
            }

            var10000 = true;
            return var10000;
        }
    }

    public int hashCode() {
        int result = 1;
         result = 31 * result + (this.getId() == null ? 0 : this.getId().hashCode());
        result = 31 * result + (this.getAccount() == null ? 0 : this.getAccount().hashCode());
        result = 31 * result + (this.getPasswd() == null ? 0 : this.getPasswd().hashCode());
        result = 31 * result + (this.getCode() == null ? 0 : this.getCode().hashCode());
        result = 31 * result + (this.getToken() == null ? 0 : this.getToken().hashCode());
        result = 31 * result + (this.getAddTime() == null ? 0 : this.getAddTime().hashCode());
        result = 31 * result + (this.getUpdateTime() == null ? 0 : this.getUpdateTime().hashCode());
        result = 31 * result + (this.getDeleted() == null ? 0 : this.getDeleted().hashCode());
        return result;
    }

    public Daili clone() throws CloneNotSupportedException {
        return (Daili)super.clone();
    }

    static {
        IS_DELETED = Daili.Deleted.IS_DELETED.value();
        NOT_DELETED = Daili.Deleted.NOT_DELETED.value();
    }

    public static enum Column {
        id("id", "id", "INTEGER", false),
        account("account", "account", "VARCHAR", false),
        passwd("passwd", "passwd", "VARCHAR", false),
        code("code", "code", "VARCHAR", false),
        token("token", "token", "VARCHAR", false),
        addTime("add_time", "addTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        deleted("deleted", "deleted", "BIT", false);

        private static final String BEGINNING_DELIMITER = "`";
        private static final String ENDING_DELIMITER = "`";
        private final String column;
        private final boolean isColumnNameDelimited;
        private final String javaProperty;
        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        private Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        public static Daili.Column[] excludes(Daili.Column... excludes) {
            ArrayList<Daili.Column> columns = new ArrayList(Arrays.asList(values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList(Arrays.asList(excludes)));
            }

            return (Daili.Column[])columns.toArray(new Daili.Column[0]);
        }

        public String getEscapedColumnName() {
            return this.isColumnNameDelimited ? "`" + this.column + "`" : this.column;
        }
    }

    public static enum Deleted {
        NOT_DELETED(new Boolean("0"), "?????????"),
        IS_DELETED(new Boolean("1"), "?????????");

        private final Boolean value;
        private final String name;

        private Deleted(Boolean value, String name) {
            this.value = value;
            this.name = name;
        }

        public Boolean getValue() {
            return this.value;
        }

        public Boolean value() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }
    }
}
