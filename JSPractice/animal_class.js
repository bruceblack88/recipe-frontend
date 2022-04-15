class Animal {
    //constructor
    constructor(name, age, kind){
        this.name = name;
        this.age = age;
        this.kind= kind;
        this.awake= false;

    }
    //methods
    speak(kind){
        if(this.kind === "pig"){
            return "oink";
        } else if (this.kind === "lion"){
            return "roar";
        }
    }
    //grow up method
    growUp(){
        this.age++;
        return this.age;
    }
    //wake up method
    wakeUp(){
        this.awake = true;
    }
    //sleep method
    sleep(){
        this.awake = false;
    }
    //feed method
    feed(){
        if(this.awake){
            return "NOM NOM NOM";
        } else{
            return "Animal is not awake";
        }
    }

}