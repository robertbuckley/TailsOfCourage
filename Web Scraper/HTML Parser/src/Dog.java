
public class Dog {
	String imgUrl;
	String name;
	String age;
	String breed;
	String sex;
	String size;
	String sheddding;
	String child;
	String train;
	String energy;
	String bark;
	
	public Dog(String imgUrl, String name, String age, String breed, String sex, String size , String shedding, String child, String train, String energy, String bark){
		this.imgUrl = imgUrl;
		this.name = name;
		this.age = age;
		this.breed  = breed;
		this.sex = sex;
		this.size = size;
		this.sheddding = shedding;
		this.child = child;
		this.train = train;
		this.energy = energy;
		this.bark = bark;
	}
	public Dog(String imgUrl, String name, String age, String breed, String size){
		this.imgUrl = imgUrl;
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.size = size;
	
	}
	public Dog(){
	
	}
	public void printInfo(){
		System.out.print("My name is " + name + ", url: " + imgUrl + "\n");
	}
	public String getimgUrl(){
		return imgUrl;
	}
	public String getName(){
		return name;
	}
	public String getAge() {
		return age;
	}
	public String getBreed() {
		return breed;
	}
	public String getSex() {
		return sex;
	}
	public String getSize() {
		return size;
	}
	public String getSheddding() {
		return sheddding;
	}
	public String getChild() {
		return child;
	}
	public String getTrain() {
		return train;
	}
	public String getEnergy() {
		return energy;
	}
	public String getBark() {
		return bark;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public void setSheddding(String sheddding) {
		this.sheddding = sheddding;
	}
	public void setChild(String child) {
		this.child = child;
	}
	public void setTrain(String train) {
		this.train = train;
	}
	public void setEnergy(String energy) {
		this.energy = energy;
	}
	public void setBark(String bark) {
		this.bark = bark;
	}	
}

