package strategy;

import java.util.List;

import task.Task;

public interface Strategy {
	public Task nextTask(List<Task> l);

}
