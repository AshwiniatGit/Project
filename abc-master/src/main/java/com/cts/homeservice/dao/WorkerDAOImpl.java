package com.cts.homeservice.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.homeservice.bean.Worker;

@Repository
@Transactional
public class WorkerDAOImpl implements WorkerDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Worker> getWorkerByLocalityAndService(String vicinity, String service ) {
		// TODO Auto-generated method stub
		TypedQuery<Worker> query = sessionFactory.getCurrentSession().createQuery("from Worker where skills like '%"+service+"%'");
		 List<Worker> workers = query.getResultList();
		 
		 List<Worker> localWorkers = new ArrayList<Worker>();
	     String locality;
		 for(Worker worker : workers) {
			  locality = worker.getLocality();
			  if(vicinity.indexOf(locality)!=-1) {
				  localWorkers.add(worker);
				  
			  }
			  
		 }
		 System.out.println(localWorkers);
		 return localWorkers;
		
	
	}

}
