package cn.elderPlatform.login;

public class Hello {
	
	private String s;
	
	public Hello(){
		System.out.println("Hello Construtor ...");
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		System.out.println("Set string S:"+s+"...");
		this.s = s;
	}

	@Override
	public String toString() {
		return "Hello [s=" + s + "]";
	}
	

}
