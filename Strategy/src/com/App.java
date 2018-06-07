package com;

import TaskList.TaskList;
import strategy.FCFS;
import strategy.LTFS;
import task.Task;

public class App {
	public static void main(String[] args) {
		TaskList taskList=new TaskList();
		taskList.addTasks(new Task("acb",5.5));
		taskList.addTasks(new Task("xyz",6.5));
		taskList.addTasks(new Task("lmn",2.5));
		taskList.addTasks(new Task("qwe",3.5));
		taskList.setStrategy(new FCFS());
		Task t=taskList.getNext();
		while(t!=null) {
			t.run();
			t=taskList.getNext();
		}
		
	}

}
