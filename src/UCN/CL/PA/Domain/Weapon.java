package UCN.CL.PA.Domain;

public class Weapon
{
	private String name;
	private String weaponCode;
	private String country;
	private int ammo;
	private int necessaryMaterial;
	
	public Weapon(String name, String weaponCode, String country, int ammo, int necessaryMaterial)
	{
		this.name = name;
		this.weaponCode = weaponCode;
		this.country = country;
		this.ammo = ammo;
		this.necessaryMaterial = necessaryMaterial;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWeaponCode() {
		return weaponCode;
	}
	public void setWeaponCode(String weaponCode) {
		this.weaponCode = weaponCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getAmmo() {
		return ammo;
	}
	public void setAmmo(int billetsAmount) {
		this.ammo = billetsAmount;
	}
	public int getNecessaryMaterial() {
		return necessaryMaterial;
	}
	public void setNecessaryMaterial(int necessaryMaterial) {
		this.necessaryMaterial = necessaryMaterial;
	}
}
