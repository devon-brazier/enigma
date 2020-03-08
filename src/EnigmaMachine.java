import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class EnigmaMachine {

    private Plugboard plugboard;
    private Rotor r1 = new Rotor("sZt_:\"WITL/x<yCmz5in>4d1c *o}^jq3R=phO;a[vk9F8Q.?!Jr$NGSwED|+AfHY0lV6Mu2B\\7`XeU{bg]'-%,~)K#(@P&");//\u007F\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\u008A\u008B\u008C\u008D\u008E\u008F\u0090\u0091\u0092\u0093\u0094\u0095\u0096\u0097\u0098\u0099\u009A\u009B\u009C\u009D\u009E\u009F ¡¢£¤¥¦§¨©ª«¬\u00AD®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿĀāĂăĄąĆćĈĉĊċČčĎďĐđĒēĔĕĖėĘęĚěĜĝĞğĠġĢģĤĥĦħĨĩĪīĬĭĮįİıĲĳĴĵĶķĸĹĺĻļĽľĿŀŁłŃńŅņŇňŉŊŋŌōŎŏŐőŒœŔŕŖŗŘřŚśŜŝŞşŠšŢţŤťŦŧŨũŪūŬŭŮůŰűŲųŴŵŶŷŸŹźŻżŽž");
    private Rotor r2 = new Rotor(",PV|K!6Q&5xEW=70#%D$:.3?*)\\^mfYZ_ed/XtRGpjnbkHwIC{v}TzgO4FqUSM (1sy9@A8+<>i'[r]`LacJ2h~-B;Noul\"");//\u007F\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\u008A\u008B\u008C\u008D\u008E\u008F\u0090\u0091\u0092\u0093\u0094\u0095\u0096\u0097\u0098\u0099\u009A\u009B\u009C\u009D\u009E\u009F ¡¢£¤¥¦§¨©ª«¬\u00AD®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿĀāĂăĄąĆćĈĉĊċČčĎďĐđĒēĔĕĖėĘęĚěĜĝĞğĠġĢģĤĥĦħĨĩĪīĬĭĮįİıĲĳĴĵĶķĸĹĺĻļĽľĿŀŁłŃńŅņŇňŉŊŋŌōŎŏŐőŒœŔŕŖŗŘřŚśŜŝŞşŠšŢţŤťŦŧŨũŪūŬŭŮůŰűŲųŴŵŶŷŸŹźŻżŽž");
    private Rotor r3 = new Rotor("*}:C1cqXbNI0pY7y,M.wlfrov%8kAs'(>OHK9\")LV`U_@/ ]4&EDj!x2mS+5${[Wt|3<uh?Pa#GRBQJFzZ=~6dei\\ng-T;^");//\u007F\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\u008A\u008B\u008C\u008D\u008E\u008F\u0090\u0091\u0092\u0093\u0094\u0095\u0096\u0097\u0098\u0099\u009A\u009B\u009C\u009D\u009E\u009F ¡¢£¤¥¦§¨©ª«¬\u00AD®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿĀāĂăĄąĆćĈĉĊċČčĎďĐđĒēĔĕĖėĘęĚěĜĝĞğĠġĢģĤĥĦħĨĩĪīĬĭĮįİıĲĳĴĵĶķĸĹĺĻļĽľĿŀŁłŃńŅņŇňŉŊŋŌōŎŏŐőŒœŔŕŖŗŘřŚśŜŝŞşŠšŢţŤťŦŧŨũŪūŬŭŮůŰűŲųŴŵŶŷŸŹźŻżŽž");
    private Rotor[] rotors = {r1,r2,r3};
    private Reflector reflector = new Reflector("%_f2p)l6;3.gV5cnmDKhyd`C^?#iEMF}\"=XL]>G0(wz8,:9YT'S{\\!eWuR|JrBoNbxq+*t -k$s4aH&vjP~IQ7A/<@OUZ1[");//\u007F\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\u008A\u008B\u008C\u008D\u008E\u008F\u0090\u0091\u0092\u0093\u0094\u0095\u0096\u0097\u0098\u0099\u009A\u009B\u009C\u009D\u009E\u009F ¡¢£¤¥¦§¨©ª«¬\u00AD®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿĀāĂăĄąĆćĈĉĊċČčĎďĐđĒēĔĕĖėĘęĚěĜĝĞğĠġĢģĤĥĦħĨĩĪīĬĭĮįİıĲĳĴĵĶķĸĹĺĻļĽľĿŀŁłŃńŅņŇňŉŊŋŌōŎŏŐőŒœŔŕŖŗŘřŚśŜŝŞşŠšŢţŤťŦŧŨũŪūŬŭŮůŰűŲųŴŵŶŷŸŹźŻżŽž");
    private String inputMessage;
    private int numberOfRotors;
    private String plugs;

    public EnigmaMachine(String inputMessage, int numberOfRotors, int[] presetRotations, String plugs){
        this.plugboard = new Plugboard(plugs);
        this.inputMessage = inputMessage;
        this.numberOfRotors = numberOfRotors;
        for (int i = 0; i < numberOfRotors; i++){
            rotors[i].presetRotate(presetRotations[i]);
        }
    }

    public int getMaxRotors(){
        return rotors.length;
    }

    public String getPlugs(){
        return plugs;
    }

    public void setPlugs(String plugs){
        this.plugs = plugs;
    }

    public int getNumberOfRotors(){
        return numberOfRotors;
    }

    public void setNumberOfRotors(int num){
        this.numberOfRotors = num;
    }

    public String getInputMessage(){
        return inputMessage;
    }

    public void setInputMessage(String s){
        this.inputMessage = s;
    }

    public StringBuilder encrypt(boolean isDecrypt){
        StringBuilder cypher = new StringBuilder(inputMessage.length());
        for (int i = 0; i < inputMessage.length(); i++){
            if((int) inputMessage.charAt(i) == 10){
                cypher.append("\n");
                continue;
            }

            char currentChar = inputMessage.charAt(i);

            currentChar = plugboard.getHashtable().get((int) currentChar - 32);

            for (int j = 0; j < numberOfRotors; j++){
                currentChar = rotors[j].getHashtable().get((int) currentChar - 32);
            }

            if(isDecrypt){
                currentChar = (char) (reflector.getHashtable().indexOf(currentChar) + 32);
            }
            else {
                currentChar = reflector.getHashtable().get((int) currentChar - 32);
            }

            for (int j = numberOfRotors - 1; j >= 0; j--){
                currentChar = (char) (rotors[j].getHashtable().indexOf(currentChar) + 32);
            }

            currentChar = plugboard.getHashtable().get((int) currentChar - 32);

            cypher.append(currentChar);
            rotateRotors();
        }
        System.out.println();
        return cypher;
    }

    public void rotateRotors(){
        rotors[0].rotate();
        for(int i = 1; i < rotors.length - 1; i++){
            if(rotors[i-1].getNumberRotations() % rotors[i-1].getHashtable().size() == 0 && rotors[i-1].getNumberRotations() != 0){
                rotors[i].rotate();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String plugs = "BA";
        int[] presetRotations = {15,25,1};
        int numberOfRotors = 3;

        String file = "/home/devon/Documents/Projects/javaProjects/enigmav2/";
        String entireFileText = new Scanner(new File(file + "thankyounext.txt")).useDelimiter("\\A").next();

        System.out.println(entireFileText + "\n");

        EnigmaMachine enigma = new EnigmaMachine(entireFileText,numberOfRotors, presetRotations, plugs);

        String cypher = enigma.encrypt(false).toString();
        System.out.println(cypher + "\n");
        EnigmaMachine decypher = new EnigmaMachine(cypher,numberOfRotors, presetRotations, plugs);

        System.out.println(decypher.encrypt(true));
    }

    public static void createRotor(){
        String s = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        LinkedList<Character> l = new LinkedList<>();
        for (int i = 0; i < s.length(); i++){
            l.add(s.charAt(i));
        }
        Collections.shuffle(l);
        StringBuilder c = new StringBuilder();
        for (Character character : l) {
            c.append(character);
        }
        System.out.println(c.toString());
    }
}