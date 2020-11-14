package com.datasupermacy.recruit_cat.My;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class RecommendResult implements DBWritable, WritableComparable<RecommendResult> {
    private String Uid;
    private String Jid;
    private int Exp;

    public RecommendResult() {
    }

    public RecommendResult(String uid, String jid, int exp) {
        Uid = uid;
        Jid = jid;
        this.Exp = exp;
    }

    @Override
    public int compareTo(RecommendResult o) {
        int uidComp=this.Uid.compareTo(o.Uid);
        int gidComp=this.Jid.compareTo(o.Jid);
        int indexComp=this.Exp-o.Exp;
        return uidComp==0?(gidComp==0?indexComp:gidComp):uidComp;

    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(Uid);
        out.writeUTF(Jid);
        out.writeInt(Exp);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        Uid = in.readUTF();
        Jid = in.readUTF();
        Exp = in.readInt();
    }

    @Override
    public void write(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1,Uid);
        preparedStatement.setString(2,Jid);
        preparedStatement.setInt(3,Exp);

    }

    @Override
    public void readFields(ResultSet resultSet) throws SQLException {
        if(resultSet==null) return;
        Uid=resultSet.getString(1);
        Jid=resultSet.getString(2);
        Exp=resultSet.getInt(3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecommendResult that = (RecommendResult) o;
        return Exp == that.Exp &&
                Objects.equals(Uid, that.Uid) &&
                Objects.equals(Jid, that.Jid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid(), getJid(), getExp());
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getJid() {
        return Jid;
    }

    public void setJid(String jid) {
        Jid = jid;
    }

    public int getExp() {
        return Exp;
    }

    public void setExp(int exp) {
        this.Exp = exp;
    }

    @Override
    public String toString() {
        return "RecommendResult{"+"uid='"+Uid+'\''+", jid='"+Jid+'\''+", exp="+Exp+'}';
    }
}
