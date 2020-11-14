package com.datasupermacy.recruit_cat.Api;

import com.datasupermacy.recruit_cat.entity.FavoritesList;
import com.datasupermacy.recruit_cat.service.ClearPerService;
import com.datasupermacy.recruit_cat.service.FavoritesListService;
import com.datasupermacy.recruit_cat.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/Api/FavoritesList")
public class FavoritesListApi {
    @Autowired
    FavoritesListService favoritesListService;
    @Autowired
    ClearPerService clearPerService;

    @GetMapping("/jobList")
    public ResponseEntity getListByUid(Integer Uid, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize){
        List<FavoritesList> favList = favoritesListService.getListByUid(Uid,pageNum,pageSize);
        if (favList!=null&&!favList.isEmpty()){
            return new ResponseEntity(1,favList);
        }
        return new ResponseEntity(-1,"无任何信息");
    }

    @DeleteMapping("/{Jid}/{Uid}")
    public ResponseEntity delListItem(@PathVariable(name = "Jid") Integer Jid,@PathVariable(name = "Uid") Integer Uid){
        if (favoritesListService.delListItem(Jid,Uid)>0){
            clearPerService.clearPer();
            return new ResponseEntity(1);
        }
        return new ResponseEntity(-1,"删除失败");
    }

}
