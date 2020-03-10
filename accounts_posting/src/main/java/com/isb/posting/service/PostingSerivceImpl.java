package com.isb.posting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isb.posting.entity.InputContract;
import com.isb.posting.repository.PostingRepositoryDTO;

@Service
public class PostingSerivceImpl implements PostingService {

	@Autowired
	private PostingRepositoryDTO dto;

	@Override
	@Transactional(readOnly=true)
	public List<InputContract> findAll() {
		
		return (List<InputContract>) dto.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public InputContract findById(String id) {
		
		return dto.findById(id).orElse(null);
	}

	@Override
	//@Transactional(readOnly=false)
	public InputContract save(InputContract inputContract) {
		
		return dto.save(inputContract);
	}

	@Override
	public void remove(String journalOperationId) {
		dto.deleteById(journalOperationId);
	}
	
	
}
