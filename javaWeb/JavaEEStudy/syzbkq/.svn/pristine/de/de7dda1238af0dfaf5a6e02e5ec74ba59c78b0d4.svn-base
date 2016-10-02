package com.neuedu.service.kq;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.neuedu.entity.baseinfo.BanTeam;
import com.neuedu.mapper.BanTeamMapper;

/**
 * 班组service层
 * @author Administrator
 */
@Component
public class BanTeamService {
	@Resource 
	private BanTeamMapper banteamMapper;
	//班组主页显示
	public List<BanTeam> listPageSearchBanTeam(BanTeam banteam){
		return banteamMapper.listPageSearchBanTeam(banteam);
	}
	//删除
	public void deleteBanteam(String banteam_id){
		banteamMapper.deleteBanteam(banteam_id);
	}
	//增加
	public void insertBanteam(BanTeam banteam){
	    banteamMapper.insertBanteam(banteam);
	}
	//查找一条数据
	public BanTeam findBanteam(String banteam_id){
		return banteamMapper.findBanteam(banteam_id);
	}
	//修改
	public void updateBanteam(BanTeam banteam){
		banteamMapper.updateBanteam(banteam);
	}

}
