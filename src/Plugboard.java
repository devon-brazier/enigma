import java.util.LinkedList;

public class Plugboard{

    LinkedList<Character> hashtable;

    public Plugboard(String hash){
        this.hashtable = createHash(hash);
    }

    public LinkedList<Character> getHashtable(){
        return hashtable;
    }

    private LinkedList<Character> createHash(String hash){
        LinkedList<Character> hashtable = new LinkedList<>();
        String alphabet = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";//\u007F\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\u008A\u008B\u008C\u008D\u008E\u008F\u0090\u0091\u0092\u0093\u0094\u0095\u0096\u0097\u0098\u0099\u009A\u009B\u009C\u009D\u009E\u009F ¡¢£¤¥¦§¨©ª«¬\u00AD®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿĀāĂăĄąĆćĈĉĊċČčĎďĐđĒēĔĕĖėĘęĚěĜĝĞğĠġĢģĤĥĦħĨĩĪīĬĭĮįİıĲĳĴĵĶķĸĹĺĻļĽľĿŀŁłŃńŅņŇňŉŊŋŌōŎŏŐőŒœŔŕŖŗŘřŚśŜŝŞşŠšŢţŤťŦŧŨũŪūŬŭŮůŰűŲųŴŵŶŷŸŹźŻżŽž";
        for(int i = 0; i < alphabet.length(); i++){
            hashtable.add(alphabet.charAt(i));
        }

        for(int i = 0; i < (hash.length() / 2); i++){
            hashtable.set((int) hash.charAt(2*i) - 32, hash.charAt(2*i+1));
            hashtable.set((int) hash.charAt(2*i+1) - 32, hash.charAt(2*i));
        }
        return hashtable;
    }

}
