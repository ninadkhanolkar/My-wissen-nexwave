package strategy;

import java.util.List;

import task.Task;

public class LTFS implements Strategy {
	public Task nextTask(List<Task> l) {
		// TODO Auto-generated method stub
		Task task=null;
//		if(l.size()>0) {
//		    task=l.get((l.size()-1));
//		    l.remove((l.size()-1));
//		}
		if(l.size()>0)
			task=l.get(0);
		for(Task t:l) {
			if(t.getDuration()>task.getDuration())
				task=t;
			     
		}
		l.remove(task);
		return task ;
	}

}
