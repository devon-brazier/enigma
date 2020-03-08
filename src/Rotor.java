import java.util.*;

public class Rotor extends EnigmaPart{
    private int numberRotations;

    public Rotor(String hash){
        super(hash);
    }

    public void rotate(){
        Collections.rotate(getHashtable(), 1);
        numberRotations++;
    }

    public void presetRotate(int presetRotations){
        Collections.rotate(getHashtable(), presetRotations % getHashtable().size());
    }

    public int getNumberRotations(){
        return numberRotations;
    }
}