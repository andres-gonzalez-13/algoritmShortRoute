package models;


public class PersonSocial {

	private int id;
	private String nickName;
	

	public PersonSocial(int id, String nickName) {
		this.nickName = nickName;
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "PersonSocial [nickName=" + nickName + "]";
	}
	
}
