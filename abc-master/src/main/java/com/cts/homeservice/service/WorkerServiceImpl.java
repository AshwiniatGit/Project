package com.cts.homeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.homeservice.bean.Worker;
import com.cts.homeservice.dao.WorkerDAO;

@Service
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	private WorkerDAO workerDAO;
	
	@Override
	public  List<Worker> getWorkerByLocalityAndService(String vicinity, String service) {
		// TODO Auto-generated method stub
		return workerDAO.getWorkerByLocalityAndService(vicinity,service);
	}

}
