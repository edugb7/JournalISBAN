package com.isb.conciliator.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Contract implements Serializable {

	private static final long serialVersionUID = 9101011696495493636L;

	private String contractId;
	
	private String contractType;

}
