public class Family {
    private int totalKids;
    private int totalDogs;
    private int totalCats;
    private boolean isHaunted;

    public int getTotalKids() {return this.totalKids;}

    public void setTotalKids(int totalKids) {this.totalKids = totalKids;}

    public int getTotalDogs() {return this.totalDogs;}

    public void setTotalDogs(int totalDogs) {this.totalDogs = totalDogs;}

    public int getTotalCats() {return this.totalCats;}

    public void setTotalCats(int totalCats) {this.totalCats = totalCats;}

    public int getTotalNumberOfPets() {return this.totalDogs + this.totalCats;}

    public boolean getIsHaunted() {return this.isHaunted;}

    public void setIsHaunted(boolean isHaunted) {this.isHaunted = isHaunted;}
}
