package UCN.CL.PA.Domain;

public class Material
{
	private String name;
	private String country;
	private int stock;
	
	public Material(String name, String country, int stock)
	{
		this.name = name;
		this.country = country;
		this.stock = stock;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
