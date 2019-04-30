public class Animals {
    public int id;
    public String name;

    public Animals(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object otherAnimal){
        if(!(otherAnimal instanceof Animals)){
            return false;
        }
        else {
            Animals newAnimals = (Animals) otherAnimal;
            return this.getName().equals(newAnimals.getName());
        }
    }
}
