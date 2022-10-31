package UCN.CL.PA.Domain;

public class Model
{
	private String modelCode;
	private String robotName;
	
	
	
	public Model(String modelCode, String robotName)
	{
		this.modelCode = modelCode;
		this.robotName = robotName;
	}
	
	public String getModelCode() {
		return modelCode;
	}
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
	public String getRobotName() {
		return robotName;
	}
	public void setRobotName(String robotName) {
		this.robotName = robotName;
	}
}
