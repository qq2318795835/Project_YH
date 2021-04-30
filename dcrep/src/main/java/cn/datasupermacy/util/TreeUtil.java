package cn.datasupermacy.util;

import java.util.List;

public class TreeUtil {
    private Integer Id;

    private String name;

    private Integer Dpid;

    private List<TreeUtil> children;

    public TreeUtil() {

    }

    public TreeUtil(Integer id, String name, Integer dpid, List<TreeUtil> children) {
        Id = id;
        this.name = name;
        Dpid = dpid;
        this.children = children;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDpid() {
        return Dpid;
    }

    public void setDpid(Integer dpid) {
        Dpid = dpid;
    }

    public List<TreeUtil> getChildren() {
        return children;
    }

    public void setChildren(List<TreeUtil> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeUtil{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", Dpid=" + Dpid +
                ", children=" + children +
                '}';
    }
}
