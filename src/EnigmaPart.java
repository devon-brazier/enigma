import java.util.LinkedList;

public abstract class EnigmaPart {
    protected LinkedList<Character> hashtable;

    public EnigmaPart(String hash){
        this.hashtable = createHash(hash);
    }

    public LinkedList<Character> getHashtable(){
        return hashtable;
    }

    private LinkedList<Character> createHash(String hash){
        LinkedList<Character> hashtable = new LinkedList<>();
        for (int i = 0; i < (hash.length()); i++) {
            hashtable.add(hash.charAt(i));
        }
        return hashtable;
    }

}