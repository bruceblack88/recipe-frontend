package solutions.adapttech.classes.InstanceMethods;
//Write a private method named foo that takes an int and adds it to the field bar.
public class FooBar {
    public int bar;

    private void foo(int bar){
        this.bar = bar + bar;
        this.bar = bar;
    }

//    Write a public method named bar that returns the value of the bar field multiplied by 20.
    public int bar(){
        this.bar = bar * 20;
        return bar;
    }

}


