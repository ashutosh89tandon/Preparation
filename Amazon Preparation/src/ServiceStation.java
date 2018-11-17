import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

enum Skill
{
	ENGINE, BODY;
}

enum Model
{	
	HONDA,HYUNDAI,TOYOTA;
}

enum TaskStatus
{	
	NEW,INPROGRESS,COMPLETED;
}


/**Entity representing Technician
 * @author
 *
 */
class Technician
{	
	static final int MAX_TASKS=10;
	private int currentNumberOfTasks=0;
	private List<Skill> skills=new ArrayList<>();
	private List<Model> models=new ArrayList<>();
	private Queue<Task> tasks=new LinkedList<>();
	private ServiceManager manager;
	
	public void addTask(Task task)
	{
		//allocate tasks only when it is less than MAX number of tasks
		if(currentNumberOfTasks==MAX_TASKS)
			throw new RuntimeException("Technician has completed all tasks for the day.");
		currentNumberOfTasks++;
		tasks.offer(task);
	}
	
	public void addSkill(Skill skill)
	{
		if(!skills.contains(skill))
			skills.add(skill);
	}
	
	public void removeSkill(Skill skill)
	{
		if(skills.contains(skill))
			skills.remove(skill);
	}
	
	public void addModel(Model model)
	{
		if(!models.contains(model))
			models.add(model);
	}
	
	public void removeModel(Model model)
	{
		if(models.contains(model))
			models.remove(model);
	}
	
	public void refresh()
	{
		currentNumberOfTasks=0;
		tasks=new LinkedList<>();
	}
	
	public void repair()
	{
		//Execute the task if technician has any
		if(!tasks.isEmpty())
		{
			Task task=tasks.poll();
			task.setStatus(TaskStatus.INPROGRESS);
			System.out.println("Task executed!!!");
			task.completeTask();
			manager.notifyStatus(task);
		}
	}
	
	public Technician(List<Skill> skills,List<Model> models,ServiceManager manager)
	{
		this.manager=manager;
		this.skills=skills;
		this.models=models;
	}

	public int getCurrentNumberOfTasks() {
		return currentNumberOfTasks;
	}

	public void setCurrentNumberOfTasks(int currentNumberOfTasks) {
		this.currentNumberOfTasks = currentNumberOfTasks;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<Model> getModels() {
		return models;
	}

	public void setModels(List<Model> models) {
		this.models = models;
	}

	public Queue<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Queue<Task> tasks) {
		this.tasks = tasks;
	}
	
	
}

/**Entity representing task state
 * @author
 *
 */
class Task
{
	private int serviceNumber;
	private Model model;
	private Skill skill;
	private TaskStatus status=TaskStatus.NEW;
	public int getServiceNumber() {
		return serviceNumber;
	}
	public void setServiceNumber(int serviceNumber) {
		this.serviceNumber = serviceNumber;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	
	public void completeTask()
	{
		this.setStatus(TaskStatus.COMPLETED);
	}
	
	public Task(int serviceNumber, Model model, Skill skill) {
		super();
		this.serviceNumber = serviceNumber;
		this.model = model;
		this.skill = skill;
	}
}

/**Entity representing service manager
 * @author
 *
 */
class ServiceManager {
	private List<Technician> technicians=new ArrayList<>();
	
	public List<Technician> getTechnicians() {
		return technicians;
	}

	public void setTechnicians(List<Technician> technicians) {
		this.technicians = technicians;
	}

	public void notifyStatus(Task task) 
	{
		System.out.println("Task completed !! "+task.getServiceNumber());
	}
	
	public void allocateTaskToTechnician(Task task)
	{
		boolean allocated=false;
		for(Technician technician: technicians)
		{
			if(allocated)
				break;
			
			if(technician.getSkills().contains(task.getSkill()) &&
					technician.getModels().contains(task.getModel()))
			{
				allocated=true;
				try 
				{
					technician.addTask(task);
				} catch (Exception e) 
				{
					allocated=false;
				}
			}
		}
		
		if(!allocated)
		{
			System.out.println("Sorry task "+task.getServiceNumber()+" cannot be allocated at the momenet!!");
		}
	}
	
}

public class ServiceStation {
    public static void main(String args[] ) throws Exception {
       
    	ServiceManager manager=new ServiceManager();
    	List<Technician> technicians=new ArrayList<>();
    	List<Skill> skills=new ArrayList<>();
    	skills.add(Skill.ENGINE);
    	List<Model> models=new ArrayList<>();
    	models.add(Model.HONDA);
    	technicians.add(new Technician(skills, models, manager));
    	manager.setTechnicians(technicians);
    	
    	for(int i=0;i<=10;i++)
    	{
    		manager.allocateTaskToTechnician(new Task(i, Model.HYUNDAI, Skill.ENGINE));
    	}
    	
    	for(Technician technician : manager.getTechnicians())
    	{
    		for(int i=0;i<technician.getCurrentNumberOfTasks();i++)
    		{
    			technician.repair();
    		}
    	}
    }
}

