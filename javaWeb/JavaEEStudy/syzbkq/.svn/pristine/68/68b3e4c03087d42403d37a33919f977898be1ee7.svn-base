package cn.thinking.system.codelist.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import cn.thinking.common.basedao.BaseDao;
import cn.thinking.org.system.codelist.Codelist;
import cn.thinking.system.codelist.dao.ICodelistDao;

@Repository(value = "cn.thinking.system.codelist.dao.impl.CodelistDaoImpl")
public class CodelistDaoImpl extends BaseDao implements ICodelistDao {



	@Override
    public List<Codelist>listvacationType(){
    	return (List<Codelist>) this.selectList("cn.thinking.org.system.codelist.Codelist.listvacationType");
    }

	@Override
	public List<Codelist> listBanSystem() {
		return (List<Codelist>) this.selectList("cn.thinking.org.system.codelist.Codelist.listBanSystem");
	}

}
