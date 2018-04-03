package a2.assign4.cmsc355.synonymantonym;

/**
 * Created by Kevin on 4/2/18.
 */

public class Thesaurus {
    String word;
    String syn;
    String ant;
    public Thesaurus(){

    }

    public void setWord(String word) {this.word = word;}
    public void setSyn(String syn) {
        this.syn = syn;
    }
    public void setAnt(String ant) {
        this.ant = ant;
    }

    public String getWord() {
        return word;
    }
    public String getSyn(){
        return this.syn;
    }
    public String getAnt(){
        return this.ant;
    }


}
