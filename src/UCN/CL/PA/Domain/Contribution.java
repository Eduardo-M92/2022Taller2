package UCN.CL.PA.Domain;

public class Contribution
{
	private String country;
	private String partName;
	private String partCode;
	private Material material;
	private int amount;
	
	public Contribution(String country, String partName, String partCode, Material material, int amount)
	{
		this.country = country;
		this.partName = partName;
		this.partCode = partCode;
		this.material = material;
		this.amount = amount;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getPartCode() {
		return partCode;
	}
	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
