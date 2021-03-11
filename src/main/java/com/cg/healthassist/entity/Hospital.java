
  package com.cg.healthassist.entity;
  
  import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
  import javax.persistence.GeneratedValue;
  import javax.persistence.GenerationType;
  import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

  @Entity 
  public class Hospital {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
@Column(unique = true,updatable = false)
@NotBlank(message="Hospital Identifier can't be blank")
@Size(min=4, max=5,message = "Size must be between 4 to 5 characters")
private String hospitalIdentifier;

public String getHospitalIdentifier() {
	return hospitalIdentifier;
}
public void setHospitalIdentifier(String hospitalIdentifier) {
	this.hospitalIdentifier = hospitalIdentifier;
}




private String hospitalName; 
  private String hospitalAddress; 
  private long hospitalPhNO;
  @ElementCollection
  private List<String> hospitalSpecialities=new ArrayList<>(); 
  private  boolean beds;
 
  
 
  public Hospital(String hospitalName, String hospitalAddress, long hospitalPhNO, List<String> hospitalSpecialities,boolean beds,String hospitalIdentifier) 
  {
	  
	  this.hospitalName = hospitalName; 
	  this.hospitalAddress = hospitalAddress;
	  this.hospitalPhNO = hospitalPhNO;
	  this.hospitalSpecialities =hospitalSpecialities; 
	  this.beds=beds;
	  this.hospitalIdentifier=hospitalIdentifier;
	}
	 
  
  public Hospital() 
  { 
	  super(); 
  }
  
  
  
  
 /**
	 * return hospital specialty
	 */

  public List<String> getHospitalSpecialities() 
  { 
	  return hospitalSpecialities;
	}
 /**
	 * set the hospital speciality
	 * 
	 * @param hospitalSpeciality
	 */

  public void setHospitalSpecialities(List<String> hospitalSpecialities) 
  {
	  this.hospitalSpecialities = hospitalSpecialities; 
	}
  
 /**
	 * @return hospital name
	 */

  public String getHospitalName() 
  { 
	  return hospitalName; 
}
 /**
	 * Set the name of the hospital
	 * 
	 * @param hospitalName
	 */

  public void setHospitalName(String hospitalName) 
  { 
	  this.hospitalName =hospitalName;
	}
 /**
	 * @return the hospital address
	 */

  public String getHospitalAddress() 
  { 
	  return hospitalAddress; 
}
 /**
	 * Set the hospital address
	 * 
	 * @param hospitalAddress
	 */

  public void setHospitalAddress(String hospitalAddress) 
  { 
	  this.hospitalAddress= hospitalAddress; 
}
 /**
	 * @return the hospital phone number
	 */
		  public long getHospitalPhNO() 
		  { 
			  return hospitalPhNO; 
		} 
		  public void setHospitalPhNO(long hospitalPhNO) 
		  { 
			  this.hospitalPhNO = hospitalPhNO; 
			}
		  
		  public boolean getBeds() 
		  { 
			  return beds; 
		} 
		  public void setBeds(boolean beds) 
		  {
			  this.beds = beds; 
		} 
		 
		
		  
		  @Override 
		  public String toString() 
		  {
			  return "Hospital [hospitalName=" +hospitalName + ", hospitalAddress=" + hospitalAddress + ", hospitalPhNO=" +
		  hospitalPhNO + ", hospitalSpecialities=" +hospitalSpecialities+","+"beds: "+beds; 
		  }
		  
		  
		  
		  
		  
		  }
		 