package com.cts.homeservice.dao;

import java.util.List;

import com.cts.homeservice.bean.Worker;

public interface WorkerDAO {

	public List<Worker> getWorkerByLocalityAndService(String vicinity, String service);
}
