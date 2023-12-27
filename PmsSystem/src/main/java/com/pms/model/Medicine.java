package com.pms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Medicine {
	
  /*-------------Attributes(data member)--------------------------*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Medicine_Id")
	private int medicineId;
	
	@Column(name="Medicine_Name",nullable=false)
	private String medicineName;
	
	@Column(name="Medicine_Quantity",nullable=false)
	private int medicineQuantity;
	
	@Column(name="Medicine_Price")
	private long medicinePrice;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Manufacturer_Date")
	private Date manufacturerDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Expiry_Date")
	private Date expiryDate;

	
	/*------------------------Generate Getter & setter-----------------------*/
	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public int getMedicineQuantity() {
		return medicineQuantity;
	}

	public void setMedicineQuantity(int medicineQuantity) {
		this.medicineQuantity = medicineQuantity;
	}

	public long getMedicinePrice() {
		return medicinePrice;
	}

	public void setMedicinePrice(long medicinePrice) {
		this.medicinePrice = medicinePrice;
	}

	public Date getManufacturerDate() {
		return manufacturerDate;
	}

	public void setManufacturerDate(Date manufacturerDate) {
		this.manufacturerDate = manufacturerDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	
	/*---------------------Generate Constructor Using field-------------------------------------------*/
	public Medicine(int medicineId, String medicineName, int medicineQuantity, long medicinePrice,
			Date manufacturerDate, Date expiryDate) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.medicineQuantity = medicineQuantity;
		this.medicinePrice = medicinePrice;
		this.manufacturerDate = manufacturerDate;
		this.expiryDate = expiryDate;
	}

	

	
	/*----------------------------------Generate Default constructor---------------------------------*/
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	/*----------------------Generate ToString method-------------------------------------------*/
	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", medicineQuantity="
				+ medicineQuantity + ", medicinePrice=" + medicinePrice + ", manufacturerDate=" + manufacturerDate
				+ ", expiryDate=" + expiryDate + "]";
	}
	
	
	
	
	
}
