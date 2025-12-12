public class complexnum {
    private double x;
    private double y;

    public complexnum(double x,double y){
        this.x=x;
        this.y=y;
    }
    public complexnum sum(complexnum n2){
        return new complexnum(n2.x+this.x,n2.y+this.y);
    }

    public complexnum sub(complexnum n2){
        return new complexnum(n2.x-this.x,n2.y-this.y);
    }
    public void print() {
        System.out.println(this.x + " + " + this.y + "i");
    }

}
