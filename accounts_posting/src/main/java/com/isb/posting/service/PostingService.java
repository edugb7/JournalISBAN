package com.isb.posting.service;

import java.util.List;

import com.isb.posting.entity.InputContract;

public interface PostingService {

	public List<InputContract> findAll();
	
	public InputContract findById(String id);
	
	public InputContract save(InputContract inputContract);
	
	public void remove(String journalOperationId);
	
}
