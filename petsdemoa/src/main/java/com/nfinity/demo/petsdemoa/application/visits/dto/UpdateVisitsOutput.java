package com.nfinity.demo.petsdemoa.application.visits.dto;

import java.util.Date;
public class UpdateVisitsOutput {

  private String description;
  private Integer id;
  private Date visitDate;
  private Integer petId;
	private String petsDescriptiveField;

  public Integer getPetId() {
  return petId;
  }

  public void setPetId(Integer petId){
  this.petId = petId;
  }
  
  public String getPetsDescriptiveField() {
  	return petsDescriptiveField;
  }

  public void setPetsDescriptiveField(String petsDescriptiveField){
  	this.petsDescriptiveField = petsDescriptiveField;
  }
 
  public String getDescription() {
  	return description;
  }

  public void setDescription(String description){
  	this.description = description;
  }
  
  public Integer getId() {
  	return id;
  }

  public void setId(Integer id){
  	this.id = id;
  }
  
  public Date getVisitDate() {
  	return visitDate;
  }

  public void setVisitDate(Date visitDate){
  	this.visitDate = visitDate;
  }
  

}