package com.pms.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.pms.model.Login;
import com.pms.model.Medicine;

@Component
public class Pmsdao {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public Pmsdao(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public Login getLogin(String username, String password) {

        String hql = "FROM Login WHERE username = :user AND password = :pwd";

        Login login = hibernateTemplate.execute(session -> {
            Query<Login> query = session.createQuery(hql, Login.class);
            query.setParameter("user", username);
            query.setParameter("pwd", password);
            return query.uniqueResult();
        });

        return login;
    }
    
    //save the medicine detail in database
    @Transactional
    public void savemedicine(Medicine medicine) {
    	this.hibernateTemplate.saveOrUpdate(medicine);
    }
    
    //for extract list of medicine detail from the database
    public List<Medicine> getmedicine(){
    	List<Medicine>medicine = this.hibernateTemplate.loadAll(Medicine.class);
		return medicine;	
    }
    
    //delete medicine data
    @Transactional
    public void deletemedicine(int mid) {
    	Medicine m = this.hibernateTemplate.get(Medicine.class, mid);
    	this.hibernateTemplate.delete(m);
    }
    
    //update medicine data
    public Medicine getMedicine(int mid) {
    	return this.hibernateTemplate.get(Medicine.class, mid);
    }
    
}
