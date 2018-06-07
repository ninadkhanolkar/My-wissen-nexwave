package TaskList;
import java.util.ArrayList;
import java.util.List;

import strategy.Strategy;
import task.Task;

public class TaskList {

	List<Task> taskList=new ArrayList<Task>();
	Strategy strategy;
	public void setStrategy(Strategy strategy) {
		this.strategy=strategy;
	}
	
	public void addTasks(Task task) {
		taskList.add(task);
	}
	
	public Task getNext() {
		return strategy.nextTask(taskList);
	}

}
