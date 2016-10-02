package cn.thinking.system.codelist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.thinking.org.system.codelist.Codelist;
import cn.thinking.system.codelist.dao.ICodelistDao;
import cn.thinking.system.codelist.service.CodelistService;

@Service
public class CodelistServiceImpl implements CodelistService {

    @Autowired
    private ICodelistDao codelistDao;

	public ICodelistDao getCodelistDao() {
		return codelistDao;
	}

	public void setCodelistDao(ICodelistDao codelistDao) {
		this.codelistDao = codelistDao;
	}
	
	@Override
	public List<Codelist> listvacationType() {
		// TODO Auto-generated method stub
		return codelistDao.listvacationType() ;
	}

	@Override
	public List<Codelist> listBanSystem() {
		return codelistDao.listBanSystem();
	}

	
}
