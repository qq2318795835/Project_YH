package cn.datasupermacy.controller;

import cn.datasupermacy.Exceptions.DeptException;
import cn.datasupermacy.entity.Dept;
import cn.datasupermacy.service.impl.DeptServiceImpl;
import cn.datasupermacy.util.ResponseEntity;
import cn.datasupermacy.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
//@CrossOrigin(origins = "http://81.70.152.49:8081")
@RestController
@RequestMapping("/Dept")
public class DeptController {
    @Autowired
    private DeptServiceImpl deptService;

    @GetMapping("/deptList")
    public ResponseEntity findAllDept(){
        List<Dept> deptList = deptService.findAllDept();
        if (deptList!=null){
            return new ResponseEntity(1,deptList);
        }else
            return new ResponseEntity(-1,"无任何信息");
    }
    @GetMapping("/deptTree")
    public List<TreeUtil> getDeptTree(){
        List<Dept> deptList = deptService.findAllDept();
        List<TreeUtil> treeUtilList = new ArrayList<>();
        List<TreeUtil> trees = new ArrayList<TreeUtil>();
        for (int i = 0; i < deptList.size(); i++) {
            TreeUtil treeUtil = new TreeUtil();
            treeUtil.setId(deptList.get(i).getDid());
            treeUtil.setName(deptList.get(i).getDtitle());
            treeUtil.setDpid(deptList.get(i).getDpid());
            treeUtilList.add(treeUtil);
        }
        for (TreeUtil treeUtil : treeUtilList) {
            if (treeUtil.getDpid() == 0){
                trees.add(treeUtil);
            }
        }
        for (TreeUtil treeUtil : treeUtilList) {
            toTreeChildren(trees,treeUtil);
        }
        return trees;
    }
    private static void toTreeChildren(List<TreeUtil>treeUtils,TreeUtil treeUtil){
        for (TreeUtil util : treeUtils) {
            if (treeUtil.getDpid() == util.getId()){
                if (util.getChildren()==null){
                    util.setChildren(new ArrayList<TreeUtil>());
                }
                util.getChildren().add(treeUtil);
            }
            if (util.getChildren() != null){
                toTreeChildren(util.getChildren(),treeUtil);
            }
        }
    }

    @GetMapping("/oneDept")
    public ResponseEntity findDeptById(Integer did){
        if (did==null||did==0){
            throw new DeptException(0,"did为空");
        }
        if (did!=null||did>0){
            Dept dept = deptService.findDeptById(did);
            return new ResponseEntity(1,dept);
        }else
            return new ResponseEntity(-1,"无任何信息");
    }

    @GetMapping("/oneDept1")
    public ResponseEntity findDeptByName(String dname){
        if (dname==null&&dname.isEmpty()){
            throw new DeptException(0,"dname为空");
        }
        Dept dept = deptService.findDeptByName(dname);
        if (dept!=null){
            return new ResponseEntity(1,dept);
        }else
            return new ResponseEntity(-1,"无任何信息");
    }

    @PostMapping("/moreDept")
    public ResponseEntity findDeptByDpid(Integer dpid){
        if (dpid==null){
            throw new DeptException(0,"dpid为0/null");
        }
        List<Dept> deptList = deptService.findDeptByDpid(dpid);
        if (deptList!=null){
            return new ResponseEntity(1,deptList);
        }else
            return new ResponseEntity(-1,"无任何信息");
    }

    @PostMapping("/moreDept2")
    public ResponseEntity findDeptByAddress(String daddress){
        if (daddress==null){
            throw new DeptException(0,"地名为空");
        }
        List<Dept> deptList = deptService.findDeptByAddress(daddress);
        if (deptList!=null){
            return new ResponseEntity(1,deptList);
        }else
            return new ResponseEntity(-1,"无任何信息");
    }

    @PostMapping("/addDept")
    public ResponseEntity addDept(@RequestBody Dept dept){
        dept.setDcreatetime(new Timestamp(System.currentTimeMillis()));
        if (dept==null){
            throw new DeptException(0,"dept为空");
        }else
        if (dept.getDpid()<0){
            throw new DeptException(2,"dpid越界");
        }
        if (dept!=null) {
            deptService.addDeptSelective(dept);
            return new ResponseEntity(1,"添加成功");
        }else
            return new ResponseEntity(-1,"添加失败");
    }

    @PostMapping("/delDEPT")
    public ResponseEntity delDept(Integer did){
        if (did==null||did<=0){
            throw new DeptException(2,"did越界/为空");
        }
        if (did!=null||did>=0){
            deptService.delDept(did);
            return new ResponseEntity(1,"删除成功");
        }else
            return new ResponseEntity(-1,"删除失败");
    }

    @PutMapping("/updateDept")
    public ResponseEntity updateDeptSelective(Integer did, @RequestBody Dept dept){
        if (dept!=null&&did!=null){
            deptService.updateDeptSelective(did,dept);
            return new ResponseEntity(1,"更新成功");
        }else {
            throw new DeptException(0,"dept/did为空");
        }
    }

    @PostMapping("/upLoad")
    public ResponseEntity fileUpload(@RequestParam("fileName") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity(-502,"上传失败");
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();

        System.out.println(fileName + "-->" + size);

        String path = "E:\\WorkFile\\upLoad";
        File dest = new File(path + "\\" + fileName);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(501,"上传成功");
    }

    @PostMapping("/downLoad")
    public ResponseEntity downLoad(HttpServletResponse response) throws UnsupportedEncodingException {
        String filename="system.jpg";
        String filePath = "E:\\WorkFile\\upLoad" ;
        File file = new File(filePath + "\\" + filename);
        if(file.exists()){ //判断文件父目录是否存在
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            // response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" +   java.net.URLEncoder.encode(filename,"UTF-8"));
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();;
            }
            System.out.println("----------file download---" + filename);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
}
