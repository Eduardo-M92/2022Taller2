package UCN.CL.PA.Domain;

public class Robot
{
	private String name;
	private String nameArms;
	private String nameLegs;
	private String nameChest;
	private String nameHead;
	private String nameWeapon;
	private String extraQuality;
	private String team;
	private String pilotCode;
	
	public Robot(String name, String nameArms, String nameLegs, String nameChest, String nameHead, String nameWeapon, String extraQuality, String team, String pilotCode)
	{
		this.name = name;
		this.nameArms = nameArms;
		this.nameLegs = nameLegs;
		this.nameChest = nameChest;
		this.nameHead = nameHead;
		this.nameWeapon = nameWeapon;
		this.extraQuality = extraQuality;
		this.team = team;
		this.pilotCode = pilotCode;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameArms() {
		return nameArms;
	}
	public void setNameArms(String nameArms) {
		this.nameArms = nameArms;
	}
	public String getNameLegs() {
		return nameLegs;
	}
	public void setNameLegs(String nameLegs) {
		this.nameLegs = nameLegs;
	}
	public String getNameChest() {
		return nameChest;
	}
	public void setNameChest(String nameChest) {
		this.nameChest = nameChest;
	}
	public String getNameHead() {
		return nameHead;
	}
	public void setNameHead(String nameHead) {
		this.nameHead = nameHead;
	}
	public String getNameWeapon() {
		return nameWeapon;
	}
	public void setNameWeapon(String nameWeapon) {
		this.nameWeapon = nameWeapon;
	}
	public String getExtraQuality() {
		return extraQuality;
	}
	public void setExtraQuality(String extraQuality) {
		this.extraQuality = extraQuality;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getPilotCode() {
		return pilotCode;
	}
	public void setPilotCode(String pilotCode) {
		this.pilotCode = pilotCode;
	}
}
