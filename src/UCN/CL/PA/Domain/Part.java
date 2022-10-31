package UCN.CL.PA.Domain;

public class Part
{
	private String name;
	private String partCode;
	private String typePart;
	private String country;
	private int necessaryMaterial;
	
	public Part(String name, String partCode, String typePart, String country, int necessaryMaterial)
	{
		this.name = name;
		this.partCode = partCode;
		this.typePart = typePart;
		this.country = country;
		this.necessaryMaterial = necessaryMaterial;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPartCode() {
		return partCode;
	}
	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}
	public String getTypePart() {
		return typePart;
	}
	public void setTypePart(String typePart) {
		this.typePart = typePart;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getNecessaryMaterial() {
		return necessaryMaterial;
	}
	public void setNecessaryMaterial(int necessaryMaterial) {
		this.necessaryMaterial = necessaryMaterial;
	}
}
