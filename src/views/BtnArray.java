package views;

public class BtnArray {

	String textBtn;
	String commandBtn;
	String colorBtn;
	String urlImageBtn;

	public BtnArray(String textBtn, String commandBtn, String colorBtn, String urlImageBtn) {
		super();
		this.textBtn = textBtn;
		this.commandBtn = commandBtn;
		this.colorBtn = colorBtn;
		this.urlImageBtn = urlImageBtn;
	}

	public String getTextBtn() {
		return textBtn;
	}

	public String getCommandBtn() {
		return commandBtn;
	}

	public String getColorBtn() {
		return colorBtn;
	}

	public String getUrlImageBtn() {
		return urlImageBtn;
	}
}
