package com.cg.healthassist.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mobile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String model;
	private Date modelyear;
	private int cost;
	private String contactno;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Date getModelyear() {
		return modelyear;
	}
	public void setModelyear(Date modelyear) {
		this.modelyear = modelyear;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id =id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Mobile(int id, String name, String model, Date modelyear, int cost, String contactno) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.modelyear = modelyear;
		this.cost = cost;
		this.contactno = contactno;
	}
	@Override
	public String toString()
	{
		return "Mobile   id: "+id+"  model: "+model+"  modelyear: "+modelyear+"  cost: "+cost+"  sellerName: "+name+"  contactno: "+contactno;
	}

}
