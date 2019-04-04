package com.cts.homeservice.service;

import java.util.List;

import com.cts.homeservice.bean.Worker;

public interface WorkerService {
	
	public  List<Worker> getWorkerByLocalityAndService(String vicinity, String service);

}
