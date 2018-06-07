package task;

public class Task {
	private String name;
	private double duration;
	public Task(String name, double duration) {
	  	// TODO Auto-generated constructor stub
		this.name=name;
		this.duration=duration;
	}
    public void run() {
    	System.out.println(""+name+"  "+duration);
    }
	public String getName() {
		return name;
	}
	public double getDuration() {
		return duration;
	}
}
