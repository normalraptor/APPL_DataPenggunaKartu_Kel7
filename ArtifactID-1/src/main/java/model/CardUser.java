package model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class CardUser {
	@Id
	private String id;
	
	@Field
	private String nama;
	private String lokasi;
	private String kk;
	private String ktp;
	private String telp;
	
	public CardUser() {
		super();
	}
	
	public CardUser(String id, String nama, String lokasi, String kk, String ktp, String telp) {
		super();
		this.id = id;
		this.nama = nama;
		this.lokasi = lokasi;
		this.kk = kk;
		this.ktp = ktp;
		this.telp = telp;
	}
	
	public String getID() {
		return id;
	}
	
	public void setID(String input) {
		this.id = input;
	}
	
	public String getNama() {
		return nama;
	}
	
	public void setNama(String input) {
		this.nama = input;
	}
	
	public String getLokasi() {
		return lokasi;
	}
	
	public void setLokasi(String input) {
		this.lokasi = input;
	}
	
	public String getKK() {
		return kk;
	}
	
	public void setKK(String input) {
		this.kk = input;
	}
	
	public String getKTP() {
		return ktp;
	}
	
	public void setKTP(String input) {
		this.ktp = input;
	}
	
	public String getTelp() {
		return telp;
	}
	
	public void setTelp(String input) {
		this.telp = input;
	}
}
