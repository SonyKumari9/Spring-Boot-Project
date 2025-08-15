package ecommerce.example.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name = "brandname_db")
public class BrandNameModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // ===== Bags - Domestic Brands =====
    private String safari;
    private String wildcraft;
    private String americanTourister;
    private String hidesign;
    private String baggit;
    private String lavie;

    // ===== Bags - International Brands =====
    private String samsonite;
    private String tumi;
    private String adidasBags;
    private String nikeBags;
    private String pumaBags;

    // ===== Clothing - Domestic Brands =====
    private String raymond;
    private String fabindia;
    private String manyavar;
    private String allenSolly;
    private String vanHeusen;
    private String wForWoman;
    private String flyingMachine;
    private String spykar;
    private String monteCarlo;
    private String siyaram;

    // ===== Clothing - International Brands =====
    private String zara;
    private String hm;
    private String levis;
    private String nikeClothing;
    private String adidasClothing;
    private String pumaClothing;
    private String uniqlo;

    // ===== Shoes - Domestic Brands =====
    private String bata;
    private String relaxo;
    private String metro;
    private String liberty;
    private String khadims;

    // ===== Shoes - International Brands =====
    private String nikeShoes;
    private String adidasShoes;
    private String pumaShoes;
    private String reebok;
    private String woodland;
    private String converse;
    private String vans;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSafari() {
		return safari;
	}
	public void setSafari(String safari) {
		this.safari = safari;
	}
	public String getWildcraft() {
		return wildcraft;
	}
	public void setWildcraft(String wildcraft) {
		this.wildcraft = wildcraft;
	}
	public String getAmericanTourister() {
		return americanTourister;
	}
	public void setAmericanTourister(String americanTourister) {
		this.americanTourister = americanTourister;
	}
	public String getHidesign() {
		return hidesign;
	}
	public void setHidesign(String hidesign) {
		this.hidesign = hidesign;
	}
	public String getBaggit() {
		return baggit;
	}
	public void setBaggit(String baggit) {
		this.baggit = baggit;
	}
	public String getLavie() {
		return lavie;
	}
	public void setLavie(String lavie) {
		this.lavie = lavie;
	}
	public String getSamsonite() {
		return samsonite;
	}
	public void setSamsonite(String samsonite) {
		this.samsonite = samsonite;
	}
	public String getTumi() {
		return tumi;
	}
	public void setTumi(String tumi) {
		this.tumi = tumi;
	}
	public String getAdidasBags() {
		return adidasBags;
	}
	public void setAdidasBags(String adidasBags) {
		this.adidasBags = adidasBags;
	}
	public String getNikeBags() {
		return nikeBags;
	}
	public void setNikeBags(String nikeBags) {
		this.nikeBags = nikeBags;
	}
	public String getPumaBags() {
		return pumaBags;
	}
	public void setPumaBags(String pumaBags) {
		this.pumaBags = pumaBags;
	}
	public String getRaymond() {
		return raymond;
	}
	public void setRaymond(String raymond) {
		this.raymond = raymond;
	}
	public String getFabindia() {
		return fabindia;
	}
	public void setFabindia(String fabindia) {
		this.fabindia = fabindia;
	}
	public String getManyavar() {
		return manyavar;
	}
	public void setManyavar(String manyavar) {
		this.manyavar = manyavar;
	}
	public String getAllenSolly() {
		return allenSolly;
	}
	public void setAllenSolly(String allenSolly) {
		this.allenSolly = allenSolly;
	}
	public String getVanHeusen() {
		return vanHeusen;
	}
	public void setVanHeusen(String vanHeusen) {
		this.vanHeusen = vanHeusen;
	}
	public String getwForWoman() {
		return wForWoman;
	}
	public void setwForWoman(String wForWoman) {
		this.wForWoman = wForWoman;
	}
	public String getFlyingMachine() {
		return flyingMachine;
	}
	public void setFlyingMachine(String flyingMachine) {
		this.flyingMachine = flyingMachine;
	}
	public String getSpykar() {
		return spykar;
	}
	public void setSpykar(String spykar) {
		this.spykar = spykar;
	}
	public String getMonteCarlo() {
		return monteCarlo;
	}
	public void setMonteCarlo(String monteCarlo) {
		this.monteCarlo = monteCarlo;
	}
	public String getSiyaram() {
		return siyaram;
	}
	public void setSiyaram(String siyaram) {
		this.siyaram = siyaram;
	}
	public String getZara() {
		return zara;
	}
	public void setZara(String zara) {
		this.zara = zara;
	}
	public String getHm() {
		return hm;
	}
	public void setHm(String hm) {
		this.hm = hm;
	}
	public String getLevis() {
		return levis;
	}
	public void setLevis(String levis) {
		this.levis = levis;
	}
	public String getNikeClothing() {
		return nikeClothing;
	}
	public void setNikeClothing(String nikeClothing) {
		this.nikeClothing = nikeClothing;
	}
	public String getAdidasClothing() {
		return adidasClothing;
	}
	public void setAdidasClothing(String adidasClothing) {
		this.adidasClothing = adidasClothing;
	}
	public String getPumaClothing() {
		return pumaClothing;
	}
	public void setPumaClothing(String pumaClothing) {
		this.pumaClothing = pumaClothing;
	}
	public String getUniqlo() {
		return uniqlo;
	}
	public void setUniqlo(String uniqlo) {
		this.uniqlo = uniqlo;
	}
	public String getBata() {
		return bata;
	}
	public void setBata(String bata) {
		this.bata = bata;
	}
	public String getRelaxo() {
		return relaxo;
	}
	public void setRelaxo(String relaxo) {
		this.relaxo = relaxo;
	}
	public String getMetro() {
		return metro;
	}
	public void setMetro(String metro) {
		this.metro = metro;
	}
	public String getLiberty() {
		return liberty;
	}
	public void setLiberty(String liberty) {
		this.liberty = liberty;
	}
	public String getKhadims() {
		return khadims;
	}
	public void setKhadims(String khadims) {
		this.khadims = khadims;
	}
	public String getNikeShoes() {
		return nikeShoes;
	}
	public void setNikeShoes(String nikeShoes) {
		this.nikeShoes = nikeShoes;
	}
	public String getAdidasShoes() {
		return adidasShoes;
	}
	public void setAdidasShoes(String adidasShoes) {
		this.adidasShoes = adidasShoes;
	}
	public String getPumaShoes() {
		return pumaShoes;
	}
	public void setPumaShoes(String pumaShoes) {
		this.pumaShoes = pumaShoes;
	}
	public String getReebok() {
		return reebok;
	}
	public void setReebok(String reebok) {
		this.reebok = reebok;
	}
	public String getWoodland() {
		return woodland;
	}
	public void setWoodland(String woodland) {
		this.woodland = woodland;
	}
	public String getConverse() {
		return converse;
	}
	public void setConverse(String converse) {
		this.converse = converse;
	}
	public String getVans() {
		return vans;
	}
	public void setVans(String vans) {
		this.vans = vans;
	}

    
}
