package kimi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kimi.domain.Test;

@Service
public class IndexServiceImpl implements IndexService {
	
	@Autowired
	private TestRepository testRepository;

	@Override
	public List<Test> findAll() {
		return testRepository.findAll();
	}

}
