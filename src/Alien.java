public class Alien extends Enemy{
    public Alien(){
        super();
    }
    public String toString(){
        return "Alien";
    }
    public Alien(int x,int y){
        super(x,y,50,50,2,172,new ImageIcon(//path),new staff(100,2,200));
    }
    
}